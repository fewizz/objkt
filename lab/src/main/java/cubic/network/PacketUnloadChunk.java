package cubic.network;

import cubic.Client;
import cubic.world.Chunk;
import io.netty.buffer.ByteBuf;

public class PacketUnloadChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:chunk_unload";
	}

	@Override
	public void read(ExtendedChannel channel, ByteBuf buf) {
		long posLong = buf.readLong();
		
		Client.TASKS.add(() -> {
			Chunk.Position pos = new Chunk.Position(posLong);
			Client.world.removeChunk(pos.x, pos.y, pos.z);
		});
	}

	@Override
	public void write(ByteBuf buf, Chunk t) {
		buf.writeLong(t.pos.toLong());
	}

}
