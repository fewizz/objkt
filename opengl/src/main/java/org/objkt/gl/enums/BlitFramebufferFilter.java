package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BlitFramebufferFilter {
	NEAREST(GLConstants.GL_NEAREST),
	LINEAR(GLConstants.GL_LINEAR);

	BlitFramebufferFilter(int token) {
		this.token = token;
	}

	public final int token;

	public static final BlitFramebufferFilter[] VALUES = values();
	private static Map<Integer, BlitFramebufferFilter> getMap() {
		Map<Integer, BlitFramebufferFilter> map = new HashMap<>();
		for(BlitFramebufferFilter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BlitFramebufferFilter> MAP = Collections.unmodifiableMap(getMap());
	public static BlitFramebufferFilter get(int raw) { return MAP.get(raw); }

}