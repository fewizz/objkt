package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum RenderbufferTarget {
	RENDERBUFFER(GLConstants.GL_RENDERBUFFER);

	RenderbufferTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final RenderbufferTarget[] VALUES = values();
	private static Map<Integer, RenderbufferTarget> getMap() {
		Map<Integer, RenderbufferTarget> map = new HashMap<>();
		for(RenderbufferTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, RenderbufferTarget> MAP = Collections.unmodifiableMap(getMap());
	public static RenderbufferTarget get(int raw) { return MAP.get(raw); }

}