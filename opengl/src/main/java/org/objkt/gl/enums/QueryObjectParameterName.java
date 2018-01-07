package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum QueryObjectParameterName {
	QUERY_RESULT_AVAILABLE(GLConstants.GL_QUERY_RESULT_AVAILABLE),
	QUERY_RESULT(GLConstants.GL_QUERY_RESULT),
	QUERY_RESULT_NO_WAIT(GLConstants.GL_QUERY_RESULT_NO_WAIT),
	QUERY_TARGET(GLConstants.GL_QUERY_TARGET);

	QueryObjectParameterName(int token) {
		this.token = token;
	}

	public final int token;

	public static final QueryObjectParameterName[] VALUES = values();
	private static Map<Integer, QueryObjectParameterName> getMap() {
		Map<Integer, QueryObjectParameterName> map = new HashMap<>();
		for(QueryObjectParameterName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, QueryObjectParameterName> MAP = Collections.unmodifiableMap(getMap());
	public static QueryObjectParameterName get(int raw) { return MAP.get(raw); }
	public static int intMaskOf(QueryObjectParameterName... enums) { int i = 0; for(QueryObjectParameterName e : VALUES) i |= e.token; return i; }

	public static class Mask {
		static final ThreadLocal<Mask> MASKS = ThreadLocal.withInitial(() -> new Mask());
		int value;

		public static Mask of(QueryObjectParameterName... enums) {
			Mask m = MASKS.get();
			m.value = intMaskOf(enums);
			return m;
		}
		public int value() { return value; }
	}
}