package cubic.world;

import org.objkt.memory.MemBlockDataInput;

import cubic.Client;
import cubic.render.WorldRenderer;

public class ClientWorld extends World {
	public void addChunkFromData(int x, int y, int z, MemBlockDataInput in) {
		Chunk chunk = new Chunk(x, y, z);
		chunk.readBlockData(in);
		in.free();

		chunks.put(chunk.pos.toLong(), chunk);

		Client.GL_TASKS.add(() -> {
			WorldRenderer.onChunkAdded(chunk);
		});
	}
}
