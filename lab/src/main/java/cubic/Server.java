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
	static ServerSocketChannel channel;
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
		
		startChannelHandler();
		
		world = new ServerWorld();
		
		for(;;) {
			TASKS.executeAvailable();
			world.update();
		}
	}
	
	private static void startChannelHandler() { new Thread(() -> { try {
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);
		
		Queue<MemBlock> blocks = new ArrayDeque<>();
		ByteBuffer buff = Utils.newNullDirectBufferWithoutCleaner();
		OffheapDataChannel mem = new OffheapDataChannel();
			
		for(;;) {
			selector.select();
				
			if(channel.keyFor(selector).isAcceptable()) {
				SocketChannel sc = channel.accept();
				sc.setOption(StandardSocketOptions.TCP_NODELAY, true);
				sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				sc.keyFor(selector).attach(new PacketHandler());
			}
			else for(SelectionKey key : selector.selectedKeys()) {
				if(key.isReadable())
					readPackets(key, blocks, buff, mem); 
				if(key.isWritable())
					sendPackets(key, blocks, buff, mem);
			}
		}
	} catch (Exception e) { e.printStackTrace(); }}, "Server Channel Thread").start();}
	
	static void onPlayerReadyToPlay(ServerPlayer player) {
		PLAYERS.put(player.name, player);
	}
}
