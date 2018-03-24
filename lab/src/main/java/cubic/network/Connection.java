package cubic.network;

import java.nio.*;
import java.nio.channels.*;

import org.objkt.memory.*;

public class Connection {
	SocketChannel channel;
	OffheapDataChannel offheapDataToWrite = OffheapDataChannel.withByteOrder(ByteOrder.LITTLE_ENDIAN);
	ByteBuffer tempByteBuffer = Utils.newNullDirectBufferWithoutCleaner();
	
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
		packet.write(offheapDataToWrite, obj, this);
		offheapDataToWrite.forEachSection(section -> {
			
		});
	}
	
}
