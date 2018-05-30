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
		int x = in.readInt();
		int y = in.readInt();
		int z = in.readInt();
		
		Client.TASKS.add(() -> {
			Client.world.removeChunk(x, y, z);
		});
	}

	@Override
	public void write(DataOutput out, Chunk t, Connection c) {
		out.writeInt(t.pos.x);
		out.writeInt(t.pos.y);
		out.writeInt(t.pos.z);
	}

}
