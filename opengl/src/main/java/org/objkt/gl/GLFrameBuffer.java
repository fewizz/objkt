package org.objkt.gl;

import org.objkt.gl.enums.FramebufferTarget;
import org.objkt.gl.enums.ObjectIdentifier;

public class GLFrameBuffer extends GLBindableObject<GLFrameBuffer> {
	public final FramebufferTarget target;
	
	public GLFrameBuffer(FramebufferTarget target) {
		super(ObjectIdentifier.FRAMEBUFFER);
		this.target = target;
		createObject();
	}

	@Override
	public void bind0() {
		context.v2w.frameBuff.bind(target.token, getName());
	}

	@Override
	protected int gen() {
		return context.v2w.frameBuff.gen();
	}

	@Override
	protected void delete0() {
		context.v2w.frameBuff.delete(getName());
	}
	
	/*public void texture(FramebufferAttachment attachment, GLTexture tex, int level) {
		bind();
		context.wrapper.framebufferTexture(target, attachment, tex.getName(), level);
	}*/

}
