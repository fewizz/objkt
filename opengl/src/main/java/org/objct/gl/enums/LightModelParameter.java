package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum LightModelParameter {
	LIGHT_MODEL_AMBIENT(GLConstants.GL_LIGHT_MODEL_AMBIENT),
	LIGHT_MODEL_TWO_SIDE(GLConstants.GL_LIGHT_MODEL_TWO_SIDE);

	LightModelParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final LightModelParameter[] VALUES = values();
	private static Map<Integer, LightModelParameter> getMap() {
		Map<Integer, LightModelParameter> map = new HashMap<>();
		for(LightModelParameter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, LightModelParameter> MAP = Collections.unmodifiableMap(getMap());
	public static LightModelParameter get(int raw) { return MAP.get(raw); }

}