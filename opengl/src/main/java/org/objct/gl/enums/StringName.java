package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum StringName {
	EXTENSIONS(GLConstants.GL_EXTENSIONS),
	RENDERER(GLConstants.GL_RENDERER),
	VENDOR(GLConstants.GL_VENDOR),
	VERSION(GLConstants.GL_VERSION),
	SHADING_LANGUAGE_VERSION(GLConstants.GL_SHADING_LANGUAGE_VERSION);

	StringName(int token) {
		this.token = token;
	}

	public final int token;

	public static final StringName[] VALUES = values();
	private static Map<Integer, StringName> getMap() {
		Map<Integer, StringName> map = new HashMap<>();
		for(StringName val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, StringName> MAP = Collections.unmodifiableMap(getMap());
	public static StringName get(int raw) { return MAP.get(raw); }

}