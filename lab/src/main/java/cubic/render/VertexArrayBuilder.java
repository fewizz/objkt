package cubic.render;

import fewizz.wrap.gl.GLVertexArray;
import fewizz.wrap.gl.GLVertexBuffer;
import fewizz.wrap.gl.enums.BufferAccess;
import fewizz.wrap.gl.enums.BufferUsage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class VertexArrayBuilder {
	final GLVertexArray va;
	final int numberOfVerticies;
	int vertex;
	final BufferUsage usage;
	final ByteBuffer[] attribBuffers;
	final ByteBuffer[] attribStepBuffers;

	public VertexArrayBuilder(BufferUsage u, int p_verts, GLVertexArray.VertexAttribFormat... attribsArray) {
		this.va = new GLVertexArray();
		this.numberOfVerticies = p_verts;
		this.usage = u;
		
		int maxIndex = 0;
		for(GLVertexArray.VertexAttribFormat format : attribsArray) if(format.index > maxIndex) maxIndex = format.index;
		
		this.attribBuffers = new ByteBuffer[maxIndex + 1];
		this.attribStepBuffers = new ByteBuffer[maxIndex + 1];

		for (GLVertexArray.VertexAttribFormat attribFormat : attribsArray) {
			GLVertexBuffer vbo = new GLVertexBuffer();
			va.vertexAttribPointer(attribFormat, vbo);
			attribBuffers[attribFormat.index] = vbo.mapRange(0, p_verts*attribFormat.bytes(), BufferAccess.MAP_WRITE_BIT);
			attribStepBuffers[attribFormat.index] = ByteBuffer.allocateDirect(attribFormat.bytes()).order(ByteOrder.nativeOrder());
		}
		
		vertex = 0;
	}

	public final void endVertex() {
		if (vertex >= numberOfVerticies) {
			throw new Error("Too much verticies.");
		}

		va.forEachAttribArray(a -> {
			int step = a.info.bytes();
			int start = step * vertex;
			attribBuffers[a.info.index].put(attribStepBuffers[a.info.index]);
			attribStepBuffers[a.info.index].position(0);
		});

		vertex++;
	}

	public GLVertexArray build() {
		va.forEachAttribArray(a -> {
			a.vbo.unmap();
			a.enable();
		});
		
		return va;
	}

	public final VertexArrayBuilder float3(int index, float f1, float f2, float f3) {
		ByteBuffer mb = attribStepBuffers[index];
		mb.putFloat(0, f1);
		mb.putFloat(Float.BYTES, f2);
		mb.putFloat(2*Float.BYTES, f3);
		return this;
	}

	public final VertexArrayBuilder float2(int index, float f1, float f2) {
		ByteBuffer mb = attribStepBuffers[index];
		mb.putFloat(0, f1);
		mb.putFloat(Float.BYTES, f2);
		return this;
	}

	public final VertexArrayBuilder float1(int index, float f) {
		attribStepBuffers[index].putFloat(0, f);
		return this;
	}

	public final VertexArrayBuilder int1(int index, int i) {
		attribStepBuffers[index].putInt(0, i);
		return this;
	}

	public final VertexArrayBuilder short1(int index, short s) {
		attribStepBuffers[index].putShort(0, s);
		return this;
	}
}
