package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ClipControlOrigin {
	LOWER_LEFT(GLConstants.GL_LOWER_LEFT),
	UPPER_LEFT(GLConstants.GL_UPPER_LEFT);

	ClipControlOrigin(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClipControlOrigin[] VALUES = values();
	private static Map<Integer, ClipControlOrigin> getMap() {
		Map<Integer, ClipControlOrigin> map = new HashMap<>();
		for(ClipControlOrigin val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ClipControlOrigin> MAP = Collections.unmodifiableMap(getMap());
	public static ClipControlOrigin get(int raw) { return MAP.get(raw); }

}