package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum QueryParameterName {
	CURRENT_QUERY(GLConstants.GL_CURRENT_QUERY),
	QUERY_COUNTER_BITS(GLConstants.GL_QUERY_COUNTER_BITS);

	QueryParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final QueryParameterName[] VALUES = values();
	private static Map<Integer, QueryParameterName> getMap() {
		Map<Integer, QueryParameterName> map = new HashMap<>();
		for(QueryParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, QueryParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static QueryParameterName get(int raw) { return MAP.get(raw); }
}