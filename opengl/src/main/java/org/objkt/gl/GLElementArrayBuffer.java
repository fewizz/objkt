package org.objkt.gl;

import org.objkt.gl.enums.BufferTarget;

public class GLElementArrayBuffer extends GLBuffer<GLElementArrayBuffer> {
	
	public GLElementArrayBuffer() {
		super(BufferTarget.ELEMENT_ARRAY_BUFFER);
	}

}
