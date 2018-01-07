package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum FramebufferStatus {
	FRAMEBUFFER_COMPLETE(GLConstants.GL_FRAMEBUFFER_COMPLETE),
	FRAMEBUFFER_UNDEFINED(GLConstants.GL_FRAMEBUFFER_UNDEFINED),
	FRAMEBUFFER_INCOMPLETE_ATTACHMENT(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT),
	FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT),
	FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER),
	FRAMEBUFFER_INCOMPLETE_READ_BUFFER(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER),
	FRAMEBUFFER_UNSUPPORTED(GLConstants.GL_FRAMEBUFFER_UNSUPPORTED),
	FRAMEBUFFER_INCOMPLETE_MULTISAMPLE(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE),
	FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS(GLConstants.GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS);

	FramebufferStatus(int token) {
		this.token = token;
	}

	public final int token;

	public static final FramebufferStatus[] VALUES = values();
	private static Map<Integer, FramebufferStatus> getMap() {
		Map<Integer, FramebufferStatus> map = new HashMap<>();
		for(FramebufferStatus val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FramebufferStatus> MAP = Collections.unmodifiableMap(getMap());
	public static FramebufferStatus get(int raw) { return MAP.get(raw); }
}