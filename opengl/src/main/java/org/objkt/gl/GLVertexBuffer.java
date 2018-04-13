package org.objkt.gl;

import org.objkt.gl.enums.*;

public class GLVertexBuffer extends GLBuffer<GLVertexBuffer> {
	
	public GLVertexBuffer() {
		super(BufferTarget.ARRAY_BUFFER);
	}
	
	//public GLVertexBuffer(OffheapAllocation mb, BufferUsage usage) {
//		super(BufferTarget.ARRAY_BUFFER, usage, mb);
	//}
	
	/*public GLVertexBuffer floatData(BufferUsage usage, float... values) {
		OffheapAllocation bl = OffheapAllocation.ofFloats(values);
		super.data(bl, usage);
		bl.free();
		return this;
	}*/
}