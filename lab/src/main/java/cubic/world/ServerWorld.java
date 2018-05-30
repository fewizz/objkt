package cubic.world;

import cubic.Server;

public class ServerWorld extends World {
	private final ChunksWatcher chunksWatcher = new ChunksWatcher();
	private final ChunkGenerator gen = new ChunkGenerator(this);
	
	@Override
	public void update() {
		super.update();
		
		Server.PLAYERS.values().forEach(player -> chunksWatcher.updateForPlayer(player));
	}
	
	public void generateChunkAt(Chunk.Position pos) {
		Chunk c = gen.generateChunk(pos);
		chunks.put(c.pos, c);
	}
}
