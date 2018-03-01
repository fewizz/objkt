package org.objkt.memory;

import java.nio.ByteBuffer;
import java.util.*;

public final class MemBlockBuffer implements DataOutput, DataInput {
	public final List<MemBlock> blocks = new ArrayList<>();
	public final List<Integer> lengths = new ArrayList<>();
	int current = 0;
	int position;
	public final int blockSize = 4*1024;
	
	public MemBlockBuffer() {
		blocks.add(new MemBlock(blockSize));
		lengths.add(0);
	}
	
	public void capture(MemBlock memBlock) {
		blocks.add(memBlock);
		lengths.add((int) memBlock.bytes);
	}
	
	@SuppressWarnings("deprecation")
	public void capture(ByteBuffer bb) {
		MemBlock block = new MemBlock();
		block.capture(Utils.address(bb), bb.remaining());
		capture(block);
	}
	
	public void free() {
		blocks.forEach(block -> block.free());
		blocks.clear();
		lengths.clear();
	}
	
	public void resetPosition() {
		current = 0;
		position = 0;
	}
	
	public int size() {
		int p = 0;
		for(int s : lengths) p += s;
		return p;
	}
	
	public boolean isReadable() {
		return (current < blocks.size() - 1) || (position < lengths.get(current) - 1);
	}
	
	private void prepare(int size, boolean allocate) {
		if(lengths.get(current) >= position + size) {
			return;
		}
		else if(blocks.get(current).bytes < lengths.get(current) + size) {
			current++;
			int lastIndex = lengths.size() - 1;
				
			if(lastIndex < current) {
				if(!allocate)
					throw new IndexOutOfBoundsException();
				lengths.add(0);
				blocks.add(new MemBlock(blockSize));		
			}
			position = 0;
		}
		else lengths.set(current, lengths.get(current) + size);	
	}

	@Override
	public void write(int b) {
		prepare(Byte.BYTES, true);
		blocks.get(current).put(position, (byte) b);
		position+=Byte.BYTES;
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
            write((byte) s.charAt(i));
        }
	}

	@Override
	public void writeChar(int v) {
		prepare(Character.BYTES, true);
		blocks.get(current).putChar0(position, (char) v);
		position += Character.BYTES;
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
		prepare(Double.BYTES, true);
		blocks.get(current).putDouble0(position, v);
		position += Double.BYTES;
	}

	@Override
	public void writeFloat(float v) {
		prepare(Float.BYTES, true);
		blocks.get(current).putFloat0(position, v);
		position += Float.BYTES;
	}

	@Override
	public void writeInt(int v) {
		prepare(Integer.BYTES, true);
		blocks.get(current).putInt0(position, v);
		position += Integer.BYTES;
	}

	@Override
	public void writeLong(long v) {
		prepare(Long.BYTES, true);
		blocks.get(current).putLong0(position, v);
		position += Long.BYTES;
	}

	@Override
	public void writeShort(int v) {
		prepare(Short.BYTES, true);
		blocks.get(current).putShort0(position, (short) v);
		position += Short.BYTES;
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
				writeByte(((ch >>> 6) & 0b00111111) | 0b1000_0000);
				writeByte((ch & 0b00111111) | 0b1000_0000);
			}
		}
	}
	
	@Override
	public boolean readBoolean() {
		return readByte() != 0;
	}

	@Override
	public byte readByte() {
		prepare(Byte.BYTES, false);
		position += Byte.BYTES;
		return blocks.get(current).get(position - Byte.BYTES);
	}

	@Override
	public char readChar() {
		prepare(Character.BYTES, false);
		position += Character.BYTES;
		return blocks.get(current).getChar0(position - Character.BYTES);
	}

	@Override
	public double readDouble() {
		prepare(Double.BYTES, false);
		position += Double.BYTES;
		return blocks.get(current).getDouble0(position - Double.BYTES);
	}

	@Override
	public float readFloat() {
		prepare(Float.BYTES, true);
		position += Float.BYTES;
		return blocks.get(current).getFloat0(position - Float.BYTES);
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
		prepare(Integer.BYTES, false);
		position += Integer.BYTES;
		return blocks.get(current).getInt0(position - Integer.BYTES);
	}

	@Override
	public String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long readLong() {
		prepare(Long.BYTES, false);
		position += Long.BYTES;
		return blocks.get(current).getLong0(position - Long.BYTES);
	}

	@Override
	public short readShort() {
		prepare(Short.BYTES, false);
		position += Short.BYTES;
		return blocks.get(current).getShort0(position - Short.BYTES);
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
		prepare(n, false);
		position += n;
		return n;
	}
	
	public static void main(String[] args) {
		MemBlockBuffer buff = new MemBlockBuffer();
		buff.writeUTF("Hello!");
		buff.writeInt(15000);
		buff.resetPosition();
		System.out.println(buff.readUTF() + " " + buff.readInt());
	}

}
