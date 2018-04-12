package org.objkt.gl;

import java.nio.IntBuffer;
import java.util.*;

import org.objkt.gl.GLShader.GLShaderCompilationError;
import org.objkt.gl.enums.*;
import org.objkt.memory.*;

public class GLShaderProgram extends GLObjectWithId<GLShaderProgram> {
	final Set<GLShader> shaders = new LinkedHashSet<>();
	boolean linked = false;
	
	public GLShaderProgram() {
		this(GLContext.current());
	}
	
	GLShaderProgram(GLContext c) {
		this(c, c.wrap.shaderProg.create(-1));
	}

	GLShaderProgram(GLContext c, int name) {
		super(c, name);
	}
	
	public GLShaderProgram(ShaderType t1, String src1, ShaderType t2, String src2) throws GLShaderCompilationError{
		this();
		attachShaders(new GLShader(t1, src1), new GLShader(t2, src2));
		link();
	}
	
	public void use() {
		if(!isLinked()) {
			throw new Error("ShaderProgram is not linked");
		}
		ctx.wrap.shaderProg.use(name);
	}

	public void delete() {
		ctx.wrap.shaderProg.delete(name);
	}

	public void attachShader(GLShader shader) {
		ctx.wrap.shaderProg.attachShader(name, shader.name);
		shaders.add(shader);
	}

	public void attachShaders(GLShader... shaders) {
		for (GLShader sh : shaders)
			attachShader(sh);
	}

	public void link() {
		ctx.wrap.shaderProg.link(name);

		if (ctx.wrap.shaderProg.geti(name, ProgramPropertyARB.LINK_STATUS.token) == 0) {
			throw new GLError(ctx.wrap.shaderProg.getInfoLog(name));
		}
		
		linked = true;
	}
	
	public boolean isLinked() {
		return linked;
	}

	public int attribLocation(String name) {
		return ctx.wrap.shaderProg.attribLoc(this.name, name);
	}

	public int getUniformLocation(String name) {
		return ctx.wrap.shaderProg.uniformLoc(this.name, name);
	}

	public void setUniformInt(int location, int value) {
		use();
		ctx.wrap.shaderProg.uniform1i(location, value);
	}
	
	public void setUniformMatrix4f(int location, MemBlock mat) {
		use();
		ctx.wrap.shaderProg.uniformMatrix4fv(location, 1, false, mat.address());
	}

	public void setUniformIntArray(int location, IntBuffer value) {
		use();
		ctx.wrap.shaderProg.uniform1iv(location, value.capacity(), Utils.address(value));
	}
	
	public void setUniformIntArray(int location, int count, MemBlock values) {
		use();
		ctx.wrap.shaderProg.uniform1iv(location, count, values.address());
	}
	
	public void setUniformIntArray(int location, MemBlock values) {
		use();
		ctx.wrap.shaderProg.uniform1iv(location, (int)values.bytes() / Integer.BYTES, values.address());
	}
	
	public void setAttrib() {
		use();
	}
}
