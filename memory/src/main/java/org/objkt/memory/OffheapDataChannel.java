package org.objkt.memory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class OffheapDataChannel implements DataOutput, DataInput, SeekableByteChannel {
	final ByteBuffer tempOffheapAllocation;
	final IntFunction<ByteBuffer> factory;
	Segment current;
	Segment first;
	Segment last;
	final int segmentSize;

	public Segment current() {
		return current;
	}

	public void addSegment() {
		addSegment(factory.apply(segmentSize));
	}
	public void addSegment(ByteBuffer t) {addSegment(t, t.position());}
	public void addSegment(ByteBuffer t, int offset) {
		if(current == null) {
			first = new Segment(t, null, offset);
			current = first;
			last = first;
		}
		else {
			Segment s = new Segment(t, last, offset);
			last.setNext(s);
			last = s;
		}
	}

	public void clear() {
		current = null;
		first = null;
		last = null;
	}

	@Override
	public long size() {
		if(last == null) return 0;
		return last.globalPosition + last.buffer.limit();
	}

	public void forEachSegment(Consumer<Segment> cons) {
		for(Segment s = first; s != null; s = s.next) {
			cons.accept(s);
		}
	}

	public static class Segment {
		Segment next;
		final Segment prev;
		public final int globalPosition;
		ByteBuffer buffer;
		final int start;

		Segment(ByteBuffer value, Segment prev, int offset) {
			this.buffer = value;
			this.prev = prev;
			this.start = offset;

			globalPosition = prev != null ? prev.globalPosition + prev.buffer.limit() : 0;
		}

		public ByteBuffer buffer() {return buffer;}

		void setNext(Segment next) {
			this.next = next;
		}

		public Segment next() {
			return next;
		}

		public Segment previous() {
			return prev;
		}

		public void incrementPosition(int val) {
			buffer.position(buffer.position() + val);
		}
	}

	interface WOp {
		void write(ByteBuffer mem);
	}

	@FunctionalInterface
	private interface ROp<T> {
		T read(ByteBuffer mem);
	}

	public OffheapDataChannel(ByteOrder order) {
		this( i -> ByteBuffer.allocateDirect(i).order(order), 4096);
	}

	public OffheapDataChannel(IntFunction<ByteBuffer> factory) {
		this(factory, 4096);
	}

	public OffheapDataChannel(IntFunction<ByteBuffer> factory, int segmentSize) {
		this.segmentSize = segmentSize;
		this.factory = factory;
		this.tempOffheapAllocation = factory.apply(Long.BYTES);
	}
	
	@Override
	public void close() {
		clear();
	}
	
	@Override
	public long position() {
		if( current == null) return 0;
		boundCheck(false);
		return current.globalPosition + current.buffer.position();
	}
	
	@Override
	public boolean isOpen() {
		return current != null;
	}

	public int readFrom(ReadableByteChannel channel, int bytes) {
		int left = bytes;

		while(left > 0) {
			boundCheck(true);
			try {
				int prevLimit = current.buffer.limit();
				int toRead = Math.min(current.buffer.remaining(), left);
				current.buffer.limit(current.buffer.position() + toRead);
				int rought = channel.read(current.buffer);
				current.buffer.limit(prevLimit);

				if(rought == 0)
		 			break;
				if(rought == -1) {
					if(left == bytes)
						return -1;
					break;
				}
				left-=rought;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bytes - left;
	}

	public int writeTo(WritableByteChannel channel, int bytes) {
		int left = bytes;

		while(left > 0) {
			boundCheck(true);
			try {
				int prevLimit = current.buffer.limit();
				int toWrite = Math.min(current.buffer.remaining(), left);
				current.buffer.limit(current.buffer.position() + toWrite);
				left -= channel.write(current.buffer);
				current.buffer.limit(prevLimit);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return bytes - left;
	}

	@Override
	public SeekableByteChannel position(long pos) {
		int path = (int)pos - (int)position();

		while(path != 0) {
			if(path < 0) {
				if(current.buffer.position() == 0)
					current = current.prev;
				int toStep = Math.min(current.buffer.position() - current.start, -path);
				current.buffer.position(current.buffer.position() - toStep);
				path+=toStep; // cos path is negative
			}
			else {
				boundCheck(false);
				int toStep = Math.min(current.buffer.remaining(), path);
				current.buffer.position(current.buffer.position() + toStep);
				path-=toStep;
			}
		}
		return this;
	}

	private void boundCheck(boolean create) {
		if(first == null && create)
			addSegment();
		else {
			while(current.buffer.remaining() == 0) {
				if (current.next == null) {
					if (create)
						addSegment();
				}
				else
					current = current.next;
			}
		}
	}

	public void ensureSize(int bytes) {
		while(size() < bytes)
			addSegment();
	}
	
	@Override
	public int read(ByteBuffer buff) {
		if(position() == size())
			return -1;
		
		int wrote = 0;
		while(buff.remaining() != 0) {
			boundCheck(false);
			int toWrite = Math.min(current.buffer.remaining(), buff.remaining());
			ByteBufferUtils.put(buff, current.buffer, toWrite);
			wrote+=toWrite;
		}
		
		return wrote;
	}

	@Override
	public SeekableByteChannel truncate(long size) {
		position(size);
		return this;
	}

	public ByteBuffer getFreeBuffer() {
		boundCheck(true);
		return current.buffer;
	}

	@Override
	public int write(ByteBuffer buff) {
		int wrote = 0;
		
		while(buff.remaining() != 0) {
			boundCheck(true);
			int toWrite = Math.min(buff.remaining(), current.buffer.remaining());
			ByteBufferUtils.put(current.buffer, buff, toWrite);
			wrote += toWrite;
		}
		
		return wrote;
	}
	
	private void write(int size, WOp op) {
		boundCheck(true);
		if(current.buffer.remaining() < size) {
			tempOffheapAllocation.position(0);
			op.write(tempOffheapAllocation);
			int left = size;
			tempOffheapAllocation.position(0);
			
			while(left > 0) {
				boundCheck(true);
				int toWrite = Math.min(left, current.buffer.remaining());
				ByteBufferUtils.put(current.buffer, tempOffheapAllocation, toWrite);
				left-=toWrite;
			}
			return;
		}
		
		op.write(current.buffer);
	}
	
	private <T> T read(int size, ROp<T> op) {
		boundCheck(false);
		if(current.buffer.remaining() < size) {
			int left = size;
			tempOffheapAllocation.position(0);
			
			while(left != 0) {
				boundCheck(false);
				int toWrite = Math.min(current.buffer.remaining(), left);
				ByteBufferUtils.put(tempOffheapAllocation, current.buffer, toWrite);
				left-=toWrite;
			}

			return op.read(tempOffheapAllocation);
		}

		return op.read(current.buffer);
	}

	@Override
	public void write(int b) {
		write(Byte.BYTES, mem -> mem.put((byte) (b & 0xFF)));
	}

	@Override
	public void write(byte[] b) {
		write(b, 0, b.length);
	}

	@Override
	public void write(byte[] b, int off, int len) {
		for(int i = off; i < len; i++) {
			write(b[i]);
		}
	}

	@Override
	public void writeBoolean(boolean v) {
		write(v ? 1 : 0);
	}

	@Override
	public void writeByte(int v) {
		write(v);
	}

	@Override
	public void writeBytes(String s) {
		int len = s.length();
        for (int i = 0; i < len; i ++) {
            write(s.charAt(i));
        }
	}

	@Override
	public void writeChar(int v) {
		write(Character.BYTES, mem -> mem.putChar((char) (v & 0xFFFF)));
	}

	@Override
	public void writeChars(String s) {
		int len = s.length();
        for (int i = 0; i < len; i ++) {
            writeChar(s.charAt(i));
        }
	}

	@Override
	public void writeDouble(double v) {
		write(Double.BYTES, mem -> mem.putDouble(v));
	}

	@Override
	public void writeFloat(float v) {
		write(Float.BYTES, mem -> mem.putFloat(v));
	}

	@Override
	public void writeInt(int v) {
		write(Integer.BYTES, mem -> mem.putInt(v));
	}

	@Override
	public void writeLong(long v) {
		write(Long.BYTES, mem -> mem.putLong(v));
	}

	@Override
	public void writeShort(int v) {
		write(Short.BYTES, mem -> mem.putShort((short) (v & 0xFFFF)));
	}

	@Override
	public void writeUTF(String s) {
		for(int i = 0; i < s.length() + 1; i++) {
			
			char ch = i == s.length() ? 0 : s.charAt(i);
			
			if(ch >= 0x1 && ch <= 0x7F) {
				writeByte(ch);
			}
			else if(ch == 0 || ch <= 0x7FF) {
				writeByte(((ch >>> 6) & 0b0001_1111) | 0b1100_0000);
				writeByte((ch & 0b0011_1111) | 0b10000000);
			}
			else {
				writeByte(((ch >>> 12) & 0b0000_1111) | 0b1110_0000);
				writeByte(((ch >>> 6)  & 0b0011_1111) | 0b1000_0000);
				writeByte(( ch         & 0b001_11111) | 0b1000_0000);
			}
		}
	}
	
	@Override
	public boolean readBoolean() {
		return readByte() != 0;
	}

	@Override
	public byte readByte() {
		return read(Byte.BYTES, ByteBuffer::get);
	}

	@Override
	public char readChar() {
		return read(Character.BYTES, ByteBuffer::getChar);
	}

	@Override
	public double readDouble() {
		return read(Double.BYTES, ByteBuffer::getDouble);
	}

	@Override
	public float readFloat() {
		return read(Float.BYTES, ByteBuffer::getFloat);
	}

	@Override
	public void readFully(byte[] b) {
		readFully(b, 0, b.length);
	}

	@Override
	public void readFully(byte[] b, int off, int len) {
		for(int i = off; i < len; i++) {
			b[i] = readByte();
		}
	}

	@Override
	public int readInt() {
		return read(Integer.BYTES, ByteBuffer::getInt);
	}

	@Override
	public String readLine() {
		StringBuilder sb = new StringBuilder();
		for(;;) {
			byte ch = readByte();
			if(ch == -1) {
				if(sb.length() == 0)
					return null;
				return sb.toString();
			}
			if(ch == '\n')
				return sb.toString();
			if(ch == '\r') {
				if(size() > position()) {
					char next = (char) readUnsignedByte();
					if(next != '\n')
						position(position() - Byte.BYTES);
				}
				return sb.toString();
			}
			sb.append((char)ch);
		}
	}

	@Override
	public long readLong() {
		return read(Long.BYTES, ByteBuffer::getLong);
	}

	@Override
	public short readShort() {
		return read(Short.BYTES, ByteBuffer::getShort);
	}

	@Override
	public String readUTF() {
		StringBuilder b = new StringBuilder();
		
		for(;;) {
			byte b1 = readByte();
			
			if((b1 & 0b1000_0000) == 0) {
				b.append((char) (b1 & 0b0111_1111));
				continue;
			}
			
			byte b2 = readByte();
			
			if((b1 & 0b11100000) == 0b11000000) {
				char c = (char) (b2 & 0b00111111);
				c |= (b1 & 0b00011111) << 6;
				
				if(c == 0)
					break;
				
				b.append(c);
				continue;
			}
			
			byte b3 = readByte();
			
			char c = (char) (b3 & 0b00111111);
			c |= (b2 & 0b00111111) << 6;
			c |= (b1 & 0b00001111) << 12;
			b.append(c);
		}
		
		return b.toString();
	}

	@Override
	public int readUnsignedByte() {
		return readByte() & 0xFF;
	}

	@Override
	public int readUnsignedShort() {
		return readShort() & 0xFFFF;
	}

	@Override
	public int skipBytes(int n) {
		position(position() + n);
		
		return n;
	}
	
	public static void main(String... args) {
		OffheapDataChannel buff = new OffheapDataChannel(size -> ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder()));
		buff.writeInt(56);
		assert(buff.position() == 4);
		buff.position(0);
		buff.writeUTF("Hello!");
		buff.writeInt(15000);
		buff.position(0);
		System.out.println(buff.readUTF() + " " + buff.readInt());
		
		buff.position(0);

		buff.writeInt(1122334455);
		System.out.println(buff.position());
		
		buff.position(0);
		System.out.println(buff.readInt());
		
		buff.position(0);
		buff.writeShort(0x8915);
		buff.position(buff.position() - Byte.BYTES);
		System.out.println(Integer.toHexString(buff.readUnsignedByte()));
	}

}