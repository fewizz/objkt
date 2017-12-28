package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum PolygonMode {
	FILL(GLConstants.GL_FILL),
	LINE(GLConstants.GL_LINE),
	POINT(GLConstants.GL_POINT);

	PolygonMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final PolygonMode[] VALUES = values();
	private static Map<Integer, PolygonMode> getMap() {
		Map<Integer, PolygonMode> map = new HashMap<>();
		for(PolygonMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PolygonMode> MAP = Collections.unmodifiableMap(getMap());
	public static PolygonMode get(int raw) { return MAP.get(raw); }

}