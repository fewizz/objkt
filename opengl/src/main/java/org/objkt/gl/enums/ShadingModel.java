package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum ShadingModel {
	FLAT(GLConstants.GL_FLAT),
	SMOOTH(GLConstants.GL_SMOOTH);

	ShadingModel(int token) {
		this.token = token;
	}

	public final int token;

	public static final ShadingModel[] VALUES = values();
	private static Map<Integer, ShadingModel> getMap() {
		Map<Integer, ShadingModel> map = new HashMap<>();
		for(ShadingModel val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ShadingModel> MAP = Collections.unmodifiableMap(getMap());
	public static ShadingModel get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(ShadingModel... enums) { int i = 0; for(ShadingModel e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(ShadingModel... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}