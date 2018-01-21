package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum ClearBuffer {
	COLOR_BUFFER_BIT(GLConstants.GL_COLOR_BUFFER_BIT),
	DEPTH_BUFFER_BIT(GLConstants.GL_DEPTH_BUFFER_BIT),
	STENCIL_BUFFER_BIT(GLConstants.GL_STENCIL_BUFFER_BIT);

	ClearBuffer(int token) {
		this.token = token;
	}

	public final int token;

	public static final ClearBuffer[] VALUES = values();
	private static Map<Integer, ClearBuffer> getMap() {
		Map<Integer, ClearBuffer> map = new HashMap<>();
		for(ClearBuffer val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ClearBuffer> MAP = Collections.unmodifiableMap(getMap());
	public static ClearBuffer get(int raw) { return MAP.get(raw); }

	// Mask
	public static int intMaskOf(ClearBuffer... enums) { int i = 0; for(ClearBuffer e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(new java.util.function.Supplier<Mask>() {public Mask get() {return new Mask();}});
		int value;

		public static Mask of(ClearBuffer... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}