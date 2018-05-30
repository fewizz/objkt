package cubic.network;

import cubic.Player;
import cubic.Registries;
import org.objkt.memory.OffheapDataChannel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Connection {
	public SocketChannel channel;
	OffheapDataChannel offheapDataToRead = new OffheapDataChannel(ByteOrder.LITTLE_ENDIAN);
	Queue<OffheapDataChannel> toFlush = new ConcurrentLinkedQueue<>();
	static Queue<OffheapDataChannel> forWrite = new ConcurrentLinkedQueue<>();
	Player player;

	public Player getPlayer() {return player;}

	public void setPlayer(Player p) {this.player = p;}
	
	public Connection(SocketChannel channel) {
		this.channel = channel;
	}

	public <T> void sendPacketAsynchronously(PacketInfo<T> packet) {
		sendPacketAsynchronously(packet, null);
	}
	
	public <T> void sendPacketAsynchronously(PacketInfo<T> packet, T obj) {
		sendPacket(packet, obj);
	}
	
	<T> void sendPacket(PacketInfo<T> packet, T obj) {
		OffheapDataChannel offheapDataToWrite = forWrite.poll();
		if(offheapDataToWrite == null) {
			offheapDataToWrite = new OffheapDataChannel(ByteOrder.LITTLE_ENDIAN);
		}
		offheapDataToWrite.position(0);
		offheapDataToWrite.writeInt(0);
		offheapDataToWrite.writeInt(packet.getID());
		packet.write(offheapDataToWrite, obj, this);
		long len = offheapDataToWrite.position();
		offheapDataToWrite.position(0);
		offheapDataToWrite.writeInt((int)len);
		offheapDataToWrite.position(len);
		
		toFlush.add(offheapDataToWrite);
	}
	
	public void flushPackets() {
		OffheapDataChannel off = toFlush.poll();
		while(off != null) {
			off.position(0);
			int size = off.readInt();
			off.position(0);
			off.writeTo(channel, size);
			off.position(0);
			forWrite.add(off);
			off = toFlush.poll();
		}
	}

	int left = -1;
	int size = -1;
	int packetToRead = -1;

	public void read() {
		while(true) {
			if (packetToRead == -1) {
				if (size == -1) {
					size = Integer.BYTES * 2;
					left = size;
					offheapDataToRead.position(0);
				}

				int r = offheapDataToRead.readFrom(channel, left);
				if (r == -1) return;
				left -= r;
				if (left > 0) return;
				offheapDataToRead.position(0);
				size = offheapDataToRead.readInt();
				packetToRead = offheapDataToRead.readInt();
				left = size - Integer.BYTES * 2;
				offheapDataToRead.position(0);
			}

			int r = offheapDataToRead.readFrom(channel, left);
			if (r == -1) return;
			left -= r;
			if (left > 0) return;

			offheapDataToRead.position(0);
			PacketInfo<?> pi = Registries.PACKETS.get(packetToRead);
			pi.read(offheapDataToRead, this);
			packetToRead = -1;
			size = -1;
		}
	}
}
