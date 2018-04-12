package cubic.network;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import cubic.Registries;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PacketHandler {
	ChannelExtension extension;
	private Map second;
	
	private final AtomicReference<Map> ref = new AtomicReference<>();
	
	public PacketHandler(ChannelExtension extension) {
		this.extension = extension;
		second = Collections.unmodifiableMap(new HashMap<>(Registries.PACKETS.size()));
		Map current = Collections.unmodifiableMap(new HashMap<>(Registries.PACKETS.size()));
		
		Registries.PACKETS.forEachElement((id, pi) -> {
			second.put(pi, new ArrayList<>());
			current.put(pi, new ArrayList<>());
		});
		
		ref.set(current);
	}
	
	public <T> Map<PacketInfo<T>, List<T>> swap() {
		second = ref.getAndSet(second);
		return second;
	}
	
	public <T> Map<PacketInfo<T>, T> current() {
		return ref.get();
	}
	
	/*private void readPackets() {
		int packetSize = Integer.MAX_VALUE;
		int readed = 0;
		
		while(mem.position() < mem.position()) {
			int packetID = mem.readInt();
			Registries.PACKETS.get(packetID).read(mem, null);
		}
		
		mem.blocks.forEach(block -> tmpBlocks.addSection(block));
		mem.reset();
	}
	
	private void sendPackets(SelectionKey key, Queue<MemBlock> tmpBlocks, ByteBuffer tmpBuff, OffheapDataChannel mem) {
		SocketChannel sc = (SocketChannel) key.channel();
		key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
		
		Map<PacketInfo<Object>, List<Object>> map = ((PadcketHandler)key.attachment()).swap();
		
		map.forEach((pi, additionalObjects) -> {
			int position = -1;
			int section = -1;
			MemBlock bl = null;
			
			for(Object obj : additionalObjects) {
				position = mem.position();
				section = mem.section();
				mem.writeInt(0);
				pi.write(mem, obj, null);
				int bytes = mem.bytesFrom(section, position);
				int s0 = mem.section();
				int p0 = mem.position();
				mem.setPosition(section, position);
				mem.writeInt(bytes);
				mem.setPosition(s0, p0);
			}
			
			additionalObjects.clear();
		});
		
		mem.resetPosition();
		
		mem.forEachBlock((block, len) -> {
			Utils.setBufferAddressAndSize(tmpBuff, block.address(), len);
			tmpBuff.position(0);
			tmpBuff.limit(len);
			
			while(tmpBuff.remaining() > 0) try {
				sc.write(tmpBuff);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		mem.reset();
	}*/
}