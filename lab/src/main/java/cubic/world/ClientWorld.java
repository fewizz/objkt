package cubic.world;

import org.objkt.memory.MemBlockDataInput;

import cubic.Client;
import cubic.render.WorldRenderer;

public class ClientWorld extends World {

	@Override
	public Chunk addChunkFromData(int x, int y, int z, MemBlockDataInput in) {
		Chunk ch = super.addChunkFromData(x, y, z, in);

		Client.GL_TASKS.add(() -> {
			WorldRenderer.onChunkAdded(ch);
		});
		
		return ch;
	}
}
