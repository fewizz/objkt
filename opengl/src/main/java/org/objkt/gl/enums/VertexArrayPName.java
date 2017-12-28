package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum VertexArrayPName {
	VERTEX_ATTRIB_ARRAY_ENABLED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_ENABLED),
	VERTEX_ATTRIB_ARRAY_SIZE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_SIZE),
	VERTEX_ATTRIB_ARRAY_STRIDE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_STRIDE),
	VERTEX_ATTRIB_ARRAY_TYPE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_TYPE),
	VERTEX_ATTRIB_ARRAY_NORMALIZED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED),
	VERTEX_ATTRIB_ARRAY_INTEGER(GLConstants.GL_VERTEX_ATTRIB_ARRAY_INTEGER),
	VERTEX_ATTRIB_ARRAY_LONG(GLConstants.GL_VERTEX_ATTRIB_ARRAY_LONG),
	VERTEX_ATTRIB_ARRAY_DIVISOR(GLConstants.GL_VERTEX_ATTRIB_ARRAY_DIVISOR),
	VERTEX_ATTRIB_RELATIVE_OFFSET(GLConstants.GL_VERTEX_ATTRIB_RELATIVE_OFFSET);

	VertexArrayPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexArrayPName[] VALUES = values();
	private static Map<Integer, VertexArrayPName> getMap() {
		Map<Integer, VertexArrayPName> map = new HashMap<>();
		for(VertexArrayPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, VertexArrayPName> MAP = Collections.unmodifiableMap(getMap());
	public static VertexArrayPName get(int raw) { return MAP.get(raw); }

}