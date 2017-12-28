package org.objct.gl.wrapper;

import org.objct.gl.enums.*;
import org.objkt.memory.*;

public abstract class Wrapper  {
	MemBlock mb = new MemBlock().allocate(Float.BYTES * 64);
	public abstract void glActiveShaderProgram(int pipeline, int program);
	public final void activeShaderProgram(int pipeline, int program) { glActiveShaderProgram(pipeline, program); }

	public abstract void glActiveTexture(int texture);
	public final void activeTexture(TextureUnit texture) { glActiveTexture(texture.token); }

	public abstract void glAttachShader(int program, int shader);
	public final void attachShader(int program, int shader) { glAttachShader(program, shader); }

	public abstract void glBeginQuery(int target, int id);
	public final void beginQuery(QueryTarget target, int id) { glBeginQuery(target.token, id); }

	public abstract void glBeginTransformFeedback(int primitiveMode);
	public final void beginTransformFeedback(PrimitiveType primitiveMode) { glBeginTransformFeedback(primitiveMode.token); }

	public abstract void glBindAttribLocation(int program, int index, long name);
	public final void bindAttribLocation(int program, int index, long name) { glBindAttribLocation(program, index, name); }

	public abstract void glBindBuffer(int target, int buffer);
	public final void bindBuffer(BufferTarget target, int buffer) { glBindBuffer(target.token, buffer); }

	public abstract void glBindBufferBase(int target, int index, int buffer);
	public final void bindBufferBase(BufferTarget target, int index, int buffer) { glBindBufferBase(target.token, index, buffer); }

	public abstract void glBindBufferRange(int target, int index, int buffer, long offset, long size);
	public final void bindBufferRange(BufferTarget target, int index, int buffer, long offset, long size) { glBindBufferRange(target.token, index, buffer, offset, size); }

	public abstract void glBindFramebuffer(int target, int framebuffer);
	public final void bindFramebuffer(FramebufferTarget target, int framebuffer) { glBindFramebuffer(target.token, framebuffer); }

	public abstract void glBindImageTexture(int unit, int texture, int level, boolean layered, int layer, int access, int format);
	public final void bindImageTexture(int unit, int texture, int level, boolean layered, int layer, BufferAccessARB access, InternalFormat format) { glBindImageTexture(unit, texture, level, layered, layer, access.token, format.token); }

	public abstract void glBindProgramPipeline(int pipeline);
	public final void bindProgramPipeline(int pipeline) { glBindProgramPipeline(pipeline); }

	public abstract void glBindRenderbuffer(int target, int renderbuffer);
	public final void bindRenderbuffer(RenderbufferTarget target, int renderbuffer) { glBindRenderbuffer(target.token, renderbuffer); }

	public abstract void glBindSampler(int unit, int sampler);
	public final void bindSampler(int unit, int sampler) { glBindSampler(unit, sampler); }

	public abstract void glBindTexture(int target, int texture);
	public final void bindTexture(TextureTarget target, int texture) { glBindTexture(target.token, texture); }

	public abstract void glBindTransformFeedback(int target, int id);
	public final void bindTransformFeedback(BindTransformFeedbackTarget target, int id) { glBindTransformFeedback(target.token, id); }

	public abstract void glBindVertexArray(int array);
	public final void bindVertexArray(int array) { glBindVertexArray(array); }

