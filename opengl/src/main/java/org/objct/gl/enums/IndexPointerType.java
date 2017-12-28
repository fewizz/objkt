package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum IndexPointerType {
	DOUBLE(GLConstants.GL_DOUBLE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT);

	IndexPointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final IndexPointerType[] VALUES = values();
	private static Map<Integer, IndexPointerType> getMap() {
		Map<Integer, IndexPointerType> map = new HashMap<>();
		for(IndexPointerType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, IndexPointerType> MAP = Collections.unmodifiableMap(getMap());
	public static IndexPointerType get(int raw) { return MAP.get(raw); }

}