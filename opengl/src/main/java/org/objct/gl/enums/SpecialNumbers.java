package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum SpecialNumbers {
	FALSE(GLConstants.GL_FALSE),
	NO_ERROR(GLConstants.GL_NO_ERROR),
	ZERO(GLConstants.GL_ZERO),
	NONE(GLConstants.GL_NONE),
	NONE_OES(GLConstants.GL_NONE_OES),
	TRUE(GLConstants.GL_TRUE),
	ONE(GLConstants.GL_ONE),
	INVALID_INDEX(GLConstants.GL_INVALID_INDEX),
	ALL_PIXELS_AMD(GLConstants.GL_ALL_PIXELS_AMD),
	TIMEOUT_IGNORED(GLConstants.GL_TIMEOUT_IGNORED),
	TIMEOUT_IGNORED_APPLE(GLConstants.GL_TIMEOUT_IGNORED_APPLE),
	VERSION_ES_CL_1_0(GLConstants.GL_VERSION_ES_CL_1_0),
	VERSION_ES_CM_1_1(GLConstants.GL_VERSION_ES_CM_1_1),
	VERSION_ES_CL_1_1(GLConstants.GL_VERSION_ES_CL_1_1),
	UUID_SIZE_EXT(GLConstants.GL_UUID_SIZE_EXT),
	LUID_SIZE_EXT(GLConstants.GL_LUID_SIZE_EXT);

	SpecialNumbers(int token) {
		this.token = token;
	}

	public final int token;

	public static final SpecialNumbers[] VALUES = values();
	private static Map<Integer, SpecialNumbers> getMap() {
		Map<Integer, SpecialNumbers> map = new HashMap<>();
		for(SpecialNumbers val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, SpecialNumbers> MAP = Collections.unmodifiableMap(getMap());
	public static SpecialNumbers get(int raw) { return MAP.get(raw); }

}