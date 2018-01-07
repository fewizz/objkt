package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum FogPName {
	FOG_MODE(GLConstants.GL_FOG_MODE),
	FOG_DENSITY(GLConstants.GL_FOG_DENSITY),
	FOG_START(GLConstants.GL_FOG_START),
	FOG_END(GLConstants.GL_FOG_END);

	FogPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final FogPName[] VALUES = values();
	private static Map<Integer, FogPName> getMap() {
		Map<Integer, FogPName> map = new HashMap<>();
		for(FogPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FogPName> MAP = Collections.unmodifiableMap(getMap());
	public static FogPName get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(FogPName... enums) { int i = 0; for(FogPName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(FogPName... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}