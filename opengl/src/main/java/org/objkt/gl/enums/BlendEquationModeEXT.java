package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BlendEquationModeEXT {
	FUNC_ADD(GLConstants.GL_FUNC_ADD),
	FUNC_REVERSE_SUBTRACT(GLConstants.GL_FUNC_REVERSE_SUBTRACT),
	FUNC_SUBTRACT(GLConstants.GL_FUNC_SUBTRACT);

	BlendEquationModeEXT(int token) {
		this.token = token;
	}

	public final int token;

	public static final BlendEquationModeEXT[] VALUES = values();
	private static Map<Integer, BlendEquationModeEXT> getMap() {
		Map<Integer, BlendEquationModeEXT> map = new HashMap<>();
		for(BlendEquationModeEXT val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BlendEquationModeEXT> MAP = Collections.unmodifiableMap(getMap());
	public static BlendEquationModeEXT get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(BlendEquationModeEXT... enums) { int i = 0; for(BlendEquationModeEXT e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(BlendEquationModeEXT... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}