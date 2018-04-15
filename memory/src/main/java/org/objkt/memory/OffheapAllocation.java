package org.objkt.memory;

import static org.objkt.memory.Utils.UNSAFE;

public interface OffheapAllocation {
	long address();
	long bytes();
	
	void free();

	default void set(byte value) {
		set(value, 0, bytes());
	}
	
	default void set(byte value, int from, long bytes) {
		UNSAFE.setMemory(address() + from, bytes, value);
	}

	// Byte
	default byte get(int pos) {
		return UNSAFE.getByte(address() + pos);
	}

	default void put(int pos, byte value) {
		UNSAFE.putByte(address() + pos, value);
	}
	
	// Short
	default short getShort0(int pos) {
		return UNSAFE.getShort(address() + pos);
	}

	default short getShort(int pos) {
		return getShort0(pos * Short.BYTES);
	}

	default void putShort(int pos, short value) {
		putShort0(pos * Short.BYTES, value);
	}

	default void putShort0(int pos, short value) {
		UNSAFE.putShort(address() + pos, value);
	}

	// Float
	default float getFloat0(int pos) {
		return UNSAFE.getFloat(address() + pos);
	}

	default float getFloat(int pos) {
		return getFloat0(pos * Float.BYTES);
	}

	default void putFloat(int pos, float value) {
		putFloat0(pos * Float.BYTES, value);
	}

	default void putFloat0(int pos, float value) {
		UNSAFE.putFloat(address() + pos, value);
	}
	
	// Int
	default int getInt0(int pos) {
		return UNSAFE.getInt(address() + pos);
	}

	default int getInt(int pos) {
		return getInt0(pos*Integer.BYTES);
	}

	default void putInt0(int pos, int value) {
		UNSAFE.putInt(address() + pos, value);
	}

	default void putInt(int pos, int value) {
		putInt0(pos*Integer.BYTES, value);
	}
	
	// Double
	default double getDouble0(int pos) {
		return UNSAFE.getDouble(address() + pos);
	}

	default double getDouble(int pos) {
		return getDouble0(pos*Double.BYTES);
	}

	default void putDouble(int pos, double value) {
		putDouble0(pos*Double.BYTES, value);
	}

	default void putDouble0(int pos, double value) {
		UNSAFE.putDouble(address() + pos, value);
	}

	// Long
	default long getLong0(int pos) {
		return UNSAFE.getLong(address() + pos);
	}

	default long getLong(int pos) {
		return getLong0(pos*Long.BYTES);
	}

	default void putLong0(int pos, long value) {
		UNSAFE.putLong(address() + pos, value);
	}

	default void putLong(int pos, long value) {
		putLong0(pos*Long.BYTES, value);
	}
	
	// Char
	default char getChar0(int pos) {
		return UNSAFE.getChar(address() + pos);
	}

	default char getChar(int pos) {
		return getChar0(pos*Character.BYTES);
	}

	default void putChar(int pos, char value) {
		putChar0(pos*Character.BYTES, value);
	}

	default void putChar0(int pos, char value) {
		UNSAFE.putChar(address() + pos, value);
	}

	default void copyTo(OffheapAllocation mb) {
		copyTo(mb, 0, 0, bytes());
	}

	default void copyTo(long adrressDest, long src, long bytes) {
		UNSAFE.copyMemory(address() + src, adrressDest, bytes);
	}

	default void copyTo(OffheapAllocation destMemoryBlock, long src, long dest, long bytes) {
		copyTo(destMemoryBlock.address() + dest, src, bytes);
	}
}
