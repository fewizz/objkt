package cubic.world;

import java.util.*;

import org.objkt.engine.MathUtils;

import cubic.*;
import cubic.network.Packets;

public class ChunksWatcher {
	static final int RAD = 10;
	final Map<Long, List<ServerPlayer>> chunkToPlayersMap = new HashMap<>();
	final Map<ServerPlayer, List<Long>> playerToChunksMap = new HashMap<>();
	final Map<ServerPlayer, Long> playerChunkPositions = new HashMap<>();
	
	void update() {
		Server.PLAYERS.values().forEach(p -> {
			if(playerChunkPositions.get(p) != p.getChunkLong()) {
				updateForPlayer(p);
			}
		});
	}
	
	void updateForPlayer(ServerPlayer player) {
		List<Long> occupiedChunks = playerToChunksMap.computeIfAbsent(player, p -> new ArrayList<>());
		
		int plx = MathUtils.floor(player.position.x) >> 16;
		int ply = MathUtils.floor(player.position.y) >> 16;
		int plz = MathUtils.floor(player.position.z) >> 16;
		
		
		if(!occupiedChunks.isEmpty()) for(long occupiedPos : new ArrayList<>(occupiedChunks)) {
			Chunk.Position pos = new Chunk.Position(occupiedPos);
			
			if(MathUtils.isOutOfRadius(RAD, pos.x - plx, pos.y - ply, pos.z - plz)) {
				removePlayerFromChunk(player, occupiedPos);
				//Server.LOGGER.info("Unloading chunk at: " + pos.x + " " + pos.y + " " + pos.z);
				player.connection.sendPacketAsynchronously(Packets.UNLOAD_CHUNK_ON_CLIENT, Server.world.getChunk(pos.x, pos.y, pos.z));
			}
		}
		
		for(int i = 0; i < RAD*RAD*RAD; i++) {
			int x = plx + i % RAD;
			int y = ply + (i / RAD) % RAD;
			int z = plz + i / (RAD * RAD);
			
			float distSq = MathUtils.dot(x, x, y, y, z, z);
			
			if(distSq > RAD * RAD) 
				continue;
			
			long pos = Chunk.Position.toLong(x, y, z);
			
			if(occupiedChunks.contains(pos))
				continue;
			
			//Server.LOGGER.info("Loading chunk at: " + x + " " + y + " " + z);
			
			if(!Server.world.chunkLoaded(x, y, z)) {
				Server.world.generateChunkAt(x, y, z);
			}
			
			addPlayerToChunk(player, pos);
			player.connection.sendPacketAsynchronously(Packets.FULL_CHUNK, Server.world.getChunk(x, y, z));
			Server.LOGGER.info("sending chunk: " + pos);
		}
		
		playerChunkPositions.put(player, player.getChunkLong());
	}
	
	private void addPlayerToChunk(ServerPlayer player, long pos) {
		chunkToPlayersMap.computeIfAbsent(pos, pos0 -> new ArrayList<>()).add(player);
		List<Long> occ = playerToChunksMap.computeIfAbsent(player, p -> new ArrayList<>());
		
		if(!occ.contains(pos))
			occ.add(pos);
	}
	
	private void removePlayerFromChunk(ServerPlayer player, long pos) {
		chunkToPlayersMap.get(pos).remove(player);
		if(chunkToPlayersMap.get(pos).isEmpty())
			chunkToPlayersMap.remove(pos);
		
		playerToChunksMap.get(player).remove(pos);
		if(playerToChunksMap.get(player).isEmpty())
			playerToChunksMap.remove(player);
	}
}
