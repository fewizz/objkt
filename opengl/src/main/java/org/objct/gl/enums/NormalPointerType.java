package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum NormalPointerType {
	BYTE(GLConstants.GL_BYTE),
	DOUBLE(GLConstants.GL_DOUBLE),
	FLOAT(GLConstants.GL_FLOAT),
	INT(GLConstants.GL_INT),
	SHORT(GLConstants.GL_SHORT);

	NormalPointerType(int token) {
		this.token = token;
	}

	public final int token;

	public static final NormalPointerType[] VALUES = values();
	private static Map<Integer, NormalPointerType> getMap() {
		Map<Integer, NormalPointerType> map = new HashMap<>();
		for(NormalPointerType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, NormalPointerType> MAP = Collections.unmodifiableMap(getMap());
	public static NormalPointerType get(int raw) { return MAP.get(raw); }

}