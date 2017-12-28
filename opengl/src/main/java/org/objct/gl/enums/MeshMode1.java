package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum MeshMode1 {
	LINE(GLConstants.GL_LINE),
	POINT(GLConstants.GL_POINT);

	MeshMode1(int token) {
		this.token = token;
	}

	public final int token;

	public static final MeshMode1[] VALUES = values();
	private static Map<Integer, MeshMode1> getMap() {
		Map<Integer, MeshMode1> map = new HashMap<>();
		for(MeshMode1 val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, MeshMode1> MAP = Collections.unmodifiableMap(getMap());
	public static MeshMode1 get(int raw) { return MAP.get(raw); }

}