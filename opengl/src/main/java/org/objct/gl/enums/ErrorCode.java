package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ErrorCode {
	INVALID_ENUM(GLConstants.GL_INVALID_ENUM),
	INVALID_FRAMEBUFFER_OPERATION(GLConstants.GL_INVALID_FRAMEBUFFER_OPERATION),
	INVALID_OPERATION(GLConstants.GL_INVALID_OPERATION),
	INVALID_VALUE(GLConstants.GL_INVALID_VALUE),
	NO_ERROR(GLConstants.GL_NO_ERROR),
	OUT_OF_MEMORY(GLConstants.GL_OUT_OF_MEMORY),
	STACK_OVERFLOW(GLConstants.GL_STACK_OVERFLOW),
	STACK_UNDERFLOW(GLConstants.GL_STACK_UNDERFLOW);

	ErrorCode(int token) {
		this.token = token;
	}

	public final int token;

	public static final ErrorCode[] VALUES = values();
	private static Map<Integer, ErrorCode> getMap() {
		Map<Integer, ErrorCode> map = new HashMap<>();
		for(ErrorCode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ErrorCode> MAP = Collections.unmodifiableMap(getMap());
	public static ErrorCode get(int raw) { return MAP.get(raw); }

}