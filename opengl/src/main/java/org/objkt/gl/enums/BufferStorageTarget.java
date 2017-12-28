package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BufferStorageTarget {
	ARRAY_BUFFER(GLConstants.GL_ARRAY_BUFFER),
	ATOMIC_COUNTER_BUFFER(GLConstants.GL_ATOMIC_COUNTER_BUFFER),
	COPY_READ_BUFFER(GLConstants.GL_COPY_READ_BUFFER),
	COPY_WRITE_BUFFER(GLConstants.GL_COPY_WRITE_BUFFER),
	DISPATCH_INDIRECT_BUFFER(GLConstants.GL_DISPATCH_INDIRECT_BUFFER),
	DRAW_INDIRECT_BUFFER(GLConstants.GL_DRAW_INDIRECT_BUFFER),
	ELEMENT_ARRAY_BUFFER(GLConstants.GL_ELEMENT_ARRAY_BUFFER),
	PIXEL_PACK_BUFFER(GLConstants.GL_PIXEL_PACK_BUFFER),
	PIXEL_UNPACK_BUFFER(GLConstants.GL_PIXEL_UNPACK_BUFFER),
	QUERY_BUFFER(GLConstants.GL_QUERY_BUFFER),
	SHADER_STORAGE_BUFFER(GLConstants.GL_SHADER_STORAGE_BUFFER),
	TEXTURE_BUFFER(GLConstants.GL_TEXTURE_BUFFER),
	TRANSFORM_FEEDBACK_BUFFER(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER),
	UNIFORM_BUFFER(GLConstants.GL_UNIFORM_BUFFER);

	BufferStorageTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferStorageTarget[] VALUES = values();
	private static Map<Integer, BufferStorageTarget> getMap() {
		Map<Integer, BufferStorageTarget> map = new HashMap<>();
		for(BufferStorageTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferStorageTarget> MAP = Collections.unmodifiableMap(getMap());
	public static BufferStorageTarget get(int raw) { return MAP.get(raw); }

}