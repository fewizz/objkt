package org.objkt.gl;

import org.objct.gl.enums.BufferTarget;

public class GLShaderStorageBuffer extends GLBuffer<GLShaderStorageBuffer> {
	
	public GLShaderStorageBuffer() {
		super(BufferTarget.SHADER_STORAGE_BUFFER);
	}
}
