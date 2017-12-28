package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum LogicOp {
	AND(GLConstants.GL_AND),
	AND_INVERTED(GLConstants.GL_AND_INVERTED),
	AND_REVERSE(GLConstants.GL_AND_REVERSE),
	CLEAR(GLConstants.GL_CLEAR),
	COPY(GLConstants.GL_COPY),
	COPY_INVERTED(GLConstants.GL_COPY_INVERTED),
	EQUIV(GLConstants.GL_EQUIV),
	INVERT(GLConstants.GL_INVERT),
	NAND(GLConstants.GL_NAND),
	NOOP(GLConstants.GL_NOOP),
	NOR(GLConstants.GL_NOR),
	OR(GLConstants.GL_OR),
	OR_INVERTED(GLConstants.GL_OR_INVERTED),
	OR_REVERSE(GLConstants.GL_OR_REVERSE),
	SET(GLConstants.GL_SET),
	XOR(GLConstants.GL_XOR);

	LogicOp(int token) {
		this.token = token;
	}

	public final int token;

	public static final LogicOp[] VALUES = values();
	private static Map<Integer, LogicOp> getMap() {
		Map<Integer, LogicOp> map = new HashMap<>();
		for(LogicOp val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, LogicOp> MAP = Collections.unmodifiableMap(getMap());
	public static LogicOp get(int raw) { return MAP.get(raw); }

}