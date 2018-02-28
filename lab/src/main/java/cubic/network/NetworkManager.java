package cubic.network;

import java.util.*;

import io.netty.buffer.*;
import io.netty.channel.Channel;

public class NetworkManager {
	Channel channel;
	Map<PacketInfo<?>, List<Runnable>> afterRead = new HashMap<>();
	
	public NetworkManager(Channel channel) {
		this.channel = channel;
	}

	public <T> void sendPacket(PacketInfo<T> packet) {
		sendPacket(this.channel, packet, null);
	}
	
	public <T> void sendPacket(PacketInfo<T> packet, T obj) {
		sendPacket(this.channel, packet, obj);
	}
	
	public void alwaysAfterPacketRead(PacketInfo<?> pi, Runnable run) {
		afterRead.computeIfAbsent(pi, pi0 -> new ArrayList<>());
		afterRead.get(pi).add(run);
	}
	
	public static <T> void sendPacket(Channel channel, PacketInfo<T> packet, T obj) {
		channel.eventLoop().execute(() -> {
			ByteBuf buf = channel.alloc().directBuffer();
			buf.writeInt(packet.getID());
			packet.write(buf, obj);
			channel.writeAndFlush(buf);
		});
	}
}
