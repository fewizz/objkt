package cubic.world;

import java.util.*;

import org.objkt.engine.MathUtils;

import cubic.*;
import cubic.network.Packets;

public class ChunksWatcher {
	static final int RAD = 2;
	final Map<Chunk.Position, List<ServerPlayer>> chunkToPlayersMap = new HashMap<>();
	final Map<ServerPlayer, List<Chunk.Position>> playerToChunksMap = new HashMap<>();
	final Map<ServerPlayer, Chunk.Position> playerChunkPositions = new HashMap<>();
	
	void update() {
		Server.PLAYERS.values().forEach(p -> {
			if(playerChunkPositions.get(p) != p.getChunkPosition()) {
				updateForPlayer(p);
			}
		});
	}
	
	void updateForPlayer(ServerPlayer player) {
		List<Chunk.Position> occupiedChunks = playerToChunksMap.computeIfAbsent(player, p -> new ArrayList<>());
		
		int plx = MathUtils.floor(player.position.x) >> 16;
		int ply = MathUtils.floor(player.position.y) >> 16;
		int plz = MathUtils.floor(player.position.z) >> 16;
		
		
		if(!occupiedChunks.isEmpty()) for(Chunk.Position pos : new ArrayList<>(occupiedChunks)) {
			//Chunk.Position pos = new Chunk.Position(occupiedPos);
			
			if(MathUtils.isOutOfRadius(RAD, pos.x - plx, pos.y - ply, pos.z - plz)) {
				removePlayerFromChunk(player, pos);
				Server.LOGGER.info("Unloading chunk at: " + pos.x + " " + pos.y + " " + pos.z);
				player.connection.sendPacketAsynchronously(Packets.UNLOAD_CHUNK_ON_CLIENT, Server.world.getChunk(pos.x, pos.y, pos.z));
			}
		}
		
		for(int lx = -RAD; lx <= RAD; lx++)
		for(int ly = -RAD; ly <= RAD; ly++)
		for(int lz = -RAD; lz <= RAD; lz++) {
			int x = plx + lx;
			int y = ply + ly;
			int z = plz + lz;

			float distSq = MathUtils.dot(lx, lx, ly, ly, lz, lz);
			
			if(distSq > RAD * RAD * RAD)
				continue;
			
			//long pos = Chunk.Position.toLong(x, y, z);
			Chunk.Position pos = new Chunk.Position(x, y, z);
			
			if(occupiedChunks.contains(pos))
				continue;
			
			//Server.LOGGER.info("Loading chunk at: " + x + " " + y + " " + z);
			
			if(!Server.world.chunkLoaded(pos)) {
				Server.LOGGER.info("Generating chunk at: " + x + " " + y + " " + z);
				Server.world.generateChunkAt(pos);
			}
			
			addPlayerToChunk(player, pos);
			player.connection.sendPacketAsynchronously(Packets.FULL_CHUNK, Server.world.getChunk(pos));
			//Server.LOGGER.info("sending chunk: " + pos);
		}
		
		playerChunkPositions.put(player, player.getChunkPosition());
	}
	
	private void addPlayerToChunk(ServerPlayer player, Chunk.Position pos) {
		chunkToPlayersMap.computeIfAbsent(pos, pos0 -> new ArrayList<>()).add(player);
		List<Chunk.Position> occ = playerToChunksMap.computeIfAbsent(player, p -> new ArrayList<>());
		
		if(!occ.contains(pos))
			occ.add(pos);
	}
	
	private void removePlayerFromChunk(ServerPlayer player, Chunk.Position pos) {
		chunkToPlayersMap.get(pos).remove(player);
		if(chunkToPlayersMap.get(pos).isEmpty())
			chunkToPlayersMap.remove(pos);
		
		playerToChunksMap.get(player).remove(pos);
		if(playerToChunksMap.get(player).isEmpty())
			playerToChunksMap.remove(player);
	}
}
