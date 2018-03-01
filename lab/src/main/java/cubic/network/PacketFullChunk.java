package cubic.network;

import org.objkt.memory.*;

import cubic.Client;
import cubic.world.Chunk;

public class PacketFullChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:full_chunk";
	}

	@Override
	public void read(DataInput in) {
		int x = in.readInt();
		int y = in.readInt();
		int z = in.readInt();
		
		//ByteBuffer buff = Utils.newDirectBufferWithoutCleaner(buf.readInt());
		
		//buf.readBytes(buff);
		//buff.position(0);
		
		Client.TASKS.add(() -> {
			//MemBlock block = new MemBlock();
			//block.capture(Utils.address(buff), buff.capacity());
			//Utils.setBufferAddress(buff, 0);
		
			//MemBlockDataInput dataIn = new MemBlockDataInput(block);
		
			Client.world.addChunkFromData(x, y, z, in);
			
			//dataIn.free();
		});
	}

	@Override
	public void write(DataOutput out, Chunk chunk) {
		out.writeInt(chunk.pos.x);
		out.writeInt(chunk.pos.y);
		out.writeInt(chunk.pos.z);
		
		//MemBlockBuffer dataOut = new MemBlockBuffer();
		chunk.writeBlockData(out);
		//buf.writeInt(dataOut.size());
		
		/*ByteBuffer buff = Utils.newNullDirectBufferWithoutCleaner();
		
		for(int i = 0; i < dataOut.blocks.size(); i++) {
			MemBlock block = dataOut.blocks.get(i);
			
			Utils.setBufferAddressAndCapacity(buff, block.address(), dataOut.lengths.get(i));
			buff.limit(dataOut.lengths.get(i));
			buff.position(0);
			
			buf.writeBytes(buff);
		}
		
		Utils.setBufferAddress(buff, 0);
		dataOut.free();*/
	}

}
