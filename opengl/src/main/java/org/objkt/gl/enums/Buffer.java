package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum Buffer {
	COLOR(GLConstants.GL_COLOR),
	DEPTH(GLConstants.GL_DEPTH),
	STENCIL(GLConstants.GL_STENCIL);

	Buffer(int token) {
		this.token = token;
	}

	public final int token;

	public static final Buffer[] VALUES = values();
	private static Map<Integer, Buffer> getMap() {
		Map<Integer, Buffer> map = new HashMap<>();
		for(Buffer val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, Buffer> MAP = Collections.unmodifiableMap(getMap());
	public static Buffer get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(Buffer... enums) { int i = 0; for(Buffer e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(Buffer... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}