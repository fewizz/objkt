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
	public void read(DataInput in, Connection c) {
		int x = in.readInt();
		int y = in.readInt();
		int z = in.readInt();

		System.out.println("Reading chunk: " + x + " " + y + " " + z);
		Client.world.addChunkFromData(x, y, z, in);
	}

	@Override
	public void write(DataOutput out, Chunk chunk, Connection c) {
		out.writeInt(chunk.pos.x);
		out.writeInt(chunk.pos.y);
		out.writeInt(chunk.pos.z);

		chunk.writeBlockData(out);
	}

}
