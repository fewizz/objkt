package cubic.network;

import java.nio.channels.Channel;

import org.objkt.memory.OffheapDataChannel;

import cubic.*;

public interface ExtendedChannel extends Channel {
	//static final AttributeKey<Player> PLAYER_ATTRIB_KEY = AttributeKey.newInstance("player");
	
	default public <T> void sendPacket(PacketInfo<T> packet) {
		this.sendPacket(packet, null);
	}
	
	default public <T> void sendPacket(PacketInfo<T> packet, T obj) {
		/*eventLoop().execute(() -> {
			ByteBuf buf = alloc().directBuffer();
			buf.writeInt(packet.getID());
			packet.write(buf, obj);
			writeAndFlush(buf);
		});*/
		
	}
	
	default public Player getPlayer() {
		return null;//attr(PLAYER_ATTRIB_KEY).get();
	}
	
	default void setPlayer(Player p) {
		//attr(PLAYER_ATTRIB_KEY).set(p);
	}
	
	default void readPacket(OffheapDataChannel msg) {
		/*int packetID = msg.readInt();
		PacketInfo<?> pi = Registries.PACKETS.get(packetID);
		pi.read(this, msg);
		ReferenceCountUtil.release(msg);*/
	}
}
