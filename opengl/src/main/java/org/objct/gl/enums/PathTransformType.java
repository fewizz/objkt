package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PathTransformType {
	NONE(GLConstants.GL_NONE);

	PathTransformType(int token) {
		this.token = token;
	}

	public final int token;

	public static final PathTransformType[] VALUES = values();
	private static Map<Integer, PathTransformType> getMap() {
		Map<Integer, PathTransformType> map = new HashMap<>();
		for(PathTransformType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PathTransformType> MAP = Collections.unmodifiableMap(getMap());
	public static PathTransformType get(int raw) { return MAP.get(raw); }

}