package org.objkt.gl;

import org.objkt.gl.enums.BufferTarget;
import org.objkt.gl.enums.BufferUsage;
import org.objkt.memory.MemBlock;

public class GLVertexBuffer extends GLBuffer<GLVertexBuffer> {
	
	public GLVertexBuffer() {
		super(BufferTarget.ARRAY_BUFFER);
	}
	
	public GLVertexBuffer(MemBlock mb, BufferUsage usage) {
		super(BufferTarget.ARRAY_BUFFER, usage, mb);
	}
}