package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum ClipControlDepth {
	NEGATIVE_ONE_TO_ONE(GLConstants.GL_NEGATIVE_ONE_TO_ONE),
	ZERO_TO_ONE(GLConstants.GL_ZERO_TO_ONE);

	ClipControlDepth(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClipControlDepth[] VALUES = values();
	private static Map<Integer, ClipControlDepth> getMap() {
		Map<Integer, ClipControlDepth> map = new HashMap<>();
		for(ClipControlDepth val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClipControlDepth> MAP = Collections.unmodifiableMap(getMap());
	public static ClipControlDepth get(int raw) { return MAP.get(raw); }
}