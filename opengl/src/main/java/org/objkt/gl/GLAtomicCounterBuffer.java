package org.objkt.gl;

import org.objct.gl.enums.BufferTarget;

public class GLAtomicCounterBuffer extends GLBuffer<GLAtomicCounterBuffer>{
	
	public GLAtomicCounterBuffer() {
		super(BufferTarget.ATOMIC_COUNTER_BUFFER);
	}
}
