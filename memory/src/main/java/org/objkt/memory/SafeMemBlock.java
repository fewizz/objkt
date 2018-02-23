package org.objkt.memory;

public class SafeMemBlock extends MemBlock implements AutoCloseable {
	@Override
	public void close() {
		free();
	}

}
