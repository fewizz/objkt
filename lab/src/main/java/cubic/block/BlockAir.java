package cubic.block;

import cubic.render.ChunkVertexArrayBuilder;
import cubic.world.Chunk;

public class BlockAir extends Block {

	public BlockAir(BlockProvider provider) {
		super(provider);
	}
	
	@Override
	public void renderStaticly(Chunk chunk, ChunkVertexArrayBuilder builder, int x, int y, int z) {
	}

}
