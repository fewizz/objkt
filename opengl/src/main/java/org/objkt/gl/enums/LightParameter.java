package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum LightParameter {
	AMBIENT(GLConstants.GL_AMBIENT),
	CONSTANT_ATTENUATION(GLConstants.GL_CONSTANT_ATTENUATION),
	DIFFUSE(GLConstants.GL_DIFFUSE),
	LINEAR_ATTENUATION(GLConstants.GL_LINEAR_ATTENUATION),
	POSITION(GLConstants.GL_POSITION),
	QUADRATIC_ATTENUATION(GLConstants.GL_QUADRATIC_ATTENUATION),
	SPECULAR(GLConstants.GL_SPECULAR),
	SPOT_CUTOFF(GLConstants.GL_SPOT_CUTOFF),
	SPOT_DIRECTION(GLConstants.GL_SPOT_DIRECTION),
	SPOT_EXPONENT(GLConstants.GL_SPOT_EXPONENT);

	LightParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final LightParameter[] VALUES = values();
	private static Map<Integer, LightParameter> getMap() {
		Map<Integer, LightParameter> map = new HashMap<>();
		for(LightParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, LightParameter> MAP = Collections.unmodifiableMap(getMap());
	public static LightParameter get(int raw) { return MAP.get(raw); }

}