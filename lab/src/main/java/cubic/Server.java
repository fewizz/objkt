package cubic;

import java.util.*;
import java.util.logging.Logger;

import cubic.network.*;
import cubic.world.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

public class Server {
	public static final Logger LOGGER = Logger.getLogger("SERVER");
	public static ServerWorld world;
	static Registries registries;
	static ServerSocketChannel channel;
	public static final Map<String, ServerPlayer> PLAYERS = new HashMap<>();
	public static final AttributeKey<ConnectionInfo> CONNECTION_INFO_ATTRIB_KEY = AttributeKey.newInstance("connection_state");
	public static final AttributeKey<ServerPlayer> PLAYER_ATTRIB_KEY = AttributeKey.newInstance("player");
	public static NetworkManager network;
	
	static {
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(new Cubic.AnsiConsoleHandler());
	}
	
	static void start(String ip, int port) {
		LOGGER.info("Starting server");
		
		ServerBootstrap boot = new ServerBootstrap();
		boot.channel(NioServerSocketChannel.class);
		boot.group(new NioEventLoopGroup());
		
		boot.childHandler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				LOGGER.info("Client is connected to server!");
				
				ch.attr(PLAYER_ATTRIB_KEY).set(null);
				ch.attr(CONNECTION_INFO_ATTRIB_KEY).set(new ConnectionInfo(ch));
				ch.attr(CONNECTION_INFO_ATTRIB_KEY).get().setConnectionState(ConnectionState.PREPARING);
				
				ch.pipeline().addLast(new ChannelPacketReadHandler());
			}
		});
		
		channel = (ServerSocketChannel) boot.bind(ip, port).awaitUninterruptibly().channel();
		channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.TRUE);
		network = new NetworkManager(channel);
		
		world = new ServerWorld();
		
		for(;;) {
			world.update();
		}
	}
	
	static void onChannelConnectionStateChanged(Channel ch, ConnectionState from, ConnectionState to) {
		ServerPlayer player = ch.attr(PLAYER_ATTRIB_KEY).get();
		
		LOGGER.info(ch.localAddress().toString() + " from " + from.name() + " to " + to.name());
		
		if(from == ConnectionState.DISCONNECTED && to == ConnectionState.PREPARING) {
			NetworkManager.sendPacket(ch, Packets.HELLO_FROM_SERVER, null);
		}
		if(from == ConnectionState.PREPARING && to == ConnectionState.PLAYTIME) {
			PLAYERS.put(player.getName(), player);
		}
	}
	
	public static class ConnectionInfo {
		final Channel channel;
		ConnectionState connectionState = ConnectionState.DISCONNECTED;
		
		public ConnectionInfo(Channel channel) {
			this.channel = channel;
		}
		
		public void setConnectionState(ConnectionState connectionState) {
			ConnectionState prev = this.connectionState;
			this.connectionState = connectionState;
			Server.onChannelConnectionStateChanged(channel, prev, connectionState);
		}
	}
	
	public static enum ConnectionState {
		DISCONNECTED,
		PREPARING,
		PLAYTIME
	}
}
