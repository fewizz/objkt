package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum MatrixMode {
	MODELVIEW(GLConstants.GL_MODELVIEW),
	PROJECTION(GLConstants.GL_PROJECTION),
	TEXTURE(GLConstants.GL_TEXTURE);

	MatrixMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final MatrixMode[] VALUES = values();
	private static Map<Integer, MatrixMode> getMap() {
		Map<Integer, MatrixMode> map = new HashMap<>();
		for(MatrixMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, MatrixMode> MAP = Collections.unmodifiableMap(getMap());
	public static MatrixMode get(int raw) { return MAP.get(raw); }

}