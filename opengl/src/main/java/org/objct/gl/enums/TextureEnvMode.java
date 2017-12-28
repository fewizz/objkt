package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum TextureEnvMode {
	ADD(GLConstants.GL_ADD),
	BLEND(GLConstants.GL_BLEND),
	DECAL(GLConstants.GL_DECAL),
	MODULATE(GLConstants.GL_MODULATE);

	TextureEnvMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureEnvMode[] VALUES = values();
	private static Map<Integer, TextureEnvMode> getMap() {
		Map<Integer, TextureEnvMode> map = new HashMap<>();
		for(TextureEnvMode val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, TextureEnvMode> MAP = Collections.unmodifiableMap(getMap());
	public static TextureEnvMode get(int raw) { return MAP.get(raw); }

}