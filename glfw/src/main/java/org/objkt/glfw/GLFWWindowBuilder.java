package org.objkt.glfw;

import static org.lwjgl.glfw.GLFW.*;

import java.util.LinkedHashSet;

public class GLFWWindowBuilder {
	boolean defaults = false;
	LinkedHashSet<Long> hints = new LinkedHashSet<>();
	int width = -1;
	int height = -1;
	String title = null;
	
	public GLFWWindowBuilder hint(int hint, int value) {
		hints.add(((long)hint << 32) | value);
		return this;
	}
	
	public GLFWWindowBuilder defaultHints() {
		defaults = true;
		return this;
	}
	
	public GLFWWindowBuilder width(int w) {
		this.width = w;
		return this;
	}
	
	public GLFWWindowBuilder height(int h) {
		this.height = h;
		return this;
	}
	
	public GLFWWindowBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public GLFWWindow build() {
		if(!org.objkt.glfw.GLFW.inited) {
			org.objkt.glfw.GLFW.init();
		}
		glfwDefaultWindowHints();
		
		hints.forEach(l -> {
			glfwWindowHint((int)(l >> 32), (int)(l & 0xFFFFFFFF));
		});
		
		return new GLFWWindow(width, height, title);
	}

}
