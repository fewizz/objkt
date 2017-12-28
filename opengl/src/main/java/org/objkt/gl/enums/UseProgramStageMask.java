package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum UseProgramStageMask {
	VERTEX_SHADER_BIT(GLConstants.GL_VERTEX_SHADER_BIT),
	FRAGMENT_SHADER_BIT(GLConstants.GL_FRAGMENT_SHADER_BIT),
	GEOMETRY_SHADER_BIT(GLConstants.GL_GEOMETRY_SHADER_BIT),
	TESS_CONTROL_SHADER_BIT(GLConstants.GL_TESS_CONTROL_SHADER_BIT),
	TESS_EVALUATION_SHADER_BIT(GLConstants.GL_TESS_EVALUATION_SHADER_BIT),
	COMPUTE_SHADER_BIT(GLConstants.GL_COMPUTE_SHADER_BIT),
	ALL_SHADER_BITS(GLConstants.GL_ALL_SHADER_BITS);

	UseProgramStageMask(int token) {
		this.token = token;
	}

	public final int token;

	public static final UseProgramStageMask[] VALUES = values();
	private static Map<Integer, UseProgramStageMask> getMap() {
		Map<Integer, UseProgramStageMask> map = new HashMap<>();
		for(UseProgramStageMask val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, UseProgramStageMask> MAP = Collections.unmodifiableMap(getMap());
	public static UseProgramStageMask get(int raw) { return MAP.get(raw); }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(UseProgramStageMask... values) {
			Mask m = MASKS.get();
			m.value = 0;
			for(UseProgramStageMask enm : values)
				m.value += enm.token;
			return m;
		}
		public int value() { return value; }
	}
}