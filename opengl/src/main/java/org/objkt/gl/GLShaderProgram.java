package org.objkt.gl;

import java.nio.IntBuffer;
import java.util.*;

import org.lwjgl.opengl.GL20;
import org.objkt.gl.enums.*;
import org.objkt.memory.MemBlock;

public class GLShaderProgram extends GLObjectWithId<GLShaderProgram> {
	final Set<GLShader> shaders = new LinkedHashSet<>();
	boolean linked = false;
	
	public GLShaderProgram() {
		this(GLContext.current());
	}
	
	GLShaderProgram(GLContext c) {
		super(c, ObjectIdentifier.PROGRAM);
		createObject();
	}
	
	public GLShaderProgram(ShaderType t1, String src1, ShaderType t2, String src2) {
		this();
		attachShaders(new GLShader(t1, src1), new GLShader(t2, src2));
		link();
	}
	
	@Override
	public int create() {
		return ctx.wrap.shaderProg.create(-1);
	}
	
	public void use() {
		checkIfGenerated();
		//if(!isLinked()) {
		//	throw new Error("ShaderProgram is not linked");
		//}
		ctx.wrap.shaderProg.use(getName());
	}
	
	@Override
	public void delete0() {
		ctx.wrap.shaderProg.delete(getName());
	}

	public void attachShader(GLShader shader) {
		checkIfGenerated();
		
		ctx.wrap.shaderProg.attachShader(getName(), shader.getName());
		shaders.add(shader);
	}

	public void attachShaders(GLShader... shaders) {
		for (GLShader sh : shaders)
			attachShader(sh);
	}

	public void link() {
		checkIfGenerated();
		
		ctx.wrap.shaderProg.link(getName());

		/*if (ctx.wrap.shaderProg.geti(getName(), ProgramPropertyARB.LINK_STATUS.token) == 0) {
			System.err.println("Program is not compiled! Error message:");
			System.err.println(GL20.glGetProgramInfoLog(getName()));
		}*/
		
		linked = true;
	}
	
	public boolean isLinked() {
		return linked;
	}

	public int attribLocation(String name) {
		return ctx.wrap.shaderProg.attribLoc(getName(), name);
	}

	public int getUniformLocation(String name) {
		return ctx.wrap.shaderProg.uniformLoc(getName(), name);
	}

	public void setUniformInt(int location, int value) {
		use();
		GL20.glUniform1i(location, value);
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
