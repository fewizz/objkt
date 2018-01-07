package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum Buffer {
	COLOR(GLConstants.GL_COLOR),
	DEPTH(GLConstants.GL_DEPTH),
	STENCIL(GLConstants.GL_STENCIL);

	Buffer(int token) {
		this.token = token;
	}

	public final int token;

	public static final Buffer[] VALUES = values();
	private static Map<Integer, Buffer> getMap() {
		Map<Integer, Buffer> map = new HashMap<>();
		for(Buffer val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, Buffer> MAP = Collections.unmodifiableMap(getMap());
	public static Buffer get(int raw) { return MAP.get(raw); }
}