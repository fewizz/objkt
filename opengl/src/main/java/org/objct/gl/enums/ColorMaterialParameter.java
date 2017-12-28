package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ColorMaterialParameter {
	AMBIENT(GLConstants.GL_AMBIENT),
	AMBIENT_AND_DIFFUSE(GLConstants.GL_AMBIENT_AND_DIFFUSE),
	DIFFUSE(GLConstants.GL_DIFFUSE),
	EMISSION(GLConstants.GL_EMISSION),
	SPECULAR(GLConstants.GL_SPECULAR);

	ColorMaterialParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final ColorMaterialParameter[] VALUES = values();
	private static Map<Integer, ColorMaterialParameter> getMap() {
		Map<Integer, ColorMaterialParameter> map = new HashMap<>();
		for(ColorMaterialParameter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ColorMaterialParameter> MAP = Collections.unmodifiableMap(getMap());
	public static ColorMaterialParameter get(int raw) { return MAP.get(raw); }

}