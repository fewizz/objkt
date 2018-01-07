package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum DrawElementsType {
	UNSIGNED_BYTE(GLConstants.GL_UNSIGNED_BYTE),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT);

	DrawElementsType(int token) {
		this.token = token;
	}

	public final int token;

	public static final DrawElementsType[] VALUES = values();
	private static Map<Integer, DrawElementsType> getMap() {
		Map<Integer, DrawElementsType> map = new HashMap<>();
		for(DrawElementsType val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, DrawElementsType> MAP = Collections.unmodifiableMap(getMap());
	public static DrawElementsType get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(DrawElementsType... enums) { int i = 0; for(DrawElementsType e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(DrawElementsType... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}