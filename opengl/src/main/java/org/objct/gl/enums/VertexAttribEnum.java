package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum VertexAttribEnum {
	VERTEX_ATTRIB_ARRAY_BUFFER_BINDING(GLConstants.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING),
	VERTEX_ATTRIB_ARRAY_ENABLED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_ENABLED),
	VERTEX_ATTRIB_ARRAY_SIZE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_SIZE),
	VERTEX_ATTRIB_ARRAY_STRIDE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_STRIDE),
	VERTEX_ATTRIB_ARRAY_TYPE(GLConstants.GL_VERTEX_ATTRIB_ARRAY_TYPE),
	VERTEX_ATTRIB_ARRAY_NORMALIZED(GLConstants.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED),
	VERTEX_ATTRIB_ARRAY_INTEGER(GLConstants.GL_VERTEX_ATTRIB_ARRAY_INTEGER),
	VERTEX_ATTRIB_ARRAY_DIVISOR(GLConstants.GL_VERTEX_ATTRIB_ARRAY_DIVISOR),
	CURRENT_VERTEX_ATTRIB(GLConstants.GL_CURRENT_VERTEX_ATTRIB);

	VertexAttribEnum(int token) {
		this.token = token;
	}

	public final int token;

	public static final VertexAttribEnum[] VALUES = values();
	private static Map<Integer, VertexAttribEnum> getMap() {
		Map<Integer, VertexAttribEnum> map = new HashMap<>();
		for(VertexAttribEnum val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, VertexAttribEnum> MAP = Collections.unmodifiableMap(getMap());
	public static VertexAttribEnum get(int raw) { return MAP.get(raw); }

}