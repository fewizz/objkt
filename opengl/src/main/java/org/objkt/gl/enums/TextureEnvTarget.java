package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum TextureEnvTarget {
	TEXTURE_ENV(GLConstants.GL_TEXTURE_ENV);

	TextureEnvTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final TextureEnvTarget[] VALUES = values();
	private static Map<Integer, TextureEnvTarget> getMap() {
		Map<Integer, TextureEnvTarget> map = new HashMap<>();
		for(TextureEnvTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TextureEnvTarget> MAP = Collections.unmodifiableMap(getMap());
	public static TextureEnvTarget get(int raw) { return MAP.get(raw); }

}