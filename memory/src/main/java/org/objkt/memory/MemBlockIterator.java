package org.objkt.memory;

import java.util.Iterator;

public class MemBlockIterator implements Iterator<Byte> {
	MemBlock memBlock;
	int location;
	
	public void set(MemBlock block) {
		memBlock = block;
	}
	
	@Override
	public boolean hasNext() {
		return location < memBlock.bytes();
	}

	@Override
	public Byte next() {
		return memBlock.get(location++);
	}
	
	public int nextInt() {
		int val = memBlock.getInt(location);
		location += Integer.BYTES;
		return val;
	}
	
	public float nextFloat() {
		float val = memBlock.getFloat(location);
		location += Float.BYTES;
		return val;
	}

}
