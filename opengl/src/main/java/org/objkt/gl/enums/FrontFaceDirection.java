package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum FrontFaceDirection {
	CCW(GLConstants.GL_CCW),
	CW(GLConstants.GL_CW);

	FrontFaceDirection(int token) {
		this.token = token;
	}

	public final int token;

	public static final FrontFaceDirection[] VALUES = values();
	private static Map<Integer, FrontFaceDirection> getMap() {
		Map<Integer, FrontFaceDirection> map = new HashMap<>();
		for(FrontFaceDirection val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, FrontFaceDirection> MAP = Collections.unmodifiableMap(getMap());
	public static FrontFaceDirection get(int raw) { return MAP.get(raw); }
}