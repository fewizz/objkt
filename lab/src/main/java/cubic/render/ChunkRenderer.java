package cubic.render;

import org.objkt.gl.*;
import org.objkt.gl.enums.*;

import cubic.Client;
import cubic.world.Chunk;

public class ChunkRenderer {
	final Chunk ch;
	GLVertexArray vao;
	static GLShaderProgram program;

	public ChunkRenderer(Chunk ch) {
		this.ch = ch;
		compile();
		
		if(program == null) {
			try {
			program = new GLShaderProgram(
					ShaderType.VERTEX_SHADER,
					  "#version 320"
					+ "layout(location = 0) in vec3 pos;"
					+ "layout(location = 1) in vec4 color;"
					+ ""
					+ "out vec4 vs_color;"
					+ ""
					+ "unifrom mat4 mat;"
					+ ""
					+ "void main() {"
					+ "	gl_VertexPosition = mat * vec4(pos, 1.);"
					+ "}",
					ShaderType.FRAGMENT_SHADER,
					  "#version 320"
					+ "in vec4 vs_color;"
					+ ""
					+ "void main() {"
					+ "	gl_FragColor = vs_color;"
					+ "}");
			} catch(Error e) {
				Client.LOGGER.severe(e.toString());
			}
		}
	}
	
	public void render() {
		program.use();
		GLContext.current().drawArrays(vao, PrimitiveType.TRIANGLES, vao.getVertexAttribArrayAt(0).getVertexCount());
	}
	
	void compile() {
		ChunkVertexArrayBuilder vaob = new ChunkVertexArrayBuilder(0xFFFF*2);
		
		for(int x = 0; x < 16; x++) {
			for(int y = 0; y < 16; y++) {
				for(int z = 0; z < 16; z++) {
					ch.getBlock(x, y, z).renderStaticly(ch, vaob, x, y, z);
				}
			}
		}
		
		vao = vaob.build();
	}
}
