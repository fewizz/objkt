package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum BindTransformFeedbackTarget {
	TRANSFORM_FEEDBACK(GLConstants.GL_TRANSFORM_FEEDBACK);

	BindTransformFeedbackTarget(int token) {
		this.token = token;
	}

	public final int token;

	public static final BindTransformFeedbackTarget[] VALUES = values();
	private static Map<Integer, BindTransformFeedbackTarget> getMap() {
		Map<Integer, BindTransformFeedbackTarget> map = new HashMap<>();
		for(BindTransformFeedbackTarget val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, BindTransformFeedbackTarget> MAP = Collections.unmodifiableMap(getMap());
	public static BindTransformFeedbackTarget get(int raw) { return MAP.get(raw); }
}