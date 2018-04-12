package cubic.network;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.SocketChannel;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import cubic.Player;
import org.objkt.memory.*;

import cubic.Registries;

public class Connection {
	SocketChannel channel;
	OffheapDataChannel offheapDataToRead = OffheapDataChannel.withByteOrder(ByteOrder.LITTLE_ENDIAN);
	//MemBlock readBlock = new MemBlock(4096);
	int left = 0;
	int size = -1;
	int packetToRead = -1;
	Queue<OffheapDataChannel> toFlush = new ConcurrentLinkedQueue<>();
	static Queue<OffheapDataChannel> forWrite = new ConcurrentLinkedQueue<>();
	static ThreadLocal<ByteBuffer> tempByteBuffers = ThreadLocal.withInitial(Utils::newNullDirectBufferWithoutCleaner);
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
			offheapDataToWrite = OffheapDataChannel.withByteOrder(ByteOrder.BIG_ENDIAN);
		}
		offheapDataToWrite.writeInt(packet.getID());
		offheapDataToWrite.writeInt(0);
		packet.write(offheapDataToWrite, obj, this);
		long len = offheapDataToWrite.position();
		offheapDataToWrite.position(Integer.BYTES);
		offheapDataToWrite.writeInt((int)len);
		offheapDataToWrite.position(len);
		
		toFlush.add(offheapDataToWrite);
	}
	
	public void flushPackets() {
		ByteBuffer bb = tempByteBuffers.get();
		
		OffheapDataChannel off = toFlush.poll();
		while(off != null) {
			off.forEachSection(sec -> {
				Utils.setBufferAddressAndSize(bb, sec.address(), (int) sec.bytes());
				bb.position(0);
				try {
					channel.write(bb);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			off.position(0);
			forWrite.add(off);
			off = toFlush.poll();
		}
	}
	
	public void read() {
		ByteBuffer bb = tempByteBuffers.get();
		
		for(;;) { try {
			if(offheapDataToRead.currentSection().getAllocation() == null) {
				offheapDataToRead.currentSection().setAllocation(new Allocation(4096));
			}
			
			if(packetToRead == -1) {
				if(size == -1) {
					size = Integer.BYTES * 2;
					left = size;
				}
				Utils.setBufferAddressAndSize(bb, offheapDataToRead.currentSection().address() + (size - left), left);
				bb.position(0);
				int rought = channel.read(bb);
				if(rought <= 0)
					break;
				
				left -= rought;
				if(left != 0)
					continue;

				offheapDataToRead.position(0);
				packetToRead = offheapDataToRead.readInt();
				size = offheapDataToRead.readInt();
				left = size;
			}
			
			Utils.setBufferAddressAndSize(bb, offheapDataToRead.currentSection().address(), Math.min((int) offheapDataToRead.currentSection().bytes(), left));
			bb.position(0);
			
			int rought = channel.read(bb);
			if(rought <= 0)
				break;
			
			left -= rought;
			offheapDataToRead.position(offheapDataToRead.position() + rought);
			
			if(left == 0) {
				PacketInfo<?> pi = Registries.PACKETS.get(packetToRead);
				offheapDataToRead.position(0);
				pi.read(offheapDataToRead, this);
				offheapDataToRead.position(0);
				packetToRead = -1;
				size = -1;
			}
			
		} catch (Exception e) {e.printStackTrace();} }
		
	}
}
