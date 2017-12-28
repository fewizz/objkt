package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PixelTexGenMode {
	LUMINANCE(GLConstants.GL_LUMINANCE),
	LUMINANCE_ALPHA(GLConstants.GL_LUMINANCE_ALPHA),
	NONE(GLConstants.GL_NONE),
	RGB(GLConstants.GL_RGB),
	RGBA(GLConstants.GL_RGBA);

	PixelTexGenMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelTexGenMode[] VALUES = values();
	private static Map<Integer, PixelTexGenMode> getMap() {
		Map<Integer, PixelTexGenMode> map = new HashMap<>();
		for(PixelTexGenMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PixelTexGenMode> MAP = Collections.unmodifiableMap(getMap());
	public static PixelTexGenMode get(int raw) { return MAP.get(raw); }

}