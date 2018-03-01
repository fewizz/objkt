package cubic.world;


import java.util.*;

import org.objkt.memory.*;

import cubic.Entity;

public class World {
	public final List<Entity> entities = new ArrayList<>();
	public final Map<Long, Chunk> chunks = new HashMap<>();
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
	
	public Chunk addChunkFromData(int x, int y, int z, DataInput in) {
		Chunk chunk = new Chunk(x, y, z);
		chunk.readBlockData(in);

		chunks.put(chunk.pos.toLong(), chunk);
		return chunk;
	}
}
