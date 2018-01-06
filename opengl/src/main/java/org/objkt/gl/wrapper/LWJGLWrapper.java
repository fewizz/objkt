package org.objkt.gl.wrapper;

public class LWJGLWrapper extends GLWrapper {
	@Override
	public void glActiveShaderProgram(int pipeline, int program) { org.lwjgl.opengl.GL41.glActiveShaderProgram(pipeline, program); }

	@Override
	public void glActiveTexture(int texture) { org.lwjgl.opengl.GL13.glActiveTexture(texture); }

	@Override
	public void glAttachShader(int program, int shader) { org.lwjgl.opengl.GL20.glAttachShader(program, shader); }

	@Override
	public void glBeginConditionalRender(int id, int mode) { org.lwjgl.opengl.GL30.glBeginConditionalRender(id, mode); }

	@Override
	public void glBeginQuery(int target, int id) { org.lwjgl.opengl.GL15.glBeginQuery(target, id); }

	@Override
	public void glBeginQueryIndexed(int target, int index, int id) { org.lwjgl.opengl.GL40.glBeginQueryIndexed(target, index, id); }

	@Override
	public void glBeginTransformFeedback(int primitiveMode) { org.lwjgl.opengl.GL30.glBeginTransformFeedback(primitiveMode); }

	@Override
	public void glBindAttribLocation(int program, int index, long name) { org.lwjgl.opengl.GL20.nglBindAttribLocation(program, index, name); }

	@Override
	public void glBindBuffer(int target, int buffer) { org.lwjgl.opengl.GL15.glBindBuffer(target, buffer); }

	@Override
	public void glBindBufferBase(int target, int index, int buffer) { org.lwjgl.opengl.GL30.glBindBufferBase(target, index, buffer); }

	@Override
	public void glBindBufferRange(int target, int index, int buffer, long offset, long size) { org.lwjgl.opengl.GL30.glBindBufferRange(target, index, buffer, offset, size); }

	@Override
	public void glBindBuffersBase(int target, int first, int count, long buffers) { org.lwjgl.opengl.GL44.nglBindBuffersBase(target, first, count, buffers); }

	@Override
	public void glBindBuffersRange(int target, int first, int count, long buffers, long offsets, long sizes) { org.lwjgl.opengl.GL44.nglBindBuffersRange(target, first, count, buffers, offsets, sizes); }

	@Override
	public void glBindFragDataLocation(int program, int color, long name) { org.lwjgl.opengl.GL30.nglBindFragDataLocation(program, color, name); }

