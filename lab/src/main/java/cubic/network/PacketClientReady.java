package cubic.network;

import cubic.*;
import cubic.Server.ConnectionState;
import io.netty.buffer.*;
import io.netty.channel.Channel;
import io.netty.util.CharsetUtil;

public class PacketClientReady extends PacketInfo<String> {
	@Override
	public String getName() {
		return "cubic:client_ready";
	}
	
	@Override
	void write(ByteBuf buf, String name) {
		buf.writeInt(name.length());
		ByteBufUtil.writeUtf8(buf, name);
	}
	
	@Override
	void read(Channel ch, ByteBuf buf) {
		String name = buf.readCharSequence(buf.readInt(), CharsetUtil.UTF_8).toString();
		
		ch.attr(Server.PLAYER_ATTRIB_KEY).set(new ServerPlayer(new NetworkManager(ch), name));
		ch.attr(Server.CONNECTION_INFO_ATTRIB_KEY).get().setConnectionState(ConnectionState.PLAYTIME);
	}
	
	@Override
	ConnectionState getConnectionState() {
		return ConnectionState.PREPARING;
	}
}
