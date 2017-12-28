package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum SyncCondition {
	SYNC_GPU_COMMANDS_COMPLETE(GLConstants.GL_SYNC_GPU_COMMANDS_COMPLETE);

	SyncCondition(int token) {
		this.token = token;
	}

	public final int token;

	public static final SyncCondition[] VALUES = values();
	private static Map<Integer, SyncCondition> getMap() {
		Map<Integer, SyncCondition> map = new HashMap<>();
		for(SyncCondition val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, SyncCondition> MAP = Collections.unmodifiableMap(getMap());
	public static SyncCondition get(int raw) { return MAP.get(raw); }

}