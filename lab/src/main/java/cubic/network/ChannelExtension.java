package cubic.network;

import java.nio.channels.NetworkChannel;

public class ChannelExtension {
	NetworkChannel channel;
	Connection connection;
	PacketHandler packetHandler;
	
	public ChannelExtension(NetworkChannel channel, Connection connection, PacketHandler packetHandler) {
		this.channel = channel;
		this.connection = connection;
		this.packetHandler = packetHandler;
	}
	
	
}
