package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum VertexBufferObjectUsage {
	STREAM_DRAW(GLConstants.GL_STREAM_DRAW),
	STREAM_READ(GLConstants.GL_STREAM_READ),
	STREAM_COPY(GLConstants.GL_STREAM_COPY),
	STATIC_DRAW(GLConstants.GL_STATIC_DRAW),
	STATIC_READ(GLConstants.GL_STATIC_READ),
	STATIC_COPY(GLConstants.GL_STATIC_COPY),
	DYNAMIC_DRAW(GLConstants.GL_DYNAMIC_DRAW),
	DYNAMIC_READ(GLConstants.GL_DYNAMIC_READ),
	DYNAMIC_COPY(GLConstants.GL_DYNAMIC_COPY);

	VertexBufferObjectUsage(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexBufferObjectUsage[] VALUES = values();
	private static Map<Integer, VertexBufferObjectUsage> getMap() {
		Map<Integer, VertexBufferObjectUsage> map = new HashMap<>();
		for(VertexBufferObjectUsage val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, VertexBufferObjectUsage> MAP = Collections.unmodifiableMap(getMap());
	public static VertexBufferObjectUsage get(int raw) { return MAP.get(raw); }

}