package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ContextFlagMask {
	CONTEXT_FLAG_DEBUG_BIT(GLConstants.GL_CONTEXT_FLAG_DEBUG_BIT),
	CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT(GLConstants.GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT),
	CONTEXT_FLAG_ROBUST_ACCESS_BIT(GLConstants.GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT),
	CONTEXT_FLAG_NO_ERROR_BIT(GLConstants.GL_CONTEXT_FLAG_NO_ERROR_BIT),
	CONTEXT_FLAG_DEBUG_BIT_KHR(GLConstants.GL_CONTEXT_FLAG_DEBUG_BIT_KHR),
	CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB(GLConstants.GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB),
	CONTEXT_FLAG_NO_ERROR_BIT_KHR(GLConstants.GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR),
	CONTEXT_FLAG_PROTECTED_CONTENT_BIT_EXT(GLConstants.GL_CONTEXT_FLAG_PROTECTED_CONTENT_BIT_EXT);

	ContextFlagMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final ContextFlagMask[] VALUES = values();
	private static Map<Integer, ContextFlagMask> getMap() {
		Map<Integer, ContextFlagMask> map = new HashMap<>();
		for(ContextFlagMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ContextFlagMask> MAP = Collections.unmodifiableMap(getMap());
	public static ContextFlagMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(ContextFlagMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(ContextFlagMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }	}
}