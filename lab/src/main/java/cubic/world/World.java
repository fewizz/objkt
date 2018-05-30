package cubic.world;


import java.util.*;

import org.objkt.memory.*;

import cubic.Entity;

public class World {
	public final List<Entity> entities = new ArrayList<>();
	public final Map<Chunk.Position, Chunk> chunks = new HashMap<>();
	public final Random random;
	public final long seed;

	public World() {
		random = new Random();
		seed = random.nextLong();
	}

	public void update() {
	}

	public boolean chunkLoaded(int x, int y, int z) {
		return chunkLoaded(new Chunk.Position(x, y, z));
	}

	public boolean chunkLoaded(Chunk.Position pos) {
		return chunks.containsKey(pos);
	}

	public Chunk getChunk(int x, int y, int z) {
		return getChunk(new Chunk.Position(x, y, z));
	}

	public Chunk getChunk(Chunk.Position pos) {
		return chunks.get(pos);
	}
	
	public void removeChunk(int x, int y, int z) {
		removeChunk(new Chunk.Position(x, y, z));
	}

	public void removeChunk(Chunk.Position pos) {
		chunks.remove(pos);
	}
	
	public Chunk addChunkFromData(int x, int y, int z, DataInput in) {
		Chunk chunk = new Chunk(x, y, z);
		chunk.readBlockData(in);

		chunks.put(chunk.pos, chunk);
		return chunk;
	}
}
