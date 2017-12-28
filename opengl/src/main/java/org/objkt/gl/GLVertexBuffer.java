package org.objkt.gl;

import org.objkt.gl.enums.BufferTarget;

public class GLVertexBuffer extends GLBuffer<GLVertexBuffer> {
	
	public GLVertexBuffer() {
		super(BufferTarget.ARRAY_BUFFER);
	}
}