package org.objkt.memory;

import static org.objkt.memory.Utils.UNSAFE;

public class MemBlock {
	protected Allocation alloc;
	
	public MemBlock() {
	}
	
	public MemBlock(Allocation alloc) {
		this.alloc = alloc;
	}
	
	public MemBlock(long bytes) {
		allocate(bytes);
	}

	public MemBlock allocate(long bytes) {
		alloc = new Allocation(bytes);
		return this;
	}
	
	public MemBlock reallocate(long bytes) {
		alloc.reallocate(bytes);
		return this;
	}
	
	public void free() {
		this.alloc.release();
		this.alloc = null;
	}
	
	public void setAllocation(Allocation alloc) {
		this.alloc = alloc;
	}
	
	public Allocation getAllocation() {
		return alloc;
	}
	
	public long bytes() {
		return alloc.bytes;
	}

	public long address() { return alloc.address; }

	public void set(byte value) {
		set(value, 0, alloc.bytes);
	}
	
	public void set(byte value, int from, long bytes) {
		UNSAFE.setMemory(alloc.address + from, bytes, value);
	}

	// Byte
	public byte get(int pos) {
		return UNSAFE.getByte(alloc.address + pos);
	}

	public void put(int pos, byte value) {
		UNSAFE.putByte(alloc.address + pos, value);
	}
	
	// Short
	public short getShort0(int pos) {
		return UNSAFE.getShort(alloc.address + pos);
	}

	public short getShort(int pos) {
		return getShort0(pos * Short.BYTES);
	}

	public void putShort(int pos, short value) {
		putShort0(pos * Short.BYTES, value);
	}
	
	public void putShort0(int pos, short value) {
		UNSAFE.putShort(alloc.address + pos, value);
	}

	// Float
	public float getFloat0(int pos) {
		return UNSAFE.getFloat(alloc.address + pos);
	}

	public float getFloat(int pos) {
		return getFloat0(pos * Float.BYTES);
	}

	public void putFloat(int pos, float value) {
		putFloat0(pos * Float.BYTES, value);
	}
	
	public void putFloat0(int pos, float value) {
		UNSAFE.putFloat(alloc.address + pos, value);
	}
	
	public MemBlock putFloats(float... values) {
		if(values.length > bytes() / Float.BYTES)
			throw new IndexOutOfBoundsException();
		for(int i = 0; i < values.length; i++) {
			putFloat(i, values[i]);
		}
		
		return this;
	}
	
	// Int
	public int getInt0(int pos) {
		return UNSAFE.getInt(alloc.address + pos);
	}

	public int getInt(int pos) {
		return getInt0(pos*Integer.BYTES);
	}
	
	public void putInt0(int pos, int value) {
		UNSAFE.putInt(alloc.address + pos, value);
	}

	public void putInt(int pos, int value) {
		putInt0(pos*Integer.BYTES, value);
	}
	
	// Double
	public double getDouble0(int pos) {
		return UNSAFE.getDouble(alloc.address + pos);
	}

	public double getDouble(int pos) {
		return getDouble0(pos*Double.BYTES);
	}

	public void putDouble(int pos, double value) {
		putDouble0(pos*Double.BYTES, value);
	}
	
	public void putDouble0(int pos, double value) {
		UNSAFE.putDouble(alloc.address + pos, value);
	}

	// Long
	public long getLong0(int pos) {
		return UNSAFE.getLong(alloc.address + pos);
	}

	public long getLong(int pos) {
		return getLong0(pos*Long.BYTES);
	}

	public void putLong0(int pos, long value) {
		UNSAFE.putLong(alloc.address + pos, value);
	}

	public void putLong(int pos, long value) {
		putLong0(pos*Long.BYTES, value);
	}
	
	// Char
	public char getChar0(int pos) {
		return UNSAFE.getChar(alloc.address + pos);
	}
	
	public char getChar(int pos) {
		return getChar0(pos*Character.BYTES);
	}
	
	public void putChar(int pos, char value) {
		putChar0(pos*Character.BYTES, value);
	}
	
	public void putChar0(int pos, char value) {
		UNSAFE.putChar(alloc.address + pos, value);
	}
	
	public void copyTo(MemBlock mb) {
		assert(mb.alloc.bytes >= alloc.bytes);
		copyTo(mb, 0, 0, alloc.bytes);
	}
	
	public void copyTo(long adrressDest, long src, long bytes) {
		UNSAFE.copyMemory(alloc.address + src, adrressDest, bytes);
	}
	
	public void copyTo(MemBlock destMemoryBlock, long src, long dest, long bytes) {
		copyTo(destMemoryBlock.alloc.address + dest, src, bytes);
	}
}
