package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum SyncObject {
	SYNC_FLUSH_COMMANDS_BIT(GLConstants.GL_SYNC_FLUSH_COMMANDS_BIT);

	SyncObject(int token) {
		this.token = token;
	}

	public final int token;

	public static final SyncObject[] VALUES = values();
	private static Map<Integer, SyncObject> getMap() {
		Map<Integer, SyncObject> map = new HashMap<>();
		for(SyncObject val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, SyncObject> MAP = Collections.unmodifiableMap(getMap());
	public static SyncObject get(int raw) { return MAP.get(raw); }

	// Mask
	public static int intMaskOf(SyncObject... enums) { int i = 0; for(SyncObject e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(SyncObject... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}