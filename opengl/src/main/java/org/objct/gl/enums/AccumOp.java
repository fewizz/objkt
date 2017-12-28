package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum AccumOp {
	ADD(GLConstants.GL_ADD);

	AccumOp(int token) {
		this.token = token;
	}

	public final int token;

	public static final AccumOp[] VALUES = values();
	private static Map<Integer, AccumOp> getMap() {
		Map<Integer, AccumOp> map = new HashMap<>();
		for(AccumOp val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, AccumOp> MAP = Collections.unmodifiableMap(getMap());
	public static AccumOp get(int raw) { return MAP.get(raw); }

}