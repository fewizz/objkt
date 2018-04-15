package org.objkt.memory;

public class ImmutableOffheapAllocation implements OffheapAllocation {
	final long address;
	final long bytes;

	ImmutableOffheapAllocation(long bytes) {
		address = Utils.UNSAFE.allocateMemory(bytes);
		this.bytes = bytes;
	}

	@Override
	public long address() {
		return address;
	}

	@Override
	public long bytes() {
		return bytes;
	}

	@Override
	public void free() {
		Utils.UNSAFE.freeMemory(bytes);
	}
}
