package org.objkt.gl.wrapper;

import org.objkt.gl.enums.*;

public abstract class GLESWrapper extends Wrapper {
	public abstract void glAlphaFunc(int func, float ref);
	public final void alphaFunc(AlphaFunction func, float ref) { glAlphaFunc(func.token, ref); }

	public abstract void glAlphaFuncx(int func, int ref);
	public final void alphaFuncx(AlphaFunction func, int ref) { glAlphaFuncx(func.token, ref); }

	public abstract void glBlendBarrier();
	public final void blendBarrier() { glBlendBarrier(); }

	public abstract void glClearColorx(int red, int green, int blue, int alpha);
	public final void clearColorx(int red, int green, int blue, int alpha) { glClearColorx(red, green, blue, alpha); }

	public abstract void glClearDepthx(int depth);
	public final void clearDepthx(int depth) { glClearDepthx(depth); }

	public abstract void glClientActiveTexture(int texture);
	public final void clientActiveTexture(TextureUnit texture) { glClientActiveTexture(texture.token); }

	public abstract void glClipPlanef(int p, long eqn);
	public final void clipPlanef(ClipPlaneName p, long eqn) { glClipPlanef(p.token, eqn); }

	public abstract void glClipPlanex(int plane, long equation);
	public final void clipPlanex(ClipPlaneName plane, long equation) { glClipPlanex(plane.token, equation); }

	public abstract void glColor4f(float red, float green, float blue, float alpha);
	public final void color4f(float red, float green, float blue, float alpha) { glColor4f(red, green, blue, alpha); }

	public abstract void glColor4ub(byte red, byte green, byte blue, byte alpha);
	public final void color4ub(byte red, byte green, byte blue, byte alpha) { glColor4ub(red, green, blue, alpha); }

	public abstract void glColor4x(int red, int green, int blue, int alpha);
	public final void color4x(int red, int green, int blue, int alpha) { glColor4x(red, green, blue, alpha); }

	public abstract void glColorPointer(int size, int type, int stride, long pointer);
	public final void colorPointer(int size, ColorPointerType type, int stride, long pointer) { glColorPointer(size, type.token, stride, pointer); }

	public abstract void glDepthRangex(int n, int f);
	public final void depthRangex(int n, int f) { glDepthRangex(n, f); }

	public abstract void glDisableClientState(int array);
	public final void disableClientState(Capability array) { glDisableClientState(array.token); }

	public abstract void glEnableClientState(int array);
	public final void enableClientState(Capability array) { glEnableClientState(array.token); }

	public abstract void glFogf(int pname, float param);
	public final void fogf(FogParameter pname, float param) { glFogf(pname.token, param); }

	public abstract void glFogfv(int pname, long params);
	public final void fogfv(FogParameter pname, long params) { glFogfv(pname.token, params); }

	public abstract void glFogx(int pname, int param);
	public final void fogx(FogPName pname, int param) { glFogx(pname.token, param); }

	public abstract void glFogxv(int pname, long param);
	public final void fogxv(FogPName pname, long param) { glFogxv(pname.token, param); }

	public abstract void glFrustumf(float l, float r, float b, float t, float n, float f);
	public final void frustumf(float l, float r, float b, float t, float n, float f) { glFrustumf(l, r, b, t, n, f); }

	public abstract void glFrustumx(int l, int r, int b, int t, int n, int f);
	public final void frustumx(int l, int r, int b, int t, int n, int f) { glFrustumx(l, r, b, t, n, f); }

	public abstract void glGetClipPlanef(int plane, long equation);
	public final void getClipPlanef(ClipPlaneName plane, long equation) { glGetClipPlanef(plane.token, equation); }

	public abstract void glGetClipPlanex(int plane, long equation);
	public final void getClipPlanex(ClipPlaneName plane, long equation) { glGetClipPlanex(plane.token, equation); }

	public abstract void glGetFixedv(int pname, long params);
	public final void getFixedv(GetPName pname, long params) { glGetFixedv(pname.token, params); }

	public abstract void glGetLightfv(int light, int pname, long params);
	public final void getLightfv(LightName light, LightParameter pname, long params) { glGetLightfv(light.token, pname.token, params); }

	public abstract void glGetLightxv(int light, int pname, long params);
	public final void getLightxv(LightName light, LightParameter pname, long params) { glGetLightxv(light.token, pname.token, params); }

	public abstract void glGetMaterialfv(int face, int pname, long params);
	public final void getMaterialfv(MaterialFace face, MaterialParameter pname, long params) { glGetMaterialfv(face.token, pname.token, params); }

