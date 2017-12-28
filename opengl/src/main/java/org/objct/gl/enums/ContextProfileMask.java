package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ContextProfileMask {
	CONTEXT_COMPATIBILITY_PROFILE_BIT(GLConstants.GL_CONTEXT_COMPATIBILITY_PROFILE_BIT),
	CONTEXT_CORE_PROFILE_BIT(GLConstants.GL_CONTEXT_CORE_PROFILE_BIT);

	ContextProfileMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final ContextProfileMask[] VALUES = values();
	private static Map<Integer, ContextProfileMask> getMap() {
		Map<Integer, ContextProfileMask> map = new HashMap<>();
		for(ContextProfileMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ContextProfileMask> MAP = Collections.unmodifiableMap(getMap());
	public static ContextProfileMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(ContextProfileMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(ContextProfileMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }	}
}