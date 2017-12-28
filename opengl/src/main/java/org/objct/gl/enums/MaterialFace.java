package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum MaterialFace {
	BACK(GLConstants.GL_BACK),
	FRONT(GLConstants.GL_FRONT),
	FRONT_AND_BACK(GLConstants.GL_FRONT_AND_BACK);

	MaterialFace(int token) {
		this.token = token;
	}

	public final int token;

	public static final MaterialFace[] VALUES = values();
	private static Map<Integer, MaterialFace> getMap() {
		Map<Integer, MaterialFace> map = new HashMap<>();
		for(MaterialFace val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, MaterialFace> MAP = Collections.unmodifiableMap(getMap());
	public static MaterialFace get(int raw) { return MAP.get(raw); }

}