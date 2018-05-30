package cubic;

import java.util.*;
import java.util.stream.Collectors;

import cubic.block.*;
import cubic.network.*;

public class Registries {
	public static final Registry<BlockProvider> BLOCKS = new Registry<>("BLOCK");
	public static final Registry<PacketInfo<?>> PACKETS = new Registry<>("PACKET");
	
	public static final List<Registry<?>> LIST = List.of(PACKETS, BLOCKS);
	public static final Map<String, Registry<?>> MAP = Collections.unmodifiableMap(LIST.stream().collect(Collectors.toMap(Registry::getName, t -> t)));
	
	public static void init() {
		PACKETS.add(Packets.IM_READY);
		PACKETS.add(Packets.HELLO_FROM_SERVER);
		PACKETS.add(Packets.FULL_CHUNK);
		PACKETS.add(Packets.UNLOAD_CHUNK_ON_CLIENT);
		
		BLOCKS.put(0, Blocks.AIR.getProvider());
		BLOCKS.put(1, Blocks.DIRT.getProvider());
	}
}
