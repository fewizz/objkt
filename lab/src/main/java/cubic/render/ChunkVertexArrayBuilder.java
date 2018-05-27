package cubic.render;

import org.objkt.engine.Color;
import fewizz.wrap.gl.GLVertexArray.VertexAttribFormat;
import fewizz.wrap.gl.enums.BufferUsage;

public class ChunkVertexArrayBuilder extends VertexArrayBuilder {

	public ChunkVertexArrayBuilder(int p_vertexNumber) {
		super(BufferUsage.STATIC_DRAW, p_vertexNumber, VertexAttribFormat.pos3f(0), VertexAttribFormat.color4ub(1));
	}
	
	public ChunkVertexArrayBuilder position(float x, float y, float z) {
		float3(0, x, y, z);
		return this;
	}
	
	public ChunkVertexArrayBuilder color(Color c) {
		int1(1, c.asInt());
		return this;
	}
	
	
}
