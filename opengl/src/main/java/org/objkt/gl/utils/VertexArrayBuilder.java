package org.objkt.gl.utils;

import org.objkt.gl.GLVertexArray;
import org.objkt.gl.GLVertexBuffer;
import org.objkt.gl.GLVertexArray.VertexAttribFormat;
import org.objkt.gl.enums.BufferUsage;
import org.objkt.memory.OffheapAllocation;

public class VertexArrayBuilder {
	final GLVertexArray va;
	final int numberOfVerticies;
	int vertex;
	final BufferUsage usage;
	final VertexAttribArrayBuffer[] attribs;

	public VertexArrayBuilder(BufferUsage u, int p_verts, VertexAttribFormat... attribsArray) {
		this.va = new GLVertexArray();
		this.numberOfVerticies = p_verts;
		this.usage = u;
		
		int maxIndex = 0;
		for(VertexAttribFormat format : attribsArray) if(format.index > maxIndex) maxIndex = format.index;
		
		this.attribs = new VertexAttribArrayBuffer[maxIndex + 1];

		for (VertexAttribFormat attribFormat : attribsArray) {
			if(attribs[attribFormat.index] != null) {
				throw new Error("Attrib index " + attribFormat.index + " uses multiple times");
			}
			
			GLVertexBuffer vbo = new GLVertexBuffer();
			vbo.allocate(numberOfVerticies * attribFormat.bytes(), usage);
			attribs[attribFormat.index] = VertexAttribArrayBuffer.map(va.vertexAttribPointer(attribFormat, vbo).enable(), p_verts);
		}
		
		vertex = 0;
	}

	public final void endVertex() {
		if (vertex >= numberOfVerticies) {
			throw new Error("Too much verticies.");
		}

		for(VertexAttribArrayBuffer vab : attribs) {
			int step = vab.vaa.info.bytes();
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

	public final VertexArrayBuilder float3(int index, float f1, float f2, float f3) {
		OffheapAllocation mb = attribs[index].nextVertexMemoryBlock;

		mb.putFloat(0, f1);
		mb.putFloat(1, f2);
		mb.putFloat(2, f3);
		return this;
	}

	public final VertexArrayBuilder float2(int index, float f1, float f2) {
		OffheapAllocation mb = attribs[index].nextVertexMemoryBlock;

		mb.putFloat(0, f1);
		mb.putFloat(1, f2);
		return this;
	}

	public final VertexArrayBuilder float1(int index, float f) {
		attribs[index].nextVertexMemoryBlock.putFloat(0, f);
		return this;
	}

	public final VertexArrayBuilder int1(int index, int i) {
		attribs[index].nextVertexMemoryBlock.putInt(0, i);
		return this;
	}

	public final VertexArrayBuilder short1(int index, short s) {
		attribs[index].nextVertexMemoryBlock.putShort(0, s);
		return this;
	}
}
