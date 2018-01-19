package org.objkt.memory;

public class SafeMemoryBlock extends MemBlock implements AutoCloseable {
	@Override
	public void close() {
		free();
	}

}
