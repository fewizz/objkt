package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PrimitiveType {
	LINES(GLConstants.GL_LINES),
	LINES_ADJACENCY(GLConstants.GL_LINES_ADJACENCY),
	LINE_LOOP(GLConstants.GL_LINE_LOOP),
	LINE_STRIP(GLConstants.GL_LINE_STRIP),
	LINE_STRIP_ADJACENCY(GLConstants.GL_LINE_STRIP_ADJACENCY),
	PATCHES(GLConstants.GL_PATCHES),
	POINTS(GLConstants.GL_POINTS),
	QUADS(GLConstants.GL_QUADS),
	TRIANGLES(GLConstants.GL_TRIANGLES),
	TRIANGLES_ADJACENCY(GLConstants.GL_TRIANGLES_ADJACENCY),
	TRIANGLE_FAN(GLConstants.GL_TRIANGLE_FAN),
	TRIANGLE_STRIP(GLConstants.GL_TRIANGLE_STRIP),
	TRIANGLE_STRIP_ADJACENCY(GLConstants.GL_TRIANGLE_STRIP_ADJACENCY);

	PrimitiveType(int token) {
		this.token = token;
	}

	public final int token;

	public static final PrimitiveType[] VALUES = values();
	private static Map<Integer, PrimitiveType> getMap() {
		Map<Integer, PrimitiveType> map = new HashMap<>();
		for(PrimitiveType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PrimitiveType> MAP = Collections.unmodifiableMap(getMap());
	public static PrimitiveType get(int raw) { return MAP.get(raw); }

}