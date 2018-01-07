package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum PixelFormat {
	ALPHA(GLConstants.GL_ALPHA),
	BLUE(GLConstants.GL_BLUE),
	DEPTH_COMPONENT(GLConstants.GL_DEPTH_COMPONENT),
	GREEN(GLConstants.GL_GREEN),
	LUMINANCE(GLConstants.GL_LUMINANCE),
	LUMINANCE_ALPHA(GLConstants.GL_LUMINANCE_ALPHA),
	RED(GLConstants.GL_RED),
	RGB(GLConstants.GL_RGB),
	RGBA(GLConstants.GL_RGBA),
	STENCIL_INDEX(GLConstants.GL_STENCIL_INDEX),
	UNSIGNED_INT(GLConstants.GL_UNSIGNED_INT),
	UNSIGNED_SHORT(GLConstants.GL_UNSIGNED_SHORT);

	PixelFormat(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelFormat[] VALUES = values();
	private static Map<Integer, PixelFormat> getMap() {
		Map<Integer, PixelFormat> map = new HashMap<>();
		for(PixelFormat val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PixelFormat> MAP = Collections.unmodifiableMap(getMap());
	public static PixelFormat get(int raw) { return MAP.get(raw); }
}