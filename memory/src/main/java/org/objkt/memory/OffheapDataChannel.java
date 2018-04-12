package org.objkt.memory;

import java.nio.*;
import java.nio.channels.SeekableByteChannel;
import java.util.function.*;

public class OffheapDataChannel implements DataOutput, DataInput, SeekableByteChannel {
	private int relPosition = 0;
	Segment current;
	final Segment first;
	MemBlock tempMemBlock = new MemBlock(Long.BYTES);
	public final ByteOrder byteOrder;
	final IntFunction<Allocation> memBlockfactory;
	
	public static class Segment extends MemBlock {
		private Segment next;
		private Segment prev;
		
		Segment(Allocation alloc) {
			this.alloc = alloc;
		}
		
		void remove() {
			if(prev != null)
				prev.next = next;
			if(next != null)
				next.prev = prev;
		}
		
		void setNext(Segment newNext) {
			newNext.next = next;
			newNext.prev = this;
			
			if(next != null && next.alloc != null)
				this.next.prev = newNext;
			
			next = newNext;
		}
		
		void setPrev(Segment s) {
			s.next = this;
			s.prev = prev;
			prev = s;
		}
		
		public Segment next() {
			return next;
		}
		
		public Segment previous() {
			return prev;
		}
	}
	
	interface WOp {
		void write(int position, MemBlock mem);
	}

	@FunctionalInterface
	private interface ROp<T> {
		T read(int position, MemBlock mem);
	}
	
	public Segment firstSection() {
		return first.next;
	}

	public static OffheapDataChannel withByteOrder(ByteOrder bo) {
		return withByteOrder(bo, Allocation::new);
	}
	
	public static OffheapDataChannel withByteOrder(ByteOrder bo, IntFunction<Allocation> factory) {
		if(bo == ByteOrder.nativeOrder())
			return new OffheapDataChannel(ByteOrder.nativeOrder(), factory);
		else
			return new OffheapDataChannelOppositeByteOrder(bo, factory);
	}
	
	OffheapDataChannel(ByteOrder order, IntFunction<Allocation> factory) {
		this.byteOrder = order;
		this.memBlockfactory = factory;
		first = new Segment(null);
		reset();
	}
	
	public Segment last() {
		Segment s = first;
		while (s.next != null)
			s = s.next;

		return s;
	}
	
	public void addToEnd(MemBlock memBlock) {
		addToEnd(memBlock.getAllocation());
	}
	
	public void addToEnd(Allocation alloc) {
		Segment last = last();
		if(last.alloc == null)
			last.setAllocation(alloc);
		else
			last.setNext(new Segment(alloc));
	}
	
	public Segment currentSection() {
		return current;
	}
	
	public void addToEnd(ByteBuffer bb) {
		addToEnd(new NativeAllocation(Utils.address(bb), bb.remaining()));
	}
	
	public void forEachSection(Consumer<Segment> cons) {
		for(Segment s = first; s != null;s = s.next) {
			cons.accept(s);
		}
	}
	
	@Override
	public void close() {
		reset();
		current = null;
	}
	
	public void reset() {
		current = first;
		relPosition = 0;
		forEachSection(sec -> {if(sec.alloc != null)sec.free();});
		first.next = null;
		first.prev = null;
	}
	
	@Override
	public long size() {
		long size = 0;
		for(Segment s = first.next;s != null; s = s.next) {
			size+=s.bytes();
		}
		return size;
	}
	
	@Override
	public long position() {
		long p = 0;
		for(Segment s = first;s != current; s = s.next) {
			p+=s.bytes();
		}
		return p + relPosition;
	}
	
	@Override
	public boolean isOpen() {
		return current != null;
	}

	@Override
	public SeekableByteChannel position(long pos) {
		relPosition = 0;
		current = first;
		incPosition((int) pos);
		return this;
	}

	private void incPosition(int val) {
		while(val != 0) {
			int toInc = Math.min(val, (int)current.bytes() - relPosition);
			val -= toInc;
			relPosition += toInc;
			
			if(relPosition == current.bytes()) {
				if(current.next == null) current.setNext(new Segment(null));
				current = current.next;
				relPosition = 0;
			}
		}
	}
	
	@Override
	public int read(ByteBuffer buff) {
		if(position() == size()) 
			return -1;
		
		int wrote = 0;
		while(buff.remaining() != 0) {
			int toWrite = Math.min((int)current.bytes() - relPosition, buff.remaining());
			current.copyTo(Utils.address(buff) + buff.position(), relPosition, toWrite);
			buff.position(buff.position() + toWrite);
			wrote += toWrite;
			incPosition(toWrite);
		}
		
		return wrote;
	}

	@Override
	public SeekableByteChannel truncate(long size) {
		position(size);
		return this;
	}

