package org.objkt.memory;

import static org.objkt.memory.Utils.UNSAFE;

public abstract class OffheapAllocation {
	abstract protected long address();
	abstract protected long bytes();
	
	public void free() {
		UNSAFE.freeMemory(address());
	}

	public void set(byte value) {
		set(value, 0, bytes());
	}
	
	public void set(byte value, int from, long bytes) {
		UNSAFE.setMemory(address() + from, bytes, value);
	}

	// Byte
	public byte get(int pos) {
		return UNSAFE.getByte(address() + pos);
	}

	public void put(int pos, byte value) {
		UNSAFE.putByte(address() + pos, value);
	}
	
	// Short
	public short getShort0(int pos) {
		return UNSAFE.getShort(address() + pos);
	}

	public short getShort(int pos) {
		return getShort0(pos * Short.BYTES);
	}

	public void putShort(int pos, short value) {
		putShort0(pos * Short.BYTES, value);
	}
	
	public void putShort0(int pos, short value) {
		UNSAFE.putShort(address() + pos, value);
	}

	// Float
	public float getFloat0(int pos) {
		return UNSAFE.getFloat(address() + pos);
	}

	public float getFloat(int pos) {
		return getFloat0(pos * Float.BYTES);
	}

	public void putFloat(int pos, float value) {
		putFloat0(pos * Float.BYTES, value);
	}
	
	public void putFloat0(int pos, float value) {
		UNSAFE.putFloat(address() + pos, value);
	}
	
	// Int
	public int getInt0(int pos) {
		return UNSAFE.getInt(address() + pos);
	}

	public int getInt(int pos) {
		return getInt0(pos*Integer.BYTES);
	}
	
	public void putInt0(int pos, int value) {
		UNSAFE.putInt(address() + pos, value);
	}

	public void putInt(int pos, int value) {
		putInt0(pos*Integer.BYTES, value);
	}
	
	// Double
	public double getDouble0(int pos) {
		return UNSAFE.getDouble(address() + pos);
	}

	public double getDouble(int pos) {
		return getDouble0(pos*Double.BYTES);
	}

	public void putDouble(int pos, double value) {
		putDouble0(pos*Double.BYTES, value);
	}
	
	public void putDouble0(int pos, double value) {
		UNSAFE.putDouble(address() + pos, value);
	}

	// Long
	public long getLong0(int pos) {
		return UNSAFE.getLong(address() + pos);
	}

	public long getLong(int pos) {
		return getLong0(pos*Long.BYTES);
	}

	public void putLong0(int pos, long value) {
		UNSAFE.putLong(address() + pos, value);
	}

	public void putLong(int pos, long value) {
		putLong0(pos*Long.BYTES, value);
	}
	
	// Char
	public char getChar0(int pos) {
		return UNSAFE.getChar(address() + pos);
	}
	
	public char getChar(int pos) {
		return getChar0(pos*Character.BYTES);
	}
	
	public void putChar(int pos, char value) {
		putChar0(pos*Character.BYTES, value);
	}
	
	public void putChar0(int pos, char value) {
		UNSAFE.putChar(address() + pos, value);
	}
	
	public void copyTo(OffheapAllocation mb) {
		copyTo(mb, 0, 0, bytes());
	}
	
	public void copyTo(long adrressDest, long src, long bytes) {
		UNSAFE.copyMemory(address() + src, adrressDest, bytes);
	}
	
	public void copyTo(OffheapAllocation destMemoryBlock, long src, long dest, long bytes) {
		copyTo(destMemoryBlock.address() + dest, src, bytes);
	}
}