	public abstract void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride);
	public final void bindVertexBuffer(int bindingindex, int buffer, long offset, int stride) { glBindVertexBuffer(bindingindex, buffer, offset, stride); }

	public abstract void glBlendColor(float red, float green, float blue, float alpha);
	public final void blendColor(float red, float green, float blue, float alpha) { glBlendColor(red, green, blue, alpha); }

	public abstract void glBlendEquation(int mode);
	public final void blendEquation(BlendEquationModeEXT mode) { glBlendEquation(mode.token); }

	public abstract void glBlendEquationSeparate(int modeRGB, int modeAlpha);
	public final void blendEquationSeparate(BlendEquationModeEXT modeRGB, BlendEquationModeEXT modeAlpha) { glBlendEquationSeparate(modeRGB.token, modeAlpha.token); }

	public abstract void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha);
	public final void blendEquationSeparatei(int buf, BlendEquationModeEXT modeRGB, BlendEquationModeEXT modeAlpha) { glBlendEquationSeparatei(buf, modeRGB.token, modeAlpha.token); }

	public abstract void glBlendEquationi(int buf, int mode);
	public final void blendEquationi(int buf, BlendEquationModeEXT mode) { glBlendEquationi(buf, mode.token); }

	public abstract void glBlendFunc(int sfactor, int dfactor);
	public final void blendFunc(BlendingFactor sfactor, BlendingFactor dfactor) { glBlendFunc(sfactor.token, dfactor.token); }

	public abstract void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha);
	public final void blendFuncSeparate(BlendingFactor sfactorRGB, BlendingFactor dfactorRGB, BlendingFactor sfactorAlpha, BlendingFactor dfactorAlpha) { glBlendFuncSeparate(sfactorRGB.token, dfactorRGB.token, sfactorAlpha.token, dfactorAlpha.token); }

	public abstract void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
	public final void blendFuncSeparatei(int buf, BlendingFactor srcRGB, BlendingFactor dstRGB, BlendingFactor srcAlpha, BlendingFactor dstAlpha) { glBlendFuncSeparatei(buf, srcRGB.token, dstRGB.token, srcAlpha.token, dstAlpha.token); }

	public abstract void glBlendFunci(int buf, int src, int dst);
	public final void blendFunci(int buf, BlendingFactor src, BlendingFactor dst) { glBlendFunci(buf, src.token, dst.token); }

	public abstract void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter);
	public final void blitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, ClearBufferMask.Mask mask, BlitFramebufferFilter filter) { glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask.value(), filter.token); }

	public abstract void glBufferData(int target, long size, long data, int usage);
	public final void bufferData(BufferTarget target, long size, long data, BufferUsage usage) { glBufferData(target.token, size, data, usage.token); }

	public abstract void glBufferSubData(int target, long offset, long size, long data);
	public final void bufferSubData(BufferTarget target, long offset, long size, long data) { glBufferSubData(target.token, offset, size, data); }

	public abstract int glCheckFramebufferStatus(int target);
	public final FramebufferStatus checkFramebufferStatus(FramebufferTarget target) { return FramebufferStatus.get(glCheckFramebufferStatus(target.token)); }

	public abstract void glClear(int mask);
	public final void clear(ClearBufferMask.Mask mask) { glClear(mask.value()); }

	public abstract void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil);
	public final void clearBufferfi(Buffer buffer, int drawbuffer, float depth, int stencil) { glClearBufferfi(buffer.token, drawbuffer, depth, stencil); }

	public abstract void glClearBufferfv(int buffer, int drawbuffer, long value);
	public final void clearBufferfv(Buffer buffer, int drawbuffer, long value) { glClearBufferfv(buffer.token, drawbuffer, value); }

	public abstract void glClearBufferiv(int buffer, int drawbuffer, long value);
	public final void clearBufferiv(Buffer buffer, int drawbuffer, long value) { glClearBufferiv(buffer.token, drawbuffer, value); }

	public abstract void glClearBufferuiv(int buffer, int drawbuffer, long value);
	public final void clearBufferuiv(Buffer buffer, int drawbuffer, long value) { glClearBufferuiv(buffer.token, drawbuffer, value); }

	public abstract void glClearColor(float red, float green, float blue, float alpha);
	public final void clearColor(float red, float green, float blue, float alpha) { glClearColor(red, green, blue, alpha); }

	public abstract void glClearDepthf(float d);
	public final void clearDepthf(float d) { glClearDepthf(d); }

	public abstract void glClearStencil(int s);
	public final void clearStencil(int s) { glClearStencil(s); }

	public abstract int glClientWaitSync(long sync, int flags, long timeout);
	public final SyncStatus clientWaitSync(long sync, SyncObjectMask.Mask flags, long timeout) { return SyncStatus.get(glClientWaitSync(sync, flags.value(), timeout)); }

	public abstract void glColorMask(boolean red, boolean green, boolean blue, boolean alpha);
	public final void colorMask(boolean red, boolean green, boolean blue, boolean alpha) { glColorMask(red, green, blue, alpha); }

	public abstract void glColorMaski(int index, boolean r, boolean g, boolean b, boolean a);
	public final void colorMaski(int index, boolean r, boolean g, boolean b, boolean a) { glColorMaski(index, r, g, b, a); }

	public abstract void glCompileShader(int shader);
	public final void compileShader(int shader) { glCompileShader(shader); }

	public abstract void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, long data);
	public final void compressedTexImage2D(TextureTarget target, int level, InternalFormat internalformat, int width, int height, int border, int imageSize, long data) { glCompressedTexImage2D(target.token, level, internalformat.token, width, height, border, imageSize, data); }

	public abstract void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, long data);
	public final void compressedTexImage3D(TextureTarget target, int level, InternalFormat internalformat, int width, int height, int depth, int border, int imageSize, long data) { glCompressedTexImage3D(target.token, level, internalformat.token, width, height, depth, border, imageSize, data); }

	public abstract void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data);
	public final void compressedTexSubImage2D(TextureTarget target, int level, int xoffset, int yoffset, int width, int height, PixelFormat format, int imageSize, long data) { glCompressedTexSubImage2D(target.token, level, xoffset, yoffset, width, height, format.token, imageSize, data); }

	public abstract void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data);
	public final void compressedTexSubImage3D(TextureTarget target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, int imageSize, long data) { glCompressedTexSubImage3D(target.token, level, xoffset, yoffset, zoffset, width, height, depth, format.token, imageSize, data); }

	public abstract void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size);
	public final void copyBufferSubData(CopyBufferSubDataTarget readTarget, CopyBufferSubDataTarget writeTarget, long readOffset, long writeOffset, long size) { glCopyBufferSubData(readTarget.token, writeTarget.token, readOffset, writeOffset, size); }

	public abstract void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth);
	public final void copyImageSubData(int srcName, CopyBufferSubDataTarget srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, CopyBufferSubDataTarget dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) { glCopyImageSubData(srcName, srcTarget.token, srcLevel, srcX, srcY, srcZ, dstName, dstTarget.token, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth); }

	public abstract void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);
	public final void copyTexImage2D(TextureTarget target, int level, InternalFormat internalformat, int x, int y, int width, int height, int border) { glCopyTexImage2D(target.token, level, internalformat.token, x, y, width, height, border); }

	public abstract void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);
	public final void copyTexSubImage2D(TextureTarget target, int level, int xoffset, int yoffset, int x, int y, int width, int height) { glCopyTexSubImage2D(target.token, level, xoffset, yoffset, x, y, width, height); }

	public abstract void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height);
	public final void copyTexSubImage3D(TextureTarget target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) { glCopyTexSubImage3D(target.token, level, xoffset, yoffset, zoffset, x, y, width, height); }

	public abstract int glCreateProgram();
	public final int createProgram() { return glCreateProgram(); }

	public abstract int glCreateShader(int type);
	public final int createShader(ShaderType type) { return glCreateShader(type.token); }

	public abstract int glCreateShaderProgramv(int type, int count, long strings);
	public final int createShaderProgramv(ShaderType type, int count, long strings) { return glCreateShaderProgramv(type.token, count, strings); }

	public abstract void glCullFace(int mode);
	public final void cullFace(CullFaceMode mode) { glCullFace(mode.token); }

	public abstract void glDebugMessageCallback(long callback, long userParam);
	public final void debugMessageCallback(long callback, long userParam) { glDebugMessageCallback(callback, userParam); }

	public abstract void glDebugMessageControl(int source, int type, int severity, int count, long ids, boolean enabled);
	public final void debugMessageControl(DebugSource source, DebugType type, DebugSeverity severity, int count, long ids, boolean enabled) { glDebugMessageControl(source.token, type.token, severity.token, count, ids, enabled); }

	public abstract void glDebugMessageInsert(int source, int type, int id, int severity, int length, long buf);
	public final void debugMessageInsert(DebugSource source, DebugType type, int id, DebugSeverity severity, int length, long buf) { glDebugMessageInsert(source.token, type.token, id, severity.token, length, buf); }

	public abstract void glDeleteBuffers(int n, long buffers);
	public final void deleteBuffers(int n, long buffers) { glDeleteBuffers(n, buffers); }
	public final void deleteBuffer(int name) { mb.putInt(0, name); glDeleteBuffers(1, mb.address()); }

	public abstract void glDeleteFramebuffers(int n, long framebuffers);
	public final void deleteFramebuffers(int n, long framebuffers) { glDeleteFramebuffers(n, framebuffers); }
	public final void deleteFramebuffer(int name) { mb.putInt(0, name); glDeleteFramebuffers(1, mb.address()); }

	public abstract void glDeleteProgram(int program);
	public final void deleteProgram(int program) { glDeleteProgram(program); }

	public abstract void glDeleteProgramPipelines(int n, long pipelines);
	public final void deleteProgramPipelines(int n, long pipelines) { glDeleteProgramPipelines(n, pipelines); }
	public final void deleteProgramPipeline(int name) { mb.putInt(0, name); glDeleteProgramPipelines(1, mb.address()); }

	public abstract void glDeleteQueries(int n, long ids);
	public final void deleteQueries(int n, long ids) { glDeleteQueries(n, ids); }
	public final void deleteQuerie(int name) { mb.putInt(0, name); glDeleteQueries(1, mb.address()); }

	public abstract void glDeleteRenderbuffers(int n, long renderbuffers);
	public final void deleteRenderbuffers(int n, long renderbuffers) { glDeleteRenderbuffers(n, renderbuffers); }
	public final void deleteRenderbuffer(int name) { mb.putInt(0, name); glDeleteRenderbuffers(1, mb.address()); }

	public abstract void glDeleteSamplers(int count, long samplers);
	public final void deleteSamplers(int count, long samplers) { glDeleteSamplers(count, samplers); }
	public final void deleteSampler(int name) { mb.putInt(0, name); glDeleteSamplers(1, mb.address()); }

	public abstract void glDeleteShader(int shader);
	public final void deleteShader(int shader) { glDeleteShader(shader); }

	public abstract void glDeleteSync(long sync);
	public final void deleteSync(long sync) { glDeleteSync(sync); }

	public abstract void glDeleteTextures(int n, long textures);
	public final void deleteTextures(int n, long textures) { glDeleteTextures(n, textures); }
	public final void deleteTexture(int name) { mb.putInt(0, name); glDeleteTextures(1, mb.address()); }

	public abstract void glDeleteTransformFeedbacks(int n, long ids);
	public final void deleteTransformFeedbacks(int n, long ids) { glDeleteTransformFeedbacks(n, ids); }
	public final void deleteTransformFeedback(int name) { mb.putInt(0, name); glDeleteTransformFeedbacks(1, mb.address()); }

	public abstract void glDeleteVertexArrays(int n, long arrays);
	public final void deleteVertexArrays(int n, long arrays) { glDeleteVertexArrays(n, arrays); }
	public final void deleteVertexArray(int name) { mb.putInt(0, name); glDeleteVertexArrays(1, mb.address()); }

	public abstract void glDepthFunc(int func);
	public final void depthFunc(DepthFunction func) { glDepthFunc(func.token); }

	public abstract void glDepthMask(boolean flag);
	public final void depthMask(boolean flag) { glDepthMask(flag); }

	public abstract void glDepthRangef(float n, float f);
	public final void depthRangef(float n, float f) { glDepthRangef(n, f); }

	public abstract void glDetachShader(int program, int shader);
	public final void detachShader(int program, int shader) { glDetachShader(program, shader); }

	public abstract void glDisable(int cap);
	public final void disable(Capability cap) { glDisable(cap.token); }

	public abstract void glDisableVertexAttribArray(int index);
	public final void disableVertexAttribArray(int index) { glDisableVertexAttribArray(index); }

	public abstract void glDisablei(int target, int index);
	public final void disablei(Capability target, int index) { glDisablei(target.token, index); }

	public abstract void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z);
	public final void dispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) { glDispatchCompute(num_groups_x, num_groups_y, num_groups_z); }

	public abstract void glDispatchComputeIndirect(long indirect);
	public final void dispatchComputeIndirect(long indirect) { glDispatchComputeIndirect(indirect); }

	public abstract void glDrawArrays(int mode, int first, int count);
	public final void drawArrays(PrimitiveType mode, int first, int count) { glDrawArrays(mode.token, first, count); }

	public abstract void glDrawArraysIndirect(int mode, long indirect);
	public final void drawArraysIndirect(PrimitiveType mode, long indirect) { glDrawArraysIndirect(mode.token, indirect); }

	public abstract void glDrawArraysInstanced(int mode, int first, int count, int instancecount);
	public final void drawArraysInstanced(PrimitiveType mode, int first, int count, int instancecount) { glDrawArraysInstanced(mode.token, first, count, instancecount); }

	public abstract void glDrawBuffers(int n, long bufs);
	public final void drawBuffers(int n, long bufs) { glDrawBuffers(n, bufs); }

	public abstract void glDrawElements(int mode, int count, int type, long indices);
	public final void drawElements(PrimitiveType mode, int count, DrawElementsType type, long indices) { glDrawElements(mode.token, count, type.token, indices); }

	public abstract void glDrawElementsBaseVertex(int mode, int count, int type, long indices, int basevertex);
	public final void drawElementsBaseVertex(PrimitiveType mode, int count, DrawElementsType type, long indices, int basevertex) { glDrawElementsBaseVertex(mode.token, count, type.token, indices, basevertex); }

	public abstract void glDrawElementsIndirect(int mode, int type, long indirect);
	public final void drawElementsIndirect(PrimitiveType mode, DrawElementsType type, long indirect) { glDrawElementsIndirect(mode.token, type.token, indirect); }

	public abstract void glDrawElementsInstanced(int mode, int count, int type, long indices, int instancecount);
	public final void drawElementsInstanced(PrimitiveType mode, int count, DrawElementsType type, long indices, int instancecount) { glDrawElementsInstanced(mode.token, count, type.token, indices, instancecount); }

	public abstract void glDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices, int instancecount, int basevertex);
	public final void drawElementsInstancedBaseVertex(PrimitiveType mode, int count, DrawElementsType type, long indices, int instancecount, int basevertex) { glDrawElementsInstancedBaseVertex(mode.token, count, type.token, indices, instancecount, basevertex); }

	public abstract void glDrawRangeElements(int mode, int start, int end, int count, int type, long indices);
	public final void drawRangeElements(PrimitiveType mode, int start, int end, int count, DrawElementsType type, long indices) { glDrawRangeElements(mode.token, start, end, count, type.token, indices); }

	public abstract void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices, int basevertex);
	public final void drawRangeElementsBaseVertex(PrimitiveType mode, int start, int end, int count, DrawElementsType type, long indices, int basevertex) { glDrawRangeElementsBaseVertex(mode.token, start, end, count, type.token, indices, basevertex); }

	public abstract void glEnable(int cap);
	public final void enable(Capability cap) { glEnable(cap.token); }

	public abstract void glEnableVertexAttribArray(int index);
	public final void enableVertexAttribArray(int index) { glEnableVertexAttribArray(index); }

	public abstract void glEnablei(int target, int index);
	public final void enablei(Capability target, int index) { glEnablei(target.token, index); }

	public abstract void glEndQuery(int target);
	public final void endQuery(QueryTarget target) { glEndQuery(target.token); }

	public abstract void glEndTransformFeedback();
	public final void endTransformFeedback() { glEndTransformFeedback(); }

	public abstract long glFenceSync(int condition, int flags);
	public final long fenceSync(SyncCondition condition, int flags) { return glFenceSync(condition.token, flags); }

	public abstract void glFinish();
	public final void finish() { glFinish(); }

	public abstract void glFlush();
	public final void flush() { glFlush(); }

	public abstract void glFlushMappedBufferRange(int target, long offset, long length);
	public final void flushMappedBufferRange(BufferTarget target, long offset, long length) { glFlushMappedBufferRange(target.token, offset, length); }

	public abstract void glFramebufferParameteri(int target, int pname, int param);
	public final void framebufferParameteri(FramebufferTarget target, FramebufferParameterName pname, int param) { glFramebufferParameteri(target.token, pname.token, param); }

	public abstract void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
	public final void framebufferRenderbuffer(FramebufferTarget target, FramebufferAttachment attachment, RenderbufferTarget renderbuffertarget, int renderbuffer) { glFramebufferRenderbuffer(target.token, attachment.token, renderbuffertarget.token, renderbuffer); }

	public abstract void glFramebufferTexture(int target, int attachment, int texture, int level);
	public final void framebufferTexture(FramebufferTarget target, FramebufferAttachment attachment, int texture, int level) { glFramebufferTexture(target.token, attachment.token, texture, level); }

	public abstract void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level);
	public final void framebufferTexture2D(FramebufferTarget target, FramebufferAttachment attachment, TextureTarget textarget, int texture, int level) { glFramebufferTexture2D(target.token, attachment.token, textarget.token, texture, level); }

	public abstract void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer);
	public final void framebufferTextureLayer(FramebufferTarget target, FramebufferAttachment attachment, int texture, int level, int layer) { glFramebufferTextureLayer(target.token, attachment.token, texture, level, layer); }

	public abstract void glFrontFace(int mode);
	public final void frontFace(FrontFaceDirection mode) { glFrontFace(mode.token); }

	public abstract void glGenBuffers(int n, long buffers);
	public final void genBuffers(int n, long buffers) { glGenBuffers(n, buffers); }
	public final int genBuffer() { glGenBuffers(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenFramebuffers(int n, long framebuffers);
	public final void genFramebuffers(int n, long framebuffers) { glGenFramebuffers(n, framebuffers); }
	public final int genFramebuffer() { glGenFramebuffers(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenProgramPipelines(int n, long pipelines);
	public final void genProgramPipelines(int n, long pipelines) { glGenProgramPipelines(n, pipelines); }
	public final int genProgramPipeline() { glGenProgramPipelines(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenQueries(int n, long ids);
	public final void genQueries(int n, long ids) { glGenQueries(n, ids); }
	public final int genQuerie() { glGenQueries(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenRenderbuffers(int n, long renderbuffers);
	public final void genRenderbuffers(int n, long renderbuffers) { glGenRenderbuffers(n, renderbuffers); }
	public final int genRenderbuffer() { glGenRenderbuffers(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenSamplers(int count, long samplers);
	public final void genSamplers(int count, long samplers) { glGenSamplers(count, samplers); }
	public final int genSampler() { glGenSamplers(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenTextures(int n, long textures);
	public final void genTextures(int n, long textures) { glGenTextures(n, textures); }
	public final int genTexture() { glGenTextures(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenTransformFeedbacks(int n, long ids);
	public final void genTransformFeedbacks(int n, long ids) { glGenTransformFeedbacks(n, ids); }
	public final int genTransformFeedback() { glGenTransformFeedbacks(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenVertexArrays(int n, long arrays);
	public final void genVertexArrays(int n, long arrays) { glGenVertexArrays(n, arrays); }
	public final int genVertexArray() { glGenVertexArrays(1, mb.address()); return mb.getInt(0); }

	public abstract void glGenerateMipmap(int target);
	public final void generateMipmap(TextureTarget target) { glGenerateMipmap(target.token); }

	public abstract void glGetActiveAttrib(int program, int index, int bufSize, long length, long size, long type, long name);
	public final void getActiveAttrib(int program, int index, int bufSize, long length, long size, long type, long name) { glGetActiveAttrib(program, index, bufSize, length, size, type, name); }

	public abstract void glGetActiveUniform(int program, int index, int bufSize, long length, long size, long type, long name);
	public final void getActiveUniform(int program, int index, int bufSize, long length, long size, long type, long name) { glGetActiveUniform(program, index, bufSize, length, size, type, name); }

	public abstract void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, long length, long uniformBlockName);
	public final void getActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, long length, long uniformBlockName) { glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName); }

	public abstract void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, long params);
	public final void getActiveUniformBlockiv(int program, int uniformBlockIndex, UniformBlockPName pname, long params) { glGetActiveUniformBlockiv(program, uniformBlockIndex, pname.token, params); }

	public abstract void glGetActiveUniformsiv(int program, int uniformCount, long uniformIndices, int pname, long params);
	public final void getActiveUniformsiv(int program, int uniformCount, long uniformIndices, UniformPName pname, long params) { glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname.token, params); }

	public abstract void glGetAttachedShaders(int program, int maxCount, long count, long shaders);
	public final void getAttachedShaders(int program, int maxCount, long count, long shaders) { glGetAttachedShaders(program, maxCount, count, shaders); }

	public abstract int glGetAttribLocation(int program, long name);
	public final int getAttribLocation(int program, long name) { return glGetAttribLocation(program, name); }

	public abstract void glGetBooleani_v(int target, int index, long data);
	public final void getBooleani_v(BufferTarget target, int index, long data) { glGetBooleani_v(target.token, index, data); }

	public abstract void glGetBooleanv(int pname, long data);
	public final void getBooleanv(GetPName pname, long data) { glGetBooleanv(pname.token, data); }

	public abstract void glGetBufferParameteri64v(int target, int pname, long params);
	public final void getBufferParameteri64v(BufferTarget target, int pname, long params) { glGetBufferParameteri64v(target.token, pname, params); }

	public abstract void glGetBufferParameteriv(int target, int pname, long params);
	public final void getBufferParameteriv(BufferTarget target, int pname, long params) { glGetBufferParameteriv(target.token, pname, params); }

	public abstract void glGetBufferPointerv(int target, int pname, long params);
	public final void getBufferPointerv(BufferTarget target, int pname, long params) { glGetBufferPointerv(target.token, pname, params); }

	public abstract int glGetDebugMessageLog(int count, int bufSize, long sources, long types, long ids, long severities, long lengths, long messageLog);
	public final int getDebugMessageLog(int count, int bufSize, long sources, long types, long ids, long severities, long lengths, long messageLog) { return glGetDebugMessageLog(count, bufSize, sources, types, ids, severities, lengths, messageLog); }

	public abstract int glGetError();
	public final ErrorCode getError() { return ErrorCode.get(glGetError()); }

	public abstract void glGetFloatv(int pname, long data);
	public final void getFloatv(GetPName pname, long data) { glGetFloatv(pname.token, data); }

	public abstract int glGetFragDataLocation(int program, long name);
	public final int getFragDataLocation(int program, long name) { return glGetFragDataLocation(program, name); }

	public abstract void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, long params);
	public final void getFramebufferAttachmentParameteriv(FramebufferTarget target, FramebufferAttachment attachment, FramebufferAttachmentParameterName pname, long params) { glGetFramebufferAttachmentParameteriv(target.token, attachment.token, pname.token, params); }

	public abstract void glGetFramebufferParameteriv(int target, int pname, long params);
	public final void getFramebufferParameteriv(FramebufferTarget target, FramebufferAttachmentParameterName pname, long params) { glGetFramebufferParameteriv(target.token, pname.token, params); }

	public abstract int glGetGraphicsResetStatus();
	public final GraphicsResetStatus getGraphicsResetStatus() { return GraphicsResetStatus.get(glGetGraphicsResetStatus()); }

	public abstract void glGetInteger64i_v(int target, int index, long data);
	public final void getInteger64i_v(TypeEnum target, int index, long data) { glGetInteger64i_v(target.token, index, data); }

	public abstract void glGetInteger64v(int pname, long data);
	public final void getInteger64v(GetPName pname, long data) { glGetInteger64v(pname.token, data); }

	public abstract void glGetIntegeri_v(int target, int index, long data);
	public final void getIntegeri_v(TypeEnum target, int index, long data) { glGetIntegeri_v(target.token, index, data); }

	public abstract void glGetIntegerv(int pname, long data);
	public final void getIntegerv(GetPName pname, long data) { glGetIntegerv(pname.token, data); }

	public abstract void glGetInternalformativ(int target, int internalformat, int pname, int bufSize, long params);
	public final void getInternalformativ(TextureTarget target, InternalFormat internalformat, InternalFormatPName pname, int bufSize, long params) { glGetInternalformativ(target.token, internalformat.token, pname.token, bufSize, params); }

	public abstract void glGetMultisamplefv(int pname, int index, long val);
	public final void getMultisamplefv(int pname, int index, long val) { glGetMultisamplefv(pname, index, val); }

	public abstract void glGetObjectLabel(int identifier, int name, int bufSize, long length, long label);
	public final void getObjectLabel(int identifier, int name, int bufSize, long length, long label) { glGetObjectLabel(identifier, name, bufSize, length, label); }

	public abstract void glGetObjectPtrLabel(long ptr, int bufSize, long length, long label);
	public final void getObjectPtrLabel(long ptr, int bufSize, long length, long label) { glGetObjectPtrLabel(ptr, bufSize, length, label); }

	public abstract void glGetPointerv(int pname, long params);
	public final void getPointerv(GetPointervPName pname, long params) { glGetPointerv(pname.token, params); }

	public abstract void glGetProgramBinary(int program, int bufSize, long length, long binaryFormat, long binary);
	public final void getProgramBinary(int program, int bufSize, long length, long binaryFormat, long binary) { glGetProgramBinary(program, bufSize, length, binaryFormat, binary); }

	public abstract void glGetProgramInfoLog(int program, int bufSize, long length, long infoLog);
	public final void getProgramInfoLog(int program, int bufSize, long length, long infoLog) { glGetProgramInfoLog(program, bufSize, length, infoLog); }

	public abstract void glGetProgramInterfaceiv(int program, int programInterface, int pname, long params);
	public final void getProgramInterfaceiv(int program, ProgramInterface programInterface, ProgramInterfacePName pname, long params) { glGetProgramInterfaceiv(program, programInterface.token, pname.token, params); }

	public abstract void glGetProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog);
	public final void getProgramPipelineInfoLog(int pipeline, int bufSize, long length, long infoLog) { glGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog); }

	public abstract void glGetProgramPipelineiv(int pipeline, int pname, long params);
	public final void getProgramPipelineiv(int pipeline, PipelineParameterName pname, long params) { glGetProgramPipelineiv(pipeline, pname.token, params); }

	public abstract int glGetProgramResourceIndex(int program, int programInterface, long name);
	public final int getProgramResourceIndex(int program, ProgramInterface programInterface, long name) { return glGetProgramResourceIndex(program, programInterface.token, name); }

	public abstract int glGetProgramResourceLocation(int program, int programInterface, long name);
	public final int getProgramResourceLocation(int program, ProgramInterface programInterface, long name) { return glGetProgramResourceLocation(program, programInterface.token, name); }

	public abstract void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, long length, long name);
	public final void getProgramResourceName(int program, ProgramInterface programInterface, int index, int bufSize, long length, long name) { glGetProgramResourceName(program, programInterface.token, index, bufSize, length, name); }

	public abstract void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, long props, int bufSize, long length, long params);
	public final void getProgramResourceiv(int program, ProgramInterface programInterface, int index, int propCount, long props, int bufSize, long length, long params) { glGetProgramResourceiv(program, programInterface.token, index, propCount, props, bufSize, length, params); }

	public abstract void glGetProgramiv(int program, int pname, long params);
	public final void getProgramiv(int program, ProgramPropertyARB pname, long params) { glGetProgramiv(program, pname.token, params); }
	public final int getProgrami(int program, ProgramPropertyARB pname) { glGetProgramiv(program, pname.token, mb.address()); return mb.getInt(0); }

	public abstract void glGetQueryObjectuiv(int id, int pname, long params);
	public final void getQueryObjectuiv(int id, QueryObjectParameterName pname, long params) { glGetQueryObjectuiv(id, pname.token, params); }

	public abstract void glGetQueryiv(int target, int pname, long params);
	public final void getQueryiv(QueryTarget target, QueryParameterName pname, long params) { glGetQueryiv(target.token, pname.token, params); }

	public abstract void glGetRenderbufferParameteriv(int target, int pname, long params);
	public final void getRenderbufferParameteriv(RenderbufferTarget target, RenderbufferParameterName pname, long params) { glGetRenderbufferParameteriv(target.token, pname.token, params); }

	public abstract void glGetSamplerParameterIiv(int sampler, int pname, long params);
	public final void getSamplerParameterIiv(int sampler, SamplerParameterName pname, long params) { glGetSamplerParameterIiv(sampler, pname.token, params); }

	public abstract void glGetSamplerParameterIuiv(int sampler, int pname, long params);
	public final void getSamplerParameterIuiv(int sampler, SamplerParameterName pname, long params) { glGetSamplerParameterIuiv(sampler, pname.token, params); }

	public abstract void glGetSamplerParameterfv(int sampler, int pname, long params);
	public final void getSamplerParameterfv(int sampler, SamplerParameterName pname, long params) { glGetSamplerParameterfv(sampler, pname.token, params); }

	public abstract void glGetSamplerParameteriv(int sampler, int pname, long params);
	public final void getSamplerParameteriv(int sampler, SamplerParameterName pname, long params) { glGetSamplerParameteriv(sampler, pname.token, params); }

	public abstract void glGetShaderInfoLog(int shader, int bufSize, long length, long infoLog);
	public final void getShaderInfoLog(int shader, int bufSize, long length, long infoLog) { glGetShaderInfoLog(shader, bufSize, length, infoLog); }

	public abstract void glGetShaderPrecisionFormat(int shadertype, int precisiontype, long range, long precision);
	public final void getShaderPrecisionFormat(ShaderType shadertype, PrecisionType precisiontype, long range, long precision) { glGetShaderPrecisionFormat(shadertype.token, precisiontype.token, range, precision); }

	public abstract void glGetShaderSource(int shader, int bufSize, long length, long source);
	public final void getShaderSource(int shader, int bufSize, long length, long source) { glGetShaderSource(shader, bufSize, length, source); }

	public abstract void glGetShaderiv(int shader, int pname, long params);
	public final void getShaderiv(int shader, ShaderParameterName pname, long params) { glGetShaderiv(shader, pname.token, params); }

	public abstract long glGetString(int name);
	public final long getString(StringName name) { return glGetString(name.token); }

	public abstract long glGetStringi(int name, int index);
	public final long getStringi(StringName name, int index) { return glGetStringi(name.token, index); }

	public abstract void glGetSynciv(long sync, int pname, int bufSize, long length, long values);
	public final void getSynciv(long sync, SyncParameterName pname, int bufSize, long length, long values) { glGetSynciv(sync, pname.token, bufSize, length, values); }

	public abstract void glGetTexLevelParameterfv(int target, int level, int pname, long params);
	public final void getTexLevelParameterfv(TextureTarget target, int level, GetTextureParameter pname, long params) { glGetTexLevelParameterfv(target.token, level, pname.token, params); }

	public abstract void glGetTexLevelParameteriv(int target, int level, int pname, long params);
	public final void getTexLevelParameteriv(TextureTarget target, int level, GetTextureParameter pname, long params) { glGetTexLevelParameteriv(target.token, level, pname.token, params); }

	public abstract void glGetTexParameterIiv(int target, int pname, long params);
	public final void getTexParameterIiv(TextureTarget target, GetTextureParameter pname, long params) { glGetTexParameterIiv(target.token, pname.token, params); }

	public abstract void glGetTexParameterIuiv(int target, int pname, long params);
	public final void getTexParameterIuiv(TextureTarget target, GetTextureParameter pname, long params) { glGetTexParameterIuiv(target.token, pname.token, params); }

	public abstract void glGetTexParameterfv(int target, int pname, long params);
	public final void getTexParameterfv(TextureTarget target, GetTextureParameter pname, long params) { glGetTexParameterfv(target.token, pname.token, params); }

	public abstract void glGetTexParameteriv(int target, int pname, long params);
	public final void getTexParameteriv(TextureTarget target, GetTextureParameter pname, long params) { glGetTexParameteriv(target.token, pname.token, params); }

	public abstract void glGetTransformFeedbackVarying(int program, int index, int bufSize, long length, long size, long type, long name);
	public final void getTransformFeedbackVarying(int program, int index, int bufSize, long length, long size, long type, long name) { glGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name); }

	public abstract int glGetUniformBlockIndex(int program, long uniformBlockName);
	public final int getUniformBlockIndex(int program, long uniformBlockName) { return glGetUniformBlockIndex(program, uniformBlockName); }

	public abstract void glGetUniformIndices(int program, int uniformCount, long uniformNames, long uniformIndices);
	public final void getUniformIndices(int program, int uniformCount, long uniformNames, long uniformIndices) { glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices); }

	public abstract int glGetUniformLocation(int program, long name);
	public final int getUniformLocation(int program, long name) { return glGetUniformLocation(program, name); }

	public abstract void glGetUniformfv(int program, int location, long params);
	public final void getUniformfv(int program, int location, long params) { glGetUniformfv(program, location, params); }

	public abstract void glGetUniformiv(int program, int location, long params);
	public final void getUniformiv(int program, int location, long params) { glGetUniformiv(program, location, params); }

	public abstract void glGetUniformuiv(int program, int location, long params);
	public final void getUniformuiv(int program, int location, long params) { glGetUniformuiv(program, location, params); }

	public abstract void glGetVertexAttribIiv(int index, int pname, long params);
	public final void getVertexAttribIiv(int index, VertexAttribEnum pname, long params) { glGetVertexAttribIiv(index, pname.token, params); }

	public abstract void glGetVertexAttribIuiv(int index, int pname, long params);
	public final void getVertexAttribIuiv(int index, VertexAttribEnum pname, long params) { glGetVertexAttribIuiv(index, pname.token, params); }

	public abstract void glGetVertexAttribPointerv(int index, int pname, long pointer);
	public final void getVertexAttribPointerv(int index, int pname, long pointer) { glGetVertexAttribPointerv(index, pname, pointer); }

	public abstract void glGetVertexAttribfv(int index, int pname, long params);
	public final void getVertexAttribfv(int index, int pname, long params) { glGetVertexAttribfv(index, pname, params); }

	public abstract void glGetVertexAttribiv(int index, int pname, long params);
	public final void getVertexAttribiv(int index, int pname, long params) { glGetVertexAttribiv(index, pname, params); }

	public abstract void glGetnUniformfv(int program, int location, int bufSize, long params);
	public final void getnUniformfv(int program, int location, int bufSize, long params) { glGetnUniformfv(program, location, bufSize, params); }

	public abstract void glGetnUniformiv(int program, int location, int bufSize, long params);
	public final void getnUniformiv(int program, int location, int bufSize, long params) { glGetnUniformiv(program, location, bufSize, params); }

	public abstract void glGetnUniformuiv(int program, int location, int bufSize, long params);
	public final void getnUniformuiv(int program, int location, int bufSize, long params) { glGetnUniformuiv(program, location, bufSize, params); }

	public abstract void glHint(int target, int mode);
	public final void hint(HintTarget target, HintMode mode) { glHint(target.token, mode.token); }

	public abstract void glInvalidateFramebuffer(int target, int numAttachments, long attachments);
	public final void invalidateFramebuffer(FramebufferTarget target, int numAttachments, long attachments) { glInvalidateFramebuffer(target.token, numAttachments, attachments); }

	public abstract void glInvalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height);
	public final void invalidateSubFramebuffer(int target, int numAttachments, long attachments, int x, int y, int width, int height) { glInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height); }

	public abstract boolean glIsBuffer(int buffer);
	public final boolean isBuffer(int buffer) { return glIsBuffer(buffer); }

	public abstract boolean glIsEnabled(int cap);
	public final boolean isEnabled(Capability cap) { return glIsEnabled(cap.token); }

	public abstract boolean glIsEnabledi(int target, int index);
	public final boolean isEnabledi(Capability target, int index) { return glIsEnabledi(target.token, index); }

	public abstract boolean glIsFramebuffer(int framebuffer);
	public final boolean isFramebuffer(int framebuffer) { return glIsFramebuffer(framebuffer); }

	public abstract boolean glIsProgram(int program);
	public final boolean isProgram(int program) { return glIsProgram(program); }

	public abstract boolean glIsProgramPipeline(int pipeline);
	public final boolean isProgramPipeline(int pipeline) { return glIsProgramPipeline(pipeline); }

	public abstract boolean glIsQuery(int id);
	public final boolean isQuery(int id) { return glIsQuery(id); }

	public abstract boolean glIsRenderbuffer(int renderbuffer);
	public final boolean isRenderbuffer(int renderbuffer) { return glIsRenderbuffer(renderbuffer); }

	public abstract boolean glIsSampler(int sampler);
	public final boolean isSampler(int sampler) { return glIsSampler(sampler); }

	public abstract boolean glIsShader(int shader);
	public final boolean isShader(int shader) { return glIsShader(shader); }

	public abstract boolean glIsSync(long sync);
	public final boolean isSync(long sync) { return glIsSync(sync); }

	public abstract boolean glIsTexture(int texture);
	public final boolean isTexture(int texture) { return glIsTexture(texture); }

	public abstract boolean glIsTransformFeedback(int id);
	public final boolean isTransformFeedback(int id) { return glIsTransformFeedback(id); }

	public abstract boolean glIsVertexArray(int array);
	public final boolean isVertexArray(int array) { return glIsVertexArray(array); }

	public abstract void glLineWidth(float width);
	public final void lineWidth(float width) { glLineWidth(width); }

	public abstract void glLinkProgram(int program);
	public final void linkProgram(int program) { glLinkProgram(program); }

	public abstract void glLogicOp(int opcode);
	public final void logicOp(LogicOp opcode) { glLogicOp(opcode.token); }

	public abstract long glMapBufferRange(int target, long offset, long length, int access);
	public final long mapBufferRange(BufferTarget target, long offset, long length, BufferAccessMask access) { return glMapBufferRange(target.token, offset, length, access.token); }

	public abstract void glMemoryBarrier(int barriers);
	public final void memoryBarrier(MemoryBarrierMask.Mask barriers) { glMemoryBarrier(barriers.value()); }

	public abstract void glMemoryBarrierByRegion(int barriers);
	public final void memoryBarrierByRegion(MemoryBarrierMask.Mask barriers) { glMemoryBarrierByRegion(barriers.value()); }

	public abstract void glMinSampleShading(float value);
	public final void minSampleShading(float value) { glMinSampleShading(value); }

	public abstract void glObjectLabel(int identifier, int name, int length, long label);
	public final void objectLabel(ObjectIdentifier identifier, int name, int length, long label) { glObjectLabel(identifier.token, name, length, label); }

	public abstract void glObjectPtrLabel(long ptr, int length, long label);
	public final void objectPtrLabel(long ptr, int length, long label) { glObjectPtrLabel(ptr, length, label); }

	public abstract void glPatchParameteri(int pname, int value);
	public final void patchParameteri(PatchParameterName pname, int value) { glPatchParameteri(pname.token, value); }

	public abstract void glPauseTransformFeedback();
	public final void pauseTransformFeedback() { glPauseTransformFeedback(); }

	public abstract void glPixelStorei(int pname, int param);
	public final void pixelStorei(PixelStoreParameter pname, int param) { glPixelStorei(pname.token, param); }

	public abstract void glPointParameterf(int pname, float param);
	public final void pointParameterf(int pname, float param) { glPointParameterf(pname, param); }

	public abstract void glPointParameterfv(int pname, long params);
	public final void pointParameterfv(int pname, long params) { glPointParameterfv(pname, params); }

	public abstract void glPointSize(float size);
	public final void pointSize(float size) { glPointSize(size); }

	public abstract void glPolygonOffset(float factor, float units);
	public final void polygonOffset(float factor, float units) { glPolygonOffset(factor, units); }

	public abstract void glPopDebugGroup();
	public final void popDebugGroup() { glPopDebugGroup(); }

	public abstract void glProgramBinary(int program, int binaryFormat, long binary, int length);
	public final void programBinary(int program, int binaryFormat, long binary, int length) { glProgramBinary(program, binaryFormat, binary, length); }

	public abstract void glProgramParameteri(int program, int pname, int value);
	public final void programParameteri(int program, ProgramParameterPName pname, int value) { glProgramParameteri(program, pname.token, value); }

	public abstract void glProgramUniform1f(int program, int location, float v0);
	public final void programUniform1f(int program, int location, float v0) { glProgramUniform1f(program, location, v0); }

	public abstract void glProgramUniform1fv(int program, int location, int count, long value);
	public final void programUniform1fv(int program, int location, int count, long value) { glProgramUniform1fv(program, location, count, value); }

	public abstract void glProgramUniform1i(int program, int location, int v0);
	public final void programUniform1i(int program, int location, int v0) { glProgramUniform1i(program, location, v0); }

	public abstract void glProgramUniform1iv(int program, int location, int count, long value);
	public final void programUniform1iv(int program, int location, int count, long value) { glProgramUniform1iv(program, location, count, value); }

	public abstract void glProgramUniform1ui(int program, int location, int v0);
	public final void programUniform1ui(int program, int location, int v0) { glProgramUniform1ui(program, location, v0); }

	public abstract void glProgramUniform1uiv(int program, int location, int count, long value);
	public final void programUniform1uiv(int program, int location, int count, long value) { glProgramUniform1uiv(program, location, count, value); }

	public abstract void glProgramUniform2f(int program, int location, float v0, float v1);
	public final void programUniform2f(int program, int location, float v0, float v1) { glProgramUniform2f(program, location, v0, v1); }

	public abstract void glProgramUniform2fv(int program, int location, int count, long value);
	public final void programUniform2fv(int program, int location, int count, long value) { glProgramUniform2fv(program, location, count, value); }

	public abstract void glProgramUniform2i(int program, int location, int v0, int v1);
	public final void programUniform2i(int program, int location, int v0, int v1) { glProgramUniform2i(program, location, v0, v1); }

	public abstract void glProgramUniform2iv(int program, int location, int count, long value);
	public final void programUniform2iv(int program, int location, int count, long value) { glProgramUniform2iv(program, location, count, value); }

	public abstract void glProgramUniform2ui(int program, int location, int v0, int v1);
	public final void programUniform2ui(int program, int location, int v0, int v1) { glProgramUniform2ui(program, location, v0, v1); }

	public abstract void glProgramUniform2uiv(int program, int location, int count, long value);
	public final void programUniform2uiv(int program, int location, int count, long value) { glProgramUniform2uiv(program, location, count, value); }

	public abstract void glProgramUniform3f(int program, int location, float v0, float v1, float v2);
	public final void programUniform3f(int program, int location, float v0, float v1, float v2) { glProgramUniform3f(program, location, v0, v1, v2); }

	public abstract void glProgramUniform3fv(int program, int location, int count, long value);
	public final void programUniform3fv(int program, int location, int count, long value) { glProgramUniform3fv(program, location, count, value); }

	public abstract void glProgramUniform3i(int program, int location, int v0, int v1, int v2);
	public final void programUniform3i(int program, int location, int v0, int v1, int v2) { glProgramUniform3i(program, location, v0, v1, v2); }

	public abstract void glProgramUniform3iv(int program, int location, int count, long value);
	public final void programUniform3iv(int program, int location, int count, long value) { glProgramUniform3iv(program, location, count, value); }

	public abstract void glProgramUniform3ui(int program, int location, int v0, int v1, int v2);
	public final void programUniform3ui(int program, int location, int v0, int v1, int v2) { glProgramUniform3ui(program, location, v0, v1, v2); }

	public abstract void glProgramUniform3uiv(int program, int location, int count, long value);
	public final void programUniform3uiv(int program, int location, int count, long value) { glProgramUniform3uiv(program, location, count, value); }

	public abstract void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3);
	public final void programUniform4f(int program, int location, float v0, float v1, float v2, float v3) { glProgramUniform4f(program, location, v0, v1, v2, v3); }

	public abstract void glProgramUniform4fv(int program, int location, int count, long value);
	public final void programUniform4fv(int program, int location, int count, long value) { glProgramUniform4fv(program, location, count, value); }

	public abstract void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3);
	public final void programUniform4i(int program, int location, int v0, int v1, int v2, int v3) { glProgramUniform4i(program, location, v0, v1, v2, v3); }

	public abstract void glProgramUniform4iv(int program, int location, int count, long value);
	public final void programUniform4iv(int program, int location, int count, long value) { glProgramUniform4iv(program, location, count, value); }

	public abstract void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3);
	public final void programUniform4ui(int program, int location, int v0, int v1, int v2, int v3) { glProgramUniform4ui(program, location, v0, v1, v2, v3); }

	public abstract void glProgramUniform4uiv(int program, int location, int count, long value);
	public final void programUniform4uiv(int program, int location, int count, long value) { glProgramUniform4uiv(program, location, count, value); }

	public abstract void glProgramUniformMatrix2fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2x3fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2x3fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2x4fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2x4fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3x2fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3x2fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3x4fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3x4fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4x2fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4x2fv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4x3fv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4x3fv(program, location, count, transpose, value); }

	public abstract void glPushDebugGroup(int source, int id, int length, long message);
	public final void pushDebugGroup(DebugSource source, int id, int length, long message) { glPushDebugGroup(source.token, id, length, message); }

	public abstract void glReadBuffer(int src);
	public final void readBuffer(ReadBufferMode src) { glReadBuffer(src.token); }

	public abstract void glReadPixels(int x, int y, int width, int height, int format, int type, long pixels);
	public final void readPixels(int x, int y, int width, int height, PixelFormat format, PixelType type, long pixels) { glReadPixels(x, y, width, height, format.token, type.token, pixels); }

	public abstract void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, long data);
	public final void readnPixels(int x, int y, int width, int height, PixelFormat format, PixelType type, int bufSize, long data) { glReadnPixels(x, y, width, height, format.token, type.token, bufSize, data); }

	public abstract void glReleaseShaderCompiler();
	public final void releaseShaderCompiler() { glReleaseShaderCompiler(); }

	public abstract void glRenderbufferStorage(int target, int internalformat, int width, int height);
	public final void renderbufferStorage(RenderbufferTarget target, InternalFormat internalformat, int width, int height) { glRenderbufferStorage(target.token, internalformat.token, width, height); }

	public abstract void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height);
	public final void renderbufferStorageMultisample(RenderbufferTarget target, int samples, InternalFormat internalformat, int width, int height) { glRenderbufferStorageMultisample(target.token, samples, internalformat.token, width, height); }

	public abstract void glResumeTransformFeedback();
	public final void resumeTransformFeedback() { glResumeTransformFeedback(); }

	public abstract void glSampleCoverage(float value, boolean invert);
	public final void sampleCoverage(float value, boolean invert) { glSampleCoverage(value, invert); }

	public abstract void glSampleMaski(int maskNumber, int mask);
	public final void sampleMaski(int maskNumber, int mask) { glSampleMaski(maskNumber, mask); }

	public abstract void glSamplerParameterIiv(int sampler, int pname, long param);
	public final void samplerParameterIiv(int sampler, SamplerParameterName pname, long param) { glSamplerParameterIiv(sampler, pname.token, param); }

	public abstract void glSamplerParameterIuiv(int sampler, int pname, long param);
	public final void samplerParameterIuiv(int sampler, SamplerParameterName pname, long param) { glSamplerParameterIuiv(sampler, pname.token, param); }

	public abstract void glSamplerParameterf(int sampler, int pname, float param);
	public final void samplerParameterf(int sampler, SamplerParameterName pname, float param) { glSamplerParameterf(sampler, pname.token, param); }

	public abstract void glSamplerParameterfv(int sampler, int pname, long param);
	public final void samplerParameterfv(int sampler, SamplerParameterName pname, long param) { glSamplerParameterfv(sampler, pname.token, param); }

	public abstract void glSamplerParameteri(int sampler, int pname, int param);
	public final void samplerParameteri(int sampler, SamplerParameterName pname, int param) { glSamplerParameteri(sampler, pname.token, param); }

	public abstract void glSamplerParameteriv(int sampler, int pname, long param);
	public final void samplerParameteriv(int sampler, SamplerParameterName pname, long param) { glSamplerParameteriv(sampler, pname.token, param); }

	public abstract void glScissor(int x, int y, int width, int height);
	public final void scissor(int x, int y, int width, int height) { glScissor(x, y, width, height); }

	public abstract void glShaderBinary(int count, long shaders, int binaryformat, long binary, int length);
	public final void shaderBinary(int count, long shaders, int binaryformat, long binary, int length) { glShaderBinary(count, shaders, binaryformat, binary, length); }

	public abstract void glShaderSource(int shader, int count, long string, long length);
	public final void shaderSource(int shader, int count, long string, long length) { glShaderSource(shader, count, string, length); }
	public final void shaderSource(int shader, java.lang.String source) { glShaderSource(shader, 1, mb.putLong(0, Utils.addressOfStringUTF8(source, true)).address(), 0); }

	public abstract void glStencilFunc(int func, int ref, int mask);
	public final void stencilFunc(StencilFunction func, int ref, int mask) { glStencilFunc(func.token, ref, mask); }

	public abstract void glStencilFuncSeparate(int face, int func, int ref, int mask);
	public final void stencilFuncSeparate(StencilFaceDirection face, StencilFunction func, int ref, int mask) { glStencilFuncSeparate(face.token, func.token, ref, mask); }

	public abstract void glStencilMask(int mask);
	public final void stencilMask(int mask) { glStencilMask(mask); }

	public abstract void glStencilMaskSeparate(int face, int mask);
	public final void stencilMaskSeparate(StencilFaceDirection face, int mask) { glStencilMaskSeparate(face.token, mask); }

	public abstract void glStencilOp(int fail, int zfail, int zpass);
	public final void stencilOp(StencilOp fail, StencilOp zfail, StencilOp zpass) { glStencilOp(fail.token, zfail.token, zpass.token); }

	public abstract void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass);
	public final void stencilOpSeparate(StencilFaceDirection face, StencilOp sfail, StencilOp dpfail, StencilOp dppass) { glStencilOpSeparate(face.token, sfail.token, dpfail.token, dppass.token); }

	public abstract void glTexBuffer(int target, int internalformat, int buffer);
	public final void texBuffer(TextureTarget target, InternalFormat internalformat, int buffer) { glTexBuffer(target.token, internalformat.token, buffer); }

	public abstract void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size);
	public final void texBufferRange(TextureTarget target, InternalFormat internalformat, int buffer, long offset, long size) { glTexBufferRange(target.token, internalformat.token, buffer, offset, size); }

	public abstract void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels);
	public final void texImage2D(TextureTarget target, int level, InternalFormat internalformat, int width, int height, int border, PixelFormat format, PixelType type, long pixels) { glTexImage2D(target.token, level, internalformat.token, width, height, border, format.token, type.token, pixels); }

	public abstract void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, long pixels);
	public final void texImage3D(TextureTarget target, int level, InternalFormat internalformat, int width, int height, int depth, int border, PixelFormat format, PixelType type, long pixels) { glTexImage3D(target.token, level, internalformat.token, width, height, depth, border, format.token, type.token, pixels); }

	public abstract void glTexParameterIiv(int target, int pname, long params);
	public final void texParameterIiv(TextureTarget target, TextureParameterName pname, long params) { glTexParameterIiv(target.token, pname.token, params); }

	public abstract void glTexParameterIuiv(int target, int pname, long params);
	public final void texParameterIuiv(TextureTarget target, TextureParameterName pname, long params) { glTexParameterIuiv(target.token, pname.token, params); }

	public abstract void glTexParameterf(int target, int pname, float param);
	public final void texParameterf(TextureTarget target, TextureParameterName pname, float param) { glTexParameterf(target.token, pname.token, param); }

	public abstract void glTexParameterfv(int target, int pname, long params);
	public final void texParameterfv(TextureTarget target, TextureParameterName pname, long params) { glTexParameterfv(target.token, pname.token, params); }

	public abstract void glTexParameteri(int target, int pname, int param);
	public final void texParameteri(TextureTarget target, TextureParameterName pname, int param) { glTexParameteri(target.token, pname.token, param); }

	public abstract void glTexParameteriv(int target, int pname, long params);
	public final void texParameteriv(TextureTarget target, TextureParameterName pname, long params) { glTexParameteriv(target.token, pname.token, params); }

	public abstract void glTexStorage2D(int target, int levels, int internalformat, int width, int height);
	public final void texStorage2D(TextureTarget target, int levels, InternalFormat internalformat, int width, int height) { glTexStorage2D(target.token, levels, internalformat.token, width, height); }

	public abstract void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations);
	public final void texStorage2DMultisample(TextureTarget target, int samples, InternalFormat internalformat, int width, int height, boolean fixedsamplelocations) { glTexStorage2DMultisample(target.token, samples, internalformat.token, width, height, fixedsamplelocations); }

	public abstract void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth);
	public final void texStorage3D(TextureTarget target, int levels, InternalFormat internalformat, int width, int height, int depth) { glTexStorage3D(target.token, levels, internalformat.token, width, height, depth); }

	public abstract void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations);
	public final void texStorage3DMultisample(TextureTarget target, int samples, InternalFormat internalformat, int width, int height, int depth, boolean fixedsamplelocations) { glTexStorage3DMultisample(target.token, samples, internalformat.token, width, height, depth, fixedsamplelocations); }

	public abstract void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels);
	public final void texSubImage2D(TextureTarget target, int level, int xoffset, int yoffset, int width, int height, PixelFormat format, PixelType type, long pixels) { glTexSubImage2D(target.token, level, xoffset, yoffset, width, height, format.token, type.token, pixels); }

	public abstract void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels);
	public final void texSubImage3D(TextureTarget target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, PixelType type, long pixels) { glTexSubImage3D(target.token, level, xoffset, yoffset, zoffset, width, height, depth, format.token, type.token, pixels); }

	public abstract void glTransformFeedbackVaryings(int program, int count, long varyings, int bufferMode);
	public final void transformFeedbackVaryings(int program, int count, long varyings, int bufferMode) { glTransformFeedbackVaryings(program, count, varyings, bufferMode); }

	public abstract void glUniform1f(int location, float v0);
	public final void uniform1f(int location, float v0) { glUniform1f(location, v0); }

	public abstract void glUniform1fv(int location, int count, long value);
	public final void uniform1fv(int location, int count, long value) { glUniform1fv(location, count, value); }

	public abstract void glUniform1i(int location, int v0);
	public final void uniform1i(int location, int v0) { glUniform1i(location, v0); }

	public abstract void glUniform1iv(int location, int count, long value);
	public final void uniform1iv(int location, int count, long value) { glUniform1iv(location, count, value); }

	public abstract void glUniform1ui(int location, int v0);
	public final void uniform1ui(int location, int v0) { glUniform1ui(location, v0); }

	public abstract void glUniform1uiv(int location, int count, long value);
	public final void uniform1uiv(int location, int count, long value) { glUniform1uiv(location, count, value); }

	public abstract void glUniform2f(int location, float v0, float v1);
	public final void uniform2f(int location, float v0, float v1) { glUniform2f(location, v0, v1); }

	public abstract void glUniform2fv(int location, int count, long value);
	public final void uniform2fv(int location, int count, long value) { glUniform2fv(location, count, value); }

	public abstract void glUniform2i(int location, int v0, int v1);
	public final void uniform2i(int location, int v0, int v1) { glUniform2i(location, v0, v1); }

	public abstract void glUniform2iv(int location, int count, long value);
	public final void uniform2iv(int location, int count, long value) { glUniform2iv(location, count, value); }

	public abstract void glUniform2ui(int location, int v0, int v1);
	public final void uniform2ui(int location, int v0, int v1) { glUniform2ui(location, v0, v1); }

	public abstract void glUniform2uiv(int location, int count, long value);
	public final void uniform2uiv(int location, int count, long value) { glUniform2uiv(location, count, value); }

	public abstract void glUniform3f(int location, float v0, float v1, float v2);
	public final void uniform3f(int location, float v0, float v1, float v2) { glUniform3f(location, v0, v1, v2); }

	public abstract void glUniform3fv(int location, int count, long value);
	public final void uniform3fv(int location, int count, long value) { glUniform3fv(location, count, value); }

	public abstract void glUniform3i(int location, int v0, int v1, int v2);
	public final void uniform3i(int location, int v0, int v1, int v2) { glUniform3i(location, v0, v1, v2); }

	public abstract void glUniform3iv(int location, int count, long value);
	public final void uniform3iv(int location, int count, long value) { glUniform3iv(location, count, value); }

	public abstract void glUniform3ui(int location, int v0, int v1, int v2);
	public final void uniform3ui(int location, int v0, int v1, int v2) { glUniform3ui(location, v0, v1, v2); }

	public abstract void glUniform3uiv(int location, int count, long value);
	public final void uniform3uiv(int location, int count, long value) { glUniform3uiv(location, count, value); }

	public abstract void glUniform4f(int location, float v0, float v1, float v2, float v3);
	public final void uniform4f(int location, float v0, float v1, float v2, float v3) { glUniform4f(location, v0, v1, v2, v3); }

	public abstract void glUniform4fv(int location, int count, long value);
	public final void uniform4fv(int location, int count, long value) { glUniform4fv(location, count, value); }

	public abstract void glUniform4i(int location, int v0, int v1, int v2, int v3);
	public final void uniform4i(int location, int v0, int v1, int v2, int v3) { glUniform4i(location, v0, v1, v2, v3); }

	public abstract void glUniform4iv(int location, int count, long value);
	public final void uniform4iv(int location, int count, long value) { glUniform4iv(location, count, value); }

	public abstract void glUniform4ui(int location, int v0, int v1, int v2, int v3);
	public final void uniform4ui(int location, int v0, int v1, int v2, int v3) { glUniform4ui(location, v0, v1, v2, v3); }

	public abstract void glUniform4uiv(int location, int count, long value);
	public final void uniform4uiv(int location, int count, long value) { glUniform4uiv(location, count, value); }

	public abstract void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding);
	public final void uniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) { glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding); }

	public abstract void glUniformMatrix2fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2fv(int location, int count, boolean transpose, long value) { glUniformMatrix2fv(location, count, transpose, value); }

	public abstract void glUniformMatrix2x3fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2x3fv(int location, int count, boolean transpose, long value) { glUniformMatrix2x3fv(location, count, transpose, value); }

	public abstract void glUniformMatrix2x4fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2x4fv(int location, int count, boolean transpose, long value) { glUniformMatrix2x4fv(location, count, transpose, value); }

	public abstract void glUniformMatrix3fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3fv(int location, int count, boolean transpose, long value) { glUniformMatrix3fv(location, count, transpose, value); }

	public abstract void glUniformMatrix3x2fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3x2fv(int location, int count, boolean transpose, long value) { glUniformMatrix3x2fv(location, count, transpose, value); }

	public abstract void glUniformMatrix3x4fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3x4fv(int location, int count, boolean transpose, long value) { glUniformMatrix3x4fv(location, count, transpose, value); }

	public abstract void glUniformMatrix4fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4fv(int location, int count, boolean transpose, long value) { glUniformMatrix4fv(location, count, transpose, value); }

	public abstract void glUniformMatrix4x2fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4x2fv(int location, int count, boolean transpose, long value) { glUniformMatrix4x2fv(location, count, transpose, value); }

	public abstract void glUniformMatrix4x3fv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4x3fv(int location, int count, boolean transpose, long value) { glUniformMatrix4x3fv(location, count, transpose, value); }

	public abstract boolean glUnmapBuffer(int target);
	public final boolean unmapBuffer(BufferTarget target) { return glUnmapBuffer(target.token); }

	public abstract void glUseProgram(int program);
	public final void useProgram(int program) { glUseProgram(program); }

	public abstract void glUseProgramStages(int pipeline, int stages, int program);
	public final void useProgramStages(int pipeline, UseProgramStageMask.Mask stages, int program) { glUseProgramStages(pipeline, stages.value(), program); }

	public abstract void glValidateProgram(int program);
	public final void validateProgram(int program) { glValidateProgram(program); }

	public abstract void glValidateProgramPipeline(int pipeline);
	public final void validateProgramPipeline(int pipeline) { glValidateProgramPipeline(pipeline); }

	public abstract void glVertexAttrib1f(int index, float x);
	public final void vertexAttrib1f(int index, float x) { glVertexAttrib1f(index, x); }

	public abstract void glVertexAttrib1fv(int index, long v);
	public final void vertexAttrib1fv(int index, long v) { glVertexAttrib1fv(index, v); }

	public abstract void glVertexAttrib2f(int index, float x, float y);
	public final void vertexAttrib2f(int index, float x, float y) { glVertexAttrib2f(index, x, y); }

	public abstract void glVertexAttrib2fv(int index, long v);
	public final void vertexAttrib2fv(int index, long v) { glVertexAttrib2fv(index, v); }

	public abstract void glVertexAttrib3f(int index, float x, float y, float z);
	public final void vertexAttrib3f(int index, float x, float y, float z) { glVertexAttrib3f(index, x, y, z); }

	public abstract void glVertexAttrib3fv(int index, long v);
	public final void vertexAttrib3fv(int index, long v) { glVertexAttrib3fv(index, v); }

	public abstract void glVertexAttrib4f(int index, float x, float y, float z, float w);
	public final void vertexAttrib4f(int index, float x, float y, float z, float w) { glVertexAttrib4f(index, x, y, z, w); }

	public abstract void glVertexAttrib4fv(int index, long v);
	public final void vertexAttrib4fv(int index, long v) { glVertexAttrib4fv(index, v); }

	public abstract void glVertexAttribBinding(int attribindex, int bindingindex);
	public final void vertexAttribBinding(int attribindex, int bindingindex) { glVertexAttribBinding(attribindex, bindingindex); }

	public abstract void glVertexAttribDivisor(int index, int divisor);
	public final void vertexAttribDivisor(int index, int divisor) { glVertexAttribDivisor(index, divisor); }

	public abstract void glVertexAttribFormat(int attribindex, int size, int type, boolean normalized, int relativeoffset);
	public final void vertexAttribFormat(int attribindex, int size, int type, boolean normalized, int relativeoffset) { glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset); }

	public abstract void glVertexAttribI4i(int index, int x, int y, int z, int w);
	public final void vertexAttribI4i(int index, int x, int y, int z, int w) { glVertexAttribI4i(index, x, y, z, w); }

	public abstract void glVertexAttribI4iv(int index, long v);
	public final void vertexAttribI4iv(int index, long v) { glVertexAttribI4iv(index, v); }

	public abstract void glVertexAttribI4ui(int index, int x, int y, int z, int w);
	public final void vertexAttribI4ui(int index, int x, int y, int z, int w) { glVertexAttribI4ui(index, x, y, z, w); }

	public abstract void glVertexAttribI4uiv(int index, long v);
	public final void vertexAttribI4uiv(int index, long v) { glVertexAttribI4uiv(index, v); }

	public abstract void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset);
	public final void vertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) { glVertexAttribIFormat(attribindex, size, type, relativeoffset); }

	public abstract void glVertexAttribIPointer(int index, int size, int type, int stride, long pointer);
	public final void vertexAttribIPointer(int index, int size, VertexAttribType type, int stride, long pointer) { glVertexAttribIPointer(index, size, type.token, stride, pointer); }

	public abstract void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer);
	public final void vertexAttribPointer(int index, int size, VertexAttribType type, boolean normalized, int stride, long pointer) { glVertexAttribPointer(index, size, type.token, normalized, stride, pointer); }

	public abstract void glVertexBindingDivisor(int bindingindex, int divisor);
	public final void vertexBindingDivisor(int bindingindex, int divisor) { glVertexBindingDivisor(bindingindex, divisor); }

	public abstract void glViewport(int x, int y, int width, int height);
	public final void viewport(int x, int y, int width, int height) { glViewport(x, y, width, height); }

	public abstract void glWaitSync(long sync, int flags, long timeout);
	public final void waitSync(long sync, int flags, long timeout) { glWaitSync(sync, flags, timeout); }

}