package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum TextureWrapMode {
	CLAMP_TO_BORDER(GLConstants.GL_CLAMP_TO_BORDER),
	CLAMP_TO_EDGE(GLConstants.GL_CLAMP_TO_EDGE),
	REPEAT(GLConstants.GL_REPEAT);

	TextureWrapMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureWrapMode[] VALUES = values();
	private static Map<Integer, TextureWrapMode> getMap() {
		Map<Integer, TextureWrapMode> map = new HashMap<>();
		for(TextureWrapMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureWrapMode> MAP = Collections.unmodifiableMap(getMap());
	public static TextureWrapMode get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(TextureWrapMode... enums) { int i = 0; for(TextureWrapMode e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(TextureWrapMode... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}