	public abstract void glGetMaterialxv(int face, int pname, long params);
	public final void getMaterialxv(MaterialFace face, MaterialParameter pname, long params) { glGetMaterialxv(face.token, pname.token, params); }

	public abstract void glGetTexEnvfv(int target, int pname, long params);
	public final void getTexEnvfv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glGetTexEnvfv(target.token, pname.token, params); }

	public abstract void glGetTexEnviv(int target, int pname, long params);
	public final void getTexEnviv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glGetTexEnviv(target.token, pname.token, params); }

	public abstract void glGetTexEnvxv(int target, int pname, long params);
	public final void getTexEnvxv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glGetTexEnvxv(target.token, pname.token, params); }

	public abstract void glGetTexParameterxv(int target, int pname, long params);
	public final void getTexParameterxv(TextureTarget target, GetTextureParameter pname, long params) { glGetTexParameterxv(target.token, pname.token, params); }

	public abstract void glLightModelf(int pname, float param);
	public final void lightModelf(LightModelParameter pname, float param) { glLightModelf(pname.token, param); }

	public abstract void glLightModelfv(int pname, long params);
	public final void lightModelfv(LightModelParameter pname, long params) { glLightModelfv(pname.token, params); }

	public abstract void glLightModelx(int pname, int param);
	public final void lightModelx(LightModelParameter pname, int param) { glLightModelx(pname.token, param); }

	public abstract void glLightModelxv(int pname, long param);
	public final void lightModelxv(LightModelParameter pname, long param) { glLightModelxv(pname.token, param); }

	public abstract void glLightf(int light, int pname, float param);
	public final void lightf(LightName light, LightParameter pname, float param) { glLightf(light.token, pname.token, param); }

	public abstract void glLightfv(int light, int pname, long params);
	public final void lightfv(LightName light, LightParameter pname, long params) { glLightfv(light.token, pname.token, params); }

	public abstract void glLightx(int light, int pname, int param);
	public final void lightx(LightName light, LightParameter pname, int param) { glLightx(light.token, pname.token, param); }

	public abstract void glLightxv(int light, int pname, long params);
	public final void lightxv(LightName light, LightParameter pname, long params) { glLightxv(light.token, pname.token, params); }

	public abstract void glLineWidthx(int width);
	public final void lineWidthx(int width) { glLineWidthx(width); }

	public abstract void glLoadIdentity();
	public final void loadIdentity() { glLoadIdentity(); }

	public abstract void glLoadMatrixf(long m);
	public final void loadMatrixf(long m) { glLoadMatrixf(m); }

	public abstract void glLoadMatrixx(long m);
	public final void loadMatrixx(long m) { glLoadMatrixx(m); }

	public abstract void glMaterialf(int face, int pname, float param);
	public final void materialf(MaterialFace face, MaterialParameter pname, float param) { glMaterialf(face.token, pname.token, param); }

	public abstract void glMaterialfv(int face, int pname, long params);
	public final void materialfv(MaterialFace face, MaterialParameter pname, long params) { glMaterialfv(face.token, pname.token, params); }

	public abstract void glMaterialx(int face, int pname, int param);
	public final void materialx(MaterialFace face, MaterialParameter pname, int param) { glMaterialx(face.token, pname.token, param); }

	public abstract void glMaterialxv(int face, int pname, long param);
	public final void materialxv(MaterialFace face, MaterialParameter pname, long param) { glMaterialxv(face.token, pname.token, param); }

	public abstract void glMatrixMode(int mode);
	public final void matrixMode(MatrixMode mode) { glMatrixMode(mode.token); }

	public abstract void glMultMatrixf(long m);
	public final void multMatrixf(long m) { glMultMatrixf(m); }

	public abstract void glMultMatrixx(long m);
	public final void multMatrixx(long m) { glMultMatrixx(m); }

	public abstract void glMultiTexCoord4f(int target, float s, float t, float r, float q);
	public final void multiTexCoord4f(TextureUnit target, float s, float t, float r, float q) { glMultiTexCoord4f(target.token, s, t, r, q); }

	public abstract void glMultiTexCoord4x(int texture, int s, int t, int r, int q);
	public final void multiTexCoord4x(TextureUnit texture, int s, int t, int r, int q) { glMultiTexCoord4x(texture.token, s, t, r, q); }

	public abstract void glNormal3f(float nx, float ny, float nz);
	public final void normal3f(float nx, float ny, float nz) { glNormal3f(nx, ny, nz); }

	public abstract void glNormal3x(int nx, int ny, int nz);
	public final void normal3x(int nx, int ny, int nz) { glNormal3x(nx, ny, nz); }

	public abstract void glNormalPointer(int type, int stride, long pointer);
	public final void normalPointer(NormalPointerType type, int stride, long pointer) { glNormalPointer(type.token, stride, pointer); }

	public abstract void glOrthof(float l, float r, float b, float t, float n, float f);
	public final void orthof(float l, float r, float b, float t, float n, float f) { glOrthof(l, r, b, t, n, f); }

	public abstract void glOrthox(int l, int r, int b, int t, int n, int f);
	public final void orthox(int l, int r, int b, int t, int n, int f) { glOrthox(l, r, b, t, n, f); }

	public abstract void glPointParameterx(int pname, int param);
	public final void pointParameterx(int pname, int param) { glPointParameterx(pname, param); }

	public abstract void glPointParameterxv(int pname, long params);
	public final void pointParameterxv(int pname, long params) { glPointParameterxv(pname, params); }

	public abstract void glPointSizex(int size);
	public final void pointSizex(int size) { glPointSizex(size); }

	public abstract void glPolygonOffsetx(int factor, int units);
	public final void polygonOffsetx(int factor, int units) { glPolygonOffsetx(factor, units); }

	public abstract void glPopMatrix();
	public final void popMatrix() { glPopMatrix(); }

	public abstract void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW);
	public final void primitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) { glPrimitiveBoundingBox(minX, minY, minZ, minW, maxX, maxY, maxZ, maxW); }

	public abstract void glPushMatrix();
	public final void pushMatrix() { glPushMatrix(); }

	public abstract void glRotatef(float angle, float x, float y, float z);
	public final void rotatef(float angle, float x, float y, float z) { glRotatef(angle, x, y, z); }

	public abstract void glRotatex(int angle, int x, int y, int z);
	public final void rotatex(int angle, int x, int y, int z) { glRotatex(angle, x, y, z); }

	public abstract void glSampleCoveragex(int value, boolean invert);
	public final void sampleCoveragex(int value, boolean invert) { glSampleCoveragex(value, invert); }

	public abstract void glScalef(float x, float y, float z);
	public final void scalef(float x, float y, float z) { glScalef(x, y, z); }

	public abstract void glScalex(int x, int y, int z);
	public final void scalex(int x, int y, int z) { glScalex(x, y, z); }

	public abstract void glShadeModel(int mode);
	public final void shadeModel(ShadingModel mode) { glShadeModel(mode.token); }

	public abstract void glTexCoordPointer(int size, int type, int stride, long pointer);
	public final void texCoordPointer(int size, TexCoordPointerType type, int stride, long pointer) { glTexCoordPointer(size, type.token, stride, pointer); }

	public abstract void glTexEnvf(int target, int pname, float param);
	public final void texEnvf(TextureEnvTarget target, TextureEnvParameter pname, float param) { glTexEnvf(target.token, pname.token, param); }

	public abstract void glTexEnvfv(int target, int pname, long params);
	public final void texEnvfv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glTexEnvfv(target.token, pname.token, params); }

	public abstract void glTexEnvi(int target, int pname, int param);
	public final void texEnvi(TextureEnvTarget target, TextureEnvParameter pname, int param) { glTexEnvi(target.token, pname.token, param); }

	public abstract void glTexEnviv(int target, int pname, long params);
	public final void texEnviv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glTexEnviv(target.token, pname.token, params); }

	public abstract void glTexEnvx(int target, int pname, int param);
	public final void texEnvx(TextureEnvTarget target, TextureEnvParameter pname, int param) { glTexEnvx(target.token, pname.token, param); }

	public abstract void glTexEnvxv(int target, int pname, long params);
	public final void texEnvxv(TextureEnvTarget target, TextureEnvParameter pname, long params) { glTexEnvxv(target.token, pname.token, params); }

	public abstract void glTexParameterx(int target, int pname, int param);
	public final void texParameterx(TextureTarget target, GetTextureParameter pname, int param) { glTexParameterx(target.token, pname.token, param); }

	public abstract void glTexParameterxv(int target, int pname, long params);
	public final void texParameterxv(TextureTarget target, GetTextureParameter pname, long params) { glTexParameterxv(target.token, pname.token, params); }

	public abstract void glTranslatef(float x, float y, float z);
	public final void translatef(float x, float y, float z) { glTranslatef(x, y, z); }

	public abstract void glTranslatex(int x, int y, int z);
	public final void translatex(int x, int y, int z) { glTranslatex(x, y, z); }

	public abstract void glVertexPointer(int size, int type, int stride, long pointer);
	public final void vertexPointer(int size, VertexPointerType type, int stride, long pointer) { glVertexPointer(size, type.token, stride, pointer); }

}