package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ListNameType {
	BYTE(GLConstants.GL_BYTE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT),
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT);

	ListNameType(int token) {
		this.token = token;
	}

	public final int token;

	public static final ListNameType[] VALUES = values();
	private static Map<Integer, ListNameType> getMap() {
		Map<Integer, ListNameType> map = new HashMap<>();
		for(ListNameType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ListNameType> MAP = Collections.unmodifiableMap(getMap());
	public static ListNameType get(int raw) { return MAP.get(raw); }

}