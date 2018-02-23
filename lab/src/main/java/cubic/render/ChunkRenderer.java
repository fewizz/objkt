package cubic.render;

import org.objkt.gl.GLVertexArray;

import cubic.world.Chunk;

public class ChunkRenderer {
	final Chunk ch;
	GLVertexArray vao;

	public ChunkRenderer(Chunk ch) {
		this.ch = ch;
		compile();
	}
	
	public void render() {
		
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
