package cubic.network;

import java.nio.ByteBuffer;

import org.objkt.memory.*;

import cubic.Client;
import cubic.world.Chunk;
import io.netty.buffer.ByteBuf;

public class PacketFullChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:full_chunk";
	}

	@SuppressWarnings("deprecation")
	@Override
	public void read(ExtendedChannel channel, ByteBuf buf) {
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		
		ByteBuffer buff = Utils.newDirectBufferWithoutCleaner(buf.readInt());
		
		buf.readBytes(buff);
		buff.position(0);
		
		Client.TASKS.add(() -> {
			MemBlock block = new MemBlock();
			block.capture(Utils.address(buff), buff.capacity());
			Utils.setBufferAddress(buff, 0);
		
			MemBlockDataInput dataIn = new MemBlockDataInput(block);
		
			Client.world.addChunkFromData(x, y, z, dataIn);
			
			dataIn.free();
		});
	}

	@Override
	public void write(ByteBuf buf, Chunk chunk) {
		buf.writeInt(chunk.pos.x);
		buf.writeInt(chunk.pos.y);
		buf.writeInt(chunk.pos.z);
		
		MemBlockDataOutput dataOut = new MemBlockDataOutput();
		chunk.writeBlockData(dataOut);
		buf.writeInt(dataOut.size());
		
		ByteBuffer buff = Utils.newNullDirectBufferWithoutCleaner();
		
		for(int i = 0; i < dataOut.blocks.size(); i++) {
			MemBlock block = dataOut.blocks.get(i);
			
			Utils.setBufferAddressAndCapacity(buff, block.address(), dataOut.lengths.get(i));
			buff.limit(dataOut.lengths.get(i));
			buff.position(0);
			
			buf.writeBytes(buff);
		}
		
		Utils.setBufferAddress(buff, 0);
		dataOut.free();
	}

}
