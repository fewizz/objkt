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
	
	public void generateChunkAt(int x, int y, int z) {
		chunks.put(Chunk.Position.toLong(x, y, z), gen.generateChunk(x, y, z));
	}
}
