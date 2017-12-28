package org.objkt.gl;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.objct.gl.enums.ObjectIdentifier;
import org.objct.gl.enums.ShaderType;

public class GLShader extends GLObjectWithId<GLShader> {
	final ShaderType type;
	String source;

	public GLShader(ShaderType type) {
		super(ObjectIdentifier.SHADER);
		this.type = type;
		createObject();
	}
	
	@Override
	public void deleteObject() {
		context.wrapper.deleteShader(getName());
	}

	public GLShader source(String source) {
		check();
		
		this.source = source;
		GL20.glShaderSource(getName(), source);
		context.wrapper.shaderSource(getName(), source);
		return this;
	}

	@Override
	public int create() {
		return context.wrapper.createShader(type);
	}

	public GLShader compile() {
		check();
		
		GL20.glCompileShader(getName());
		if (GL20.glGetShaderi(getName(), GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.println(source + " \n" + type.name() + " not compiled!");
			System.err.println(GL20.glGetShaderInfoLog(getName()));
		}
		return this;
	}

}
