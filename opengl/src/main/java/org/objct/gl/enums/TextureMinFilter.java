package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum TextureMinFilter {
	LINEAR(GLConstants.GL_LINEAR),
	LINEAR_MIPMAP_LINEAR(GLConstants.GL_LINEAR_MIPMAP_LINEAR),
	LINEAR_MIPMAP_NEAREST(GLConstants.GL_LINEAR_MIPMAP_NEAREST),
	NEAREST(GLConstants.GL_NEAREST),
	NEAREST_MIPMAP_LINEAR(GLConstants.GL_NEAREST_MIPMAP_LINEAR),
	NEAREST_MIPMAP_NEAREST(GLConstants.GL_NEAREST_MIPMAP_NEAREST);

	TextureMinFilter(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureMinFilter[] VALUES = values();
	private static Map<Integer, TextureMinFilter> getMap() {
		Map<Integer, TextureMinFilter> map = new HashMap<>();
		for(TextureMinFilter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, TextureMinFilter> MAP = Collections.unmodifiableMap(getMap());
	public static TextureMinFilter get(int raw) { return MAP.get(raw); }

}