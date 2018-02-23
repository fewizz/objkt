package cubic.network;

import java.nio.ByteBuffer;

import org.objkt.memory.*;

import cubic.Client;
import cubic.Server.ConnectionState;
import cubic.world.Chunk;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class PacketFullChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:full_chunk";
	}

	@SuppressWarnings("deprecation")
	@Override
	void read(Channel channel, ByteBuf buf) {
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		
		ByteBuffer buff = Utils.newDirectBufferWithoutCleaner(buf.readInt());
		
		buf.readBytes(buff);
		
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
	void write(ByteBuf buf, Chunk ch) {
		buf.writeInt(ch.pos.x);
		buf.writeInt(ch.pos.y);
		buf.writeInt(ch.pos.z);
		
		MemBlockDataOutput dataOut = new MemBlockDataOutput();
		ch.writeBlockData(dataOut);
		buf.writeInt(dataOut.size());
		
		ByteBuffer buff = Utils.newNullDirectBufferWithoutCleaner();
		
		for(int i = 0; i < dataOut.blocks.size(); i++) {
			MemBlock block = dataOut.blocks.get(i);
			
			Utils.setBufferAddressAndCapacity(buff, block.address(), dataOut.lengths.get(i));
			buff.limit(dataOut.lengths.get(i));
			
			buf.writeBytes(buff);
		}
		
		Utils.setBufferAddress(buff, 0);
		dataOut.free();
	}

	@Override
	ConnectionState getConnectionState() {
		return ConnectionState.PLAYTIME;
	}

}
