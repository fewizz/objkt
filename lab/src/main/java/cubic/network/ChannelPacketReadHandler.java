package cubic.network;

import cubic.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

public class ChannelPacketReadHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		int packetID = buf.readInt();
		Registries.PACKETS.get(packetID).read(ctx.channel(), buf);
		ReferenceCountUtil.release(buf);
	}
}
