package org.objkt.glfw;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWErrorCallback;

public class GLFW {
	static boolean inited = false;
	
	public static void init() {
		inited = true;
		glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));
		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
	}

	public static void pollEvents() {
		glfwPollEvents();
	}
}