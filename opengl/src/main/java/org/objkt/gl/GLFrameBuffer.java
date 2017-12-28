package org.objkt.gl;

import org.objkt.gl.enums.FramebufferAttachment;
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
		context.wrapper.bindFramebuffer(target, getName());
	}

	@Override
	protected int gen() {
		return context.wrapper.genFramebuffer();
	}

	@Override
	protected void deleteObject() {
		context.wrapper.deleteTexture(getName());
	}
	
	public void texture(FramebufferAttachment attachment, GLTexture tex, int level) {
		context.wrapper.framebufferTexture(target, attachment, tex.getName(), level);
	}

}
