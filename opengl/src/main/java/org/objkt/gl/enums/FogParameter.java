package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum FogParameter {
	FOG_COLOR(GLConstants.GL_FOG_COLOR),
	FOG_DENSITY(GLConstants.GL_FOG_DENSITY),
	FOG_END(GLConstants.GL_FOG_END),
	FOG_MODE(GLConstants.GL_FOG_MODE),
	FOG_START(GLConstants.GL_FOG_START);

	FogParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogParameter[] VALUES = values();
	private static Map<Integer, FogParameter> getMap() {
		Map<Integer, FogParameter> map = new HashMap<>();
		for(FogParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FogParameter> MAP = Collections.unmodifiableMap(getMap());
	public static FogParameter get(int raw) { return MAP.get(raw); }
}