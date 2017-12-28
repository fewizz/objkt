package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum ProgramStagePName {
	ACTIVE_SUBROUTINE_UNIFORMS(GLConstants.GL_ACTIVE_SUBROUTINE_UNIFORMS),
	ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS(GLConstants.GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS),
	ACTIVE_SUBROUTINES(GLConstants.GL_ACTIVE_SUBROUTINES),
	ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH(GLConstants.GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH),
	ACTIVE_SUBROUTINE_MAX_LENGTH(GLConstants.GL_ACTIVE_SUBROUTINE_MAX_LENGTH);

	ProgramStagePName(int token) {
		this.token = token;
	}

	public final int token;

	public static final ProgramStagePName[] VALUES = values();
	private static Map<Integer, ProgramStagePName> getMap() {
		Map<Integer, ProgramStagePName> map = new HashMap<>();
		for(ProgramStagePName val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, ProgramStagePName> MAP = Collections.unmodifiableMap(getMap());
	public static ProgramStagePName get(int raw) { return MAP.get(raw); }

}