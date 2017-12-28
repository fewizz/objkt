package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum VertexProvokingMode {
	FIRST_VERTEX_CONVENTION(GLConstants.GL_FIRST_VERTEX_CONVENTION),
	LAST_VERTEX_CONVENTION(GLConstants.GL_LAST_VERTEX_CONVENTION);

	VertexProvokingMode(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexProvokingMode[] VALUES = values();
	private static Map<Integer, VertexProvokingMode> getMap() {
		Map<Integer, VertexProvokingMode> map = new HashMap<>();
		for(VertexProvokingMode val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, VertexProvokingMode> MAP = Collections.unmodifiableMap(getMap());
	public static VertexProvokingMode get(int raw) { return MAP.get(raw); }

}