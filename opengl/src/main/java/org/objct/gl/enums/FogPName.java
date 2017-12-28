package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum FogPName {
	FOG_MODE(GLConstants.GL_FOG_MODE),
	FOG_DENSITY(GLConstants.GL_FOG_DENSITY),
	FOG_START(GLConstants.GL_FOG_START),
	FOG_END(GLConstants.GL_FOG_END);

	FogPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogPName[] VALUES = values();
	private static Map<Integer, FogPName> getMap() {
		Map<Integer, FogPName> map = new HashMap<>();
		for(FogPName val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, FogPName> MAP = Collections.unmodifiableMap(getMap());
	public static FogPName get(int raw) { return MAP.get(raw); }

}