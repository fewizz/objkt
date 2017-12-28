package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PointParameterNameSGIS {
	POINT_DISTANCE_ATTENUATION(GLConstants.GL_POINT_DISTANCE_ATTENUATION),
	POINT_FADE_THRESHOLD_SIZE(GLConstants.GL_POINT_FADE_THRESHOLD_SIZE),
	POINT_SIZE_MAX(GLConstants.GL_POINT_SIZE_MAX),
	POINT_SIZE_MIN(GLConstants.GL_POINT_SIZE_MIN);

	PointParameterNameSGIS(int token) {
		this.token = token;
	}

	public final int token;

	public static final PointParameterNameSGIS[] VALUES = values();
	private static Map<Integer, PointParameterNameSGIS> getMap() {
		Map<Integer, PointParameterNameSGIS> map = new HashMap<>();
		for(PointParameterNameSGIS val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PointParameterNameSGIS> MAP = Collections.unmodifiableMap(getMap());
	public static PointParameterNameSGIS get(int raw) { return MAP.get(raw); }

}