package org.objct.gl.utils;

import org.objct.gl.enums.BufferUsage;
import org.objkt.gl.GLVertexArray;
import org.objkt.gl.GLVertexBuffer;
import org.objkt.gl.GLVertexArray.VertexAttribInfo;
import org.objkt.memory.MemBlock;

public class VertexArrayBuilder {
	final GLVertexArray va;
	final int vertexNumber;
	int vertex;
	final BufferUsage usage;
	//final Map<Integer, VertexAttribArrayBuffer> attribArrays = new HashMap<>();
	final VertexAttribArrayBuffer[] attribs;

	public VertexArrayBuilder(BufferUsage u, int p_vertexNumber, VertexAttribInfo... attribsArray) {
		this.va = new GLVertexArray();
		this.vertexNumber = p_vertexNumber;
		this.usage = u;
		this.attribs = new VertexAttribArrayBuffer[attribsArray.length];

		for (int i = 0; i < attribsArray.length; i++) {
			VertexAttribInfo attribInfo = attribsArray[i];
			GLVertexBuffer vbo = new GLVertexBuffer();
			vbo.allocate(vertexNumber * attribInfo.componentsBytes(), usage);
			attribs[i] = VertexAttribArrayBuffer.map(va.vertexAttribPointer(i, attribInfo, vbo).enable(), p_vertexNumber);
		}
		
		vertex = 0;
	}

	public void endVertex() {
		if (vertex >= vertexNumber) {
			throw new Error("Too much verticies.");
		}

		for(VertexAttribArrayBuffer vab : attribs) {
			int step = vab.vaa.info.componentsBytes();
			int start = step * vertex;
			vab.nextVertexMemoryBlock.copyTo(vab, 0, start, step);
		}

		vertex++;
	}

	public GLVertexArray build() {
		for(VertexAttribArrayBuffer vab : attribs) {
			vab.updateServerData();
			vab.freeClientData();
		}
		
		return va;
	}

	public VertexArrayBuilder float3(int location, float f1, float f2, float f3) {
		MemBlock mb = attribs[location].nextVertexMemoryBlock;

		mb.putFloat(0, f1);
		mb.putFloat(1, f2);
		mb.putFloat(2, f3);
		return this;
	}

	public VertexArrayBuilder float2(int location, float f1, float f2) {
		MemBlock mb = attribs[location].nextVertexMemoryBlock;

		mb.putFloat(0, f1);
		mb.putFloat(1, f2);
		return this;
	}

	public VertexArrayBuilder float1(int location, float f) {
		attribs[location].nextVertexMemoryBlock.putFloat(0, f);
		return this;
	}

	public VertexArrayBuilder int1(int location, int i) {
		attribs[location].nextVertexMemoryBlock.putInt(0, i);
		return this;
	}

	public VertexArrayBuilder short1(int location, short s) {
		attribs[location].nextVertexMemoryBlock.putShort(0, s);
		return this;
	}
}
