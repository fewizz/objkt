package org.objkt.memory;

public class SafeOffheapAllocation implements OffheapAllocation {
	
	// Byte
	@Override
	default byte get(int pos) {
		check(pos);
		return OffheapAllocation.super.get(pos);
	}
	
	@Override
	public void put(int pos, byte value) {
		check(pos);
		super.put(pos, value);
	}
	
	// Short
	@Override
	public short getShort0(int pos) {
		check(pos);
		return super.getShort0(pos);
	}
	
	@Override
	public void putShort0(int pos, short value) {
		check(pos);
		super.putShort(pos, value);
	}
	
	// Char
	@Override
	public void putChar0(int pos, char value) {
		check(pos);
		super.putChar0(pos, value);
	}
	
	@Override
	public char getChar0(int pos) {
		check(pos);
		return super.getChar0(pos);
	}
	
	// Int
	@Override
	public int getInt0(int pos) {
		check(pos);
		return super.getInt0(pos);
	}
	
	@Override
	public void putInt0(int pos, int value) {
		check(pos);
		super.putInt0(pos, value);
	}
	
	// Long
	@Override
	public long getLong0(int pos) {
		check(pos);
		return super.getLong0(pos);
	}
	
	@Override
	public void putLong0(int pos, long value) {
		check(pos);
		super.putLong0(pos, value);
	}
	
	// Float
	@Override
	public float getFloat0(int pos) {
		check(pos);
		return super.getFloat0(pos);
	}
	
	@Override
	public void putFloat0(int pos, float value) {
		check(pos);
		super.putFloat0(pos, value);
	}
	
	// Double
	@Override
	public double getDouble0(int pos) {
		check(pos);
		return super.getDouble0(pos);
	}
	
	@Override
	public void putDouble0(int pos, double value) {
		check(pos);
		super.putDouble0(pos, value);
	}
	
	default void check(int pos) {
		if(pos < 0 || pos >= bytes()) throw new Error();
	}

}
