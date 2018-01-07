package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum SyncStatus {
	ALREADY_SIGNALED(GLConstants.GL_ALREADY_SIGNALED),
	TIMEOUT_EXPIRED(GLConstants.GL_TIMEOUT_EXPIRED),
	CONDITION_SATISFIED(GLConstants.GL_CONDITION_SATISFIED),
	WAIT_FAILED(GLConstants.GL_WAIT_FAILED);

	SyncStatus(int token) {
		this.token = token;
	}

	public final int token;

	public static final SyncStatus[] VALUES = values();
	private static Map<Integer, SyncStatus> getMap() {
		Map<Integer, SyncStatus> map = new HashMap<>();
		for(SyncStatus val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, SyncStatus> MAP = Collections.unmodifiableMap(getMap());
	public static SyncStatus get(int raw) { return MAP.get(raw); }
}