package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum VertexPointerType {
	DOUBLE(GLConstants.GL_DOUBLE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT);

	VertexPointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexPointerType[] VALUES = values();
	private static Map<Integer, VertexPointerType> getMap() {
		Map<Integer, VertexPointerType> map = new HashMap<>();
		for(VertexPointerType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, VertexPointerType> MAP = Collections.unmodifiableMap(getMap());
	public static VertexPointerType get(int raw) { return MAP.get(raw); }
}