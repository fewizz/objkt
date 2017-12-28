package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum FramebufferTarget {
	FRAMEBUFFER(GLConstants.GL_FRAMEBUFFER),
	DRAW_FRAMEBUFFER(GLConstants.GL_DRAW_FRAMEBUFFER),
	READ_FRAMEBUFFER(GLConstants.GL_READ_FRAMEBUFFER);

	FramebufferTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final FramebufferTarget[] VALUES = values();
	private static Map<Integer, FramebufferTarget> getMap() {
		Map<Integer, FramebufferTarget> map = new HashMap<>();
		for(FramebufferTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FramebufferTarget> MAP = Collections.unmodifiableMap(getMap());
	public static FramebufferTarget get(int raw) { return MAP.get(raw); }

}