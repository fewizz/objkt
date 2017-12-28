package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum VertexBufferObjectParameter {
	BUFFER_ACCESS(GLConstants.GL_BUFFER_ACCESS),
	BUFFER_ACCESS_FLAGS(GLConstants.GL_BUFFER_ACCESS_FLAGS),
	BUFFER_IMMUTABLE_STORAGE(GLConstants.GL_BUFFER_IMMUTABLE_STORAGE),
	BUFFER_MAPPED(GLConstants.GL_BUFFER_MAPPED),
	BUFFER_MAP_LENGTH(GLConstants.GL_BUFFER_MAP_LENGTH),
	BUFFER_MAP_OFFSET(GLConstants.GL_BUFFER_MAP_OFFSET),
	BUFFER_SIZE(GLConstants.GL_BUFFER_SIZE),
	BUFFER_STORAGE_FLAGS(GLConstants.GL_BUFFER_STORAGE_FLAGS),
	BUFFER_USAGE(GLConstants.GL_BUFFER_USAGE);

	VertexBufferObjectParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexBufferObjectParameter[] VALUES = values();
	private static Map<Integer, VertexBufferObjectParameter> getMap() {
		Map<Integer, VertexBufferObjectParameter> map = new HashMap<>();
		for(VertexBufferObjectParameter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, VertexBufferObjectParameter> MAP = Collections.unmodifiableMap(getMap());
	public static VertexBufferObjectParameter get(int raw) { return MAP.get(raw); }

}