	@Override
	public int write(ByteBuffer buff) {
		int wrote = 0;
		
		while(buff.remaining() != 0) {
			if(current.alloc == null)
				current.setAllocation(memBlockfactory.apply(4096));
			int toWrite = Math.min((int)current.bytes() - relPosition, buff.remaining());
			Utils.UNSAFE.copyMemory(Utils.address(buff) + buff.position(), current.alloc.address + relPosition, toWrite);
			buff.position(buff.position() + toWrite);
			wrote += toWrite;
			incPosition(toWrite);
		}
		
		return wrote;
	}
	
	private void write(int size, WOp op) {
		if(current.alloc == null)
			current.setAllocation(memBlockfactory.apply(4096));
		if(relPosition + size > current.bytes()) {
			op.write(0, tempMemBlock);
			int left = size;
			
			while(left != 0) {
				if(current.alloc == null)
					current.setAllocation(memBlockfactory.apply(4096));
				int toWrite = Math.min(left, (int)current.bytes() - relPosition);
				tempMemBlock.copyTo(current, size - left, relPosition, toWrite);
				left-=toWrite;
				incPosition(toWrite);
			}
			return;
		}
		
		op.write(relPosition, current);
		relPosition += size;
	}
	
	private <T> T read(int size, ROp<T> op) {
		if(relPosition + size > current.bytes()) {
			int left = size;
			
			while(left != 0) {
				int toRead = Math.min((int)current.bytes() - relPosition, left);
				current.copyTo(tempMemBlock, relPosition, size - left, toRead);
				left-=toRead;
				incPosition(toRead);
			}
			
			return op.read(0, tempMemBlock);
		}
		
		relPosition+=size;
		return op.read(relPosition-size, current);
	}

	@Override
	public void write(int b) {
		write(Byte.BYTES, (pos, mem) -> mem.put(pos, (byte) (b & 0xFF)));
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
		write(Character.BYTES, (pos, mem) -> mem.putChar0(pos, (char) (v & 0xFFFF)));
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
		//wd.value = v;
		write(Double.BYTES, (pos, mem) -> mem.putDouble0(pos, v));
	}

	@Override
	public void writeFloat(float v) {
		//wf.value = v;
		//write(Float.BYTES, wf);
		write(Float.BYTES, (pos, mem) -> mem.putFloat0(pos, v));
	}

	@Override
	public void writeInt(int v) {
		//wi.value = v;
		write(Integer.BYTES, (pos, mem) -> mem.putInt0(pos, v));
	}

	@Override
	public void writeLong(long v) {
		//wl.value = v;
		write(Long.BYTES, (pos, mem) -> mem.putLong0(pos, v));
	}

	@Override
	public void writeShort(int v) {
		//ws.value = (short) (v & 0xFFFF);
		write(Short.BYTES, (pos, mem) -> mem.putShort0(pos, (short) (v & 0xFFFF)));
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
		return read(Byte.BYTES, (pos, mem) -> mem.get(pos));
	}

	@Override
	public char readChar() {
		return read(Character.BYTES, (pos, mem) -> mem.getChar0(pos));
	}

	@Override
	public double readDouble() {
		return read(Double.BYTES, (pos, mem) -> mem.getDouble0(pos));
	}

	@Override
	public float readFloat() {
		return read(Float.BYTES, (pos, mem) -> mem.getFloat0(pos));
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
		return read(Integer.BYTES, (pos, mem) -> mem.getInt0(pos));
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
		return read(Long.BYTES, (pos, mem) -> mem.getLong0(pos));
	}

	@Override
	public short readShort() {
		return read(Short.BYTES, (pos, mem) -> mem.getShort0(pos));
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
		for(int i = 0; i < n; n++) {
			read(Byte.BYTES, (op, mem) -> 0);
		}
		
		return n;
	}
	
	public static void main(String... args) {
		OffheapDataChannel buff = OffheapDataChannel.withByteOrder(ByteOrder.BIG_ENDIAN);
		System.out.println(buff.byteOrder);
		buff.writeInt(56);
		assert(buff.position() == 4);
		buff.position(0);
		buff.writeUTF("Hello!");
		buff.writeInt(15000);
		buff.position(0);
		System.out.println(buff.readUTF() + " " + buff.readInt());
		
		buff.reset();
		
		buff.addToEnd(new MemBlock(3));
		buff.writeInt(1122334455);
		System.out.println(buff.position());
		
		buff.position(0);
		System.out.println(buff.readInt());
		
		//buff.reset();
		buff.writeShort(0x8915);
		buff.position(buff.position() - Byte.BYTES);
		System.out.println(Integer.toHexString(buff.readUnsignedByte()));
		
		buff.reset();
		
		/*int i = 0;
		while(true) {
			buff.writeFloat(0);
			i++;
			if(i == 15000) {
				i = 0;
				buff.position(0);
				//break;
			}
		}
		
		/*float f;
		while(true) {
			f = buff.readFloat();
			i++;
			if(i == 15000) {
				i = 0;
				buff.position(0);
				if(i > 0)
					break;
			}
		}
		System.out.println(f);*/
	}

}