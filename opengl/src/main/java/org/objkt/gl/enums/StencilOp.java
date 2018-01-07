package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum StencilOp {
	DECR(GLConstants.GL_DECR),
	INCR(GLConstants.GL_INCR),
	INVERT(GLConstants.GL_INVERT),
	KEEP(GLConstants.GL_KEEP),
	REPLACE(GLConstants.GL_REPLACE),
	ZERO(GLConstants.GL_ZERO);

	StencilOp(int token) {
		this.token = token;
	}

	public final int token;

	public static final StencilOp[] VALUES = values();
	private static Map<Integer, StencilOp> getMap() {
		Map<Integer, StencilOp> map = new HashMap<>();
		for(StencilOp val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, StencilOp> MAP = Collections.unmodifiableMap(getMap());
	public static StencilOp get(int raw) { return MAP.get(raw); }
}