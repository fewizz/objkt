package cubic.network;

import org.objkt.memory.*;

import cubic.Client;
import cubic.world.Chunk;

public class PacketUnloadChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:chunk_unload";
	}

	@Override
	public void read(DataInput in, Connection c) {
		long posLong = in.readLong();
		
		Client.TASKS.add(() -> {
			Chunk.Position pos = new Chunk.Position(posLong);
			Client.world.removeChunk(pos.x, pos.y, pos.z);
		});
	}

	@Override
	public void write(DataOutput out, Chunk t, Connection c) {
		out.writeLong(t.pos.toLong());
	}

}
