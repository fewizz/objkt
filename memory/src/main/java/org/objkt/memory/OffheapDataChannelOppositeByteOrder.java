package org.objkt.memory;

import java.nio.ByteOrder;
import java.util.function.Supplier;

public class OffheapDataChannelOppositeByteOrder extends OffheapDataChannel {

	OffheapDataChannelOppositeByteOrder(ByteOrder order, Supplier<MemBlock> factory) {
		super(order, factory);
	}

	@Override
	public char readChar() {
		return Character.reverseBytes(super.readChar());
	}
	
	@Override
	public short readShort() {
		return Short.reverseBytes(super.readShort());
	}
	
	@Override
	public int readInt() {
		return Integer.reverseBytes(super.readInt());
	}
	
	@Override
	public long readLong() {
		return Long.reverseBytes(super.readLong());
	}
	
	@Override
	public float readFloat() {
		return Float.intBitsToFloat(Integer.reverseBytes(super.readInt()));
	}
	
	@Override
	public double readDouble() {
		return Double.longBitsToDouble(Long.reverseBytes(super.readLong()));
	}
	
	@Override
	public void writeChar(int v) {
		super.writeChar(Character.reverseBytes((char) (v & 0xFFFF)));
	}
	
	@Override
	public void writeShort(int v) {
		super.writeShort(Short.reverseBytes((short) (v & 0xFFFF)));
	}
	
	@Override
	public void writeInt(int v) {
		super.writeInt(Integer.reverseBytes(v));
	}
	
	@Override
	public void writeLong(long v) {
		super.writeLong(Long.reverseBytes(v));
	}
	
	@Override
	public void writeFloat(float v) {
		super.writeInt(Integer.reverseBytes(Float.floatToIntBits(v)));
	}
	
	@Override
	public void writeDouble(double v) {
		super.writeLong(Long.reverseBytes(Double.doubleToLongBits(v)));
	}
}
