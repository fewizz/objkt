package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum FogCoordinatePointerType {
	FLOAT(GLConstants.GL_FLOAT),
	DOUBLE(GLConstants.GL_DOUBLE);

	FogCoordinatePointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogCoordinatePointerType[] VALUES = values();
	private static Map<Integer, FogCoordinatePointerType> getMap() {
		Map<Integer, FogCoordinatePointerType> map = new HashMap<>();
		for(FogCoordinatePointerType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, FogCoordinatePointerType> MAP = Collections.unmodifiableMap(getMap());
	public static FogCoordinatePointerType get(int raw) { return MAP.get(raw); }

}