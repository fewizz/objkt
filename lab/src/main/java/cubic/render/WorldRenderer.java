package cubic.render;

import java.util.*;

import cubic.world.Chunk;

public class WorldRenderer {
	static final List<ChunkRenderer> RENDERERS = new ArrayList<>();
	
	public static void onChunkAdded(Chunk ch) {
		RENDERERS.add(new ChunkRenderer(ch));
	}
	
	public static void render() {
		RENDERERS.forEach(cr -> {
			
		});
	}
}
