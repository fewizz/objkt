package cubic.world;


import java.util.*;

import cubic.Entity;
import io.netty.util.collection.*;

public class World {
	public final List<Entity> entities = new ArrayList<>();
	public final LongObjectMap<Chunk> chunks = new LongObjectHashMap<>();
	public final Random random;
	public final long seed;

	public World() {
		random = new Random();
		seed = random.nextLong();
	}

	public void update() {
	}

	public boolean chunkLoaded(int x, int y, int z) {
		return chunks.containsKey(Chunk.Position.toLong(x, y, z));
	}

	public Chunk getChunk(int x, int y, int z) {
		return chunks.get(Chunk.Position.toLong(x, y, z));
	}
	
	public void removeChunk(int x, int y, int z) {
		chunks.remove(Chunk.Position.toLong(x, y, z));
	}
}
