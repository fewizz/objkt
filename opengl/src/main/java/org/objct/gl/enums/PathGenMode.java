package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PathGenMode {
	NONE(GLConstants.GL_NONE),
	CONSTANT(GLConstants.GL_CONSTANT);

	PathGenMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final PathGenMode[] VALUES = values();
	private static Map<Integer, PathGenMode> getMap() {
		Map<Integer, PathGenMode> map = new HashMap<>();
		for(PathGenMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PathGenMode> MAP = Collections.unmodifiableMap(getMap());
	public static PathGenMode get(int raw) { return MAP.get(raw); }

}