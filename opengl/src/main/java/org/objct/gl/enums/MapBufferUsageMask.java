package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum MapBufferUsageMask {
	CLIENT_STORAGE_BIT(GLConstants.GL_CLIENT_STORAGE_BIT),
	DYNAMIC_STORAGE_BIT(GLConstants.GL_DYNAMIC_STORAGE_BIT),
	MAP_COHERENT_BIT(GLConstants.GL_MAP_COHERENT_BIT),
	MAP_FLUSH_EXPLICIT_BIT(GLConstants.GL_MAP_FLUSH_EXPLICIT_BIT),
	MAP_INVALIDATE_BUFFER_BIT(GLConstants.GL_MAP_INVALIDATE_BUFFER_BIT),
	MAP_INVALIDATE_RANGE_BIT(GLConstants.GL_MAP_INVALIDATE_RANGE_BIT),
	MAP_PERSISTENT_BIT(GLConstants.GL_MAP_PERSISTENT_BIT),
	MAP_READ_BIT(GLConstants.GL_MAP_READ_BIT),
	MAP_UNSYNCHRONIZED_BIT(GLConstants.GL_MAP_UNSYNCHRONIZED_BIT),
	MAP_WRITE_BIT(GLConstants.GL_MAP_WRITE_BIT),
	MAP_READ_BIT_EXT(GLConstants.GL_MAP_READ_BIT_EXT),
	MAP_WRITE_BIT_EXT(GLConstants.GL_MAP_WRITE_BIT_EXT),
	MAP_INVALIDATE_RANGE_BIT_EXT(GLConstants.GL_MAP_INVALIDATE_RANGE_BIT_EXT),
	MAP_INVALIDATE_BUFFER_BIT_EXT(GLConstants.GL_MAP_INVALIDATE_BUFFER_BIT_EXT),
	MAP_FLUSH_EXPLICIT_BIT_EXT(GLConstants.GL_MAP_FLUSH_EXPLICIT_BIT_EXT),
	MAP_UNSYNCHRONIZED_BIT_EXT(GLConstants.GL_MAP_UNSYNCHRONIZED_BIT_EXT),
	MAP_PERSISTENT_BIT_EXT(GLConstants.GL_MAP_PERSISTENT_BIT_EXT),
	MAP_COHERENT_BIT_EXT(GLConstants.GL_MAP_COHERENT_BIT_EXT),
	DYNAMIC_STORAGE_BIT_EXT(GLConstants.GL_DYNAMIC_STORAGE_BIT_EXT),
	CLIENT_STORAGE_BIT_EXT(GLConstants.GL_CLIENT_STORAGE_BIT_EXT),
	SPARSE_STORAGE_BIT_ARB(GLConstants.GL_SPARSE_STORAGE_BIT_ARB),
	LGPU_SEPARATE_STORAGE_BIT_NVX(GLConstants.GL_LGPU_SEPARATE_STORAGE_BIT_NVX),
	PER_GPU_STORAGE_BIT_NV(GLConstants.GL_PER_GPU_STORAGE_BIT_NV),
	EXTERNAL_STORAGE_BIT_NVX(GLConstants.GL_EXTERNAL_STORAGE_BIT_NVX);

	MapBufferUsageMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final MapBufferUsageMask[] VALUES = values();
	private static Map<Integer, MapBufferUsageMask> getMap() {
		Map<Integer, MapBufferUsageMask> map = new HashMap<>();
		for(MapBufferUsageMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, MapBufferUsageMask> MAP = Collections.unmodifiableMap(getMap());
	public static MapBufferUsageMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(MapBufferUsageMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(MapBufferUsageMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }	}
}