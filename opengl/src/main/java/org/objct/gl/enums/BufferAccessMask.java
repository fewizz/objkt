package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum BufferAccessMask {
	MAP_COHERENT_BIT(GLConstants.GL_MAP_COHERENT_BIT),
	MAP_FLUSH_EXPLICIT_BIT(GLConstants.GL_MAP_FLUSH_EXPLICIT_BIT),
	MAP_INVALIDATE_BUFFER_BIT(GLConstants.GL_MAP_INVALIDATE_BUFFER_BIT),
	MAP_INVALIDATE_RANGE_BIT(GLConstants.GL_MAP_INVALIDATE_RANGE_BIT),
	MAP_PERSISTENT_BIT(GLConstants.GL_MAP_PERSISTENT_BIT),
	MAP_READ_BIT(GLConstants.GL_MAP_READ_BIT),
	MAP_UNSYNCHRONIZED_BIT(GLConstants.GL_MAP_UNSYNCHRONIZED_BIT),
	MAP_WRITE_BIT(GLConstants.GL_MAP_WRITE_BIT);

	BufferAccessMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferAccessMask[] VALUES = values();
	private static Map<Integer, BufferAccessMask> getMap() {
		Map<Integer, BufferAccessMask> map = new HashMap<>();
		for(BufferAccessMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, BufferAccessMask> MAP = Collections.unmodifiableMap(getMap());
	public static BufferAccessMask get(int raw) { return MAP.get(raw); }

}