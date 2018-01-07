package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum StencilFunction {
	ALWAYS(GLConstants.GL_ALWAYS),
	EQUAL(GLConstants.GL_EQUAL),
	GEQUAL(GLConstants.GL_GEQUAL),
	GREATER(GLConstants.GL_GREATER),
	LEQUAL(GLConstants.GL_LEQUAL),
	LESS(GLConstants.GL_LESS),
	NEVER(GLConstants.GL_NEVER),
	NOTEQUAL(GLConstants.GL_NOTEQUAL);

	StencilFunction(int token) {
		this.token = token;
	}

	public final int token;

	public static final StencilFunction[] VALUES = values();
	private static Map<Integer, StencilFunction> getMap() {
		Map<Integer, StencilFunction> map = new HashMap<>();
		for(StencilFunction val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, StencilFunction> MAP = Collections.unmodifiableMap(getMap());
	public static StencilFunction get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(StencilFunction... enums) { int i = 0; for(StencilFunction e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(StencilFunction... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}