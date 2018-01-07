package org.objkt.gl;

import org.objkt.gl.enums.FramebufferTarget;
import org.objkt.gl.enums.ObjectIdentifier;

public class GLFrameBuffer extends GLBindableObject<GLFrameBuffer> {
	public final FramebufferTarget target;
	
	
	GLFrameBuffer(GLContext c, FramebufferTarget target) {
		super(c, ObjectIdentifier.FRAMEBUFFER);
		this.target = target;
		createObject();
	}

	@Override
	public void bind0() {
		ctx.wrap.frameBuff.bind(target.token, getName());
	}

	@Override
	protected int gen() {
		return ctx.wrap.frameBuff.gen();
	}

	@Override
	protected void delete0() {
		ctx.wrap.frameBuff.delete(getName());
	}
	
	/*public void texture(FramebufferAttachment attachment, GLTexture tex, int level) {
		bind();
		context.wrapper.framebufferTexture(target, attachment, tex.getName(), level);
	}*/

}
