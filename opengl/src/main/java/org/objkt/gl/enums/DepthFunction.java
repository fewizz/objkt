package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum DepthFunction {
	ALWAYS(GLConstants.GL_ALWAYS),
	EQUAL(GLConstants.GL_EQUAL),
	GEQUAL(GLConstants.GL_GEQUAL),
	GREATER(GLConstants.GL_GREATER),
	LEQUAL(GLConstants.GL_LEQUAL),
	LESS(GLConstants.GL_LESS),
	NEVER(GLConstants.GL_NEVER),
	NOTEQUAL(GLConstants.GL_NOTEQUAL);

	DepthFunction(int token) {
		this.token = token;
	}

	public final int token;

	public static final DepthFunction[] VALUES = values();
	private static Map<Integer, DepthFunction> getMap() {
		Map<Integer, DepthFunction> map = new HashMap<>();
		for(DepthFunction val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, DepthFunction> MAP = Collections.unmodifiableMap(getMap());
	public static DepthFunction get(int raw) { return MAP.get(raw); }

}