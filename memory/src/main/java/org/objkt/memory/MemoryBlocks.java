package org.objkt.memory;

public class MemoryBlocks {
	static final ThreadLocal<SafeMemoryBlock> MEM_BLOCKS = ThreadLocal.withInitial(() -> new SafeMemoryBlock());
	
	public static SafeMemoryBlock get() {
		return MEM_BLOCKS.get();
	}
}
