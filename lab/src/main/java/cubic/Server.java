package cubic;

import java.util.*;
import java.util.logging.Logger;

import org.objkt.engine.Tasks;

import cubic.network.*;
import cubic.world.ServerWorld;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;

public class Server {
	public static final Logger LOGGER = Logger.getLogger("SERVER");
	public static ServerWorld world;
	static Registries registries;
	static ExtendedServerSocketChannel channel;
	public static final Map<String, ServerPlayer> PLAYERS = new HashMap<>();
	public static final Tasks TASKS = new Tasks();
	
	static {
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(new Cubic.AnsiConsoleHandler());
	}
	
	static void start(String ip, int port) {
		LOGGER.info("Starting server");
		
		ServerBootstrap boot = new ServerBootstrap();
		boot.channel(ExtendedNioServerSocketChannel.class);
		boot.group(new NioEventLoopGroup());
		
		boot.childHandler(new ChannelInitializer<ExtendedChannel>() {
			@Override
			protected void initChannel(ExtendedChannel ch) throws Exception {
				LOGGER.info("Client is connected to server!");
				
				ch.pipeline().addLast(new ChannelPacketReadHandler());
				
				ch.sendPacket(Packets.HELLO_FROM_SERVER);
			}
		});
		
		channel = (ExtendedServerSocketChannel) boot.bind(ip, port).awaitUninterruptibly().channel();
		channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.TRUE);
		
		world = new ServerWorld();
		
		for(;;) {
			TASKS.executeAvailable();
			world.update();
		}
	}
	
	static void onPlayerReadyToPlay(ServerPlayer player) {
		PLAYERS.put(player.name, player);
	}
}
