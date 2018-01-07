package org.objkt.memory;

import static org.objkt.memory.Utils.unsafe;

import java.util.Arrays;

public class MemBlock {
	public static final long NULL_ADDRESS = 0L;
	static final boolean DEBUG = true;
	private static long allocatedTotal = 0;
	protected Allocation allocation;
	protected long address = NULL_ADDRESS;
	protected long bytes = 0;

	public MemBlock() {
	}
	
	public MemBlock(int bytes) {
		allocate(bytes);
	}
	
	public static MemBlock ofFloats(float... floats) {
		return new MemBlock().allocateFloats(floats.length).putFloats(floats);
	}
	
	public static long getAllocatedTotal() {
		return allocatedTotal;
	}

	public MemBlock allocate(long bytes) {
		if(DEBUG) {
			allocation = new Allocation();
		}
		
		capture(unsafe.allocateMemory(bytes), bytes);
		return this;
	}
	
	public MemBlock reallocate(long bytes) {
		if(DEBUG) {
			allocation = new Allocation();
		}
		
		capture(unsafe.reallocateMemory(address, bytes), bytes);
		return this;
	}
	
	public MemBlock allocateOrReallocate(long bytes) {
		return isAllocated() ? reallocate(bytes) : allocate(bytes);
	}
	
	/*@Deprecated
	public MemBlock capture(boolean freePrevious, long address, long bytes) {
		if(freePrevious) {
			free();
		}
		return capture(address, bytes);
	}*/
	
	@Deprecated
	public MemBlock capture(long address, long bytes) {
		this.address = address;
		setBytes(bytes);
		
		return this;
	}
	
	public MemBlock ensureAllocated(long bytes) {
		if(this.bytes < bytes) {
			allocate(bytes);
		}
		return this;
	}
	
	public MemBlock allocateShorts(int shorts) {
		return allocate(shorts * Short.BYTES);
	}
	
	public MemBlock allocateInts(int ints) {
		return allocate(ints * Integer.BYTES);
	}
	
	public MemBlock allocateFloats(int floats) {
		return allocate(floats * Float.BYTES);
	}
	
	public boolean isAllocated() {
		return address != NULL_ADDRESS;
	}

	public void set(byte value) {
		set(value, 0, bytes);
	}
	
	public void set(byte value, int from, long bytes) {
		unsafe.setMemory(address + from, bytes, value);
	}
	
	public long address() {
		return address;
	}

	// Byte
	public byte get(int pos) {
		return unsafe.getByte(address + pos);
	}

	public MemBlock put(int pos, byte value) {
		onPut(pos);
		unsafe.putByte(address + pos, value);
		return this;
	}
	
	// Short
	public short getShort0(int pos) {
		return unsafe.getShort(address + pos);
	}

	public short getShort(int pos) {
		return unsafe.getShort(address + pos * Short.BYTES);
	}

	public void putShort(int pos, short value) {
		pos *= Short.BYTES;
		onPut(pos);
		unsafe.putShort(address + pos, value);
	}

	// Float
	public float getFloat0(int pos) {
		return unsafe.getFloat(address + pos);
	}

	public float getFloat(int pos) {
		return unsafe.getFloat(address + pos * Float.BYTES);
	}

	public MemBlock putFloat(int pos, float value) {
		pos *= Float.BYTES;
		onPut(pos);
		unsafe.putFloat(address + pos, value);
		return this;
	}
	
	public MemBlock putFloats(float... values) {
		if(values.length > floats())
			throw new IndexOutOfBoundsException();
		for(int i = 0; i < values.length; i++) {
			putFloat(i, values[i]);
		}
		
		return this;
	}
	
	// Int
	public int getInt0(int pos) {
		return unsafe.getInt(address + pos);
	}

	public int getInt(int pos) {
		return unsafe.getInt(address + pos * Integer.BYTES);
	}
	
	public void putInt0(int pos, int value) {
		onPut(pos);
		unsafe.putInt(address + pos, value);
	}

	public void putInt(int pos, int value) {
		pos *= Integer.BYTES;
		onPut(pos);
		unsafe.putInt(address + pos, value);
	}
	
	// Double
	public double getDouble0(int pos) {
		return unsafe.getDouble(address + pos);
	}

	public double getDouble(int pos) {
		return unsafe.getDouble(address + pos * Double.BYTES);
	}

	public void putDouble(int pos, double value) {
		pos *= Double.BYTES;
		onPut(pos);
		unsafe.putDouble(address + pos, value);
	}

	// Long
	public long getLong0(int pos) {
		return unsafe.getLong(address + pos);
	}

	public long getLong(int pos) {
		return unsafe.getLong(address + pos * Long.BYTES);
	}

	public void putLong0(int pos, long value) {
		onPut(pos);
		unsafe.putLong(address + pos, value);
	}

	public MemBlock putLong(int pos, long value) {
		pos *= Long.BYTES;
		onPut(pos);
		unsafe.putLong(address + pos, value);
		return this;
	}

	public void free() {
		if(address == NULL_ADDRESS) {
			throw new RuntimeException();
		}
		
		if(allocation != null) {
			allocation.release();
			allocation = null;
		}
		
		unsafe.freeMemory(address);
		address = NULL_ADDRESS;
		setBytes(0);
	}

	public void copyTo(MemBlock mb) {
		assert(mb.bytes >= bytes);
		copyTo(mb, 0, 0, bytes);
	}
	
	public void copyTo(long adrressDest, long src, long bytes) {
		unsafe.copyMemory(address + src, adrressDest, bytes);
	}
	
	public void copyTo(MemBlock destMemoryBlock, long src, long dest, long bytes) {
		copyTo(destMemoryBlock.address + dest, src, bytes);
	}

	private void setBytes(long bytes) {
		allocatedTotal -= this.bytes;
		this.bytes = bytes;
		allocatedTotal += this.bytes;
	}

	public long bytes() {
		return bytes;
	}
	
	public long floats() {
		return bytes / Float.BYTES;
	}
	
	void onPut(int pos) {
		check(pos);
	}
	
	void check(int pos) {
		if(DEBUG) if(pos < 0 || pos >= bytes) throw new Error();
	}
	
	public int ints() {
		return (int) (bytes / Integer.BYTES);
	}

	/*public ByteBuffer getAsByteBuffer(int capacity) {
		return memByteBuffer(address, capacity);
	}

	public ByteBuffer getAsByteBuffer() {
		return getAsByteBuffer(bytes);
	}

	public FloatBuffer getAsFloatBuffer() {
		return memFloatBuffer(address, bytes / Float.BYTES);
	}*/
	
	public static class Allocation {
		final StackTraceElement[] allocStackTrace;
		boolean released;
		
		public Allocation() {
			if(DEBUG) {
				StackTraceElement[] allocStackTrace = Thread.currentThread().getStackTrace();
				this.allocStackTrace = Arrays.copyOfRange(allocStackTrace, 3, allocStackTrace.length);
			}
			else {
				this.allocStackTrace = null;
			}
		}
		
		public void release() {
			released = true;
		}
		
		@Override
		protected void finalize() throws Throwable {
			if(!released && allocStackTrace != null) {
				System.err.println("Allocated Memory Block is not free'ed:");
				
				for(StackTraceElement s : allocStackTrace)
					System.err.println(s);
				System.err.println();
				
			}
		}
	}
}
