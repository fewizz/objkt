package org.objkt.memory;

import java.io.*;
import java.util.*;

public final class MemBlockDataOutput implements DataOutput {
	public final List<MemBlock> blocks = new ArrayList<>();
	public final List<Integer> lengths = new ArrayList<>();
	int current;
	//int position = 0;
	public final int blockSize = 0xFFF;
	
	public MemBlockDataOutput() {
		blocks.add(new MemBlock(blockSize));
		lengths.add(0);
	}
	
	public void free() {
		blocks.forEach(block -> block.free());
		blocks.clear();
		lengths.clear();
	}
	
	public int size() {
		int p = 0;
		for(int s : lengths) p += s;
		return p;
	}
	
	private void check(int size) {
		if(blocks.get(current).bytes < lengths.get(current) + size) {
			lengths.add(size);
			blocks.add(new MemBlock(blockSize));
			current++;
		}
		else {
			lengths.set(current, lengths.get(current) + size);
		}
	}

	@Override
	public void write(int b) {
		check(Byte.BYTES);
		blocks.get(current).put(lengths.get(current) - Byte.BYTES, (byte) b);
		//position += Byte.BYTES;
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
		check(Character.BYTES);
		blocks.get(current).putChar0(lengths.get(current) - Character.BYTES, (char) v);
		//position += Character.BYTES;
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
		check(Double.BYTES);
		blocks.get(current).putDouble0(lengths.get(current) - Double.BYTES, v);
		//position += Double.BYTES;
	}

	@Override
	public void writeFloat(float v) {
		check(Float.BYTES);
		blocks.get(current).putFloat0(lengths.get(current) - Float.BYTES, v);
		//position += Float.BYTES;
	}

	@Override
	public void writeInt(int v) {
		check(Integer.BYTES);
		blocks.get(current).putInt0(lengths.get(current) - Integer.BYTES, v);
		//position += Integer.BYTES;
	}

	@Override
	public void writeLong(long v) {
		check(Long.BYTES);
		blocks.get(current).putLong0(lengths.get(current) - Long.BYTES, v);
		//position += Long.BYTES;
	}

	@Override
	public void writeShort(int v) {
		check(Short.BYTES);
		blocks.get(current).putShort0(lengths.get(current) - Short.BYTES, (short) v);
		//position += Short.BYTES;
	}

	@Override
	public void writeUTF(String s) {
		int len = Utils.utf8Length(s);
		check(len);
		blocks.get(current).putUTF8(s, lengths.get(current) - len, false);
		//position += len;
	}

}
