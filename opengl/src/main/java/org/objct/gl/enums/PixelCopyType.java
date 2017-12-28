package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PixelCopyType {
	COLOR(GLConstants.GL_COLOR),
	DEPTH(GLConstants.GL_DEPTH),
	STENCIL(GLConstants.GL_STENCIL);

	PixelCopyType(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelCopyType[] VALUES = values();
	private static Map<Integer, PixelCopyType> getMap() {
		Map<Integer, PixelCopyType> map = new HashMap<>();
		for(PixelCopyType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PixelCopyType> MAP = Collections.unmodifiableMap(getMap());
	public static PixelCopyType get(int raw) { return MAP.get(raw); }

}