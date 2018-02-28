package cubic.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

public class ChannelPacketReadHandler extends ChannelInboundHandlerAdapter {
	//final NetworkManager netManager;
	
	/*public ChannelPacketReadHandler(NetworkManager netManager) {
		this.netManager = netManager;
	}*/

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		((ExtendedChannel)ctx.channel()).readPacket(buf);
	}
}
