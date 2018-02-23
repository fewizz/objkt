package cubic.network;

import cubic.Server;
import cubic.Registry.SimpleRegistryElement;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public abstract class PacketInfo<T> extends SimpleRegistryElement {
	
	abstract void read(Channel channel, ByteBuf buf);
	
	abstract void write(ByteBuf buf, T t);
	
	abstract Server.ConnectionState getConnectionState();
}
