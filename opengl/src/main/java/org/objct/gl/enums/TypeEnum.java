package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum TypeEnum {
	QUERY_WAIT(GLConstants.GL_QUERY_WAIT),
	QUERY_NO_WAIT(GLConstants.GL_QUERY_NO_WAIT),
	QUERY_BY_REGION_WAIT(GLConstants.GL_QUERY_BY_REGION_WAIT),
	QUERY_BY_REGION_NO_WAIT(GLConstants.GL_QUERY_BY_REGION_NO_WAIT);

	TypeEnum(int token) {
		this.token = token;
	}

	public final int token;

	public static final TypeEnum[] VALUES = values();
	private static Map<Integer, TypeEnum> getMap() {
		Map<Integer, TypeEnum> map = new HashMap<>();
		for(TypeEnum val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, TypeEnum> MAP = Collections.unmodifiableMap(getMap());
	public static TypeEnum get(int raw) { return MAP.get(raw); }

}