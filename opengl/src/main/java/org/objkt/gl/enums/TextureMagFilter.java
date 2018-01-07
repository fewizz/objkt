package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum TextureMagFilter {
	LINEAR(GLConstants.GL_LINEAR),
	NEAREST(GLConstants.GL_NEAREST);

	TextureMagFilter(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureMagFilter[] VALUES = values();
	private static Map<Integer, TextureMagFilter> getMap() {
		Map<Integer, TextureMagFilter> map = new HashMap<>();
		for(TextureMagFilter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureMagFilter> MAP = Collections.unmodifiableMap(getMap());
	public static TextureMagFilter get(int raw) { return MAP.get(raw); }
}