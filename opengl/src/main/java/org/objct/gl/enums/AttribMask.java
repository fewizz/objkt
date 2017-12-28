package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum AttribMask {
	COLOR_BUFFER_BIT(GLConstants.GL_COLOR_BUFFER_BIT),
	DEPTH_BUFFER_BIT(GLConstants.GL_DEPTH_BUFFER_BIT),
	STENCIL_BUFFER_BIT(GLConstants.GL_STENCIL_BUFFER_BIT),
	CURRENT_BIT(GLConstants.GL_CURRENT_BIT),
	POINT_BIT(GLConstants.GL_POINT_BIT),
	LINE_BIT(GLConstants.GL_LINE_BIT),
	POLYGON_BIT(GLConstants.GL_POLYGON_BIT),
	POLYGON_STIPPLE_BIT(GLConstants.GL_POLYGON_STIPPLE_BIT),
	PIXEL_MODE_BIT(GLConstants.GL_PIXEL_MODE_BIT),
	LIGHTING_BIT(GLConstants.GL_LIGHTING_BIT),
	FOG_BIT(GLConstants.GL_FOG_BIT),
	ACCUM_BUFFER_BIT(GLConstants.GL_ACCUM_BUFFER_BIT),
	VIEWPORT_BIT(GLConstants.GL_VIEWPORT_BIT),
	TRANSFORM_BIT(GLConstants.GL_TRANSFORM_BIT),
	ENABLE_BIT(GLConstants.GL_ENABLE_BIT),
	HINT_BIT(GLConstants.GL_HINT_BIT),
	EVAL_BIT(GLConstants.GL_EVAL_BIT),
	LIST_BIT(GLConstants.GL_LIST_BIT),
	TEXTURE_BIT(GLConstants.GL_TEXTURE_BIT),
	SCISSOR_BIT(GLConstants.GL_SCISSOR_BIT),
	MULTISAMPLE_BIT(GLConstants.GL_MULTISAMPLE_BIT),
	MULTISAMPLE_BIT_ARB(GLConstants.GL_MULTISAMPLE_BIT_ARB),
	MULTISAMPLE_BIT_EXT(GLConstants.GL_MULTISAMPLE_BIT_EXT),
	MULTISAMPLE_BIT_3DFX(GLConstants.GL_MULTISAMPLE_BIT_3DFX),
	ALL_ATTRIB_BITS(GLConstants.GL_ALL_ATTRIB_BITS);

	AttribMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final AttribMask[] VALUES = values();
	private static Map<Integer, AttribMask> getMap() {
		Map<Integer, AttribMask> map = new HashMap<>();
		for(AttribMask val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, AttribMask> MAP = Collections.unmodifiableMap(getMap());
	public static AttribMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(AttribMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(AttribMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }	}
}