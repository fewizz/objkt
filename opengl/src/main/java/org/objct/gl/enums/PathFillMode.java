package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PathFillMode {
	INVERT(GLConstants.GL_INVERT);

	PathFillMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final PathFillMode[] VALUES = values();
	private static Map<Integer, PathFillMode> getMap() {
		Map<Integer, PathFillMode> map = new HashMap<>();
		for(PathFillMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PathFillMode> MAP = Collections.unmodifiableMap(getMap());
	public static PathFillMode get(int raw) { return MAP.get(raw); }

}