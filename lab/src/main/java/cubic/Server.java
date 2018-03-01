package cubic;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.logging.Logger;

import org.objkt.engine.Tasks;
import org.objkt.memory.*;

import cubic.world.ServerWorld;

public class Server {
	public static final Logger LOGGER = Logger.getLogger("SERVER");
	public static ServerWorld world;
	static Registries registries;
	//static ExtendedServerSocketChannel channel;
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
		
		/*ServerBootstrap boot = new ServerBootstrap();
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
		channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.TRUE);*/
		channel = ServerSocketChannel.open();
		channel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
		channel.setOption(StandardSocketOptions.TCP_NODELAY, true);
		channel.bind(new InetSocketAddress(ip, port));
		
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
			
		for(;;) {
			selector.select();
				
			if(channel.keyFor(selector).isAcceptable()) {
				SocketChannel sc = channel.accept();
				sc.register(selector, SelectionKey.OP_READ);
			}
			else for(SelectionKey key : selector.selectedKeys()) {
				if(!key.isReadable())
					continue;
					
				SocketChannel sc = (SocketChannel) key.channel();
				MemBlockBuffer mem = new MemBlockBuffer();
					
				for(;;) {
					MemBlock memBlock = blocks.peek();
					if(memBlock == null) {
						memBlock = new MemBlock(channel.getOption(StandardSocketOptions.SO_RCVBUF));
						blocks.add(memBlock);
					}
						
					Utils.setBufferAddressAndCapacity(buff, memBlock.address(), (int) memBlock.bytes());
					
					if(sc.read(buff) <= 0)
						break;
						
					mem.capture(memBlock);
				}
					
				for(;mem.isReadable();) {
					int packetID = mem.readInt();
					Registries.PACKETS.get(packetID).read(mem);
				}
			}
		}
	} catch (Exception e) { e.printStackTrace(); }}, "Server Channel Thread").start();}
	
	static void onPlayerReadyToPlay(ServerPlayer player) {
		PLAYERS.put(player.name, player);
	}
}
