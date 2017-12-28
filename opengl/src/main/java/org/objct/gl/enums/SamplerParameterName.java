package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum SamplerParameterName {
	TEXTURE_WRAP_S(GLConstants.GL_TEXTURE_WRAP_S),
	TEXTURE_WRAP_T(GLConstants.GL_TEXTURE_WRAP_T),
	TEXTURE_WRAP_R(GLConstants.GL_TEXTURE_WRAP_R),
	TEXTURE_MIN_FILTER(GLConstants.GL_TEXTURE_MIN_FILTER),
	TEXTURE_MAG_FILTER(GLConstants.GL_TEXTURE_MAG_FILTER),
	TEXTURE_BORDER_COLOR(GLConstants.GL_TEXTURE_BORDER_COLOR),
	TEXTURE_MIN_LOD(GLConstants.GL_TEXTURE_MIN_LOD),
	TEXTURE_MAX_LOD(GLConstants.GL_TEXTURE_MAX_LOD),
	TEXTURE_COMPARE_MODE(GLConstants.GL_TEXTURE_COMPARE_MODE),
	TEXTURE_COMPARE_FUNC(GLConstants.GL_TEXTURE_COMPARE_FUNC);

	SamplerParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final SamplerParameterName[] VALUES = values();
	private static Map<Integer, SamplerParameterName> getMap() {
		Map<Integer, SamplerParameterName> map = new HashMap<>();
		for(SamplerParameterName val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, SamplerParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static SamplerParameterName get(int raw) { return MAP.get(raw); }

}