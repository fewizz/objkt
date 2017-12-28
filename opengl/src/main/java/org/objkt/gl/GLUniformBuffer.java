package org.objkt.gl;

import org.objkt.gl.enums.BufferTarget;

public class GLUniformBuffer extends GLBuffer<GLUniformBuffer> {
	
	public GLUniformBuffer() {
		super(BufferTarget.UNIFORM_BUFFER);
	}
}
