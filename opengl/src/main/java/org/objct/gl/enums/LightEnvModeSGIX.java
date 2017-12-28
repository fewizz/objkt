package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum LightEnvModeSGIX {
	ADD(GLConstants.GL_ADD),
	MODULATE(GLConstants.GL_MODULATE),
	REPLACE(GLConstants.GL_REPLACE);

	LightEnvModeSGIX(int token) {
		this.token = token;
	}

	public final int token;

	public static final LightEnvModeSGIX[] VALUES = values();
	private static Map<Integer, LightEnvModeSGIX> getMap() {
		Map<Integer, LightEnvModeSGIX> map = new HashMap<>();
		for(LightEnvModeSGIX val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, LightEnvModeSGIX> MAP = Collections.unmodifiableMap(getMap());
	public static LightEnvModeSGIX get(int raw) { return MAP.get(raw); }

}