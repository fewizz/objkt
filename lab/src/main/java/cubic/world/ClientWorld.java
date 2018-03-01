package cubic.world;

import org.objkt.memory.*;

import cubic.Client;
import cubic.render.WorldRenderer;

public class ClientWorld extends World {

	@Override
	public Chunk addChunkFromData(int x, int y, int z, DataInput in) {
		Chunk ch = super.addChunkFromData(x, y, z, in);

		Client.GL_TASKS.add(() -> {
			WorldRenderer.onChunkAdded(ch);
		});
		
		return ch;
	}
}
