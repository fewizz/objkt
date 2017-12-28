package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum FogPointerTypeIBM {
	FLOAT(GLConstants.GL_FLOAT),
	DOUBLE(GLConstants.GL_DOUBLE);

	FogPointerTypeIBM(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogPointerTypeIBM[] VALUES = values();
	private static Map<Integer, FogPointerTypeIBM> getMap() {
		Map<Integer, FogPointerTypeIBM> map = new HashMap<>();
		for(FogPointerTypeIBM val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, FogPointerTypeIBM> MAP = Collections.unmodifiableMap(getMap());
	public static FogPointerTypeIBM get(int raw) { return MAP.get(raw); }

}