	@Override
	public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, long name) { org.lwjgl.opengl.GL33.nglBindFragDataLocationIndexed(program, colorNumber, index, name); }

	@Override
	public void glBindFramebuffer(int target, int framebuffer) { org.lwjgl.opengl.GL30.glBindFramebuffer(target, framebuffer); }

	@Override
	public void glBindImageTexture(int unit, int texture, int level, boolean layered, int layer, int access, int format) { org.lwjgl.opengl.GL42.glBindImageTexture(unit, texture, level, layered, layer, access, format); }

	@Override
	public void glBindImageTextures(int first, int count, long textures) { org.lwjgl.opengl.GL44.nglBindImageTextures(first, count, textures); }

	@Override
	public void glBindProgramPipeline(int pipeline) { org.lwjgl.opengl.GL41.glBindProgramPipeline(pipeline); }

	@Override
	public void glBindRenderbuffer(int target, int renderbuffer) { org.lwjgl.opengl.GL30.glBindRenderbuffer(target, renderbuffer); }

	@Override
	public void glBindSampler(int unit, int sampler) { org.lwjgl.opengl.GL33.glBindSampler(unit, sampler); }

	@Override
	public void glBindSamplers(int first, int count, long samplers) { org.lwjgl.opengl.GL44.nglBindSamplers(first, count, samplers); }

	@Override
	public void glBindTexture(int target, int texture) { org.lwjgl.opengl.GL11.glBindTexture(target, texture); }

	@Override
	public void glBindTextureUnit(int unit, int texture) { org.lwjgl.opengl.GL45.glBindTextureUnit(unit, texture); }

	@Override
	public void glBindTextures(int first, int count, long textures) { org.lwjgl.opengl.GL44.nglBindTextures(first, count, textures); }

	@Override
	public void glBindTransformFeedback(int target, int id) { org.lwjgl.opengl.GL40.glBindTransformFeedback(target, id); }

	@Override
	public void glBindVertexArray(int array) { org.lwjgl.opengl.GL30.glBindVertexArray(array); }

	@Override
	public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) { org.lwjgl.opengl.GL43.glBindVertexBuffer(bindingindex, buffer, offset, stride); }

	@Override
	public void glBindVertexBuffers(int first, int count, long buffers, long offsets, long strides) { org.lwjgl.opengl.GL44.nglBindVertexBuffers(first, count, buffers, offsets, strides); }

	@Override
	public void glBlendColor(float red, float green, float blue, float alpha) { org.lwjgl.opengl.GL14.glBlendColor(red, green, blue, alpha); }

	@Override
	public void glBlendEquation(int mode) { org.lwjgl.opengl.GL14.glBlendEquation(mode); }

	@Override
	public void glBlendEquationSeparate(int modeRGB, int modeAlpha) { org.lwjgl.opengl.GL20.glBlendEquationSeparate(modeRGB, modeAlpha); }

	@Override
	public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) { org.lwjgl.opengl.GL40.glBlendEquationSeparatei(buf, modeRGB, modeAlpha); }

	@Override
	public void glBlendEquationi(int buf, int mode) { org.lwjgl.opengl.GL40.glBlendEquationi(buf, mode); }

	@Override
	public void glBlendFunc(int sfactor, int dfactor) { org.lwjgl.opengl.GL11.glBlendFunc(sfactor, dfactor); }

	@Override
	public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) { org.lwjgl.opengl.GL14.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha); }

	@Override
	public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) { org.lwjgl.opengl.GL40.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha); }

	@Override
	public void glBlendFunci(int buf, int src, int dst) { org.lwjgl.opengl.GL40.glBlendFunci(buf, src, dst); }

	@Override
	public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) { org.lwjgl.opengl.GL30.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter); }

	@Override
	public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) { org.lwjgl.opengl.GL45.glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter); }

	@Override
	public void glBufferData(int target, long size, long data, int usage) { org.lwjgl.opengl.GL15.nglBufferData(target, size, data, usage); }

	@Override
	public void glBufferStorage(int target, long size, long data, int flags) { org.lwjgl.opengl.GL44.nglBufferStorage(target, size, data, flags); }

	@Override
	public void glBufferSubData(int target, long offset, long size, long data) { org.lwjgl.opengl.GL15.nglBufferSubData(target, offset, size, data); }

	@Override
	public int glCheckFramebufferStatus(int target) { return org.lwjgl.opengl.GL30.glCheckFramebufferStatus(target); }

	@Override
	public int glCheckNamedFramebufferStatus(int framebuffer, int target) { return org.lwjgl.opengl.GL45.glCheckNamedFramebufferStatus(framebuffer, target); }

	@Override
	public void glClampColor(int target, int clamp) { org.lwjgl.opengl.GL30.glClampColor(target, clamp); }

	@Override
	public void glClear(int mask) { org.lwjgl.opengl.GL11.glClear(mask); }

	@Override
	public void glClearBufferData(int target, int internalformat, int format, int type, long data) { org.lwjgl.opengl.GL43.nglClearBufferData(target, internalformat, format, type, data); }

	@Override
	public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, long data) { org.lwjgl.opengl.GL43.nglClearBufferSubData(target, internalformat, offset, size, format, type, data); }

	@Override
	public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) { org.lwjgl.opengl.GL30.glClearBufferfi(buffer, drawbuffer, depth, stencil); }

	@Override
	public void glClearBufferfv(int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL30.nglClearBufferfv(buffer, drawbuffer, value); }

	@Override
	public void glClearBufferiv(int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL30.nglClearBufferiv(buffer, drawbuffer, value); }

	@Override
	public void glClearBufferuiv(int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL30.nglClearBufferuiv(buffer, drawbuffer, value); }

	@Override
	public void glClearColor(float red, float green, float blue, float alpha) { org.lwjgl.opengl.GL11.glClearColor(red, green, blue, alpha); }

	@Override
	public void glClearDepth(double depth) { org.lwjgl.opengl.GL11.glClearDepth(depth); }

	@Override
	public void glClearDepthf(float d) { org.lwjgl.opengl.GL41.glClearDepthf(d); }

	@Override
	public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, long data) { org.lwjgl.opengl.GL45.nglClearNamedBufferData(buffer, internalformat, format, type, data); }

	@Override
	public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, long data) { org.lwjgl.opengl.GL45.nglClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data); }

	@Override
	public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil) { org.lwjgl.opengl.GL45.glClearNamedFramebufferfi(framebuffer, buffer, drawbuffer, depth, stencil); }

	@Override
	public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL45.nglClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value); }

	@Override
	public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL45.nglClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value); }

	@Override
	public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, long value) { org.lwjgl.opengl.GL45.nglClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value); }

	@Override
	public void glClearStencil(int s) { org.lwjgl.opengl.GL11.glClearStencil(s); }

	@Override
	public void glClearTexImage(int texture, int level, int format, int type, long data) { org.lwjgl.opengl.GL44.nglClearTexImage(texture, level, format, type, data); }

	@Override
	public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long data) { org.lwjgl.opengl.GL44.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data); }

	@Override
	public int glClientWaitSync(long sync, int flags, long timeout) { return org.lwjgl.opengl.GL32.nglClientWaitSync(sync, flags, timeout); }

	@Override
	public void glClipControl(int origin, int depth) { org.lwjgl.opengl.GL45.glClipControl(origin, depth); }

	@Override
	public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) { org.lwjgl.opengl.GL11.glColorMask(red, green, blue, alpha); }

	@Override
	public void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a) { org.lwjgl.opengl.GL30.glColorMaski(index, r, g, b, a); }

	@Override
	public void glCompileShader(int shader) { org.lwjgl.opengl.GL20.glCompileShader(shader); }

	@Override
	public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data) { org.lwjgl.opengl.GL13.nglCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data); }

	@Override
	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data) { org.lwjgl.opengl.GL13.nglCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data); }

	@Override
	public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data) { org.lwjgl.opengl.GL13.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data); }

	@Override
	public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data) { org.lwjgl.opengl.GL13.nglCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data); }

	@Override
	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) { org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data); }

	@Override
	public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) { org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data); }

	@Override
	public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, long data) { org.lwjgl.opengl.GL45.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data); }

	@Override
	public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data) { org.lwjgl.opengl.GL45.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data); }

	@Override
	public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data) { org.lwjgl.opengl.GL45.nglCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data); }

	@Override
	public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) { org.lwjgl.opengl.GL31.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size); }

	@Override
	public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) { org.lwjgl.opengl.GL43.glCopyImageSubData(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth); }

	@Override
	public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) { org.lwjgl.opengl.GL45.glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size); }

	@Override
	public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) { org.lwjgl.opengl.GL11.glCopyTexImage1D(target, level, internalformat, x, y, width, border); }

	@Override
	public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) { org.lwjgl.opengl.GL11.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border); }

	@Override
	public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) { org.lwjgl.opengl.GL11.glCopyTexSubImage1D(target, level, xoffset, x, y, width); }

	@Override
	public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) { org.lwjgl.opengl.GL11.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height); }

	@Override
	public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) { org.lwjgl.opengl.GL12.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height); }

	@Override
	public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) { org.lwjgl.opengl.GL45.glCopyTextureSubImage1D(texture, level, xoffset, x, y, width); }

	@Override
	public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) { org.lwjgl.opengl.GL45.glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height); }

	@Override
	public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) { org.lwjgl.opengl.GL45.glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height); }

	@Override
	public void glCreateBuffers(int n, long buffers) { org.lwjgl.opengl.GL45.nglCreateBuffers(n, buffers); }

	@Override
	public void glCreateFramebuffers(int n, long framebuffers) { org.lwjgl.opengl.GL45.nglCreateFramebuffers(n, framebuffers); }

	@Override
	public int glCreateProgram() { return org.lwjgl.opengl.GL20.glCreateProgram(); }

	@Override
	public void glCreateProgramPipelines(int n, long pipelines) { org.lwjgl.opengl.GL45.nglCreateProgramPipelines(n, pipelines); }

	@Override
	public void glCreateQueries(int target, int n, long ids) { org.lwjgl.opengl.GL45.nglCreateQueries(target, n, ids); }

	@Override
	public void glCreateRenderbuffers(int n, long renderbuffers) { org.lwjgl.opengl.GL45.nglCreateRenderbuffers(n, renderbuffers); }

	@Override
	public void glCreateSamplers(int n, long samplers) { org.lwjgl.opengl.GL45.nglCreateSamplers(n, samplers); }

	@Override
	public int glCreateShader(int type) { return org.lwjgl.opengl.GL20.glCreateShader(type); }

	@Override
	public int glCreateShaderProgramv(int type, int count, long strings) { return org.lwjgl.opengl.GL41.nglCreateShaderProgramv(type, count, strings); }

	@Override
	public void glCreateTextures(int target, int n, long textures) { org.lwjgl.opengl.GL45.nglCreateTextures(target, n, textures); }

	@Override
	public void glCreateTransformFeedbacks(int n, long ids) { org.lwjgl.opengl.GL45.nglCreateTransformFeedbacks(n, ids); }

	@Override
	public void glCreateVertexArrays(int n, long arrays) { org.lwjgl.opengl.GL45.nglCreateVertexArrays(n, arrays); }

	@Override
	public void glCullFace(int mode) { org.lwjgl.opengl.GL11.glCullFace(mode); }

	@Override
	public void glDebugMessageCallback(long callback, long userParam) { org.lwjgl.opengl.GL43.nglDebugMessageCallback(callback, userParam); }

	@Override
	public void glDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled) { org.lwjgl.opengl.GL43.nglDebugMessageControl(source, type, severity, count, ids, enabled); }

	@Override
	public void glDebugMessageInsert(int source, int type, int id, int severity, int length, long buf) { org.lwjgl.opengl.GL43.nglDebugMessageInsert(source, type, id, severity, length, buf); }

	@Override
	public void glDeleteBuffers(int n, long buffers) { org.lwjgl.opengl.GL15.nglDeleteBuffers(n, buffers); }

	@Override
	public void glDeleteFramebuffers(int n, long framebuffers) { org.lwjgl.opengl.GL30.nglDeleteFramebuffers(n, framebuffers); }

	@Override
	public void glDeleteProgram(int program) { org.lwjgl.opengl.GL20.glDeleteProgram(program); }

	@Override
	public void glDeleteProgramPipelines(int n, long pipelines) { org.lwjgl.opengl.GL41.nglDeleteProgramPipelines(n, pipelines); }

	@Override
	public void glDeleteQueries(int n, long ids) { org.lwjgl.opengl.GL15.nglDeleteQueries(n, ids); }

	@Override
	public void glDeleteRenderbuffers(int n, long renderbuffers) { org.lwjgl.opengl.GL30.nglDeleteRenderbuffers(n, renderbuffers); }

	@Override
	public void glDeleteSamplers(int count, long samplers) { org.lwjgl.opengl.GL33.nglDeleteSamplers(count, samplers); }

	@Override
	public void glDeleteShader(int shader) { org.lwjgl.opengl.GL20.glDeleteShader(shader); }

	@Override
	public void glDeleteSync(long sync) { org.lwjgl.opengl.GL32.glDeleteSync(sync); }

	@Override
	public void glDeleteTextures(int n, long textures) { org.lwjgl.opengl.GL11.nglDeleteTextures(n, textures); }

	@Override
	public void glDeleteTransformFeedbacks(int n, long ids) { org.lwjgl.opengl.GL40.nglDeleteTransformFeedbacks(n, ids); }

	@Override
	public void glDeleteVertexArrays(int n, long arrays) { org.lwjgl.opengl.GL30.nglDeleteVertexArrays(n, arrays); }

	@Override
	public void glDepthFunc(int func) { org.lwjgl.opengl.GL11.glDepthFunc(func); }

	@Override
	public void glDepthMask(boolean flag) { org.lwjgl.opengl.GL11.glDepthMask(flag); }

	@Override
	public void glDepthRange(double near, double far) { org.lwjgl.opengl.GL11.glDepthRange(near, far); }

	@Override
	public void glDepthRangeArrayv(int first, int count, long v) { org.lwjgl.opengl.GL41.nglDepthRangeArrayv(first, count, v); }

	@Override
	public void glDepthRangeIndexed(int index, double n, double f) { org.lwjgl.opengl.GL41.glDepthRangeIndexed(index, n, f); }

	@Override
	public void glDepthRangef(float n, float f) { org.lwjgl.opengl.GL41.glDepthRangef(n, f); }

	@Override
	public void glDetachShader(int program, int shader) { org.lwjgl.opengl.GL20.glDetachShader(program, shader); }

	@Override
	public void glDisable(int cap) { org.lwjgl.opengl.GL11.glDisable(cap); }

	@Override
	public void glDisableVertexArrayAttrib(int vaobj, int index) { org.lwjgl.opengl.GL45.glDisableVertexArrayAttrib(vaobj, index); }

	@Override
	public void glDisableVertexAttribArray(int index) { org.lwjgl.opengl.GL20.glDisableVertexAttribArray(index); }

	@Override
	public void glDisablei(int target, int index) { org.lwjgl.opengl.GL30.glDisablei(target, index); }

	@Override
	public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) { org.lwjgl.opengl.GL43.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z); }

	@Override
	public void glDispatchComputeIndirect(long indirect) { org.lwjgl.opengl.GL43.glDispatchComputeIndirect(indirect); }

	@Override
	public void glDrawArrays(int mode, int first, int count) { org.lwjgl.opengl.GL11.glDrawArrays(mode, first, count); }

	@Override
	public void glDrawArraysIndirect(int mode, long indirect) { org.lwjgl.opengl.GL40.nglDrawArraysIndirect(mode, indirect); }

	@Override
	public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) { org.lwjgl.opengl.GL31.glDrawArraysInstanced(mode, first, count, instancecount); }

	@Override
	public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance) { org.lwjgl.opengl.GL42.glDrawArraysInstancedBaseInstance(mode, first, count, instancecount, baseinstance); }

	@Override
	public void glDrawBuffer(int buf) { org.lwjgl.opengl.GL11.glDrawBuffer(buf); }

	@Override
	public void glDrawBuffers(int n, long bufs) { org.lwjgl.opengl.GL20.nglDrawBuffers(n, bufs); }

	@Override
	public void glDrawElements(int mode, int count, int type, long indices) { org.lwjgl.opengl.GL11.glDrawElements(mode, count, type, indices); }

	@Override
	public void glDrawElementsBaseVertex(int mode, int count, int type, long indices, int basevertex) { org.lwjgl.opengl.GL32.glDrawElementsBaseVertex(mode, count, type, indices, basevertex); }

	@Override
	public void glDrawElementsIndirect(int mode, int type, long indirect) { org.lwjgl.opengl.GL40.glDrawElementsIndirect(mode, type, indirect); }

	@Override
	public void glDrawElementsInstanced(int mode, int count, int type, long indices, int instancecount) { org.lwjgl.opengl.GL31.nglDrawElementsInstanced(mode, count, type, indices, instancecount); }

	@Override
	public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, long indices, int instancecount, int baseinstance) { org.lwjgl.opengl.GL42.nglDrawElementsInstancedBaseInstance(mode, count, type, indices, instancecount, baseinstance); }

	@Override
	public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int instancecount, int basevertex) { org.lwjgl.opengl.GL32.glDrawElementsInstancedBaseVertex(mode, count, type, indices, instancecount, basevertex); }

	@Override
	public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, long indices, int instancecount, int basevertex, int baseinstance) { org.lwjgl.opengl.GL42.nglDrawElementsInstancedBaseVertexBaseInstance(mode, count, type, indices, instancecount, basevertex, baseinstance); }

	@Override
	public void glDrawRangeElements(int mode, int start, int end, int count, int type, long indices) { org.lwjgl.opengl.GL12.glDrawRangeElements(mode, start, end, count, type, indices); }

	@Override
	public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices, int basevertex) { org.lwjgl.opengl.GL32.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex); }

	@Override
	public void glDrawTransformFeedback(int mode, int id) { org.lwjgl.opengl.GL40.glDrawTransformFeedback(mode, id); }

	@Override
	public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount) { org.lwjgl.opengl.GL42.glDrawTransformFeedbackInstanced(mode, id, instancecount); }

	@Override
	public void glDrawTransformFeedbackStream(int mode, int id, int stream) { org.lwjgl.opengl.GL40.glDrawTransformFeedbackStream(mode, id, stream); }

	@Override
	public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount) { org.lwjgl.opengl.GL42.glDrawTransformFeedbackStreamInstanced(mode, id, stream, instancecount); }

	@Override
	public void glEnable(int cap) { org.lwjgl.opengl.GL11.glEnable(cap); }

	@Override
	public void glEnableVertexArrayAttrib(int vaobj, int index) { org.lwjgl.opengl.GL45.glEnableVertexArrayAttrib(vaobj, index); }

	@Override
	public void glEnableVertexAttribArray(int index) { org.lwjgl.opengl.GL20.glEnableVertexAttribArray(index); }

	@Override
	public void glEnablei(int target, int index) { org.lwjgl.opengl.GL30.glEnablei(target, index); }

	@Override
	public void glEndConditionalRender() { org.lwjgl.opengl.GL30.glEndConditionalRender(); }

	@Override
	public void glEndQuery(int target) { org.lwjgl.opengl.GL15.glEndQuery(target); }

	@Override
	public void glEndQueryIndexed(int target, int index) { org.lwjgl.opengl.GL40.glEndQueryIndexed(target, index); }

	@Override
	public void glEndTransformFeedback() { org.lwjgl.opengl.GL30.glEndTransformFeedback(); }

	@Override
	public long glFenceSync(int condition, int flags) { return org.lwjgl.opengl.GL32.glFenceSync(condition, flags); }

	@Override
	public void glFinish() { org.lwjgl.opengl.GL11.glFinish(); }

	@Override
	public void glFlush() { org.lwjgl.opengl.GL11.glFlush(); }

	@Override
	public void glFlushMappedBufferRange(int target, long offset, long length) { org.lwjgl.opengl.GL30.glFlushMappedBufferRange(target, offset, length); }

	@Override
	public void glFlushMappedNamedBufferRange(int buffer, long offset, long length) { org.lwjgl.opengl.GL45.glFlushMappedNamedBufferRange(buffer, offset, length); }

	@Override
	public void glFramebufferParameteri(int target, int pname, int param) { org.lwjgl.opengl.GL43.glFramebufferParameteri(target, pname, param); }

	@Override
	public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) { org.lwjgl.opengl.GL30.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer); }

	@Override
	public void glFramebufferTexture(int target, int attachment, int texture, int level) { org.lwjgl.opengl.GL32.glFramebufferTexture(target, attachment, texture, level); }

	@Override
	public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) { org.lwjgl.opengl.GL30.glFramebufferTexture1D(target, attachment, textarget, texture, level); }

	@Override
	public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) { org.lwjgl.opengl.GL30.glFramebufferTexture2D(target, attachment, textarget, texture, level); }

	@Override
	public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) { org.lwjgl.opengl.GL30.glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset); }

	@Override
	public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) { org.lwjgl.opengl.GL30.glFramebufferTextureLayer(target, attachment, texture, level, layer); }

	@Override
	public void glFrontFace(int mode) { org.lwjgl.opengl.GL11.glFrontFace(mode); }

	@Override
	public void glGenBuffers(int n, long buffers) { org.lwjgl.opengl.GL15.nglGenBuffers(n, buffers); }

	@Override
	public void glGenFramebuffers(int n, long framebuffers) { org.lwjgl.opengl.GL30.nglGenFramebuffers(n, framebuffers); }

	@Override
	public void glGenProgramPipelines(int n, long pipelines) { org.lwjgl.opengl.GL41.nglGenProgramPipelines(n, pipelines); }

	@Override
	public void glGenQueries(int n, long ids) { org.lwjgl.opengl.GL15.nglGenQueries(n, ids); }

	@Override
	public void glGenRenderbuffers(int n, long renderbuffers) { org.lwjgl.opengl.GL30.nglGenRenderbuffers(n, renderbuffers); }

	@Override
	public void glGenSamplers(int count, long samplers) { org.lwjgl.opengl.GL33.nglGenSamplers(count, samplers); }

	@Override
	public void glGenTextures(int n, long textures) { org.lwjgl.opengl.GL11.nglGenTextures(n, textures); }

	@Override
	public void glGenTransformFeedbacks(int n, long ids) { org.lwjgl.opengl.GL40.nglGenTransformFeedbacks(n, ids); }

	@Override
	public void glGenVertexArrays(int n, long arrays) { org.lwjgl.opengl.GL30.nglGenVertexArrays(n, arrays); }

	@Override
	public void glGenerateMipmap(int target) { org.lwjgl.opengl.GL30.glGenerateMipmap(target); }

	@Override
	public void glGenerateTextureMipmap(int texture) { org.lwjgl.opengl.GL45.glGenerateTextureMipmap(texture); }

	@Override
	public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, long params) { org.lwjgl.opengl.GL42.nglGetActiveAtomicCounterBufferiv(program, bufferIndex, pname, params); }

	@Override
	public void glGetActiveAttrib(int program, int index, int bufSize, long length, long size, long type, long name) { org.lwjgl.opengl.GL20.nglGetActiveAttrib(program, index, bufSize, length, size, type, name); }

	@Override
	public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufsize, long length, long name) { org.lwjgl.opengl.GL40.nglGetActiveSubroutineName(program, shadertype, index, bufsize, length, name); }

	@Override
	public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize, long length, long name) { org.lwjgl.opengl.GL40.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, length, name); }

	@Override
	public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, long values) { org.lwjgl.opengl.GL40.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values); }

	@Override
	public void glGetActiveUniform(int program, int index, int bufSize, long length, long size, long type, long name) { org.lwjgl.opengl.GL20.nglGetActiveUniform(program, index, bufSize, length, size, type, name); }

	@Override
	public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, long length, long uniformBlockName) { org.lwjgl.opengl.GL31.nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName); }

	@Override
	public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, long params) { org.lwjgl.opengl.GL31.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params); }

	@Override
	public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, long length, long uniformName) { org.lwjgl.opengl.GL31.nglGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName); }

	@Override
	public void glGetActiveUniformsiv(int program, int uniformCount, long uniformIndices, int pname, long params) { org.lwjgl.opengl.GL31.nglGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params); }

	@Override
	public void glGetAttachedShaders(int program, int maxCount, long count, long shaders) { org.lwjgl.opengl.GL20.nglGetAttachedShaders(program, maxCount, count, shaders); }

	@Override
	public int glGetAttribLocation(int program, long name) { return org.lwjgl.opengl.GL20.nglGetAttribLocation(program, name); }

	@Override
	public void glGetBooleani_v(int target, int index, long data) { org.lwjgl.opengl.GL30.nglGetBooleani_v(target, index, data); }

	@Override
	public void glGetBooleanv(int pname, long data) { org.lwjgl.opengl.GL11.nglGetBooleanv(pname, data); }

	@Override
	public void glGetBufferParameteri64v(int target, int pname, long params) { org.lwjgl.opengl.GL32.nglGetBufferParameteri64v(target, pname, params); }

	@Override
	public void glGetBufferParameteriv(int target, int pname, long params) { org.lwjgl.opengl.GL15.nglGetBufferParameteriv(target, pname, params); }

	@Override
	public void glGetBufferPointerv(int target, int pname, long params) { org.lwjgl.opengl.GL15.nglGetBufferPointerv(target, pname, params); }

	@Override
	public void glGetBufferSubData(int target, long offset, long size, long data) { org.lwjgl.opengl.GL15.nglGetBufferSubData(target, offset, size, data); }

	@Override
	public void glGetCompressedTexImage(int target, int level, long img) { org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, level, img); }

	@Override
	public void glGetCompressedTextureImage(int texture, int level, int bufSize, long pixels) { org.lwjgl.opengl.GL45.nglGetCompressedTextureImage(texture, level, bufSize, pixels); }

	@Override
	public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) { org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels); }

	@Override
	public int glGetDebugMessageLog(int count, int bufSize, long sources, long types, long ids, long severities, long lengths, long messageLog) { return org.lwjgl.opengl.GL43.nglGetDebugMessageLog(count, bufSize, sources, types, ids, severities, lengths, messageLog); }

	@Override
	public void glGetDoublei_v(int target, int index, long data) { org.lwjgl.opengl.GL41.nglGetDoublei_v(target, index, data); }

	@Override
	public void glGetDoublev(int pname, long data) { org.lwjgl.opengl.GL11.nglGetDoublev(pname, data); }

	@Override
	public int glGetError() { return org.lwjgl.opengl.GL11.glGetError(); }

	@Override
	public void glGetFloati_v(int target, int index, long data) { org.lwjgl.opengl.GL41.nglGetFloati_v(target, index, data); }

	@Override
	public void glGetFloatv(int pname, long data) { org.lwjgl.opengl.GL11.nglGetFloatv(pname, data); }

	@Override
	public int glGetFragDataIndex(int program, long name) { return org.lwjgl.opengl.GL33.nglGetFragDataIndex(program, name); }

	@Override
	public int glGetFragDataLocation(int program, long name) { return org.lwjgl.opengl.GL30.nglGetFragDataLocation(program, name); }

	@Override
	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, long params) { org.lwjgl.opengl.GL30.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params); }

	@Override
	public void glGetFramebufferParameteriv(int target, int pname, long params) { org.lwjgl.opengl.GL43.nglGetFramebufferParameteriv(target, pname, params); }

	@Override
	public int glGetGraphicsResetStatus() { return org.lwjgl.opengl.GL45.glGetGraphicsResetStatus(); }

	@Override
	public void glGetInteger64i_v(int target, int index, long data) { org.lwjgl.opengl.GL32.nglGetInteger64i_v(target, index, data); }

	@Override
	public void glGetInteger64v(int pname, long data) { org.lwjgl.opengl.GL32.nglGetInteger64v(pname, data); }

	@Override
	public void glGetIntegeri_v(int target, int index, long data) { org.lwjgl.opengl.GL30.nglGetIntegeri_v(target, index, data); }

	@Override
	public void glGetIntegerv(int pname, long data) { org.lwjgl.opengl.GL11.nglGetIntegerv(pname, data); }

	@Override
	public void glGetInternalformati64v(int target, int internalformat, int pname, int bufSize, long params) { org.lwjgl.opengl.GL43.nglGetInternalformati64v(target, internalformat, pname, bufSize, params); }

	@Override
	public void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, long params) { org.lwjgl.opengl.GL42.nglGetInternalformativ(target, internalformat, pname, bufSize, params); }

	@Override
	public void glGetMultisamplefv(int pname, int index, long val) { org.lwjgl.opengl.GL32.nglGetMultisamplefv(pname, index, val); }

	@Override
	public void glGetNamedBufferParameteri64v(int buffer, int pname, long params) { org.lwjgl.opengl.GL45.nglGetNamedBufferParameteri64v(buffer, pname, params); }

	@Override
	public void glGetNamedBufferParameteriv(int buffer, int pname, long params) { org.lwjgl.opengl.GL45.nglGetNamedBufferParameteriv(buffer, pname, params); }

	@Override
	public void glGetNamedBufferPointerv(int buffer, int pname, long params) { org.lwjgl.opengl.GL45.nglGetNamedBufferPointerv(buffer, pname, params); }

	@Override
	public void glGetNamedBufferSubData(int buffer, long offset, long size, long data) { org.lwjgl.opengl.GL45.nglGetNamedBufferSubData(buffer, offset, size, data); }

	@Override
	public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, long params) { org.lwjgl.opengl.GL45.nglGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params); }

	@Override
	public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, long param) { org.lwjgl.opengl.GL45.nglGetNamedFramebufferParameteriv(framebuffer, pname, param); }

	@Override
	public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, long params) { org.lwjgl.opengl.GL45.nglGetNamedRenderbufferParameteriv(renderbuffer, pname, params); }

	@Override
	public void glGetObjectLabel(int identifier, int name, int bufSize, long length, long label) { org.lwjgl.opengl.GL43.nglGetObjectLabel(identifier, name, bufSize, length, label); }

	@Override
	public void glGetObjectPtrLabel(long ptr, int bufSize, long length, long label) { org.lwjgl.opengl.GL43.nglGetObjectPtrLabel(ptr, bufSize, length, label); }

	@Override
	public void glGetPointerv(int pname, long params) { org.lwjgl.opengl.GL11.nglGetPointerv(pname, params); }

	@Override
	public void glGetProgramBinary(int program, int bufSize, long length, long binaryFormat, long binary) { org.lwjgl.opengl.GL41.nglGetProgramBinary(program, bufSize, length, binaryFormat, binary); }

	@Override
	public void glGetProgramInfoLog(int program, int bufSize, long length, long infoLog) { org.lwjgl.opengl.GL20.nglGetProgramInfoLog(program, bufSize, length, infoLog); }

	@Override
	public void glGetProgramInterfaceiv(int program, int programInterface, int pname, long params) { org.lwjgl.opengl.GL43.nglGetProgramInterfaceiv(program, programInterface, pname, params); }

	@Override
	public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog) { org.lwjgl.opengl.GL41.nglGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog); }

	@Override
	public void glGetProgramPipelineiv(int pipeline, int pname, long params) { org.lwjgl.opengl.GL41.nglGetProgramPipelineiv(pipeline, pname, params); }

	@Override
	public int glGetProgramResourceIndex(int program, int programInterface, long name) { return org.lwjgl.opengl.GL43.nglGetProgramResourceIndex(program, programInterface, name); }

	@Override
	public int glGetProgramResourceLocation(int program, int programInterface, long name) { return org.lwjgl.opengl.GL43.nglGetProgramResourceLocation(program, programInterface, name); }

	@Override
	public int glGetProgramResourceLocationIndex(int program, int programInterface, long name) { return org.lwjgl.opengl.GL43.nglGetProgramResourceLocationIndex(program, programInterface, name); }

	@Override
	public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, long length, long name) { org.lwjgl.opengl.GL43.nglGetProgramResourceName(program, programInterface, index, bufSize, length, name); }

	@Override
	public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, long props, int bufSize, long length, long params) { org.lwjgl.opengl.GL43.nglGetProgramResourceiv(program, programInterface, index, propCount, props, bufSize, length, params); }

	@Override
	public void glGetProgramStageiv(int program, int shadertype, int pname, long values) { org.lwjgl.opengl.GL40.nglGetProgramStageiv(program, shadertype, pname, values); }

	@Override
	public void glGetProgramiv(int program, int pname, long params) { org.lwjgl.opengl.GL20.nglGetProgramiv(program, pname, params); }

	@Override
	public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset) { org.lwjgl.opengl.GL45.glGetQueryBufferObjecti64v(id, buffer, pname, offset); }

	@Override
	public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset) { org.lwjgl.opengl.GL45.glGetQueryBufferObjectiv(id, buffer, pname, offset); }

	@Override
	public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset) { org.lwjgl.opengl.GL45.glGetQueryBufferObjectui64v(id, buffer, pname, offset); }

	@Override
	public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset) { org.lwjgl.opengl.GL45.glGetQueryBufferObjectuiv(id, buffer, pname, offset); }

	@Override
	public void glGetQueryIndexediv(int target, int index, int pname, long params) { org.lwjgl.opengl.GL40.nglGetQueryIndexediv(target, index, pname, params); }

	@Override
	public void glGetQueryObjecti64v(int id, int pname, long params) { org.lwjgl.opengl.GL33.nglGetQueryObjecti64v(id, pname, params); }

	@Override
	public void glGetQueryObjectiv(int id, int pname, long params) { org.lwjgl.opengl.GL15.nglGetQueryObjectiv(id, pname, params); }

	@Override
	public void glGetQueryObjectui64v(int id, int pname, long params) { org.lwjgl.opengl.GL33.nglGetQueryObjectui64v(id, pname, params); }

	@Override
	public void glGetQueryObjectuiv(int id, int pname, long params) { org.lwjgl.opengl.GL15.nglGetQueryObjectuiv(id, pname, params); }

	@Override
	public void glGetQueryiv(int target, int pname, long params) { org.lwjgl.opengl.GL15.nglGetQueryiv(target, pname, params); }

	@Override
	public void glGetRenderbufferParameteriv(int target, int pname, long params) { org.lwjgl.opengl.GL30.nglGetRenderbufferParameteriv(target, pname, params); }

	@Override
	public void glGetSamplerParameterIiv(int sampler, int pname, long params) { org.lwjgl.opengl.GL33.nglGetSamplerParameterIiv(sampler, pname, params); }

	@Override
	public void glGetSamplerParameterIuiv(int sampler, int pname, long params) { org.lwjgl.opengl.GL33.nglGetSamplerParameterIuiv(sampler, pname, params); }

	@Override
	public void glGetSamplerParameterfv(int sampler, int pname, long params) { org.lwjgl.opengl.GL33.nglGetSamplerParameterfv(sampler, pname, params); }

	@Override
	public void glGetSamplerParameteriv(int sampler, int pname, long params) { org.lwjgl.opengl.GL33.nglGetSamplerParameteriv(sampler, pname, params); }

	@Override
	public void glGetShaderInfoLog(int shader, int bufSize, long length, long infoLog) { org.lwjgl.opengl.GL20.nglGetShaderInfoLog(shader, bufSize, length, infoLog); }

	@Override
	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, long range, long precision) { org.lwjgl.opengl.GL41.nglGetShaderPrecisionFormat(shadertype, precisiontype, range, precision); }

	@Override
	public void glGetShaderSource(int shader, int bufSize, long length, long source) { org.lwjgl.opengl.GL20.nglGetShaderSource(shader, bufSize, length, source); }

	@Override
	public void glGetShaderiv(int shader, int pname, long params) { org.lwjgl.opengl.GL20.nglGetShaderiv(shader, pname, params); }

	@Override
	public long glGetString(int name) { return org.lwjgl.opengl.GL11.nglGetString(name); }

	@Override
	public long glGetStringi(int name, int index) { return org.lwjgl.opengl.GL30.nglGetStringi(name, index); }

	@Override
	public int glGetSubroutineIndex(int program, int shadertype, long name) { return org.lwjgl.opengl.GL40.nglGetSubroutineIndex(program, shadertype, name); }

	@Override
	public int glGetSubroutineUniformLocation(int program, int shadertype, long name) { return org.lwjgl.opengl.GL40.nglGetSubroutineUniformLocation(program, shadertype, name); }

	@Override
	public void glGetSynciv(long sync, int pname, int bufSize, long length, long values) { org.lwjgl.opengl.GL32.nglGetSynciv(sync, pname, bufSize, length, values); }

	@Override
	public void glGetTexImage(int target, int level, int format, int type, long pixels) { org.lwjgl.opengl.GL11.nglGetTexImage(target, level, format, type, pixels); }

	@Override
	public void glGetTexLevelParameterfv(int target, int level, int pname, long params) { org.lwjgl.opengl.GL11.nglGetTexLevelParameterfv(target, level, pname, params); }

	@Override
	public void glGetTexLevelParameteriv(int target, int level, int pname, long params) { org.lwjgl.opengl.GL11.nglGetTexLevelParameteriv(target, level, pname, params); }

	@Override
	public void glGetTexParameterIiv(int target, int pname, long params) { org.lwjgl.opengl.GL30.nglGetTexParameterIiv(target, pname, params); }

	@Override
	public void glGetTexParameterIuiv(int target, int pname, long params) { org.lwjgl.opengl.GL30.nglGetTexParameterIuiv(target, pname, params); }

	@Override
	public void glGetTexParameterfv(int target, int pname, long params) { org.lwjgl.opengl.GL11.nglGetTexParameterfv(target, pname, params); }

	@Override
	public void glGetTexParameteriv(int target, int pname, long params) { org.lwjgl.opengl.GL11.nglGetTexParameteriv(target, pname, params); }

	@Override
	public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, long pixels) { org.lwjgl.opengl.GL45.glGetTextureImage(texture, level, format, type, bufSize, pixels); }

	@Override
	public void glGetTextureLevelParameterfv(int texture, int level, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureLevelParameterfv(texture, level, pname, params); }

	@Override
	public void glGetTextureLevelParameteriv(int texture, int level, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureLevelParameteriv(texture, level, pname, params); }

	@Override
	public void glGetTextureParameterIiv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureParameterIiv(texture, pname, params); }

	@Override
	public void glGetTextureParameterIuiv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureParameterIuiv(texture, pname, params); }

	@Override
	public void glGetTextureParameterfv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureParameterfv(texture, pname, params); }

	@Override
	public void glGetTextureParameteriv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglGetTextureParameteriv(texture, pname, params); }

	@Override
	public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels) { org.lwjgl.opengl.GL45.nglGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels); }

	@Override
	public void glGetTransformFeedbackVarying(int program, int index, int bufSize, long length, long size, long type, long name) { org.lwjgl.opengl.GL30.nglGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name); }

	@Override
	public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, long param) { org.lwjgl.opengl.GL45.nglGetTransformFeedbacki64_v(xfb, pname, index, param); }

	@Override
	public void glGetTransformFeedbacki_v(int xfb, int pname, int index, long param) { org.lwjgl.opengl.GL45.nglGetTransformFeedbacki_v(xfb, pname, index, param); }

	@Override
	public void glGetTransformFeedbackiv(int xfb, int pname, long param) { org.lwjgl.opengl.GL45.nglGetTransformFeedbackiv(xfb, pname, param); }

	@Override
	public int glGetUniformBlockIndex(int program, long uniformBlockName) { return org.lwjgl.opengl.GL31.nglGetUniformBlockIndex(program, uniformBlockName); }

	@Override
	public void glGetUniformIndices(int program, int uniformCount, long uniformNames, long uniformIndices) { org.lwjgl.opengl.GL31.nglGetUniformIndices(program, uniformCount, uniformNames, uniformIndices); }

	@Override
	public int glGetUniformLocation(int program, long name) { return org.lwjgl.opengl.GL20.nglGetUniformLocation(program, name); }

	@Override
	public void glGetUniformSubroutineuiv(int shadertype, int location, long params) { org.lwjgl.opengl.GL40.nglGetUniformSubroutineuiv(shadertype, location, params); }

	@Override
	public void glGetUniformdv(int program, int location, long params) { org.lwjgl.opengl.GL40.nglGetUniformdv(program, location, params); }

	@Override
	public void glGetUniformfv(int program, int location, long params) { org.lwjgl.opengl.GL20.nglGetUniformfv(program, location, params); }

	@Override
	public void glGetUniformiv(int program, int location, long params) { org.lwjgl.opengl.GL20.nglGetUniformiv(program, location, params); }

	@Override
	public void glGetUniformuiv(int program, int location, long params) { org.lwjgl.opengl.GL30.nglGetUniformuiv(program, location, params); }

	@Override
	public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, long param) { org.lwjgl.opengl.GL45.nglGetVertexArrayIndexed64iv(vaobj, index, pname, param); }

	@Override
	public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, long param) { org.lwjgl.opengl.GL45.nglGetVertexArrayIndexediv(vaobj, index, pname, param); }

	@Override
	public void glGetVertexArrayiv(int vaobj, int pname, long param) { org.lwjgl.opengl.GL45.nglGetVertexArrayiv(vaobj, pname, param); }

	@Override
	public void glGetVertexAttribIiv(int index, int pname, long params) { org.lwjgl.opengl.GL30.nglGetVertexAttribIiv(index, pname, params); }

	@Override
	public void glGetVertexAttribIuiv(int index, int pname, long params) { org.lwjgl.opengl.GL30.nglGetVertexAttribIuiv(index, pname, params); }

	@Override
	public void glGetVertexAttribLdv(int index, int pname, long params) { org.lwjgl.opengl.GL41.nglGetVertexAttribLdv(index, pname, params); }

	@Override
	public void glGetVertexAttribPointerv(int index, int pname, long pointer) { org.lwjgl.opengl.GL20.nglGetVertexAttribPointerv(index, pname, pointer); }

	@Override
	public void glGetVertexAttribdv(int index, int pname, long params) { org.lwjgl.opengl.GL20.nglGetVertexAttribdv(index, pname, params); }

	@Override
	public void glGetVertexAttribfv(int index, int pname, long params) { org.lwjgl.opengl.GL20.nglGetVertexAttribfv(index, pname, params); }

	@Override
	public void glGetVertexAttribiv(int index, int pname, long params) { org.lwjgl.opengl.GL20.nglGetVertexAttribiv(index, pname, params); }

	@Override
	public void glGetnCompressedTexImage(int target, int lod, int bufSize, long pixels) { org.lwjgl.opengl.GL45.glGetnCompressedTexImage(target, lod, bufSize, pixels); }

	@Override
	public void glGetnTexImage(int target, int level, int format, int type, int bufSize, long pixels) { org.lwjgl.opengl.GL45.nglGetnTexImage(target, level, format, type, bufSize, pixels); }

	@Override
	public void glGetnUniformdv(int program, int location, int bufSize, long params) { org.lwjgl.opengl.GL45.nglGetnUniformdv(program, location, bufSize, params); }

	@Override
	public void glGetnUniformfv(int program, int location, int bufSize, long params) { org.lwjgl.opengl.GL45.nglGetnUniformfv(program, location, bufSize, params); }

	@Override
	public void glGetnUniformiv(int program, int location, int bufSize, long params) { org.lwjgl.opengl.GL45.nglGetnUniformiv(program, location, bufSize, params); }

	@Override
	public void glGetnUniformuiv(int program, int location, int bufSize, long params) { org.lwjgl.opengl.GL45.nglGetnUniformuiv(program, location, bufSize, params); }

	@Override
	public void glHint(int target, int mode) { org.lwjgl.opengl.GL11.glHint(target, mode); }

	@Override
	public void glInvalidateBufferData(int buffer) { org.lwjgl.opengl.GL43.glInvalidateBufferData(buffer); }

	@Override
	public void glInvalidateBufferSubData(int buffer, long offset, long length) { org.lwjgl.opengl.GL43.glInvalidateBufferSubData(buffer, offset, length); }

	@Override
	public void glInvalidateFramebuffer(int target, int numAttachments, long attachments) { org.lwjgl.opengl.GL43.nglInvalidateFramebuffer(target, numAttachments, attachments); }

	@Override
	public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments) { org.lwjgl.opengl.GL45.nglInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments); }

	@Override
	public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height) { org.lwjgl.opengl.GL45.nglInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height); }

	@Override
	public void glInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height) { org.lwjgl.opengl.GL43.nglInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height); }

	@Override
	public void glInvalidateTexImage(int texture, int level) { org.lwjgl.opengl.GL43.glInvalidateTexImage(texture, level); }

	@Override
	public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) { org.lwjgl.opengl.GL43.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth); }

	@Override
	public boolean glIsBuffer(int buffer) { return org.lwjgl.opengl.GL15.glIsBuffer(buffer); }

	@Override
	public boolean glIsEnabled(int cap) { return org.lwjgl.opengl.GL11.glIsEnabled(cap); }

	@Override
	public boolean glIsEnabledi(int target, int index) { return org.lwjgl.opengl.GL30.glIsEnabledi(target, index); }

	@Override
	public boolean glIsFramebuffer(int framebuffer) { return org.lwjgl.opengl.GL30.glIsFramebuffer(framebuffer); }

	@Override
	public boolean glIsProgram(int program) { return org.lwjgl.opengl.GL20.glIsProgram(program); }

	@Override
	public boolean glIsProgramPipeline(int pipeline) { return org.lwjgl.opengl.GL41.glIsProgramPipeline(pipeline); }

	@Override
	public boolean glIsQuery(int id) { return org.lwjgl.opengl.GL15.glIsQuery(id); }

	@Override
	public boolean glIsRenderbuffer(int renderbuffer) { return org.lwjgl.opengl.GL30.glIsRenderbuffer(renderbuffer); }

	@Override
	public boolean glIsSampler(int sampler) { return org.lwjgl.opengl.GL33.glIsSampler(sampler); }

	@Override
	public boolean glIsShader(int shader) { return org.lwjgl.opengl.GL20.glIsShader(shader); }

	@Override
	public boolean glIsSync(long sync) { return org.lwjgl.opengl.GL32.glIsSync(sync); }

	@Override
	public boolean glIsTexture(int texture) { return org.lwjgl.opengl.GL11.glIsTexture(texture); }

	@Override
	public boolean glIsTransformFeedback(int id) { return org.lwjgl.opengl.GL40.glIsTransformFeedback(id); }

	@Override
	public boolean glIsVertexArray(int array) { return org.lwjgl.opengl.GL30.glIsVertexArray(array); }

	@Override
	public void glLineWidth(float width) { org.lwjgl.opengl.GL11.glLineWidth(width); }

	@Override
	public void glLinkProgram(int program) { org.lwjgl.opengl.GL20.glLinkProgram(program); }

	@Override
	public void glLogicOp(int opcode) { org.lwjgl.opengl.GL11.glLogicOp(opcode); }

	@Override
	public long glMapBuffer(int target, int access) { return org.lwjgl.opengl.GL15.nglMapBuffer(target, access); }

	@Override
	public long glMapBufferRange(int target, long offset, long length, int access) { return org.lwjgl.opengl.GL30.nglMapBufferRange(target, offset, length, access); }

	@Override
	public long glMapNamedBuffer(int buffer, int access) { return org.lwjgl.opengl.GL45.nglMapNamedBuffer(buffer, access); }

	@Override
	public long glMapNamedBufferRange(int buffer, long offset, long length, int access) { return org.lwjgl.opengl.GL45.nglMapNamedBufferRange(buffer, offset, length, access); }

	@Override
	public void glMemoryBarrier(int barriers) { org.lwjgl.opengl.GL42.glMemoryBarrier(barriers); }

	@Override
	public void glMemoryBarrierByRegion(int barriers) { org.lwjgl.opengl.GL45.glMemoryBarrierByRegion(barriers); }

	@Override
	public void glMinSampleShading(float value) { org.lwjgl.opengl.GL40.glMinSampleShading(value); }

	@Override
	public void glMultiDrawArrays(int mode, long first, long count, int drawcount) { org.lwjgl.opengl.GL14.nglMultiDrawArrays(mode, first, count, drawcount); }

	@Override
	public void glMultiDrawArraysIndirect(int mode, long indirect, int drawcount, int stride) { org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride); }

	@Override
	public void glMultiDrawArraysIndirectCount(int mode, long indirect, long drawcount, int maxdrawcount, int stride) { org.lwjgl.opengl.GL46.nglMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride); }

	@Override
	public void glMultiDrawElements(int mode, long count, int type, long indices, int drawcount) { org.lwjgl.opengl.GL14.nglMultiDrawElements(mode, count, type, indices, drawcount); }

	@Override
	public void glMultiDrawElementsBaseVertex(int mode, long count, int type, long indices, int drawcount, long basevertex) { org.lwjgl.opengl.GL32.nglMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex); }

	@Override
	public void glMultiDrawElementsIndirect(int mode, int type, long indirect, int drawcount, int stride) { org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride); }

	@Override
	public void glMultiDrawElementsIndirectCount(int mode, int type, long indirect, long drawcount, int maxdrawcount, int stride) { org.lwjgl.opengl.GL46.nglMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride); }

	@Override
	public void glNamedBufferData(int buffer, long size, long data, int usage) { org.lwjgl.opengl.GL45.nglNamedBufferData(buffer, size, data, usage); }

	@Override
	public void glNamedBufferStorage(int buffer, long size, long data, int flags) { org.lwjgl.opengl.GL45.nglNamedBufferStorage(buffer, size, data, flags); }

	@Override
	public void glNamedBufferSubData(int buffer, long offset, long size, long data) { org.lwjgl.opengl.GL45.nglNamedBufferSubData(buffer, offset, size, data); }

	@Override
	public void glNamedFramebufferDrawBuffer(int framebuffer, int buf) { org.lwjgl.opengl.GL45.glNamedFramebufferDrawBuffer(framebuffer, buf); }

	@Override
	public void glNamedFramebufferDrawBuffers(int framebuffer, int n, long bufs) { org.lwjgl.opengl.GL45.nglNamedFramebufferDrawBuffers(framebuffer, n, bufs); }

	@Override
	public void glNamedFramebufferParameteri(int framebuffer, int pname, int param) { org.lwjgl.opengl.GL45.glNamedFramebufferParameteri(framebuffer, pname, param); }

	@Override
	public void glNamedFramebufferReadBuffer(int framebuffer, int src) { org.lwjgl.opengl.GL45.glNamedFramebufferReadBuffer(framebuffer, src); }

	@Override
	public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) { org.lwjgl.opengl.GL45.glNamedFramebufferRenderbuffer(framebuffer, attachment, renderbuffertarget, renderbuffer); }

	@Override
	public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level) { org.lwjgl.opengl.GL45.glNamedFramebufferTexture(framebuffer, attachment, texture, level); }

	@Override
	public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer) { org.lwjgl.opengl.GL45.glNamedFramebufferTextureLayer(framebuffer, attachment, texture, level, layer); }

	@Override
	public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height) { org.lwjgl.opengl.GL45.glNamedRenderbufferStorage(renderbuffer, internalformat, width, height); }

	@Override
	public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height) { org.lwjgl.opengl.GL45.glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat, width, height); }

	@Override
	public void glObjectLabel(int identifier, int name, int length, long label) { org.lwjgl.opengl.GL43.nglObjectLabel(identifier, name, length, label); }

	@Override
	public void glObjectPtrLabel(long ptr, int length, long label) { org.lwjgl.opengl.GL43.nglObjectPtrLabel(ptr, length, label); }

	@Override
	public void glPatchParameterfv(int pname, long values) { org.lwjgl.opengl.GL40.nglPatchParameterfv(pname, values); }

	@Override
	public void glPatchParameteri(int pname, int value) { org.lwjgl.opengl.GL40.glPatchParameteri(pname, value); }

	@Override
	public void glPauseTransformFeedback() { org.lwjgl.opengl.GL40.glPauseTransformFeedback(); }

	@Override
	public void glPixelStoref(int pname, float param) { org.lwjgl.opengl.GL11.glPixelStoref(pname, param); }

	@Override
	public void glPixelStorei(int pname, int param) { org.lwjgl.opengl.GL11.glPixelStorei(pname, param); }

	@Override
	public void glPointParameterf(int pname, float param) { org.lwjgl.opengl.GL14.glPointParameterf(pname, param); }

	@Override
	public void glPointParameterfv(int pname, long params) { org.lwjgl.opengl.GL14.nglPointParameterfv(pname, params); }

	@Override
	public void glPointParameteri(int pname, int param) { org.lwjgl.opengl.GL14.glPointParameteri(pname, param); }

	@Override
	public void glPointParameteriv(int pname, long params) { org.lwjgl.opengl.GL14.nglPointParameteriv(pname, params); }

	@Override
	public void glPointSize(float size) { org.lwjgl.opengl.GL11.glPointSize(size); }

	@Override
	public void glPolygonMode(int face, int mode) { org.lwjgl.opengl.GL11.glPolygonMode(face, mode); }

	@Override
	public void glPolygonOffset(float factor, float units) { org.lwjgl.opengl.GL11.glPolygonOffset(factor, units); }

	@Override
	public void glPolygonOffsetClamp(float factor, float units, float clamp) { org.lwjgl.opengl.GL46.glPolygonOffsetClamp(factor, units, clamp); }

	@Override
	public void glPopDebugGroup() { org.lwjgl.opengl.GL43.glPopDebugGroup(); }

	@Override
	public void glPrimitiveRestartIndex(int index) { org.lwjgl.opengl.GL31.glPrimitiveRestartIndex(index); }

	@Override
	public void glProgramBinary(int program, int binaryFormat, long binary, int length) { org.lwjgl.opengl.GL41.nglProgramBinary(program, binaryFormat, binary, length); }

	@Override
	public void glProgramParameteri(int program, int pname, int value) { org.lwjgl.opengl.GL41.glProgramParameteri(program, pname, value); }

	@Override
	public void glProgramUniform1d(int program, int location, double v0) { org.lwjgl.opengl.GL41.glProgramUniform1d(program, location, v0); }

	@Override
	public void glProgramUniform1dv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform1dv(program, location, count, value); }

	@Override
	public void glProgramUniform1f(int program, int location, float v0) { org.lwjgl.opengl.GL41.glProgramUniform1f(program, location, v0); }

	@Override
	public void glProgramUniform1fv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform1fv(program, location, count, value); }

	@Override
	public void glProgramUniform1i(int program, int location, int v0) { org.lwjgl.opengl.GL41.glProgramUniform1i(program, location, v0); }

	@Override
	public void glProgramUniform1iv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform1iv(program, location, count, value); }

	@Override
	public void glProgramUniform1ui(int program, int location, int v0) { org.lwjgl.opengl.GL41.glProgramUniform1ui(program, location, v0); }

	@Override
	public void glProgramUniform1uiv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform1uiv(program, location, count, value); }

	@Override
	public void glProgramUniform2d(int program, int location, double v0, double v1) { org.lwjgl.opengl.GL41.glProgramUniform2d(program, location, v0, v1); }

	@Override
	public void glProgramUniform2dv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform2dv(program, location, count, value); }

	@Override
	public void glProgramUniform2f(int program, int location, float v0, float v1) { org.lwjgl.opengl.GL41.glProgramUniform2f(program, location, v0, v1); }

	@Override
	public void glProgramUniform2fv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform2fv(program, location, count, value); }

	@Override
	public void glProgramUniform2i(int program, int location, int v0, int v1) { org.lwjgl.opengl.GL41.glProgramUniform2i(program, location, v0, v1); }

	@Override
	public void glProgramUniform2iv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform2iv(program, location, count, value); }

	@Override
	public void glProgramUniform2ui(int program, int location, int v0, int v1) { org.lwjgl.opengl.GL41.glProgramUniform2ui(program, location, v0, v1); }

	@Override
	public void glProgramUniform2uiv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform2uiv(program, location, count, value); }

	@Override
	public void glProgramUniform3d(int program, int location, double v0, double v1, double v2) { org.lwjgl.opengl.GL41.glProgramUniform3d(program, location, v0, v1, v2); }

	@Override
	public void glProgramUniform3dv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform3dv(program, location, count, value); }

	@Override
	public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) { org.lwjgl.opengl.GL41.glProgramUniform3f(program, location, v0, v1, v2); }

	@Override
	public void glProgramUniform3fv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform3fv(program, location, count, value); }

	@Override
	public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) { org.lwjgl.opengl.GL41.glProgramUniform3i(program, location, v0, v1, v2); }

	@Override
	public void glProgramUniform3iv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform3iv(program, location, count, value); }

	@Override
	public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) { org.lwjgl.opengl.GL41.glProgramUniform3ui(program, location, v0, v1, v2); }

	@Override
	public void glProgramUniform3uiv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform3uiv(program, location, count, value); }

	@Override
	public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3) { org.lwjgl.opengl.GL41.glProgramUniform4d(program, location, v0, v1, v2, v3); }

	@Override
	public void glProgramUniform4dv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform4dv(program, location, count, value); }

	@Override
	public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) { org.lwjgl.opengl.GL41.glProgramUniform4f(program, location, v0, v1, v2, v3); }

	@Override
	public void glProgramUniform4fv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform4fv(program, location, count, value); }

	@Override
	public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) { org.lwjgl.opengl.GL41.glProgramUniform4i(program, location, v0, v1, v2, v3); }

	@Override
	public void glProgramUniform4iv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform4iv(program, location, count, value); }

	@Override
	public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) { org.lwjgl.opengl.GL41.glProgramUniform4ui(program, location, v0, v1, v2, v3); }

	@Override
	public void glProgramUniform4uiv(int program, int location, int count, long value) { org.lwjgl.opengl.GL41.nglProgramUniform4uiv(program, location, count, value); }

	@Override
	public void glProgramUniformMatrix2dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2x3dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2x3fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2x4dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix2x4fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3x2dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3x2fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3x4dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix3x4fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4x2dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4x2fv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4x3dv(program, location, count, transpose, value); }

	@Override
	public void glProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL41.nglProgramUniformMatrix4x3fv(program, location, count, transpose, value); }

	@Override
	public void glProvokingVertex(int mode) { org.lwjgl.opengl.GL32.glProvokingVertex(mode); }

	@Override
	public void glPushDebugGroup(int source, int id, int length, long message) { org.lwjgl.opengl.GL43.nglPushDebugGroup(source, id, length, message); }

	@Override
	public void glQueryCounter(int id, int target) { org.lwjgl.opengl.GL33.glQueryCounter(id, target); }

	@Override
	public void glReadBuffer(int src) { org.lwjgl.opengl.GL11.glReadBuffer(src); }

	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, long pixels) { org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels); }

	@Override
	public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, long data) { org.lwjgl.opengl.GL45.glReadnPixels(x, y, width, height, format, type, bufSize, data); }

	@Override
	public void glReleaseShaderCompiler() { org.lwjgl.opengl.GL41.glReleaseShaderCompiler(); }

	@Override
	public void glRenderbufferStorage(int target, int internalformat, int width, int height) { org.lwjgl.opengl.GL30.glRenderbufferStorage(target, internalformat, width, height); }

	@Override
	public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) { org.lwjgl.opengl.GL30.glRenderbufferStorageMultisample(target, samples, internalformat, width, height); }

	@Override
	public void glResumeTransformFeedback() { org.lwjgl.opengl.GL40.glResumeTransformFeedback(); }

	@Override
	public void glSampleCoverage(float value, boolean invert) { org.lwjgl.opengl.GL13.glSampleCoverage(value, invert); }

	@Override
	public void glSampleMaski(int maskNumber, int mask) { org.lwjgl.opengl.GL32.glSampleMaski(maskNumber, mask); }

	@Override
	public void glSamplerParameterIiv(int sampler, int pname, long param) { org.lwjgl.opengl.GL33.nglSamplerParameterIiv(sampler, pname, param); }

	@Override
	public void glSamplerParameterIuiv(int sampler, int pname, long param) { org.lwjgl.opengl.GL33.nglSamplerParameterIuiv(sampler, pname, param); }

	@Override
	public void glSamplerParameterf(int sampler, int pname, float param) { org.lwjgl.opengl.GL33.glSamplerParameterf(sampler, pname, param); }

	@Override
	public void glSamplerParameterfv(int sampler, int pname, long param) { org.lwjgl.opengl.GL33.nglSamplerParameterfv(sampler, pname, param); }

	@Override
	public void glSamplerParameteri(int sampler, int pname, int param) { org.lwjgl.opengl.GL33.glSamplerParameteri(sampler, pname, param); }

	@Override
	public void glSamplerParameteriv(int sampler, int pname, long param) { org.lwjgl.opengl.GL33.nglSamplerParameteriv(sampler, pname, param); }

	@Override
	public void glScissor(int x, int y, int width, int height) { org.lwjgl.opengl.GL11.glScissor(x, y, width, height); }

	@Override
	public void glScissorArrayv(int first, int count, long v) { org.lwjgl.opengl.GL41.nglScissorArrayv(first, count, v); }

	@Override
	public void glScissorIndexed(int index, int left, int bottom, int width, int height) { org.lwjgl.opengl.GL41.glScissorIndexed(index, left, bottom, width, height); }

	@Override
	public void glScissorIndexedv(int index, long v) { org.lwjgl.opengl.GL41.nglScissorIndexedv(index, v); }

	@Override
	public void glShaderBinary(int count, long shaders, int binaryformat, long binary, int length) { org.lwjgl.opengl.GL41.nglShaderBinary(count, shaders, binaryformat, binary, length); }

	@Override
	public void glShaderSource(int shader, int count, long string, long length) { org.lwjgl.opengl.GL20.nglShaderSource(shader, count, string, length); }

	@Override
	public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) { org.lwjgl.opengl.GL43.glShaderStorageBlockBinding(program, storageBlockIndex, storageBlockBinding); }

	@Override
	public void glSpecializeShader(int shader, long pEntryPoint, int numSpecializationConstants, long pConstantIndex, long pConstantValue) { org.lwjgl.opengl.GL46.nglSpecializeShader(shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue); }

	@Override
	public void glStencilFunc(int func, int ref, int mask) { org.lwjgl.opengl.GL11.glStencilFunc(func, ref, mask); }

	@Override
	public void glStencilFuncSeparate(int face, int func, int ref, int mask) { org.lwjgl.opengl.GL20.glStencilFuncSeparate(face, func, ref, mask); }

	@Override
	public void glStencilMask(int mask) { org.lwjgl.opengl.GL11.glStencilMask(mask); }

	@Override
	public void glStencilMaskSeparate(int face, int mask) { org.lwjgl.opengl.GL20.glStencilMaskSeparate(face, mask); }

	@Override
	public void glStencilOp(int fail, int zfail, int zpass) { org.lwjgl.opengl.GL11.glStencilOp(fail, zfail, zpass); }

	@Override
	public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) { org.lwjgl.opengl.GL20.glStencilOpSeparate(face, sfail, dpfail, dppass); }

	@Override
	public void glTexBuffer(int target, int internalformat, int buffer) { org.lwjgl.opengl.GL31.glTexBuffer(target, internalformat, buffer); }

	@Override
	public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) { org.lwjgl.opengl.GL43.glTexBufferRange(target, internalformat, buffer, offset, size); }

	@Override
	public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels) { org.lwjgl.opengl.GL11.nglTexImage1D(target, level, internalformat, width, border, format, type, pixels); }

	@Override
	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels) { org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels); }

	@Override
	public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) { org.lwjgl.opengl.GL32.glTexImage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations); }

	@Override
	public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, long pixels) { org.lwjgl.opengl.GL12.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels); }

	@Override
	public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) { org.lwjgl.opengl.GL32.glTexImage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations); }

	@Override
	public void glTexParameterIiv(int target, int pname, long params) { org.lwjgl.opengl.GL30.nglTexParameterIiv(target, pname, params); }

	@Override
	public void glTexParameterIuiv(int target, int pname, long params) { org.lwjgl.opengl.GL30.nglTexParameterIuiv(target, pname, params); }

	@Override
	public void glTexParameterf(int target, int pname, float param) { org.lwjgl.opengl.GL11.glTexParameterf(target, pname, param); }

	@Override
	public void glTexParameterfv(int target, int pname, long params) { org.lwjgl.opengl.GL11.nglTexParameterfv(target, pname, params); }

	@Override
	public void glTexParameteri(int target, int pname, int param) { org.lwjgl.opengl.GL11.glTexParameteri(target, pname, param); }

	@Override
	public void glTexParameteriv(int target, int pname, long params) { org.lwjgl.opengl.GL11.nglTexParameteriv(target, pname, params); }

	@Override
	public void glTexStorage1D(int target, int levels, int internalformat, int width) { org.lwjgl.opengl.GL42.glTexStorage1D(target, levels, internalformat, width); }

	@Override
	public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) { org.lwjgl.opengl.GL42.glTexStorage2D(target, levels, internalformat, width, height); }

	@Override
	public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) { org.lwjgl.opengl.GL43.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations); }

	@Override
	public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) { org.lwjgl.opengl.GL42.glTexStorage3D(target, levels, internalformat, width, height, depth); }

	@Override
	public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) { org.lwjgl.opengl.GL43.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations); }

	@Override
	public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels) { org.lwjgl.opengl.GL11.nglTexSubImage1D(target, level, xoffset, width, format, type, pixels); }

	@Override
	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) { org.lwjgl.opengl.GL11.nglTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels); }

	@Override
	public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels) { org.lwjgl.opengl.GL12.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels); }

	@Override
	public void glTextureBarrier() { org.lwjgl.opengl.GL45.glTextureBarrier(); }

	@Override
	public void glTextureBuffer(int texture, int internalformat, int buffer) { org.lwjgl.opengl.GL45.glTextureBuffer(texture, internalformat, buffer); }

	@Override
	public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size) { org.lwjgl.opengl.GL45.glTextureBufferRange(texture, internalformat, buffer, offset, size); }

	@Override
	public void glTextureParameterIiv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglTextureParameterIiv(texture, pname, params); }

	@Override
	public void glTextureParameterIuiv(int texture, int pname, long params) { org.lwjgl.opengl.GL45.nglTextureParameterIuiv(texture, pname, params); }

	@Override
	public void glTextureParameterf(int texture, int pname, float param) { org.lwjgl.opengl.GL45.glTextureParameterf(texture, pname, param); }

	@Override
	public void glTextureParameterfv(int texture, int pname, long param) { org.lwjgl.opengl.GL45.nglTextureParameterfv(texture, pname, param); }

	@Override
	public void glTextureParameteri(int texture, int pname, int param) { org.lwjgl.opengl.GL45.glTextureParameteri(texture, pname, param); }

	@Override
	public void glTextureParameteriv(int texture, int pname, long param) { org.lwjgl.opengl.GL45.nglTextureParameteriv(texture, pname, param); }

	@Override
	public void glTextureStorage1D(int texture, int levels, int internalformat, int width) { org.lwjgl.opengl.GL45.glTextureStorage1D(texture, levels, internalformat, width); }

	@Override
	public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height) { org.lwjgl.opengl.GL45.glTextureStorage2D(texture, levels, internalformat, width, height); }

	@Override
	public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) { org.lwjgl.opengl.GL45.glTextureStorage2DMultisample(texture, samples, internalformat, width, height, fixedsamplelocations); }

	@Override
	public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth) { org.lwjgl.opengl.GL45.glTextureStorage3D(texture, levels, internalformat, width, height, depth); }

	@Override
	public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) { org.lwjgl.opengl.GL45.glTextureStorage3DMultisample(texture, samples, internalformat, width, height, depth, fixedsamplelocations); }

	@Override
	public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, long pixels) { org.lwjgl.opengl.GL45.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels); }

	@Override
	public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels) { org.lwjgl.opengl.GL45.nglTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels); }

	@Override
	public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels) { org.lwjgl.opengl.GL45.nglTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels); }

	@Override
	public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) { org.lwjgl.opengl.GL43.glTextureView(texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers); }

	@Override
	public void glTransformFeedbackBufferBase(int xfb, int index, int buffer) { org.lwjgl.opengl.GL45.glTransformFeedbackBufferBase(xfb, index, buffer); }

	@Override
	public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) { org.lwjgl.opengl.GL45.glTransformFeedbackBufferRange(xfb, index, buffer, offset, size); }

	@Override
	public void glTransformFeedbackVaryings(int program, int count, long varyings, int bufferMode) { org.lwjgl.opengl.GL30.nglTransformFeedbackVaryings(program, count, varyings, bufferMode); }

	@Override
	public void glUniform1d(int location, double x) { org.lwjgl.opengl.GL40.glUniform1d(location, x); }

	@Override
	public void glUniform1dv(int location, int count, long value) { org.lwjgl.opengl.GL40.nglUniform1dv(location, count, value); }

	@Override
	public void glUniform1f(int location, float v0) { org.lwjgl.opengl.GL20.glUniform1f(location, v0); }

	@Override
	public void glUniform1fv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform1fv(location, count, value); }

	@Override
	public void glUniform1i(int location, int v0) { org.lwjgl.opengl.GL20.glUniform1i(location, v0); }

	@Override
	public void glUniform1iv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform1iv(location, count, value); }

	@Override
	public void glUniform1ui(int location, int v0) { org.lwjgl.opengl.GL30.glUniform1ui(location, v0); }

	@Override
	public void glUniform1uiv(int location, int count, long value) { org.lwjgl.opengl.GL30.nglUniform1uiv(location, count, value); }

	@Override
	public void glUniform2d(int location, double x, double y) { org.lwjgl.opengl.GL40.glUniform2d(location, x, y); }

	@Override
	public void glUniform2dv(int location, int count, long value) { org.lwjgl.opengl.GL40.nglUniform2dv(location, count, value); }

	@Override
	public void glUniform2f(int location, float v0, float v1) { org.lwjgl.opengl.GL20.glUniform2f(location, v0, v1); }

	@Override
	public void glUniform2fv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform2fv(location, count, value); }

	@Override
	public void glUniform2i(int location, int v0, int v1) { org.lwjgl.opengl.GL20.glUniform2i(location, v0, v1); }

	@Override
	public void glUniform2iv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform2iv(location, count, value); }

	@Override
	public void glUniform2ui(int location, int v0, int v1) { org.lwjgl.opengl.GL30.glUniform2ui(location, v0, v1); }

	@Override
	public void glUniform2uiv(int location, int count, long value) { org.lwjgl.opengl.GL30.nglUniform2uiv(location, count, value); }

	@Override
	public void glUniform3d(int location, double x, double y, double z) { org.lwjgl.opengl.GL40.glUniform3d(location, x, y, z); }

	@Override
	public void glUniform3dv(int location, int count, long value) { org.lwjgl.opengl.GL40.nglUniform3dv(location, count, value); }

	@Override
	public void glUniform3f(int location, float v0, float v1, float v2) { org.lwjgl.opengl.GL20.glUniform3f(location, v0, v1, v2); }

	@Override
	public void glUniform3fv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform3fv(location, count, value); }

	@Override
	public void glUniform3i(int location, int v0, int v1, int v2) { org.lwjgl.opengl.GL20.glUniform3i(location, v0, v1, v2); }

	@Override
	public void glUniform3iv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform3iv(location, count, value); }

	@Override
	public void glUniform3ui(int location, int v0, int v1, int v2) { org.lwjgl.opengl.GL30.glUniform3ui(location, v0, v1, v2); }

	@Override
	public void glUniform3uiv(int location, int count, long value) { org.lwjgl.opengl.GL30.nglUniform3uiv(location, count, value); }

	@Override
	public void glUniform4d(int location, double x, double y, double z, double w) { org.lwjgl.opengl.GL40.glUniform4d(location, x, y, z, w); }

	@Override
	public void glUniform4dv(int location, int count, long value) { org.lwjgl.opengl.GL40.nglUniform4dv(location, count, value); }

	@Override
	public void glUniform4f(int location, float v0, float v1, float v2, float v3) { org.lwjgl.opengl.GL20.glUniform4f(location, v0, v1, v2, v3); }

	@Override
	public void glUniform4fv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform4fv(location, count, value); }

	@Override
	public void glUniform4i(int location, int v0, int v1, int v2, int v3) { org.lwjgl.opengl.GL20.glUniform4i(location, v0, v1, v2, v3); }

	@Override
	public void glUniform4iv(int location, int count, long value) { org.lwjgl.opengl.GL20.nglUniform4iv(location, count, value); }

	@Override
	public void glUniform4ui(int location, int v0, int v1, int v2, int v3) { org.lwjgl.opengl.GL30.glUniform4ui(location, v0, v1, v2, v3); }

	@Override
	public void glUniform4uiv(int location, int count, long value) { org.lwjgl.opengl.GL30.nglUniform4uiv(location, count, value); }

	@Override
	public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) { org.lwjgl.opengl.GL31.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding); }

	@Override
	public void glUniformMatrix2dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix2dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix2fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL20.nglUniformMatrix2fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix2x3dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix2x3dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix2x3fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix2x3fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix2x4dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix2x4dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix2x4fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix2x4fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix3dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL20.nglUniformMatrix3fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3x2dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix3x2dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3x2fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix3x2fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3x4dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix3x4dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix3x4fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix3x4fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix4dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL20.nglUniformMatrix4fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4x2dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix4x2dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4x2fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix4x2fv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4x3dv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL40.nglUniformMatrix4x3dv(location, count, transpose, value); }

	@Override
	public void glUniformMatrix4x3fv(int location, int count, boolean transpose, long value) { org.lwjgl.opengl.GL21.nglUniformMatrix4x3fv(location, count, transpose, value); }

	@Override
	public void glUniformSubroutinesuiv(int shadertype, int count, long indices) { org.lwjgl.opengl.GL40.nglUniformSubroutinesuiv(shadertype, count, indices); }

	@Override
	public boolean glUnmapBuffer(int target) { return org.lwjgl.opengl.GL15.glUnmapBuffer(target); }

	@Override
	public boolean glUnmapNamedBuffer(int buffer) { return org.lwjgl.opengl.GL45.glUnmapNamedBuffer(buffer); }

	@Override
	public void glUseProgram(int program) { org.lwjgl.opengl.GL20.glUseProgram(program); }

	@Override
	public void glUseProgramStages(int pipeline, int stages, int program) { org.lwjgl.opengl.GL41.glUseProgramStages(pipeline, stages, program); }

	@Override
	public void glValidateProgram(int program) { org.lwjgl.opengl.GL20.glValidateProgram(program); }

	@Override
	public void glValidateProgramPipeline(int pipeline) { org.lwjgl.opengl.GL41.glValidateProgramPipeline(pipeline); }

	@Override
	public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) { org.lwjgl.opengl.GL45.glVertexArrayAttribBinding(vaobj, attribindex, bindingindex); }

	@Override
	public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, boolean normalized, int relativeoffset) { org.lwjgl.opengl.GL45.glVertexArrayAttribFormat(vaobj, attribindex, size, type, normalized, relativeoffset); }

	@Override
	public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) { org.lwjgl.opengl.GL45.glVertexArrayAttribIFormat(vaobj, attribindex, size, type, relativeoffset); }

	@Override
	public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) { org.lwjgl.opengl.GL45.glVertexArrayAttribLFormat(vaobj, attribindex, size, type, relativeoffset); }

	@Override
	public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) { org.lwjgl.opengl.GL45.glVertexArrayBindingDivisor(vaobj, bindingindex, divisor); }

	@Override
	public void glVertexArrayElementBuffer(int vaobj, int buffer) { org.lwjgl.opengl.GL45.glVertexArrayElementBuffer(vaobj, buffer); }

	@Override
	public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) { org.lwjgl.opengl.GL45.glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride); }

	@Override
	public void glVertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides) { org.lwjgl.opengl.GL45.nglVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides); }

	@Override
	public void glVertexAttrib1d(int index, double x) { org.lwjgl.opengl.GL20.glVertexAttrib1d(index, x); }

	@Override
	public void glVertexAttrib1dv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib1dv(index, v); }

	@Override
	public void glVertexAttrib1f(int index, float x) { org.lwjgl.opengl.GL20.glVertexAttrib1f(index, x); }

	@Override
	public void glVertexAttrib1fv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib1fv(index, v); }

	@Override
	public void glVertexAttrib1s(int index, short x) { org.lwjgl.opengl.GL20.glVertexAttrib1s(index, x); }

	@Override
	public void glVertexAttrib1sv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib1sv(index, v); }

	@Override
	public void glVertexAttrib2d(int index, double x, double y) { org.lwjgl.opengl.GL20.glVertexAttrib2d(index, x, y); }

	@Override
	public void glVertexAttrib2dv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib2dv(index, v); }

	@Override
	public void glVertexAttrib2f(int index, float x, float y) { org.lwjgl.opengl.GL20.glVertexAttrib2f(index, x, y); }

	@Override
	public void glVertexAttrib2fv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib2fv(index, v); }

	@Override
	public void glVertexAttrib2s(int index, short x, short y) { org.lwjgl.opengl.GL20.glVertexAttrib2s(index, x, y); }

	@Override
	public void glVertexAttrib2sv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib2sv(index, v); }

	@Override
	public void glVertexAttrib3d(int index, double x, double y, double z) { org.lwjgl.opengl.GL20.glVertexAttrib3d(index, x, y, z); }

	@Override
	public void glVertexAttrib3dv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib3dv(index, v); }

	@Override
	public void glVertexAttrib3f(int index, float x, float y, float z) { org.lwjgl.opengl.GL20.glVertexAttrib3f(index, x, y, z); }

	@Override
	public void glVertexAttrib3fv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib3fv(index, v); }

	@Override
	public void glVertexAttrib3s(int index, short x, short y, short z) { org.lwjgl.opengl.GL20.glVertexAttrib3s(index, x, y, z); }

	@Override
	public void glVertexAttrib3sv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib3sv(index, v); }

	@Override
	public void glVertexAttrib4Nbv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Nbv(index, v); }

	@Override
	public void glVertexAttrib4Niv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Niv(index, v); }

	@Override
	public void glVertexAttrib4Nsv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Nsv(index, v); }

	@Override
	public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) { org.lwjgl.opengl.GL20.glVertexAttrib4Nub(index, x, y, z, w); }

	@Override
	public void glVertexAttrib4Nubv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Nubv(index, v); }

	@Override
	public void glVertexAttrib4Nuiv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Nuiv(index, v); }

	@Override
	public void glVertexAttrib4Nusv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4Nusv(index, v); }

	@Override
	public void glVertexAttrib4bv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4bv(index, v); }

	@Override
	public void glVertexAttrib4d(int index, double x, double y, double z, double w) { org.lwjgl.opengl.GL20.glVertexAttrib4d(index, x, y, z, w); }

	@Override
	public void glVertexAttrib4dv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4dv(index, v); }

	@Override
	public void glVertexAttrib4f(int index, float x, float y, float z, float w) { org.lwjgl.opengl.GL20.glVertexAttrib4f(index, x, y, z, w); }

	@Override
	public void glVertexAttrib4fv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4fv(index, v); }

	@Override
	public void glVertexAttrib4iv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4iv(index, v); }

	@Override
	public void glVertexAttrib4s(int index, short x, short y, short z, short w) { org.lwjgl.opengl.GL20.glVertexAttrib4s(index, x, y, z, w); }

	@Override
	public void glVertexAttrib4sv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4sv(index, v); }

	@Override
	public void glVertexAttrib4ubv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4ubv(index, v); }

	@Override
	public void glVertexAttrib4uiv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4uiv(index, v); }

	@Override
	public void glVertexAttrib4usv(int index, long v) { org.lwjgl.opengl.GL20.nglVertexAttrib4usv(index, v); }

	@Override
	public void glVertexAttribBinding(int attribindex, int bindingindex) { org.lwjgl.opengl.GL43.glVertexAttribBinding(attribindex, bindingindex); }

	@Override
	public void glVertexAttribDivisor(int index, int divisor) { org.lwjgl.opengl.GL33.glVertexAttribDivisor(index, divisor); }

	@Override
	public void glVertexAttribFormat(int attribindex, int size, int type, boolean normalized, int relativeoffset) { org.lwjgl.opengl.GL43.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset); }

	@Override
	public void glVertexAttribI1i(int index, int x) { org.lwjgl.opengl.GL30.glVertexAttribI1i(index, x); }

	@Override
	public void glVertexAttribI1iv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI1iv(index, v); }

	@Override
	public void glVertexAttribI1ui(int index, int x) { org.lwjgl.opengl.GL30.glVertexAttribI1ui(index, x); }

	@Override
	public void glVertexAttribI1uiv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI1uiv(index, v); }

	@Override
	public void glVertexAttribI2i(int index, int x, int y) { org.lwjgl.opengl.GL30.glVertexAttribI2i(index, x, y); }

	@Override
	public void glVertexAttribI2iv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI2iv(index, v); }

	@Override
	public void glVertexAttribI2ui(int index, int x, int y) { org.lwjgl.opengl.GL30.glVertexAttribI2ui(index, x, y); }

	@Override
	public void glVertexAttribI2uiv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI2uiv(index, v); }

	@Override
	public void glVertexAttribI3i(int index, int x, int y, int z) { org.lwjgl.opengl.GL30.glVertexAttribI3i(index, x, y, z); }

	@Override
	public void glVertexAttribI3iv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI3iv(index, v); }

	@Override
	public void glVertexAttribI3ui(int index, int x, int y, int z) { org.lwjgl.opengl.GL30.glVertexAttribI3ui(index, x, y, z); }

	@Override
	public void glVertexAttribI3uiv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI3uiv(index, v); }

	@Override
	public void glVertexAttribI4bv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4bv(index, v); }

	@Override
	public void glVertexAttribI4i(int index, int x, int y, int z, int w) { org.lwjgl.opengl.GL30.glVertexAttribI4i(index, x, y, z, w); }

	@Override
	public void glVertexAttribI4iv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4iv(index, v); }

	@Override
	public void glVertexAttribI4sv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4sv(index, v); }

	@Override
	public void glVertexAttribI4ubv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4ubv(index, v); }

	@Override
	public void glVertexAttribI4ui(int index, int x, int y, int z, int w) { org.lwjgl.opengl.GL30.glVertexAttribI4ui(index, x, y, z, w); }

	@Override
	public void glVertexAttribI4uiv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4uiv(index, v); }

	@Override
	public void glVertexAttribI4usv(int index, long v) { org.lwjgl.opengl.GL30.nglVertexAttribI4usv(index, v); }

	@Override
	public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) { org.lwjgl.opengl.GL43.glVertexAttribIFormat(attribindex, size, type, relativeoffset); }

	@Override
	public void glVertexAttribIPointer(int index, int size, int type, int stride, long pointer) { org.lwjgl.opengl.GL30.nglVertexAttribIPointer(index, size, type, stride, pointer); }

	@Override
	public void glVertexAttribL1d(int index, double x) { org.lwjgl.opengl.GL41.glVertexAttribL1d(index, x); }

	@Override
	public void glVertexAttribL1dv(int index, long v) { org.lwjgl.opengl.GL41.nglVertexAttribL1dv(index, v); }

	@Override
	public void glVertexAttribL2d(int index, double x, double y) { org.lwjgl.opengl.GL41.glVertexAttribL2d(index, x, y); }

	@Override
	public void glVertexAttribL2dv(int index, long v) { org.lwjgl.opengl.GL41.nglVertexAttribL2dv(index, v); }

	@Override
	public void glVertexAttribL3d(int index, double x, double y, double z) { org.lwjgl.opengl.GL41.glVertexAttribL3d(index, x, y, z); }

	@Override
	public void glVertexAttribL3dv(int index, long v) { org.lwjgl.opengl.GL41.nglVertexAttribL3dv(index, v); }

	@Override
	public void glVertexAttribL4d(int index, double x, double y, double z, double w) { org.lwjgl.opengl.GL41.glVertexAttribL4d(index, x, y, z, w); }

	@Override
	public void glVertexAttribL4dv(int index, long v) { org.lwjgl.opengl.GL41.nglVertexAttribL4dv(index, v); }

	@Override
	public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) { org.lwjgl.opengl.GL43.glVertexAttribLFormat(attribindex, size, type, relativeoffset); }

	@Override
	public void glVertexAttribLPointer(int index, int size, int type, int stride, long pointer) { org.lwjgl.opengl.GL41.glVertexAttribLPointer(index, size, type, stride, pointer); }

	@Override
	public void glVertexAttribP1ui(int index, int type, boolean normalized, int value) { org.lwjgl.opengl.GL33.glVertexAttribP1ui(index, type, normalized, value); }

	@Override
	public void glVertexAttribP1uiv(int index, int type, boolean normalized, long value) { org.lwjgl.opengl.GL33.nglVertexAttribP1uiv(index, type, normalized, value); }

	@Override
	public void glVertexAttribP2ui(int index, int type, boolean normalized, int value) { org.lwjgl.opengl.GL33.glVertexAttribP2ui(index, type, normalized, value); }

	@Override
	public void glVertexAttribP2uiv(int index, int type, boolean normalized, long value) { org.lwjgl.opengl.GL33.nglVertexAttribP2uiv(index, type, normalized, value); }

	@Override
	public void glVertexAttribP3ui(int index, int type, boolean normalized, int value) { org.lwjgl.opengl.GL33.glVertexAttribP3ui(index, type, normalized, value); }

	@Override
	public void glVertexAttribP3uiv(int index, int type, boolean normalized, long value) { org.lwjgl.opengl.GL33.nglVertexAttribP3uiv(index, type, normalized, value); }

	@Override
	public void glVertexAttribP4ui(int index, int type, boolean normalized, int value) { org.lwjgl.opengl.GL33.glVertexAttribP4ui(index, type, normalized, value); }

	@Override
	public void glVertexAttribP4uiv(int index, int type, boolean normalized, long value) { org.lwjgl.opengl.GL33.nglVertexAttribP4uiv(index, type, normalized, value); }

	@Override
	public void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) { org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, type, normalized, stride, pointer); }

	@Override
	public void glVertexBindingDivisor(int bindingindex, int divisor) { org.lwjgl.opengl.GL43.glVertexBindingDivisor(bindingindex, divisor); }

	@Override
	public void glViewport(int x, int y, int width, int height) { org.lwjgl.opengl.GL11.glViewport(x, y, width, height); }

	@Override
	public void glViewportArrayv(int first, int count, long v) { org.lwjgl.opengl.GL41.nglViewportArrayv(first, count, v); }

	@Override
	public void glViewportIndexedf(int index, float x, float y, float w, float h) { org.lwjgl.opengl.GL41.glViewportIndexedf(index, x, y, w, h); }

	@Override
	public void glViewportIndexedfv(int index, long v) { org.lwjgl.opengl.GL41.nglViewportIndexedfv(index, v); }

	@Override
	public void glWaitSync(long sync, int flags, long timeout) { org.lwjgl.opengl.GL32.glWaitSync(sync, flags, timeout); }

}