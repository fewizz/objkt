package cubic;

import static org.lwjgl.glfw.GLFW.*;

import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.*;
import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

import cubic.network.Packets;
import cubic.render.WorldRenderer;
import fewizz.wrap.gl.enums.Capability;
import fewizz.wrap.gl.enums.DebugSeverity;
import fewizz.wrap.gl.enums.DebugSource;
import fewizz.wrap.gl.enums.DebugType;
import fewizz.wrap.gl.wrapper.LWJGLGLFWContextProvider;
import fewizz.wrap.gl.wrapper.LWJGLWrapper;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.objkt.engine.Tasks;
import fewizz.wrap.gl.GLContext;
import org.objkt.glfw.*;

import cubic.network.Connection;
import cubic.world.ClientWorld;

public class Client {
	public static final Logger LOGGER = Logger.getLogger("CLIENT");
	public 	final static Camera CAM = new Camera();
	public static GLContext gl;
	public static final Tasks GL_TASKS = new Tasks();
	public static final Tasks TASKS = new Tasks();
	public static GLFWWindow window;
	public static Connection connection;
	public static ClientWorld world;
	
	static void start() {
		LOGGER.setUseParentHandlers(false);
		LOGGER.addHandler(new Cubic.AnsiConsoleHandler());
		
		Thread.currentThread().setName("Client Thread");
		
		Registries.init();
		
		new Thread(() -> Server.start("127.0.0.1", 25565), "Server Thread").start();
		
		world = new ClientWorld();
		connectToServer();
		connection.sendPacketAsynchronously(Packets.IM_READY, "Player" + new Random().nextInt());
		
		new Thread(() -> {
			createWindow();
			initGL();
			glfwSwapInterval(1);
			gl.viewport(0, 0, window.width(), window.height());
			gl.enable(Capability.DEPTH_TEST);
			window.show();
			
			while(!glfwWindowShouldClose(window.id)) try {
				glfwPollEvents();
				GL_TASKS.executeAvailable();
				WorldRenderer.render();
				glfwSwapBuffers(window.id);
			} catch (Exception e) {
				LOGGER.info("GL Thread interrupted");
				break;
			}
		}, "GL Thread").start();
		
		for(;;) try {
			TASKS.executeAvailable();
			connection.flushPackets();
			connection.read();
			Thread.sleep(50);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
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
			if(key == GLFW_KEY_W)
				CAM.x += 0.5;
			if(key == GLFW_KEY_S)
				CAM.x -= 0.5;
			if(key == GLFW_KEY_D)
				CAM.z += 0.5;
			if(key == GLFW_KEY_A)
				CAM.z -= 0.5;
			if(key == GLFW_KEY_SPACE)
				CAM.y += 0.5;
			if(key == GLFW_KEY_LEFT_SHIFT)
				CAM.y -= 0.5;
		});
		window.setCursorPosCallback((long window0, double xpos, double ypos) -> {
			CAM.rotate(xpos - window.width() / 2F, ypos - window.height() / 2F);
		});
		window.setFramebufferSizeCallback((long window, int width, int height) -> {
			GL_TASKS.add(() -> gl.viewport(0, 0, width, height));
		});
	}
	
	static void initGL() {
		gl = GLContext.create(new LWJGLGLFWContextProvider(window.id), new LWJGLWrapper());

		gl.dedugMessageCallback((DebugSource source, DebugType type, int id, DebugSeverity severity, String message) -> {
			if(type == DebugType.DEBUG_TYPE_ERROR) {
				LOGGER.severe(message);
				System.exit(1);
			}
			
			LOGGER.info("GL " + source.name() + ": " + message);
		});
	}
	
	static void connectToServer() { try {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress("127.0.0.1", 25565));
		sc.setOption(StandardSocketOptions.TCP_NODELAY, true);
		sc.configureBlocking(false);
		connection = new Connection(sc);
		
		LOGGER.info("I connected to server!");
	} catch(Exception e) {e.printStackTrace();System.exit(-1);} }
}
