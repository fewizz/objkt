package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum DebugSeverity {
	DEBUG_SEVERITY_LOW(GLConstants.GL_DEBUG_SEVERITY_LOW),
	DEBUG_SEVERITY_MEDIUM(GLConstants.GL_DEBUG_SEVERITY_MEDIUM),
	DEBUG_SEVERITY_HIGH(GLConstants.GL_DEBUG_SEVERITY_HIGH),
	DONT_CARE(GLConstants.GL_DONT_CARE);

	DebugSeverity(int token) {
		this.token = token;
	}

	public final int token;

	public static final DebugSeverity[] VALUES = values();
	private static Map<Integer, DebugSeverity> getMap() {
		Map<Integer, DebugSeverity> map = new HashMap<>();
		for(DebugSeverity val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, DebugSeverity> MAP = Collections.unmodifiableMap(getMap());
	public static DebugSeverity get(int raw) { return MAP.get(raw); }

}