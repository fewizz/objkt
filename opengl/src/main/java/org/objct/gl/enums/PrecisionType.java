package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PrecisionType {
	LOW_FLOAT(GLConstants.GL_LOW_FLOAT),
	MEDIUM_FLOAT(GLConstants.GL_MEDIUM_FLOAT),
	HIGH_FLOAT(GLConstants.GL_HIGH_FLOAT),
	LOW_INT(GLConstants.GL_LOW_INT),
	MEDIUM_INT(GLConstants.GL_MEDIUM_INT),
	HIGH_INT(GLConstants.GL_HIGH_INT);

	PrecisionType(int token) {
		this.token = token;
	}

	public final int token;

	public static final PrecisionType[] VALUES = values();
	private static Map<Integer, PrecisionType> getMap() {
		Map<Integer, PrecisionType> map = new HashMap<>();
		for(PrecisionType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PrecisionType> MAP = Collections.unmodifiableMap(getMap());
	public static PrecisionType get(int raw) { return MAP.get(raw); }

}