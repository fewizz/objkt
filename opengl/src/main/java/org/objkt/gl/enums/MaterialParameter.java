package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum MaterialParameter {
	AMBIENT(GLConstants.GL_AMBIENT),
	AMBIENT_AND_DIFFUSE(GLConstants.GL_AMBIENT_AND_DIFFUSE),
	DIFFUSE(GLConstants.GL_DIFFUSE),
	EMISSION(GLConstants.GL_EMISSION),
	SHININESS(GLConstants.GL_SHININESS),
	SPECULAR(GLConstants.GL_SPECULAR);

	MaterialParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final MaterialParameter[] VALUES = values();
	private static Map<Integer, MaterialParameter> getMap() {
		Map<Integer, MaterialParameter> map = new HashMap<>();
		for(MaterialParameter val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, MaterialParameter> MAP = Collections.unmodifiableMap(getMap());
	public static MaterialParameter get(int raw) { return MAP.get(raw); }

}