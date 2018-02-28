package cubic;

import static org.lwjgl.glfw.GLFW.*;

import java.util.logging.Logger;

import org.joml.Matrix4f;
import org.objkt.engine.Tasks;
import org.objkt.gl.GLContext;
import org.objkt.gl.enums.*;
import org.objkt.gl.wrapper.*;
import org.objkt.glfw.*;

import cubic.network.*;
import cubic.world.ClientWorld;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;

public class Client {
	public static final Logger LOGGER = Logger.getLogger("CLIENT");
	public static final Matrix4f MAT = new Matrix4f();
	final static Camera CAM = new Camera();
	public static GLContext gl;
	public static final Tasks GL_TASKS = new Tasks();
	public static final Tasks TASKS = new Tasks();
	public static GLFWWindow window;
	public static ExtendedNioSocketChannel channel;
	public static ClientWorld world;
	
	static void start() {
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(new Cubic.AnsiConsoleHandler());
		
		Thread.currentThread().setName("Client Thread");
		
		Registries.init();
		
		new Thread(() -> Server.start("127.0.0.1", 25565), "Server Thread").start();
		
		world = new ClientWorld();
		connectToServer();
		
		new Thread(() -> {
			createWindow();
			initGL();
			glfwSwapInterval(1);
			gl.viewport(0, 0, window.width(), window.height());
			window.show();
			
			for(;;) try {
				GL_TASKS.waitAndExecute();
			} catch (InterruptedException e) {
				LOGGER.info("GL Thread interrupted");
				break;
			}
		}, "GL Thread").start();
		
		
		for(;;) try {
			TASKS.waitAndExecute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void createWindow() {
		window = new GLFWWindowBuilder()
				.title("Cubic")
				.width(1000)
				.height(600)
				.hint(GLFW_CONTEXT_VERSION_MAJOR, 3)
				.hint(GLFW_CONTEXT_VERSION_MINOR, 2)
				.hint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE)
				.hint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
				.hint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE)
				.build();

		window.setKeyCallback((windowID, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				window.setShouldClose();
		});
		window.setCursorPosCallback((long window, double xpos, double ypos) -> {
			CAM.rotate(xpos, ypos);
		});
		window.setFramebufferSizeCallback((long window, int width, int height) -> {
			GL_TASKS.add(() -> gl.viewport(0, 0, width, height));
		});
	}
	
	static void initGL() {
		gl = GLContext.createForThisThread(new LWJGLGLFWContextProvider(window.id), new LWJGLWrapper());

		gl.dedugMessageCallback((DebugSource source, DebugType type, int id, DebugSeverity severity, String message) -> {
			if(type == DebugType.DEBUG_TYPE_ERROR) {
				LOGGER.severe(message);
				System.exit(1);
			}
			
			LOGGER.info("GL " + source.name() + ": " + message);
		});
	}
	
	static void connectToServer() {
		Bootstrap boot = new Bootstrap();
		boot.channel(ExtendedNioSocketChannel.class);
		boot.group(new NioEventLoopGroup());
		boot.handler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				ch.pipeline().addLast(new ChannelPacketReadHandler());
			}
		});
		channel = (ExtendedNioSocketChannel) boot.connect("127.0.0.1", 25565).awaitUninterruptibly().channel();
		channel.config().setTcpNoDelay(true);
		
		LOGGER.info("I connected to server!");
	}
}
