package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum CheckFramebufferStatusTarget {
	DRAW_FRAMEBUFFER(GLConstants.GL_DRAW_FRAMEBUFFER),
	READ_FRAMEBUFFER(GLConstants.GL_READ_FRAMEBUFFER),
	FRAMEBUFFER(GLConstants.GL_FRAMEBUFFER);

	CheckFramebufferStatusTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final CheckFramebufferStatusTarget[] VALUES = values();
	private static Map<Integer, CheckFramebufferStatusTarget> getMap() {
		Map<Integer, CheckFramebufferStatusTarget> map = new HashMap<>();
		for(CheckFramebufferStatusTarget val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, CheckFramebufferStatusTarget> MAP = Collections.unmodifiableMap(getMap());
	public static CheckFramebufferStatusTarget get(int raw) { return MAP.get(raw); }

}