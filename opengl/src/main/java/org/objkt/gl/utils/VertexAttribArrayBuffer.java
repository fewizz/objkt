package org.objkt.gl.utils;

import org.objkt.gl.GLVertexArray.VertexAttribArray;
import org.objkt.gl.enums.BufferAccessMask;
import org.objkt.memory.MemBlock;

class VertexAttribArrayBuffer extends MemBlock {
	final VertexAttribArray vaa;
	public final MemBlock nextVertexMemoryBlock = new MemBlock();
	int clientVertexNumber = 0;
	
	private VertexAttribArrayBuffer(VertexAttribArray vaa) {
		this.vaa = vaa;
		nextVertexMemoryBlock.allocate(vaa.info.componentsBytes());
	}
	
	public static VertexAttribArrayBuffer map(VertexAttribArray vaa, int size) {
		VertexAttribArrayBuffer b = new VertexAttribArrayBuffer(vaa);
		vaa.vbo.mapRange(0, size * vaa.info.componentsBytes(), BufferAccessMask.MAP_WRITE_BIT, b);
		
		return b;
	}
	
	public void freeClientData() {
		clientVertexNumber = 0;
		
		nextVertexMemoryBlock.free();
		
		if(isAllocated()) {
			System.err.println("VertexAttribBuffer is mapped");
		}
	}
	
	public void updateServerData() {
		vaa.vbo.unmap();
	}
}
