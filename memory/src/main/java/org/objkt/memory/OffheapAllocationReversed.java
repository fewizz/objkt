package org.objkt.memory;

public interface OffheapAllocationReversed extends OffheapAllocation {
	@Override
	default void putShort0(int pos, short value) {
		OffheapAllocation.super.putShort0(pos, Short.reverseBytes(value));
	}

	@Override
	default short getShort0(int pos) {
		return Short.reverseBytes(OffheapAllocation.super.getShort0(pos));
	}

	@Override
	default void putChar0(int pos, char value) {
		OffheapAllocation.super.putChar0(pos, Character.reverseBytes(value));
	}

	@Override
	default char getChar0(int pos) {
		return Character.reverseBytes(OffheapAllocation.super.getChar0(pos));
	}

	@Override
	default void putInt0(int pos, int value) {
		OffheapAllocation.super.putInt0(pos, Integer.reverseBytes(value));
	}
}
