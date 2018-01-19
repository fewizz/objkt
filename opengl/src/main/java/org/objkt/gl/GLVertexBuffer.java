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
	
	/*public GLVertexBuffer floatData(BufferUsage usage, float... values) {
		MemBlock bl = MemBlock.ofFloats(values);
		super.data(bl, usage);
		bl.free();
		return this;
	}*/
}