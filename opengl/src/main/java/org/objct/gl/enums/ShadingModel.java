package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ShadingModel {
	FLAT(GLConstants.GL_FLAT),
	SMOOTH(GLConstants.GL_SMOOTH);

	ShadingModel(int token) {
		this.token = token;
	}

	public final int token;

	public static final ShadingModel[] VALUES = values();
	private static Map<Integer, ShadingModel> getMap() {
		Map<Integer, ShadingModel> map = new HashMap<>();
		for(ShadingModel val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ShadingModel> MAP = Collections.unmodifiableMap(getMap());
	public static ShadingModel get(int raw) { return MAP.get(raw); }

}