package cubic.network;

import cubic.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.util.*;

public interface ExtendedChannel extends Channel {
	static final AttributeKey<Player> PLAYER_ATTRIB_KEY = AttributeKey.newInstance("player");
	
	default public <T> void sendPacket(PacketInfo<T> packet) {
		this.sendPacket(packet, null);
	}
	
	default public <T> void sendPacket(PacketInfo<T> packet, T obj) {
		eventLoop().execute(() -> {
			ByteBuf buf = alloc().directBuffer();
			buf.writeInt(packet.getID());
			packet.write(buf, obj);
			writeAndFlush(buf);
		});
	}
	
	default public Player getPlayer() {
		return attr(PLAYER_ATTRIB_KEY).get();
	}
	
	default void setPlayer(Player p) {
		attr(PLAYER_ATTRIB_KEY).set(p);
	}
	
	default void readPacket(ByteBuf msg) {
		int packetID = msg.readInt();
		PacketInfo<?> pi = Registries.PACKETS.get(packetID);
		pi.read(this, msg);
		ReferenceCountUtil.release(msg);
	}
}
