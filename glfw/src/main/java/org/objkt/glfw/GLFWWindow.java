package org.objkt.glfw;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.*;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class GLFWWindow {
	ByteBuffer buff = BufferUtils.createByteBuffer(8);
	IntBuffer buffi = buff.asIntBuffer();
	DoubleBuffer buffd = buff.asDoubleBuffer();
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
		glfwGetWindowSize(id, buffi, null);
		return buff.getInt(0);
	}
	
	public int height() {
		glfwGetWindowSize(id, null, buffi);
		return buff.getInt(0);
	}
	
	public int getX() {
		glfwGetWindowPos(id, buffi, null);
		return buff.getInt(0);
	}
	
	public int getY() {
		glfwGetWindowPos(id, null, buffi);
		return buff.getInt(0);
	}
	
	public void setCursorPos(double x, double y) {
		glfwSetCursorPos(id, x, y);
	}
	
	public double getCursorX() {
		glfwGetCursorPos(id, buffd, null);
		return buff.getDouble(0);
	}
	
	public double getCursorY() {
		glfwGetCursorPos(id, null, buffd);
		return buff.getDouble(0);
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
