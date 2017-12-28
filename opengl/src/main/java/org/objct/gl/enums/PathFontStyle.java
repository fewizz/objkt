package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PathFontStyle {
	NONE(GLConstants.GL_NONE);

	PathFontStyle(int token) {
		this.token = token;
	}

	public final int token;

	public static final PathFontStyle[] VALUES = values();
	private static Map<Integer, PathFontStyle> getMap() {
		Map<Integer, PathFontStyle> map = new HashMap<>();
		for(PathFontStyle val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PathFontStyle> MAP = Collections.unmodifiableMap(getMap());
	public static PathFontStyle get(int raw) { return MAP.get(raw); }

}