package org.objkt.memory;

public class NativeAllocation extends Allocation {

	public NativeAllocation(long address, long bytes) {
		this.address = address;
		this.bytes = bytes;
	}

	public void set(long a, long b) {
		this.address = a;
		this.bytes = b;
	}

}
