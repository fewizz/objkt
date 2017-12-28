package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PathColor {
	PRIMARY_COLOR(GLConstants.GL_PRIMARY_COLOR);

	PathColor(int token) {
		this.token = token;
	}

	public final int token;

	public static final PathColor[] VALUES = values();
	private static Map<Integer, PathColor> getMap() {
		Map<Integer, PathColor> map = new HashMap<>();
		for(PathColor val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PathColor> MAP = Collections.unmodifiableMap(getMap());
	public static PathColor get(int raw) { return MAP.get(raw); }

}