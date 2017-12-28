package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum SyncObjectMask {
	SYNC_FLUSH_COMMANDS_BIT(GLConstants.GL_SYNC_FLUSH_COMMANDS_BIT),
	SYNC_FLUSH_COMMANDS_BIT_APPLE(GLConstants.GL_SYNC_FLUSH_COMMANDS_BIT_APPLE);

	SyncObjectMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final SyncObjectMask[] VALUES = values();
	private static Map<Integer, SyncObjectMask> getMap() {
		Map<Integer, SyncObjectMask> map = new HashMap<>();
		for(SyncObjectMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, SyncObjectMask> MAP = Collections.unmodifiableMap(getMap());
	public static SyncObjectMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(SyncObjectMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(SyncObjectMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }	}
}