package org.objkt.gl;

import static org.objkt.gl.GLConstants.GL_TEXTURE_DEPTH;
import static org.objkt.gl.GLConstants.GL_TEXTURE_MAG_FILTER;
import static org.objkt.gl.GLConstants.GL_TEXTURE_MIN_FILTER;
import static org.objkt.gl.GLConstants.GL_TEXTURE_WIDTH;
import static org.objkt.gl.GLConstants.GL_TEXTURE_WRAP_S;
import static org.objkt.gl.GLConstants.GL_TEXTURE_WRAP_T;

import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.TextureMagFilter;
import org.objkt.gl.enums.TextureTarget;
import org.objkt.gl.enums.TextureWrapMode;

public abstract class GLTexture extends GLBindableObject<GLTexture> {
	public final TextureTarget target;
	
	GLTexture(GLContext c, TextureTarget tar) {
		super(c, ObjectIdentifier.TEXTURE);
		this.target = tar;
		createObject();
	}
	
	public GLTexture(TextureTarget tar) {
		this(GLContext.current(), tar);
	}
	
	@Override
	protected void createObject() {
		super.createObject();
		wrapMode(TextureWrapMode.REPEAT);
		filter(TextureMagFilter.NEAREST);
	}

	@Override
	protected int gen() {
		return context.v2w.tex.gen();
	}
	
	@Override
	public void bind0() {
		context.v2w.tex.bind(target.token, getName());
	}
	
	public void bindTextureUnit(int index) {
		context.bindTextureUnit(this, index);
	}
	
	@Override
	protected void delete0() {
		context.v2w.tex.delete(getName());
	}
	
	public void wrapMode(TextureWrapMode mode) {
		bind();
		parameter(GL_TEXTURE_WRAP_S, mode.token);
		parameter(GL_TEXTURE_WRAP_T, mode.token);
	}
	
	public void filter(TextureMagFilter filter) {
		bind();
		parameter(GL_TEXTURE_MAG_FILTER, filter.token);
		parameter(GL_TEXTURE_MIN_FILTER, filter.token);
	}

	protected GLTexture parameter(int pname, int param) {
		bind();
		context.v2w.tex.parameteri(target.token, pname, param);
		return getThis();
	}

	protected GLTexture parameter(int pname, float param) {
		bind();
		context.v2w.tex.parameterf(target.token, pname, param);
		return getThis();
	}
	
	public int width() {
		bind();
		return context.v2w.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int height() {
		bind();
		return context.v2w.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_WIDTH);
	}
	
	public int depth() {
		bind();
		return context.v2w.tex.getTexLevelParameteri(target.token, 0, GL_TEXTURE_DEPTH);
	}
}
