package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum ShaderParameterName {
	SHADER_TYPE(GLConstants.GL_SHADER_TYPE),
	DELETE_STATUS(GLConstants.GL_DELETE_STATUS),
	COMPILE_STATUS(GLConstants.GL_COMPILE_STATUS),
	INFO_LOG_LENGTH(GLConstants.GL_INFO_LOG_LENGTH),
	SHADER_SOURCE_LENGTH(GLConstants.GL_SHADER_SOURCE_LENGTH);

	ShaderParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ShaderParameterName[] VALUES = values();
	private static Map<Integer, ShaderParameterName> getMap() {
		Map<Integer, ShaderParameterName> map = new HashMap<>();
		for(ShaderParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, ShaderParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static ShaderParameterName get(int raw) { return MAP.get(raw); }

}