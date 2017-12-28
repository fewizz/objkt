package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum TexCoordPointerType {
	DOUBLE(GLConstants.GL_DOUBLE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT);

	TexCoordPointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final TexCoordPointerType[] VALUES = values();
	private static Map<Integer, TexCoordPointerType> getMap() {
		Map<Integer, TexCoordPointerType> map = new HashMap<>();
		for(TexCoordPointerType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, TexCoordPointerType> MAP = Collections.unmodifiableMap(getMap());
	public static TexCoordPointerType get(int raw) { return MAP.get(raw); }

}