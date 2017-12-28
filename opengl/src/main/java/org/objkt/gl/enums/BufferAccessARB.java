package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BufferAccessARB {
	READ_ONLY(GLConstants.GL_READ_ONLY),
	WRITE_ONLY(GLConstants.GL_WRITE_ONLY),
	READ_WRITE(GLConstants.GL_READ_WRITE);

	BufferAccessARB(int token) {
		this.token = token;
	}

	public final int token;

	public static final BufferAccessARB[] VALUES = values();
	private static Map<Integer, BufferAccessARB> getMap() {
		Map<Integer, BufferAccessARB> map = new HashMap<>();
		for(BufferAccessARB val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BufferAccessARB> MAP = Collections.unmodifiableMap(getMap());
	public static BufferAccessARB get(int raw) { return MAP.get(raw); }

}