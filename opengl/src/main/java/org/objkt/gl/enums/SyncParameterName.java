package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum SyncParameterName {
	OBJECT_TYPE(GLConstants.GL_OBJECT_TYPE),
	SYNC_STATUS(GLConstants.GL_SYNC_STATUS),
	SYNC_CONDITION(GLConstants.GL_SYNC_CONDITION),
	SYNC_FLAGS(GLConstants.GL_SYNC_FLAGS);

	SyncParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final SyncParameterName[] VALUES = values();
	private static Map<Integer, SyncParameterName> getMap() {
		Map<Integer, SyncParameterName> map = new HashMap<>();
		for(SyncParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, SyncParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static SyncParameterName get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(SyncParameterName... enums) { int i = 0; for(SyncParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(SyncParameterName... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}