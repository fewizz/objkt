package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum FogMode {
	EXP(GLConstants.GL_EXP),
	EXP2(GLConstants.GL_EXP2),
	LINEAR(GLConstants.GL_LINEAR);

	FogMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogMode[] VALUES = values();
	private static Map<Integer, FogMode> getMap() {
		Map<Integer, FogMode> map = new HashMap<>();
		for(FogMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, FogMode> MAP = Collections.unmodifiableMap(getMap());
	public static FogMode get(int raw) { return MAP.get(raw); }

}