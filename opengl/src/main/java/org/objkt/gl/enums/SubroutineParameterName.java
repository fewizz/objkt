package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum SubroutineParameterName {
	NUM_COMPATIBLE_SUBROUTINES(GLConstants.GL_NUM_COMPATIBLE_SUBROUTINES),
	COMPATIBLE_SUBROUTINES(GLConstants.GL_COMPATIBLE_SUBROUTINES),
	UNIFORM_SIZE(GLConstants.GL_UNIFORM_SIZE),
	UNIFORM_NAME_LENGTH(GLConstants.GL_UNIFORM_NAME_LENGTH);

	SubroutineParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final SubroutineParameterName[] VALUES = values();
	private static Map<Integer, SubroutineParameterName> getMap() {
		Map<Integer, SubroutineParameterName> map = new HashMap<>();
		for(SubroutineParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, SubroutineParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static SubroutineParameterName get(int raw) { return MAP.get(raw); }
}