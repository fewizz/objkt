package org.objkt.glfw;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.*;
import org.lwjgl.system.MemoryUtil;
import org.objkt.memory.MemBlock;

public class GLFWWindow {
	private final MemBlock tempMemoryBlock = new MemBlock(8);
	public final long id;
	
	GLFWWindow(int w, int h, String title) {
		id = glfwCreateWindow(w, h, title, MemoryUtil.NULL, MemoryUtil.NULL);
		
		if (id == MemoryUtil.NULL)
			throw new RuntimeException("Failed to create the GLFW window");
	}
	
	public void show() {
		glfwShowWindow(id);
	}
	
	public void makeContextCurrent() {
		glfwMakeContextCurrent(id);
	}
	
	public void setPos(int x, int y) {
		glfwSetWindowPos(id, x, y);
	}
	
	public int width() {
		nglfwGetWindowSize(id, tempMemoryBlock.address(), MemoryUtil.NULL);
		return tempMemoryBlock.getInt(0);
	}
	
	public int height() {
		nglfwGetWindowSize(id, MemoryUtil.NULL, tempMemoryBlock.address());
		return tempMemoryBlock.getInt(0);
	}
	
	public int getX() {
		nglfwGetWindowPos(id, tempMemoryBlock.address(), MemoryUtil.NULL);
		return tempMemoryBlock.getInt(0);
	}
	
	public int getY() {
		nglfwGetWindowPos(id, MemoryUtil.NULL, tempMemoryBlock.address());
		return tempMemoryBlock.getInt(0);
	}
	
	public void setCursorPos(double x, double y) {
		glfwSetCursorPos(id, x, y);
	}
	
	public double getCursorX() {
		nglfwGetCursorPos(id, tempMemoryBlock.address(), MemoryUtil.NULL);
		return tempMemoryBlock.getDouble0(0);
	}
	
	public double getCursorY() {
		nglfwGetCursorPos(id, MemoryUtil.NULL, tempMemoryBlock.address());
		return tempMemoryBlock.getDouble0(0);
	}
	
	public void setKeyCallback(GLFWKeyCallbackI c) {
		glfwSetKeyCallback(id, c);
	}
	
	public void setMouseButtonCallback(GLFWMouseButtonCallbackI c) {
		glfwSetMouseButtonCallback(id, c);
	}
	
	public void setFramebufferSizeCallback(GLFWFramebufferSizeCallbackI c) {
		glfwSetFramebufferSizeCallback(id, c);
	}
	
	public void setCursorPosCallback(GLFWCursorPosCallbackI c) {
		glfwSetCursorPosCallback(id, c);
	}
	
	public void setShouldClose() {
		glfwSetWindowShouldClose(id, true);
	}
}
