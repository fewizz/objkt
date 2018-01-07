package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum HintMode {
	DONT_CARE(GLConstants.GL_DONT_CARE),
	FASTEST(GLConstants.GL_FASTEST),
	NICEST(GLConstants.GL_NICEST);

	HintMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final HintMode[] VALUES = values();
	private static Map<Integer, HintMode> getMap() {
		Map<Integer, HintMode> map = new HashMap<>();
		for(HintMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, HintMode> MAP = Collections.unmodifiableMap(getMap());
	public static HintMode get(int raw) { return MAP.get(raw); }
}