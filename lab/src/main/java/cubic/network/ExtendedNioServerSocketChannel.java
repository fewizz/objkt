package cubic.network;

import java.nio.channels.SocketChannel;
import java.util.List;

import cubic.Server;
import io.netty.channel.socket.nio.*;
import io.netty.util.internal.SocketUtils;

public class ExtendedNioServerSocketChannel extends NioServerSocketChannel implements ExtendedServerSocketChannel {
	@Override
    protected int doReadMessages(List<Object> buf) throws Exception {
        SocketChannel ch = SocketUtils.accept(javaChannel());

        try {
            if (ch != null) {
                buf.add(new ExtendedNioSocketChannel(this, ch));
                return 1;
            }
        } catch (Throwable t) {
            Server.LOGGER.severe("Failed to create a new channel from an accepted socket.\n" + t.getMessage());

            try {
                ch.close();
            } catch (Throwable t2) {
            	Server.LOGGER.severe("Failed to close a socket.\n" + t2.getMessage());
            }
        }

        return 0;
    }
}
