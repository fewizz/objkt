package org.objkt.gl;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.ShaderType;

public class GLShader extends GLObjectWithId<GLShader> {
	final ShaderType type;
	String source;

	public GLShader(ShaderType type) {
		this(GLContext.current(), type);
	}
	
	public GLShader(GLContext c, ShaderType type) {
		super(c, ObjectIdentifier.SHADER);
		this.type = type;
		createObject();
	}
	
	public GLShader(ShaderType type, String src) {
		this(type);
		source(src);
		compile();
	}
	
	@Override
	public void delete0() {
		ctx.wrap.shader.delete(getName());
	}

	public GLShader source(String source) {
		checkIfGenerated();
		
		this.source = source;
		ctx.wrap.shader.source(getName(), source);
		return this;
	}

	@Override
	public int create() {
		return ctx.wrap.shader.create(type.token);
	}

	public GLShader compile() {
		checkIfGenerated();
		
		ctx.wrap.shader.compile(getName());
		
		if (GL20.glGetShaderi(getName(), GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.println(source + " \n" + type.name() + " not compiled!");
			System.err.println(GL20.glGetShaderInfoLog(getName()));
		}
		return this;
	}

	public class GLShaderCompilationError extends GLError {
		private static final long serialVersionUID = 4104267426370159580L;

		public GLShaderCompilationError(String message) {
			super(message);
		}
	}
}
