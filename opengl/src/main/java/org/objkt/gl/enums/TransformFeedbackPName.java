package org.objkt.gl.enums;

import java.util.*;
import org.objkt.gl.GLConstants;

public enum TransformFeedbackPName {
	TRANSFORM_FEEDBACK_BUFFER_BINDING(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER_BINDING),
	TRANSFORM_FEEDBACK_BUFFER_START(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER_START),
	TRANSFORM_FEEDBACK_BUFFER_SIZE(GLConstants.GL_TRANSFORM_FEEDBACK_BUFFER_SIZE),
	TRANSFORM_FEEDBACK_PAUSED(GLConstants.GL_TRANSFORM_FEEDBACK_PAUSED),
	TRANSFORM_FEEDBACK_ACTIVE(GLConstants.GL_TRANSFORM_FEEDBACK_ACTIVE);

	TransformFeedbackPName(int token) {
		this.token = token;
	}

	public final int token;

	public static final TransformFeedbackPName[] VALUES = values();
	private static Map<Integer, TransformFeedbackPName> getMap() {
		Map<Integer, TransformFeedbackPName> map = new HashMap<>();
		for(TransformFeedbackPName val : VALUES) map.put(val.token, val);
		return map;
	}
	private static final Map<Integer, TransformFeedbackPName> MAP = Collections.unmodifiableMap(getMap());
	public static TransformFeedbackPName get(int raw) { return MAP.get(raw); }
}