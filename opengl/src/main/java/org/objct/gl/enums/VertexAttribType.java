package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum VertexAttribType {
	BYTE(GLConstants.GL_BYTE, true, Byte.BYTES),
	SHORT(GLConstants.GL_SHORT, true, Short.BYTES),
	INT(GLConstants.GL_INT, true, Integer.BYTES),
	FIXED(GLConstants.GL_FIXED, true, Integer.BYTES),
	FLOAT(GLConstants.GL_FLOAT, false, Float.BYTES),
	HALF_FLOAT(GLConstants.GL_HALF_FLOAT, false, Float.BYTES / 2),
	DOUBLE(GLConstants.GL_DOUBLE, false, Double.BYTES),
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE, true, Byte.BYTES),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT, true, Short.BYTES),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT, true, Integer.BYTES),
	INT_2_10_10_10_REV(GLConstants.GL_INT_2_10_10_10_REV, true, Integer.BYTES),
	UNSIGNED_INT_2_10_10_10_REV(GLConstants.GL_UNSIGNED_INT_2_10_10_10_REV, true, Integer.BYTES),
	UNSIGNED_INT_10F_11F_11F_REV(GLConstants.GL_UNSIGNED_INT_10F_11F_11F_REV, true, Integer.BYTES);

	VertexAttribType(int token, boolean isIntegral, int bytes) {
		this.token = token;
		this.isIntegral = isIntegral;
		this.bytes = bytes;
	}

	public final int token;
	public final boolean isIntegral;
	public final int bytes;

	public static final VertexAttribType[] VALUES = values();
	private static Map<Integer, VertexAttribType> getMap() {
		Map<Integer, VertexAttribType> map = new HashMap<>();
		for(VertexAttribType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, VertexAttribType> MAP = Collections.unmodifiableMap(getMap());
	public static VertexAttribType get(int raw) { return MAP.get(raw); }

}