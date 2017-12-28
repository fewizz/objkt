package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum MeshMode2 {
	FILL(GLConstants.GL_FILL),
	LINE(GLConstants.GL_LINE),
	POINT(GLConstants.GL_POINT);

	MeshMode2(int token) {
		this.token = token;
	}

	public final int token;

	public static final MeshMode2[] VALUES = values();
	private static Map<Integer, MeshMode2> getMap() {
		Map<Integer, MeshMode2> map = new HashMap<>();
		for(MeshMode2 val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, MeshMode2> MAP = Collections.unmodifiableMap(getMap());
	public static MeshMode2 get(int raw) { return MAP.get(raw); }

}