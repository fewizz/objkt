package cubic.network;

public class Packets {
	public static final PacketHelloFromServer HELLO_FROM_SERVER = new PacketHelloFromServer();
	public static final PacketFullChunk FULL_CHUNK = new PacketFullChunk();
	public static final PacketClientReady IM_READY = new PacketClientReady();
	public static final PacketUnloadChunk UNLOAD_CHUNK_ON_CLIENT = new PacketUnloadChunk();
}
