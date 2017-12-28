package org.objkt.gl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL12;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.TextureTarget;

public abstract class GLTexture extends GLBindableObject<GLTexture> {
	public final TextureTarget target;
	
	public GLTexture(TextureTarget tar) {
		super(ObjectIdentifier.TEXTURE);
		this.target = tar;
		createObject();
		setDefaultParams();
	}

	@Override
	protected int gen() {
		return context.wrapper.genTexture();
	}
	
	@Override
	public void bind0() {
		context.wrapper.bindTexture(target, getName());
	}
	
	public void bindTextureUnit(int index) {
		check();
		context.bindTextureUnit(this, index);
	}
	
	@Override
	protected void deleteObject() {
		context.wrapper.deleteTexture(getName());
	}

	public GLTexture setDefaultParams() {
		check();
		parameter(GL_TEXTURE_WRAP_S, GL_REPEAT);
		parameter(GL_TEXTURE_WRAP_T, GL_REPEAT);
		parameter(GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		parameter(GL_TEXTURE_MIN_FILTER, GL_NEAREST);

		return getThis();
	}

	public GLTexture parameter(int pname, int param) {
		bind();
		glTexParameteri(target.token, pname, param);
		return getThis();
	}

	public GLTexture parameter(int pname, float param) {
		bind();
		glTexParameterf(target.token, pname, param);
		return getThis();
	}
	
	public int width() {
		bind();
		return glGetTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int height() {
		bind();
		return glGetTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int depth() {
		bind();
		return glGetTexLevelParameteri(target.token, 0, GL12.GL_TEXTURE_DEPTH);
	}
}
