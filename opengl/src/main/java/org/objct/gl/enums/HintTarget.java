package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum HintTarget {
	FOG_HINT(GLConstants.GL_FOG_HINT),
	FRAGMENT_SHADER_DERIVATIVE_HINT(GLConstants.GL_FRAGMENT_SHADER_DERIVATIVE_HINT),
	GENERATE_MIPMAP_HINT(GLConstants.GL_GENERATE_MIPMAP_HINT),
	LINE_SMOOTH_HINT(GLConstants.GL_LINE_SMOOTH_HINT),
	PERSPECTIVE_CORRECTION_HINT(GLConstants.GL_PERSPECTIVE_CORRECTION_HINT),
	POINT_SMOOTH_HINT(GLConstants.GL_POINT_SMOOTH_HINT),
	POLYGON_SMOOTH_HINT(GLConstants.GL_POLYGON_SMOOTH_HINT),
	PROGRAM_BINARY_RETRIEVABLE_HINT(GLConstants.GL_PROGRAM_BINARY_RETRIEVABLE_HINT),
	TEXTURE_COMPRESSION_HINT(GLConstants.GL_TEXTURE_COMPRESSION_HINT);

	HintTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final HintTarget[] VALUES = values();
	private static Map<Integer, HintTarget> getMap() {
		Map<Integer, HintTarget> map = new HashMap<>();
		for(HintTarget val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, HintTarget> MAP = Collections.unmodifiableMap(getMap());
	public static HintTarget get(int raw) { return MAP.get(raw); }

}