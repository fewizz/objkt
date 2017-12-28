package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum PixelTransferParameter {
	ALPHA_SCALE(GLConstants.GL_ALPHA_SCALE);

	PixelTransferParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final PixelTransferParameter[] VALUES = values();
	private static Map<Integer, PixelTransferParameter> getMap() {
		Map<Integer, PixelTransferParameter> map = new HashMap<>();
		for(PixelTransferParameter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, PixelTransferParameter> MAP = Collections.unmodifiableMap(getMap());
	public static PixelTransferParameter get(int raw) { return MAP.get(raw); }

}