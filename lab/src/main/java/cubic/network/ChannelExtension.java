package cubic.network;

import java.nio.channels.*;

public class ChannelExtension {
	public final SocketChannel channel;
	public final Connection connection;
	//public final PacketHandler packetHandler;
	
	public ChannelExtension(SocketChannel channel) {
		this.channel = channel;
		this.connection = new Connection(channel);
		//this.packetHandler = new PacketHandler(this);
	}
	
	
}
