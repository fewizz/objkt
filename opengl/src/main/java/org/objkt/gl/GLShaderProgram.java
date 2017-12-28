package org.objkt.gl;

import java.nio.IntBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

import org.lwjgl.opengl.GL20;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.ProgramPropertyARB;
import org.objkt.memory.MemBlock;
import org.objkt.memory.Utils;

public class GLShaderProgram extends GLObjectWithId<GLShaderProgram> {
	final Set<GLShader> shaders = new LinkedHashSet<>();
	boolean linked = false;
	
	public GLShaderProgram() {
		super(ObjectIdentifier.PROGRAM);
		createObject();
	}
	
	@Override
	public int create() {
		return context.wrapper.glCreateProgram();
	}
	
	public void use() {
		check();
		context.wrapper.glUseProgram(getName());
	}
	
	@Override
	public void deleteObject() {
		context.wrapper.glDeleteProgram(getName());
	}

	public void attachShader(GLShader shader) {
		check();
		
		context.wrapper.glAttachShader(getName(), shader.getName());
		shaders.add(shader);
	}

	public void attachShaders(GLShader... shaders) {
		for (GLShader sh : shaders)
			attachShader(sh);
	}

	public void link() {
		check();
		
		context.wrapper.glLinkProgram(getName());

		if (context.wrapper.getProgrami(getName(), ProgramPropertyARB.LINK_STATUS) == 0) {
			System.err.println("Program is not compiled! Error message:");
			System.err.println(GL20.glGetProgramInfoLog(getName()));
		}
		
		linked = true;
	}
	
	public boolean isLinked() {
		return linked;
	}

	public int getAttributeLocation(String name) {
		check();
		return context.wrapper.getAttribLocation(getName(), Utils.addressOfStringUTF8(name, true));
	}

	public int getUniformLocation(String name) {
		check();
		return context.wrapper.getUniformLocation(getName(), Utils.addressOfStringUTF8(name, true));
	}

	public void setUniformInt(int location, int value) {
		use();
		context.wrapper.uniform1i(getName(), value);
	}

	/*public void setUniformMatrix4f(int location, Matrix4f mat) {
		use();
		try (MemoryStack ms = MemoryStack.stackPush()) {
			FloatBuffer buff = ms.mallocFloat(4 * 4);
			GL20.glUniformMatrix4fv(location, false, mat.get(buff));
		}
	}*/
	
	public void setUniformMatrix4f(int location, MemBlock mat) {
		use();
		GL20.nglUniformMatrix4fv(location, 1, false, mat.address());
	}

	public void setUniformIntArray(int location, IntBuffer value) {
		use();
		GL20.glUniform1iv(location, value);
	}
	
	public void setUniformIntArray(int location, int count, MemBlock values) {
		use();
		GL20.nglUniform1iv(location, count, values.address());
	}
	
	public void setUniformIntArray(int location, MemBlock values) {
		use();
		GL20.nglUniform1iv(location, values.ints(), values.address());
	}
}
