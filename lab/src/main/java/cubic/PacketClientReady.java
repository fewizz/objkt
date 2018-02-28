package cubic;

import cubic.network.*;
import io.netty.buffer.*;
import io.netty.util.CharsetUtil;

public class PacketClientReady extends PacketInfo<String> {
	@Override
	public String getName() {
		return "cubic:client_ready";
	}
	
	@Override
	public void write(ByteBuf buf, String name) {
		buf.writeInt(name.length());
		ByteBufUtil.writeUtf8(buf, name);
	}
	
	@Override
	public void read(ExtendedChannel ch, ByteBuf buf) {
		String name = buf.readCharSequence(buf.readInt(), CharsetUtil.UTF_8).toString();
		Server.TASKS.add(() -> {
			ch.setPlayer(new ServerPlayer(ch, name));
			Server.onPlayerReadyToPlay((ServerPlayer) ch.getPlayer());
		});
	}
}
