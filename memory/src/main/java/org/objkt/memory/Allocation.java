package org.objkt.memory;

import static org.objkt.memory.Utils.*;

public class Allocation {
	protected long address = 0;
	protected long bytes = 0;
	
	protected Allocation() {}
	
	public Allocation(long bytes) {
		address = UNSAFE.allocateMemory(bytes);
		this.bytes = bytes;
	}
	
	public void reallocate(long bytes) {
		UNSAFE.reallocateMemory(address, bytes);
		this.bytes = bytes;
	}
	
	public void release() {
		UNSAFE.freeMemory(address);
		address = 0;
	}
	
	/*public void set(byte value, int from, long bytes) {
		UNSAFE.setMemory(address + from, bytes, value);
	}
	
	/*public byte getByte(int index) {
		return UNSAFE.getByte(address + index);
	}
	
	public short getShort(int index) {
		return UNSAFE.getShort(address + index);
	}
	
	public char getChar(int index) {
		return UNSAFE.getChar(address + index);
	}
	
	public int getInt(int index) {
		return UNSAFE.getInt(address + index);
	}
	
	public float getFloat(int index) {
		return UNSAFE.getFloat(address + index);
	}
	
	public long getLong(int index) {
		return UNSAFE.getLong(address + index);
	}
	
	public double getDouble(int index) {
		return UNSAFE.getDouble(address + index);
	}*/
}
