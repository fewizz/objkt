package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ColorMaterialFace {
	BACK(GLConstants.GL_BACK),
	FRONT(GLConstants.GL_FRONT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK);

	ColorMaterialFace(int token) {
		this.token = token;
	}

	public final int token;

	public static final ColorMaterialFace[] VALUES = values();
	private static Map<Integer, ColorMaterialFace> getMap() {
		Map<Integer, ColorMaterialFace> map = new HashMap<>();
		for(ColorMaterialFace val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ColorMaterialFace> MAP = Collections.unmodifiableMap(getMap());
	public static ColorMaterialFace get(int raw) { return MAP.get(raw); }

}