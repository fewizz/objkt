package cubic.block;
import org.objkt.engine.Color;
import org.objkt.memory.*;

import cubic.render.ChunkVertexArrayBuilder;
import cubic.world.Chunk;

public class Block {
	private BlockProvider provider;
	
	public Block(BlockProvider provider) {
		this.provider = provider;
	}
	
	public BlockProvider getProvider() {
		return provider;
	}
	
	public void renderStaticly(Chunk chunk, ChunkVertexArrayBuilder builder, int x, int y, int z) {
		builder.color(Color.WHITE);
		builder.position(x, y, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		builder.position(x + 1, y + 1, z).endVertex();
		builder.position(x + 1, y + 1, z).endVertex();
		builder.position(x, y + 1, z).endVertex();
		builder.position(x, y, z).endVertex();
		
		builder.color(Color.BLACK);
		builder.position(x + 1, y, z).endVertex();
		builder.position(x + 1, y, z + 1).endVertex();
		builder.position(x + 1, y + 1, z + 1).endVertex();
		builder.position(x + 1, y + 1, z + 1).endVertex();
		builder.position(x + 1, y + 1, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		
		builder.color(Color.RED);
		builder.position(x + 1, y, z + 1).endVertex();
		builder.position(x, y, z + 1).endVertex();
		builder.position(x, y + 1, z + 1).endVertex();
		builder.position(x, y + 1, z + 1).endVertex();
		builder.position(x + 1, y + 1, z + 1).endVertex();
		builder.position(x + 1, y, z + 1).endVertex();
		
		builder.color(Color.GREEN);
		builder.position(x, y, z + 1).endVertex();
		builder.position(x, y, z).endVertex();
		builder.position(x, y + 1, z).endVertex();
		builder.position(x, y + 1, z).endVertex();
		builder.position(x, y + 1, z + 1).endVertex();
		builder.position(x, y, z + 1).endVertex();
		
		builder.color(Color.BLUE);
		builder.position(x, y, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		builder.position(x, y, z).endVertex();
		builder.position(x, y, z).endVertex();
		
		builder.color(Color.WHITE);
		builder.position(x, y, z).endVertex();
		builder.position(x + 1, y, z).endVertex();
		builder.position(x + 1, y + 1, z).endVertex();
		builder.position(x + 1, y + 1, z).endVertex();
		builder.position(x, y + 1, z).endVertex();
		builder.position(x, y, z).endVertex();
	}
	
	public void write(DataOutput out) {
	}
}
