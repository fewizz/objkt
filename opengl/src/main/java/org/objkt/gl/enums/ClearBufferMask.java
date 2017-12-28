package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum ClearBufferMask {
	COLOR_BUFFER_BIT(GLConstants.GL_COLOR_BUFFER_BIT),
	DEPTH_BUFFER_BIT(GLConstants.GL_DEPTH_BUFFER_BIT),
	STENCIL_BUFFER_BIT(GLConstants.GL_STENCIL_BUFFER_BIT);

	ClearBufferMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClearBufferMask[] VALUES = values();
	private static Map<Integer, ClearBufferMask> getMap() {
		Map<Integer, ClearBufferMask> map = new HashMap<>();
		for(ClearBufferMask val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClearBufferMask> MAP = Collections.unmodifiableMap(getMap());
	public static ClearBufferMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(ClearBufferMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(ClearBufferMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }
	}
}