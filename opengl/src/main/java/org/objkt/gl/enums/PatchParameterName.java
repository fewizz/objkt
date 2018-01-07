package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum PatchParameterName {
	PATCH_VERTICES(GLConstants.GL_PATCH_VERTICES),
	PATCH_DEFAULT_OUTER_LEVEL(GLConstants.GL_PATCH_DEFAULT_OUTER_LEVEL),
	PATCH_DEFAULT_INNER_LEVEL(GLConstants.GL_PATCH_DEFAULT_INNER_LEVEL);

	PatchParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final PatchParameterName[] VALUES = values();
	private static Map<Integer, PatchParameterName> getMap() {
		Map<Integer, PatchParameterName> map = new HashMap<>();
		for(PatchParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, PatchParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static PatchParameterName get(int raw) { return MAP.get(raw); }
}