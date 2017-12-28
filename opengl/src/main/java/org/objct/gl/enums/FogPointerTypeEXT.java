package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum FogPointerTypeEXT {
	FLOAT(GLConstants.GL_FLOAT),
	DOUBLE(GLConstants.GL_DOUBLE);

	FogPointerTypeEXT(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogPointerTypeEXT[] VALUES = values();
	private static Map<Integer, FogPointerTypeEXT> getMap() {
		Map<Integer, FogPointerTypeEXT> map = new HashMap<>();
		for(FogPointerTypeEXT val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, FogPointerTypeEXT> MAP = Collections.unmodifiableMap(getMap());
	public static FogPointerTypeEXT get(int raw) { return MAP.get(raw); }

}