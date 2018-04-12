package cubic;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.logging.Logger;

import org.objkt.engine.Tasks;
import org.objkt.memory.*;

import cubic.network.*;
import cubic.world.ServerWorld;

public class Server {
	public static final Logger LOGGER = Logger.getLogger("SERVER");
	public static ServerWorld world;
	static Registries registries;
	static volatile ServerSocketChannel channel;
	public static final Map<String, ServerPlayer> PLAYERS = new HashMap<>();
	public static final Tasks TASKS = new Tasks();
	
	static {
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(new Cubic.AnsiConsoleHandler());
	}
	
	static void start(String ip, int port) {
		try {
			start0(ip, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void start0(String ip, int port) throws Exception {
		LOGGER.info("Starting server");
		

		channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress(ip, port));
		channel.configureBlocking(false);
		
		world = new ServerWorld();

		startChannelHandler();
		
		for(;;) {
			TASKS.executeAvailable();
			world.update();
		}
	}
	
	private static void startChannelHandler() { new Thread(() -> { try {
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);
			
		for(;;) {
			selector.select();

			if(selector.selectedKeys().contains(channel.keyFor(selector)) && channel.keyFor(selector).isAcceptable()) {
				SocketChannel sc = channel.accept();
				if(sc == null) continue;
				sc.configureBlocking(false);
				sc.setOption(StandardSocketOptions.TCP_NODELAY, true);
				sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				sc.keyFor(selector).attach(new ChannelExtension(sc));
			}
			for(SelectionKey key : selector.selectedKeys()) {
				ChannelExtension extension = (ChannelExtension) key.attachment();
				if(key.isReadable())
					extension.connection.read();
				if(key.isWritable())
					extension.connection.flushPackets();
			}
		}
	} catch (Exception e) { e.printStackTrace(); }}, "Server Channel Thread").start();}
	
	static void onPlayerReadyToPlay(ServerPlayer player) {
		PLAYERS.put(player.name, player);
		LOGGER.info(player.name + " connected");
	}
}
