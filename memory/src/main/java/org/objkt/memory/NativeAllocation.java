package org.objkt.memory;

public class NativeAllocation extends Allocation {

	public NativeAllocation(long address, long bytes) {
		this.address = address;
		this.bytes = bytes;
	}

}
