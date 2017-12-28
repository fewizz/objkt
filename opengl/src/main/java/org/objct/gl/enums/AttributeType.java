package org.objct.gl.enums;

import java.util.*;

import org.objkt.gl.GLConstants;

public enum AttributeType {
	FLOAT_VEC2(GLConstants.GL_FLOAT_VEC2),
	FLOAT_VEC3(GLConstants.GL_FLOAT_VEC3),
	FLOAT_VEC4(GLConstants.GL_FLOAT_VEC4),
	INT_VEC2(GLConstants.GL_INT_VEC2),
	INT_VEC3(GLConstants.GL_INT_VEC3),
	INT_VEC4(GLConstants.GL_INT_VEC4),
	BOOL(GLConstants.GL_BOOL),
	BOOL_VEC2(GLConstants.GL_BOOL_VEC2),
	BOOL_VEC3(GLConstants.GL_BOOL_VEC3),
	BOOL_VEC4(GLConstants.GL_BOOL_VEC4),
	FLOAT_MAT2(GLConstants.GL_FLOAT_MAT2),
	FLOAT_MAT3(GLConstants.GL_FLOAT_MAT3),
	FLOAT_MAT4(GLConstants.GL_FLOAT_MAT4),
	SAMPLER_1D(GLConstants.GL_SAMPLER_1D),
	SAMPLER_2D(GLConstants.GL_SAMPLER_2D),
	SAMPLER_3D(GLConstants.GL_SAMPLER_3D),
	SAMPLER_CUBE(GLConstants.GL_SAMPLER_CUBE),
	SAMPLER_1D_SHADOW(GLConstants.GL_SAMPLER_1D_SHADOW),
	SAMPLER_2D_SHADOW(GLConstants.GL_SAMPLER_2D_SHADOW),
	SAMPLER_2D_RECT(GLConstants.GL_SAMPLER_2D_RECT),
	SAMPLER_2D_RECT_SHADOW(GLConstants.GL_SAMPLER_2D_RECT_SHADOW),
	FLOAT_MAT2x3(GLConstants.GL_FLOAT_MAT2x3),
	FLOAT_MAT2x4(GLConstants.GL_FLOAT_MAT2x4),
	FLOAT_MAT3x2(GLConstants.GL_FLOAT_MAT3x2),
	FLOAT_MAT3x4(GLConstants.GL_FLOAT_MAT3x4),
	FLOAT_MAT4x2(GLConstants.GL_FLOAT_MAT4x2),
	FLOAT_MAT4x3(GLConstants.GL_FLOAT_MAT4x3),
	FLOAT_VEC2_ARB(GLConstants.GL_FLOAT_VEC2_ARB),
	FLOAT_VEC3_ARB(GLConstants.GL_FLOAT_VEC3_ARB),
	FLOAT_VEC4_ARB(GLConstants.GL_FLOAT_VEC4_ARB),
	INT_VEC2_ARB(GLConstants.GL_INT_VEC2_ARB),
	INT_VEC3_ARB(GLConstants.GL_INT_VEC3_ARB),
	INT_VEC4_ARB(GLConstants.GL_INT_VEC4_ARB),
	BOOL_ARB(GLConstants.GL_BOOL_ARB),
	BOOL_VEC2_ARB(GLConstants.GL_BOOL_VEC2_ARB),
	BOOL_VEC3_ARB(GLConstants.GL_BOOL_VEC3_ARB),
	BOOL_VEC4_ARB(GLConstants.GL_BOOL_VEC4_ARB),
	FLOAT_MAT2_ARB(GLConstants.GL_FLOAT_MAT2_ARB),
	FLOAT_MAT3_ARB(GLConstants.GL_FLOAT_MAT3_ARB),
	FLOAT_MAT4_ARB(GLConstants.GL_FLOAT_MAT4_ARB),
	SAMPLER_1D_ARB(GLConstants.GL_SAMPLER_1D_ARB),
	SAMPLER_2D_ARB(GLConstants.GL_SAMPLER_2D_ARB),
	SAMPLER_3D_ARB(GLConstants.GL_SAMPLER_3D_ARB),
	SAMPLER_3D_OES(GLConstants.GL_SAMPLER_3D_OES),
	SAMPLER_CUBE_ARB(GLConstants.GL_SAMPLER_CUBE_ARB),
	SAMPLER_1D_SHADOW_ARB(GLConstants.GL_SAMPLER_1D_SHADOW_ARB),
	SAMPLER_2D_SHADOW_ARB(GLConstants.GL_SAMPLER_2D_SHADOW_ARB),
	SAMPLER_2D_SHADOW_EXT(GLConstants.GL_SAMPLER_2D_SHADOW_EXT),
	SAMPLER_2D_RECT_ARB(GLConstants.GL_SAMPLER_2D_RECT_ARB),
	SAMPLER_2D_RECT_SHADOW_ARB(GLConstants.GL_SAMPLER_2D_RECT_SHADOW_ARB),
	FLOAT_MAT2x3_NV(GLConstants.GL_FLOAT_MAT2x3_NV),
	FLOAT_MAT2x4_NV(GLConstants.GL_FLOAT_MAT2x4_NV),
	FLOAT_MAT3x2_NV(GLConstants.GL_FLOAT_MAT3x2_NV),
	FLOAT_MAT3x4_NV(GLConstants.GL_FLOAT_MAT3x4_NV),
	FLOAT_MAT4x2_NV(GLConstants.GL_FLOAT_MAT4x2_NV),
	FLOAT_MAT4x3_NV(GLConstants.GL_FLOAT_MAT4x3_NV);

	AttributeType(int token) {
		this.token = token;
	}

	public final int token;

	public static final AttributeType[] VALUES = values();
	private static Map<Integer, AttributeType> getMap() {
		Map<Integer, AttributeType> map = new HashMap<>();
		for(AttributeType val : VALUES) map.put(val.token, val);
		return map;	}
	private static final Map<Integer, AttributeType> MAP = Collections.unmodifiableMap(getMap());
	public static AttributeType get(int raw) { return MAP.get(raw); }

}