package org.objkt.memory;

import java.io.*;

public class MemBlockDataInput implements DataInput {
	final MemBlock block;
	int position = 0;
	
	public MemBlockDataInput(MemBlock block) {
		this.block = block;
	}
	
	public void free() {
		block.free();
		position = -1;
	}

	@Override
	public boolean readBoolean() {
		byte v = block.get(position);
		position++;
		return v != 0;
	}

	@Override
	public byte readByte() {
		byte v = block.get(position);
		position++;
		return v;
	}

	@Override
	public char readChar() {
		char v = block.getChar0(position);
		position += Character.BYTES;
		return v;
	}

	@Override
	public double readDouble() {
		double v = block.getDouble0(position);
		position += Double.BYTES;
		return v;
	}

	@Override
	public float readFloat() {
		float v = block.getFloat0(position);
		position += Float.BYTES;
		return v;
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
		int v = block.getInt0(position);
		position += Integer.BYTES;
		return v;
	}

	@Override
	public String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long readLong() {
		long v = block.getLong0(position);
		position += Long.BYTES;
		return v;
	}

	@Override
	public short readShort() {
		short v = block.getShort0(position);
		position += Short.BYTES;
		return v;
	}

	@Override
	public String readUTF() {
		// TODO Auto-generated method stub
		return null;
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
		position += n;
		return n; //TODO
	}

}
