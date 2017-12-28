package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum GetFramebufferParameter {
	FRAMEBUFFER_DEFAULT_WIDTH(GLConstants.GL_FRAMEBUFFER_DEFAULT_WIDTH),
	FRAMEBUFFER_DEFAULT_HEIGHT(GLConstants.GL_FRAMEBUFFER_DEFAULT_HEIGHT),
	FRAMEBUFFER_DEFAULT_LAYERS(GLConstants.GL_FRAMEBUFFER_DEFAULT_LAYERS),
	FRAMEBUFFER_DEFAULT_SAMPLES(GLConstants.GL_FRAMEBUFFER_DEFAULT_SAMPLES),
	FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS(GLConstants.GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS),
	DOUBLEBUFFER(GLConstants.GL_DOUBLEBUFFER),
	IMPLEMENTATION_COLOR_READ_FORMAT(GLConstants.GL_IMPLEMENTATION_COLOR_READ_FORMAT),
	IMPLEMENTATION_COLOR_READ_TYPE(GLConstants.GL_IMPLEMENTATION_COLOR_READ_TYPE),
	SAMPLES(GLConstants.GL_SAMPLES),
	SAMPLE_BUFFERS(GLConstants.GL_SAMPLE_BUFFERS),
	STEREO(GLConstants.GL_STEREO);

	GetFramebufferParameter(int token) {
		this.token = token;
	}

	public final int token;

	public static final GetFramebufferParameter[] VALUES = values();
	private static Map<Integer, GetFramebufferParameter> getMap() {
		Map<Integer, GetFramebufferParameter> map = new HashMap<>();
		for(GetFramebufferParameter val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, GetFramebufferParameter> MAP = Collections.unmodifiableMap(getMap());
	public static GetFramebufferParameter get(int raw) { return MAP.get(raw); }

}