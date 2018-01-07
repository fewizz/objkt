package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum GraphicsResetStatus {
	NO_ERROR(GLConstants.GL_NO_ERROR),
	GUILTY_CONTEXT_RESET(GLConstants.GL_GUILTY_CONTEXT_RESET),
	INNOCENT_CONTEXT_RESET(GLConstants.GL_INNOCENT_CONTEXT_RESET),
	UNKNOWN_CONTEXT_RESET(GLConstants.GL_UNKNOWN_CONTEXT_RESET);

	GraphicsResetStatus(int token) {
		this.token = token;
	}

	public final int token;

	public static final GraphicsResetStatus[] VALUES = values();
	private static Map<Integer, GraphicsResetStatus> getMap() {
		Map<Integer, GraphicsResetStatus> map = new HashMap<>();
		for(GraphicsResetStatus val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, GraphicsResetStatus> MAP = Collections.unmodifiableMap(getMap());
	public static GraphicsResetStatus get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(GraphicsResetStatus... enums) { int i = 0; for(GraphicsResetStatus e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(GraphicsResetStatus... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}