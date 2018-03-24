package org.objkt.memory;

import java.nio.*;
import java.nio.channels.SeekableByteChannel;
import java.util.*;
import java.util.function.*;

public class OffheapDataChannel implements DataOutput, DataInput, SeekableByteChannel {
	List<Section> sections = new ArrayList<Section>(1) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean add(Section s) {
			if(size() >= 1) {
				Section prev = get(size() - 1);
				prev.next = s;
				s.prev = prev;
				s.position = prev.position+prev.size;
			}
			return super.add(s);
		}
	};
	final Section first = new Section(new MemBlock(0), 0, 0);
	boolean released = false;
	private int relPosition = 0;
	Section current = first;
	MemBlock tempMemBlock = new MemBlock(Long.BYTES);
	public final ByteOrder byteOrder;
	final Supplier<MemBlock> factory;
	
	public static class Section {
		final int index;
		final MemBlock block;
		Section next;
		Section prev;
		int size;
		long position;
		
		Section(MemBlock block, int size, int index) {
			this.block = block;
			this.size = size;
			this.index = index;
		}
		
		void offsetPos(int val) {
			position += val;
			if(next != null)
				next.offsetPos(val);
		}
		
		void increaseSize(int val) {
			size += val;
			if(next != null)
				next.offsetPos(val);
		}
	}
	
	@FunctionalInterface
	interface WOp {
		void write(int position, MemBlock mem);
	}
	
	@FunctionalInterface
	interface ROp<T> {
		T read(int position, MemBlock mem);
	}

	public static OffheapDataChannel withByteOrder(ByteOrder bo) {
		return withByteOrder(bo, () -> new MemBlock(4096));
	}
	
	public static OffheapDataChannel withByteOrder(ByteOrder bo, Supplier<MemBlock> factory) {
		if(bo == ByteOrder.nativeOrder())
			return new OffheapDataChannel(ByteOrder.nativeOrder(), factory);
		else
			return new OffheapDataChannelOppositeByteOrder(bo, factory);
	}
	
	OffheapDataChannel(ByteOrder order, Supplier<MemBlock> factory) {
		this.byteOrder = order;
		this.factory = factory;
		reset();
	}
	
	public void addToEnd(MemBlock memBlock) {
		sections.add(new Section(memBlock, (int) memBlock.bytes(), sections.size()));
	}
	
	public void addToEnd(ByteBuffer bb) {
		MemBlock block = new MemBlock();
		block.setAllocation(new NativeAllocation(Utils.address(bb), bb.remaining()));
		addToEnd(block);
	}
	
	public void forEachSection(Consumer<Section> cons) {
		sections.forEach(cons);
	}
	
	@Override
	public void close() {
		sections.forEach(sec -> sec.block.free());
		reset();
		released = true;
	}
	
	public void reset() {
		position(0);
		sections.clear();
		sections.add(first);
		first.next = null;
	}
	
	@Override
	public long size() {
		Section last = sections.get(sections.size() - 1);
		return last.position + last.size;
	}
	
	@Override
	public long position() {
		return current.position + relPosition;
	}
	
	@Override
	public boolean isOpen() {
		return !released;
	}

	@Override
	public SeekableByteChannel position(long pos) {
		Section s = first;
		while(s.position + s.size < pos) s = s.next;
		current = s;
		relPosition = (int) (pos - s.position);
		return this;
	}

	@Override
	public int read(ByteBuffer buff) {
		if(position() == size()) 
			return -1;
		
		Section s = current;
		int wrote = 0;
		for(;;) {
			int toWrite = Math.min(s.size - relPosition, buff.remaining());
			current.block.copyTo(Utils.address(buff) + buff.position(), relPosition, toWrite);
			buff.position(buff.position() + toWrite);
			wrote += toWrite;
			relPosition += toWrite;
			
			if(buff.remaining() == 0)
				return wrote;
			
			current = current.next;
			relPosition = 0;
		}
	}

	@Override
	public SeekableByteChannel truncate(long size) {
		position(size);
		return this;
	}

	@Override
	public int write(ByteBuffer buff) {
		Section s = current;
		int wrote = 0;
		for(;;) {
			int toWrite = Math.min(s.size - relPosition, buff.remaining());
			Utils.UNSAFE.copyMemory(Utils.address(buff) + buff.position(), current.position + relPosition, toWrite);
			buff.position(buff.position() + toWrite);
			wrote += toWrite;
			relPosition += toWrite;
			
			if(buff.remaining() == 0)
				return wrote;
			
			current = current.next;
			relPosition = 0;
		}
	}
	
	private void write(int size, WOp op) {
		if(relPosition + size > current.block.bytes()) {
			op.write(0, tempMemBlock);
			int left = size;
			
			for(;;) {
				int toWrite = Math.min(left, (int)current.block.bytes() - relPosition);
				if(toWrite > 0) {
					if(relPosition + toWrite > current.size)
						current.increaseSize(toWrite);
					tempMemBlock.copyTo(current.block, size - left, relPosition, toWrite);
					relPosition+=toWrite;
					left-=toWrite;
					if(left == 0 )
						break;
				}
				if(current.next == null)
					addToEnd(new MemBlock(4096));
				relPosition = 0;
				current = current.next;
			}
		}
		else {
			if(relPosition + size > current.size) {
				current.increaseSize(size);
			}
			op.write(relPosition, current.block);
			relPosition += size;
		}
	}
	
	private <T> T read(int size, ROp<T> op) {
		if(relPosition + size > current.size) {
			int left = size;
			
			for(;;) {
				int toRead = Math.min(current.size - relPosition, left);
				if(toRead > 0) {
					current.block.copyTo(tempMemBlock, relPosition, size - left, toRead);
					relPosition+=toRead;
					left-=toRead;
					
					if(left == 0) 
						break;
				}
				current = current.next;
				relPosition = 0;
			}
			
			return op.read(0, tempMemBlock);
		}
		
		relPosition+=size;
		return op.read(relPosition-size, current.block);
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
		write(Double.BYTES, (pos, mem) -> mem.putDouble0(pos, v));
	}

	@Override
	public void writeFloat(float v) {
		write(Float.BYTES, (pos, mem) -> mem.putFloat0(pos, v));
	}

	@Override
	public void writeInt(int v) {
		write(Integer.BYTES, (pos, mem) -> mem.putInt0(pos, v));
	}

	@Override
	public void writeLong(long v) {
		write(Long.BYTES, (pos, mem) -> mem.putLong0(pos, v));
	}

	@Override
	public void writeShort(int v) {
		write(Short.BYTES, (pos, mem) -> mem.putShort0(pos, (short) (v & 0xFFFF)));
	}

	@Override
	public void writeUTF(String s) {
		for(int i = 0; i < s.length() + 1; i++) {
			
			char ch = i == s.length() ? 0 : s.charAt(i);
			
			if(ch >= 0x1 && ch <= 0x7F) {
				writeByte(ch);
			}
			else if(ch == 0 || (ch >= 0x80 && ch <= 0x7FF)) {
				writeByte(((ch >>> 6) & 0b0001_1111) | 0b1100_0000);
				writeByte((ch & 0b0011_1111) | 0b10000000);
			}
			else if(ch >= 0x800 && ch <= 0xFFFF) {
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
			char ch = (char) readUnsignedByte();
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
			read(Byte.BYTES, (op, mem) -> {return 0;});
		}
		
		return n;
	}
	
	public static void main(String... args) {
		OffheapDataChannel buff = OffheapDataChannel.withByteOrder(ByteOrder.BIG_ENDIAN);
		System.out.println(buff.byteOrder);
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
		
		buff.writeShort(0x8915);
		buff.position(buff.position() - Byte.BYTES);
		System.out.println(Integer.toHexString(buff.readUnsignedByte()));
		
		
		buff.close();
	}

}