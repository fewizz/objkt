package org.objkt.gl.utils;

import org.objkt.gl.GLVertexArray.VertexAttribArray;
import org.objkt.gl.enums.BufferAccess;
import org.objkt.memory.MemBlock;

class VertexAttribArrayBuffer extends MemBlock {
	final VertexAttribArray vaa;
	public final MemBlock nextVertexMemoryBlock = MemBlock.empty();
	
	private VertexAttribArrayBuffer(VertexAttribArray vaa) {
		super(0);
		this.vaa = vaa;
		nextVertexMemoryBlock.allocate(vaa.info.bytes()); 
	}
	
	public static VertexAttribArrayBuffer map(VertexAttribArray vaa, int size) {
		VertexAttribArrayBuffer vaab = new VertexAttribArrayBuffer(vaa);
		vaa.vbo.mapRange(0, size * vaa.info.bytes(), vaab, BufferAccess.MAP_WRITE_BIT);
		
		return vaab;
	}
	
	public void freeClientData() {
		nextVertexMemoryBlock.free();
		
		if(isAllocated()) {
			System.err.println("VertexAttribBuffer is mapped");
		}
	}
	
	public void updateServerData() {
		vaa.vbo.unmap();
	}
}
