package cubic.network;

import java.nio.channels.SocketChannel;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ExtendedNioSocketChannel extends NioSocketChannel implements ExtendedChannel {
	public ExtendedNioSocketChannel() {
		super();
	}
	
	public ExtendedNioSocketChannel(Channel parent, SocketChannel socket) {
        super(parent, socket);
    }
}
