package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BlitFramebufferFilter {
	NEAREST(GLConstants.GL_NEAREST),
	LINEAR(GLConstants.GL_LINEAR);

	BlitFramebufferFilter(int token) {
		this.token = token;
	}

	public final int token;

	public static final BlitFramebufferFilter[] VALUES = values();
	private static Map<Integer, BlitFramebufferFilter> getMap() {
		Map<Integer, BlitFramebufferFilter> map = new HashMap<>();
		for(BlitFramebufferFilter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BlitFramebufferFilter> MAP = Collections.unmodifiableMap(getMap());
	public static BlitFramebufferFilter get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(BlitFramebufferFilter... enums) { int i = 0; for(BlitFramebufferFilter e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(BlitFramebufferFilter... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}