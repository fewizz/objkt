package cubic.network;

import cubic.Client;
import cubic.Server.ConnectionState;
import cubic.world.Chunk;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

public class PacketUnloadChunk extends PacketInfo<Chunk> {

	@Override
	public String getName() {
		return "cubic:chunk_unload";
	}

	@Override
	void read(Channel channel, ByteBuf buf) {
		long posLong = buf.readLong();
		
		Client.TASKS.add(() -> {
			Chunk.Position pos = new Chunk.Position(posLong);
			Client.world.removeChunk(pos.x, pos.y, pos.z);
		});
	}

	@Override
	void write(ByteBuf buf, Chunk t) {
		buf.writeLong(t.pos.toLong());
	}

	@Override
	ConnectionState getConnectionState() {
		return ConnectionState.PLAYTIME;
	}

}
