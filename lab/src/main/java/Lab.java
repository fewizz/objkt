import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.glfw.*;
import org.lwjgl.system.MemoryStack;
import org.objkt.gl.*;
import org.objkt.gl.GLVertexArray.VertexAttribInfo;
import org.objkt.gl.enums.*;
import org.objkt.gl.wrapper.*;
import org.objkt.memory.SafeMemoryBlock;

public class Lab {

	private long window;

	public void run() {
		init();
		loop();

		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	private void init() {
		GLFWErrorCallback.createPrint(System.err).set();

		if ( !glfwInit() )
			throw new IllegalStateException("Unable to initialize GLFW");

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE);

		window = glfwCreateWindow(300, 300, "Hello World!", NULL, NULL);
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");

		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true);
		});

		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			glfwGetWindowSize(window, pWidth, pHeight);

			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			glfwSetWindowPos(
				window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);
		}

		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		glfwShowWindow(window);
	}

	private void loop() {
		GLContext gl = GLContext.createForThisThread(new LWJGLGLFWContextProvider(window), new LWJGLWrapper());

		gl.dedugMessageCallback((DebugSource source, DebugType type, int id, DebugSeverity severity, String message) -> {
			if(type == DebugType.DEBUG_TYPE_ERROR) {
				System.err.println(message);
				System.exit(1);
			}
			
			System.out.println(source.name() + ": " + message);
		});
		
		gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
		GLShaderProgram p = new GLShaderProgram(		
				ShaderType.VERTEX_SHADER,
				  "attribute vec2 pos;"
				+ "void main() {"
				+ "	gl_Position = vec4(pos, 0., 1.);"
				+ "}",
				
				ShaderType.FRAGMENT_SHADER,
				"void main() {"
				+ "	gl_FragColor = vec4(0., 1., 0., 1.);"
				+ "}");
		
		GLVertexBuffer vbo = new GLVertexBuffer();
		
		try(SafeMemoryBlock mb = new SafeMemoryBlock()) {
			mb.allocateWithFloats(
					-1, -1,
					1, 1,
					-1, 1);
			
			vbo.data(mb, BufferUsage.STATIC_DRAW);
		}
		
		GLVertexArray vao = new GLVertexArray();
		vao.vertexAttribPointer(p.attribLocation("pos"), VertexAttribInfo.POS2f, vbo).enable();

		while ( !glfwWindowShouldClose(window) ) {
			gl.clear(ClearBuffer.COLOR_BUFFER_BIT);
			
			p.use();
			gl.drawArrays(vao, PrimitiveType.TRIANGLES, 3);
			
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}

	public static void main(String[] args) {
		new Lab().run();
	}

}
