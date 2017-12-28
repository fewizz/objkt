package org.objct.gl.wrapper;

import org.objct.gl.enums.*;
import org.objkt.memory.*;

public abstract class GLWrapper extends Wrapper {
	MemBlock mb = new MemBlock().allocate(Float.BYTES * 64);
	public abstract void glBeginConditionalRender(int id, int mode);
	public final void beginConditionalRender(int id, TypeEnum mode) { glBeginConditionalRender(id, mode.token); }

	public abstract void glBeginQueryIndexed(int target, int index, int id);
	public final void beginQueryIndexed(QueryTarget target, int index, int id) { glBeginQueryIndexed(target.token, index, id); }

	public abstract void glBindBuffersBase(int target, int first, int count, long buffers);
	public final void bindBuffersBase(BufferTarget target, int first, int count, long buffers) { glBindBuffersBase(target.token, first, count, buffers); }

	public abstract void glBindBuffersRange(int target, int first, int count, long buffers, long offsets, long sizes);
	public final void bindBuffersRange(BufferTarget target, int first, int count, long buffers, long offsets, long sizes) { glBindBuffersRange(target.token, first, count, buffers, offsets, sizes); }

	public abstract void glBindFragDataLocation(int program, int color, long name);
	public final void bindFragDataLocation(int program, int color, long name) { glBindFragDataLocation(program, color, name); }

	public abstract void glBindFragDataLocationIndexed(int program, int colorNumber, int index, long name);
	public final void bindFragDataLocationIndexed(int program, int colorNumber, int index, long name) { glBindFragDataLocationIndexed(program, colorNumber, index, name); }

	public abstract void glBindImageTextures(int first, int count, long textures);
	public final void bindImageTextures(int first, int count, long textures) { glBindImageTextures(first, count, textures); }

	public abstract void glBindSamplers(int first, int count, long samplers);
	public final void bindSamplers(int first, int count, long samplers) { glBindSamplers(first, count, samplers); }

	public abstract void glBindTextureUnit(int unit, int texture);
	public final void bindTextureUnit(int unit, int texture) { glBindTextureUnit(unit, texture); }

	public abstract void glBindTextures(int first, int count, long textures);
	public final void bindTextures(int first, int count, long textures) { glBindTextures(first, count, textures); }

	public abstract void glBindVertexBuffers(int first, int count, long buffers, long offsets, long strides);
	public final void bindVertexBuffers(int first, int count, long buffers, long offsets, long strides) { glBindVertexBuffers(first, count, buffers, offsets, strides); }

	public abstract void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter);
	public final void blitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, ClearBufferMask.Mask mask, BlitFramebufferFilter filter) { glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask.value(), filter.token); }

	public abstract void glBufferStorage(int target, long size, long data, int flags);
	public final void bufferStorage(BufferStorageTarget target, long size, long data, MapBufferUsageMask.Mask flags) { glBufferStorage(target.token, size, data, flags.value()); }

	public abstract int glCheckNamedFramebufferStatus(int framebuffer, int target);
	public final FramebufferStatus checkNamedFramebufferStatus(int framebuffer, FramebufferTarget target) { return FramebufferStatus.get(glCheckNamedFramebufferStatus(framebuffer, target.token)); }

	public abstract void glClampColor(int target, int clamp);
	public final void clampColor(int target, int clamp) { glClampColor(target, clamp); }

	public abstract void glClearBufferData(int target, int internalformat, int format, int type, long data);
	public final void clearBufferData(BufferStorageTarget target, InternalFormat internalformat, PixelFormat format, PixelType type, long data) { glClearBufferData(target.token, internalformat.token, format.token, type.token, data); }

	public abstract void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, long data);
	public final void clearBufferSubData(int target, InternalFormat internalformat, long offset, long size, PixelFormat format, PixelType type, long data) { glClearBufferSubData(target, internalformat.token, offset, size, format.token, type.token, data); }

	public abstract void glClearDepth(double depth);
	public final void clearDepth(double depth) { glClearDepth(depth); }

	public abstract void glClearNamedBufferData(int buffer, int internalformat, int format, int type, long data);
	public final void clearNamedBufferData(int buffer, InternalFormat internalformat, PixelFormat format, PixelType type, long data) { glClearNamedBufferData(buffer, internalformat.token, format.token, type.token, data); }

	public abstract void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, long data);
	public final void clearNamedBufferSubData(int buffer, InternalFormat internalformat, long offset, long size, PixelFormat format, PixelType type, long data) { glClearNamedBufferSubData(buffer, internalformat.token, offset, size, format.token, type.token, data); }

	public abstract void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil);
	public final void clearNamedFramebufferfi(int framebuffer, Buffer buffer, int drawbuffer, float depth, int stencil) { glClearNamedFramebufferfi(framebuffer, buffer.token, drawbuffer, depth, stencil); }

	public abstract void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, long value);
	public final void clearNamedFramebufferfv(int framebuffer, Buffer buffer, int drawbuffer, long value) { glClearNamedFramebufferfv(framebuffer, buffer.token, drawbuffer, value); }

	public abstract void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, long value);
	public final void clearNamedFramebufferiv(int framebuffer, Buffer buffer, int drawbuffer, long value) { glClearNamedFramebufferiv(framebuffer, buffer.token, drawbuffer, value); }

	public abstract void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, long value);
	public final void clearNamedFramebufferuiv(int framebuffer, Buffer buffer, int drawbuffer, long value) { glClearNamedFramebufferuiv(framebuffer, buffer.token, drawbuffer, value); }

	public abstract void glClearTexImage(int texture, int level, int format, int type, long data);
	public final void clearTexImage(int texture, int level, PixelFormat format, PixelType type, long data) { glClearTexImage(texture, level, format.token, type.token, data); }

	public abstract void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long data);
	public final void clearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, PixelType type, long data) { glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format.token, type.token, data); }

	public abstract void glClipControl(int origin, int depth);
	public final void clipControl(ClipControlOrigin origin, ClipControlDepth depth) { glClipControl(origin.token, depth.token); }

	public abstract void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, long data);
	public final void compressedTexImage1D(TextureTarget target, int level, InternalFormat internalformat, int width, int border, int imageSize, long data) { glCompressedTexImage1D(target.token, level, internalformat.token, width, border, imageSize, data); }

	public abstract void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, long data);
	public final void compressedTexSubImage1D(TextureTarget target, int level, int xoffset, int width, PixelFormat format, int imageSize, long data) { glCompressedTexSubImage1D(target.token, level, xoffset, width, format.token, imageSize, data); }

	public abstract void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, long data);
	public final void compressedTextureSubImage1D(int texture, int level, int xoffset, int width, PixelFormat format, int imageSize, long data) { glCompressedTextureSubImage1D(texture, level, xoffset, width, format.token, imageSize, data); }

	public abstract void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, long data);
	public final void compressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, PixelFormat format, int imageSize, long data) { glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format.token, imageSize, data); }

	public abstract void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, long data);
	public final void compressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, int imageSize, long data) { glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format.token, imageSize, data); }

	public abstract void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size);
	public final void copyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) { glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size); }

	public abstract void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border);
	public final void copyTexImage1D(TextureTarget target, int level, InternalFormat internalformat, int x, int y, int width, int border) { glCopyTexImage1D(target.token, level, internalformat.token, x, y, width, border); }

	public abstract void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width);
	public final void copyTexSubImage1D(TextureTarget target, int level, int xoffset, int x, int y, int width) { glCopyTexSubImage1D(target.token, level, xoffset, x, y, width); }

	public abstract void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width);
	public final void copyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) { glCopyTextureSubImage1D(texture, level, xoffset, x, y, width); }

	public abstract void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height);
	public final void copyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) { glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height); }

	public abstract void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height);
	public final void copyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) { glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height); }

	public abstract void glCreateBuffers(int n, long buffers);
	public final void createBuffers(int n, long buffers) { glCreateBuffers(n, buffers); }

	public abstract void glCreateFramebuffers(int n, long framebuffers);
	public final void createFramebuffers(int n, long framebuffers) { glCreateFramebuffers(n, framebuffers); }

	public abstract void glCreateProgramPipelines(int n, long pipelines);
	public final void createProgramPipelines(int n, long pipelines) { glCreateProgramPipelines(n, pipelines); }

	public abstract void glCreateQueries(int target, int n, long ids);
	public final void createQueries(QueryTarget target, int n, long ids) { glCreateQueries(target.token, n, ids); }

	public abstract void glCreateRenderbuffers(int n, long renderbuffers);
	public final void createRenderbuffers(int n, long renderbuffers) { glCreateRenderbuffers(n, renderbuffers); }

	public abstract void glCreateSamplers(int n, long samplers);
	public final void createSamplers(int n, long samplers) { glCreateSamplers(n, samplers); }

	public abstract void glCreateTextures(int target, int n, long textures);
	public final void createTextures(TextureTarget target, int n, long textures) { glCreateTextures(target.token, n, textures); }

	public abstract void glCreateTransformFeedbacks(int n, long ids);
	public final void createTransformFeedbacks(int n, long ids) { glCreateTransformFeedbacks(n, ids); }

	public abstract void glCreateVertexArrays(int n, long arrays);
	public final void createVertexArrays(int n, long arrays) { glCreateVertexArrays(n, arrays); }

	public abstract void glDepthRange(double near, double far);
	public final void depthRange(double near, double far) { glDepthRange(near, far); }

	public abstract void glDepthRangeArrayv(int first, int count, long v);
	public final void depthRangeArrayv(int first, int count, long v) { glDepthRangeArrayv(first, count, v); }

	public abstract void glDepthRangeIndexed(int index, double n, double f);
	public final void depthRangeIndexed(int index, double n, double f) { glDepthRangeIndexed(index, n, f); }

	public abstract void glDisableVertexArrayAttrib(int vaobj, int index);
	public final void disableVertexArrayAttrib(int vaobj, int index) { glDisableVertexArrayAttrib(vaobj, index); }

	public abstract void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance);
	public final void drawArraysInstancedBaseInstance(PrimitiveType mode, int first, int count, int instancecount, int baseinstance) { glDrawArraysInstancedBaseInstance(mode.token, first, count, instancecount, baseinstance); }

	public abstract void glDrawBuffer(int buf);
	public final void drawBuffer(DrawBufferMode buf) { glDrawBuffer(buf.token); }

	public abstract void glDrawElementsInstancedBaseInstance(int mode, int count, int type, long indices, int instancecount, int baseinstance);
	public final void drawElementsInstancedBaseInstance(PrimitiveType mode, int count, PrimitiveType type, long indices, int instancecount, int baseinstance) { glDrawElementsInstancedBaseInstance(mode.token, count, type.token, indices, instancecount, baseinstance); }

	public abstract void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, long indices, int instancecount, int basevertex, int baseinstance);
	public final void drawElementsInstancedBaseVertexBaseInstance(PrimitiveType mode, int count, PrimitiveType type, long indices, int instancecount, int basevertex, int baseinstance) { glDrawElementsInstancedBaseVertexBaseInstance(mode.token, count, type.token, indices, instancecount, basevertex, baseinstance); }

	public abstract void glDrawTransformFeedback(int mode, int id);
	public final void drawTransformFeedback(PrimitiveType mode, int id) { glDrawTransformFeedback(mode.token, id); }

	public abstract void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount);
	public final void drawTransformFeedbackInstanced(PrimitiveType mode, int id, int instancecount) { glDrawTransformFeedbackInstanced(mode.token, id, instancecount); }

	public abstract void glDrawTransformFeedbackStream(int mode, int id, int stream);
	public final void drawTransformFeedbackStream(PrimitiveType mode, int id, int stream) { glDrawTransformFeedbackStream(mode.token, id, stream); }

	public abstract void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount);
	public final void drawTransformFeedbackStreamInstanced(PrimitiveType mode, int id, int stream, int instancecount) { glDrawTransformFeedbackStreamInstanced(mode.token, id, stream, instancecount); }

	public abstract void glEnableVertexArrayAttrib(int vaobj, int index);
	public final void enableVertexArrayAttrib(int vaobj, int index) { glEnableVertexArrayAttrib(vaobj, index); }

	public abstract void glEndConditionalRender();
	public final void endConditionalRender() { glEndConditionalRender(); }

	public abstract void glEndQueryIndexed(int target, int index);
	public final void endQueryIndexed(QueryTarget target, int index) { glEndQueryIndexed(target.token, index); }

	public abstract void glFlushMappedNamedBufferRange(int buffer, long offset, long length);
	public final void flushMappedNamedBufferRange(int buffer, long offset, long length) { glFlushMappedNamedBufferRange(buffer, offset, length); }

	public abstract void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level);
	public final void framebufferTexture1D(FramebufferTarget target, FramebufferAttachment attachment, TextureTarget textarget, int texture, int level) { glFramebufferTexture1D(target.token, attachment.token, textarget.token, texture, level); }

	public abstract void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset);
	public final void framebufferTexture3D(FramebufferTarget target, FramebufferAttachment attachment, TextureTarget textarget, int texture, int level, int zoffset) { glFramebufferTexture3D(target.token, attachment.token, textarget.token, texture, level, zoffset); }

	public abstract void glGenerateTextureMipmap(int texture);
	public final void generateTextureMipmap(int texture) { glGenerateTextureMipmap(texture); }

	public abstract void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, long params);
	public final void getActiveAtomicCounterBufferiv(int program, int bufferIndex, AtomicCounterBufferPName pname, long params) { glGetActiveAtomicCounterBufferiv(program, bufferIndex, pname.token, params); }

	public abstract void glGetActiveSubroutineName(int program, int shadertype, int index, int bufsize, long length, long name);
	public final void getActiveSubroutineName(int program, ShaderType shadertype, int index, int bufsize, long length, long name) { glGetActiveSubroutineName(program, shadertype.token, index, bufsize, length, name); }

	public abstract void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize, long length, long name);
	public final void getActiveSubroutineUniformName(int program, ShaderType shadertype, int index, int bufsize, long length, long name) { glGetActiveSubroutineUniformName(program, shadertype.token, index, bufsize, length, name); }

	public abstract void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, long values);
	public final void getActiveSubroutineUniformiv(int program, ShaderType shadertype, int index, SubroutineParameterName pname, long values) { glGetActiveSubroutineUniformiv(program, shadertype.token, index, pname.token, values); }

	public abstract void glGetActiveUniformName(int program, int uniformIndex, int bufSize, long length, long uniformName);
	public final void getActiveUniformName(int program, int uniformIndex, int bufSize, long length, long uniformName) { glGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName); }

	public abstract void glGetBufferSubData(int target, long offset, long size, long data);
	public final void getBufferSubData(BufferTarget target, long offset, long size, long data) { glGetBufferSubData(target.token, offset, size, data); }

	public abstract void glGetCompressedTexImage(int target, int level, long img);
	public final void getCompressedTexImage(TextureTarget target, int level, long img) { glGetCompressedTexImage(target.token, level, img); }

	public abstract void glGetCompressedTextureImage(int texture, int level, int bufSize, long pixels);
	public final void getCompressedTextureImage(int texture, int level, int bufSize, long pixels) { glGetCompressedTextureImage(texture, level, bufSize, pixels); }

	public abstract void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels);
	public final void getCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, long pixels) { glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels); }

	public abstract void glGetDoublei_v(int target, int index, long data);
	public final void getDoublei_v(TypeEnum target, int index, long data) { glGetDoublei_v(target.token, index, data); }

	public abstract void glGetDoublev(int pname, long data);
	public final void getDoublev(GetPName pname, long data) { glGetDoublev(pname.token, data); }

	public abstract void glGetFloati_v(int target, int index, long data);
	public final void getFloati_v(TypeEnum target, int index, long data) { glGetFloati_v(target.token, index, data); }

	public abstract int glGetFragDataIndex(int program, long name);
	public final int getFragDataIndex(int program, long name) { return glGetFragDataIndex(program, name); }

	public abstract void glGetInternalformati64v(int target, int internalformat, int pname, int bufSize, long params);
	public final void getInternalformati64v(TextureTarget target, InternalFormat internalformat, InternalFormatPName pname, int bufSize, long params) { glGetInternalformati64v(target.token, internalformat.token, pname.token, bufSize, params); }

	public abstract void glGetNamedBufferParameteri64v(int buffer, int pname, long params);
	public final void getNamedBufferParameteri64v(int buffer, VertexBufferObjectParameter pname, long params) { glGetNamedBufferParameteri64v(buffer, pname.token, params); }

	public abstract void glGetNamedBufferParameteriv(int buffer, int pname, long params);
	public final void getNamedBufferParameteriv(int buffer, VertexBufferObjectParameter pname, long params) { glGetNamedBufferParameteriv(buffer, pname.token, params); }

	public abstract void glGetNamedBufferPointerv(int buffer, int pname, long params);
	public final void getNamedBufferPointerv(int buffer, VertexBufferObjectParameter pname, long params) { glGetNamedBufferPointerv(buffer, pname.token, params); }

	public abstract void glGetNamedBufferSubData(int buffer, long offset, long size, long data);
	public final void getNamedBufferSubData(int buffer, long offset, long size, long data) { glGetNamedBufferSubData(buffer, offset, size, data); }

	public abstract void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, long params);
	public final void getNamedFramebufferAttachmentParameteriv(int framebuffer, FramebufferAttachment attachment, FramebufferAttachmentParameterName pname, long params) { glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment.token, pname.token, params); }

	public abstract void glGetNamedFramebufferParameteriv(int framebuffer, int pname, long param);
	public final void getNamedFramebufferParameteriv(int framebuffer, GetFramebufferParameter pname, long param) { glGetNamedFramebufferParameteriv(framebuffer, pname.token, param); }

	public abstract void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, long params);
	public final void getNamedRenderbufferParameteriv(int renderbuffer, RenderbufferParameterName pname, long params) { glGetNamedRenderbufferParameteriv(renderbuffer, pname.token, params); }

	public abstract int glGetProgramResourceLocationIndex(int program, int programInterface, long name);
	public final int getProgramResourceLocationIndex(int program, ProgramInterface programInterface, long name) { return glGetProgramResourceLocationIndex(program, programInterface.token, name); }

	public abstract void glGetProgramStageiv(int program, int shadertype, int pname, long values);
	public final void getProgramStageiv(int program, ShaderType shadertype, ProgramStagePName pname, long values) { glGetProgramStageiv(program, shadertype.token, pname.token, values); }

	public abstract void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset);
	public final void getQueryBufferObjecti64v(int id, int buffer, QueryObjectParameterName pname, long offset) { glGetQueryBufferObjecti64v(id, buffer, pname.token, offset); }

	public abstract void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset);
	public final void getQueryBufferObjectiv(int id, int buffer, QueryObjectParameterName pname, long offset) { glGetQueryBufferObjectiv(id, buffer, pname.token, offset); }

	public abstract void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset);
	public final void getQueryBufferObjectui64v(int id, int buffer, QueryObjectParameterName pname, long offset) { glGetQueryBufferObjectui64v(id, buffer, pname.token, offset); }

	public abstract void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset);
	public final void getQueryBufferObjectuiv(int id, int buffer, QueryObjectParameterName pname, long offset) { glGetQueryBufferObjectuiv(id, buffer, pname.token, offset); }

	public abstract void glGetQueryIndexediv(int target, int index, int pname, long params);
	public final void getQueryIndexediv(int target, int index, QueryParameterName pname, long params) { glGetQueryIndexediv(target, index, pname.token, params); }

	public abstract void glGetQueryObjecti64v(int id, int pname, long params);
	public final void getQueryObjecti64v(int id, QueryObjectParameterName pname, long params) { glGetQueryObjecti64v(id, pname.token, params); }

	public abstract void glGetQueryObjectiv(int id, int pname, long params);
	public final void getQueryObjectiv(int id, QueryObjectParameterName pname, long params) { glGetQueryObjectiv(id, pname.token, params); }

	public abstract void glGetQueryObjectui64v(int id, int pname, long params);
	public final void getQueryObjectui64v(int id, QueryObjectParameterName pname, long params) { glGetQueryObjectui64v(id, pname.token, params); }

	public abstract int glGetSubroutineIndex(int program, int shadertype, long name);
	public final int getSubroutineIndex(int program, ShaderType shadertype, long name) { return glGetSubroutineIndex(program, shadertype.token, name); }

	public abstract int glGetSubroutineUniformLocation(int program, int shadertype, long name);
	public final int getSubroutineUniformLocation(int program, ShaderType shadertype, long name) { return glGetSubroutineUniformLocation(program, shadertype.token, name); }

	public abstract void glGetTexImage(int target, int level, int format, int type, long pixels);
	public final void getTexImage(TextureTarget target, int level, PixelFormat format, PixelType type, long pixels) { glGetTexImage(target.token, level, format.token, type.token, pixels); }

	public abstract void glGetTextureImage(int texture, int level, int format, int type, int bufSize, long pixels);
	public final void getTextureImage(int texture, int level, PixelFormat format, PixelType type, int bufSize, long pixels) { glGetTextureImage(texture, level, format.token, type.token, bufSize, pixels); }

	public abstract void glGetTextureLevelParameterfv(int texture, int level, int pname, long params);
	public final void getTextureLevelParameterfv(int texture, int level, GetTextureParameter pname, long params) { glGetTextureLevelParameterfv(texture, level, pname.token, params); }

	public abstract void glGetTextureLevelParameteriv(int texture, int level, int pname, long params);
	public final void getTextureLevelParameteriv(int texture, int level, GetTextureParameter pname, long params) { glGetTextureLevelParameteriv(texture, level, pname.token, params); }

	public abstract void glGetTextureParameterIiv(int texture, int pname, long params);
	public final void getTextureParameterIiv(int texture, GetTextureParameter pname, long params) { glGetTextureParameterIiv(texture, pname.token, params); }

	public abstract void glGetTextureParameterIuiv(int texture, int pname, long params);
	public final void getTextureParameterIuiv(int texture, GetTextureParameter pname, long params) { glGetTextureParameterIuiv(texture, pname.token, params); }

	public abstract void glGetTextureParameterfv(int texture, int pname, long params);
	public final void getTextureParameterfv(int texture, GetTextureParameter pname, long params) { glGetTextureParameterfv(texture, pname.token, params); }

	public abstract void glGetTextureParameteriv(int texture, int pname, long params);
	public final void getTextureParameteriv(int texture, GetTextureParameter pname, long params) { glGetTextureParameteriv(texture, pname.token, params); }

	public abstract void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, long pixels);
	public final void getTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, PixelType type, int bufSize, long pixels) { glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format.token, type.token, bufSize, pixels); }

	public abstract void glGetTransformFeedbacki64_v(int xfb, int pname, int index, long param);
	public final void getTransformFeedbacki64_v(int xfb, TransformFeedbackPName pname, int index, long param) { glGetTransformFeedbacki64_v(xfb, pname.token, index, param); }

	public abstract void glGetTransformFeedbacki_v(int xfb, int pname, int index, long param);
	public final void getTransformFeedbacki_v(int xfb, TransformFeedbackPName pname, int index, long param) { glGetTransformFeedbacki_v(xfb, pname.token, index, param); }

	public abstract void glGetTransformFeedbackiv(int xfb, int pname, long param);
	public final void getTransformFeedbackiv(int xfb, TransformFeedbackPName pname, long param) { glGetTransformFeedbackiv(xfb, pname.token, param); }

	public abstract void glGetUniformSubroutineuiv(int shadertype, int location, long params);
	public final void getUniformSubroutineuiv(ShaderType shadertype, int location, long params) { glGetUniformSubroutineuiv(shadertype.token, location, params); }

	public abstract void glGetUniformdv(int program, int location, long params);
	public final void getUniformdv(int program, int location, long params) { glGetUniformdv(program, location, params); }

	public abstract void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, long param);
	public final void getVertexArrayIndexed64iv(int vaobj, int index, VertexArrayPName pname, long param) { glGetVertexArrayIndexed64iv(vaobj, index, pname.token, param); }

	public abstract void glGetVertexArrayIndexediv(int vaobj, int index, int pname, long param);
	public final void getVertexArrayIndexediv(int vaobj, int index, VertexArrayPName pname, long param) { glGetVertexArrayIndexediv(vaobj, index, pname.token, param); }

	public abstract void glGetVertexArrayiv(int vaobj, int pname, long param);
	public final void getVertexArrayiv(int vaobj, VertexArrayPName pname, long param) { glGetVertexArrayiv(vaobj, pname.token, param); }

	public abstract void glGetVertexAttribLdv(int index, int pname, long params);
	public final void getVertexAttribLdv(int index, VertexAttribEnum pname, long params) { glGetVertexAttribLdv(index, pname.token, params); }

	public abstract void glGetVertexAttribdv(int index, int pname, long params);
	public final void getVertexAttribdv(int index, int pname, long params) { glGetVertexAttribdv(index, pname, params); }

	public abstract void glGetnCompressedTexImage(int target, int lod, int bufSize, long pixels);
	public final void getnCompressedTexImage(TextureTarget target, int lod, int bufSize, long pixels) { glGetnCompressedTexImage(target.token, lod, bufSize, pixels); }

	public abstract void glGetnTexImage(int target, int level, int format, int type, int bufSize, long pixels);
	public final void getnTexImage(TextureTarget target, int level, PixelFormat format, PixelType type, int bufSize, long pixels) { glGetnTexImage(target.token, level, format.token, type.token, bufSize, pixels); }

	public abstract void glGetnUniformdv(int program, int location, int bufSize, long params);
	public final void getnUniformdv(int program, int location, int bufSize, long params) { glGetnUniformdv(program, location, bufSize, params); }

	public abstract void glInvalidateBufferData(int buffer);
	public final void invalidateBufferData(int buffer) { glInvalidateBufferData(buffer); }

	public abstract void glInvalidateBufferSubData(int buffer, long offset, long length);
	public final void invalidateBufferSubData(int buffer, long offset, long length) { glInvalidateBufferSubData(buffer, offset, length); }

	public abstract void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments);
	public final void invalidateNamedFramebufferData(int framebuffer, int numAttachments, long attachments) { glInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments); }

	public abstract void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height);
	public final void invalidateNamedFramebufferSubData(int framebuffer, int numAttachments, long attachments, int x, int y, int width, int height) { glInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height); }

	public abstract void glInvalidateTexImage(int texture, int level);
	public final void invalidateTexImage(int texture, int level) { glInvalidateTexImage(texture, level); }

	public abstract void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth);
	public final void invalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) { glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth); }

	public abstract long glMapBuffer(int target, int access);
	public final long mapBuffer(BufferTarget target, BufferAccessARB access) { return glMapBuffer(target.token, access.token); }

	public abstract long glMapNamedBuffer(int buffer, int access);
	public final long mapNamedBuffer(int buffer, BufferAccessARB access) { return glMapNamedBuffer(buffer, access.token); }

	public abstract long glMapNamedBufferRange(int buffer, long offset, long length, int access);
	public final long mapNamedBufferRange(int buffer, long offset, long length, BufferAccessMask access) { return glMapNamedBufferRange(buffer, offset, length, access.token); }

	public abstract void glMultiDrawArrays(int mode, long first, long count, int drawcount);
	public final void multiDrawArrays(PrimitiveType mode, long first, long count, int drawcount) { glMultiDrawArrays(mode.token, first, count, drawcount); }

	public abstract void glMultiDrawArraysIndirect(int mode, long indirect, int drawcount, int stride);
	public final void multiDrawArraysIndirect(PrimitiveType mode, long indirect, int drawcount, int stride) { glMultiDrawArraysIndirect(mode.token, indirect, drawcount, stride); }

	public abstract void glMultiDrawArraysIndirectCount(int mode, long indirect, long drawcount, int maxdrawcount, int stride);
	public final void multiDrawArraysIndirectCount(PrimitiveType mode, long indirect, long drawcount, int maxdrawcount, int stride) { glMultiDrawArraysIndirectCount(mode.token, indirect, drawcount, maxdrawcount, stride); }

	public abstract void glMultiDrawElements(int mode, long count, int type, long indices, int drawcount);
	public final void multiDrawElements(PrimitiveType mode, long count, DrawElementsType type, long indices, int drawcount) { glMultiDrawElements(mode.token, count, type.token, indices, drawcount); }

	public abstract void glMultiDrawElementsBaseVertex(int mode, long count, int type, long indices, int drawcount, long basevertex);
	public final void multiDrawElementsBaseVertex(PrimitiveType mode, long count, DrawElementsType type, long indices, int drawcount, long basevertex) { glMultiDrawElementsBaseVertex(mode.token, count, type.token, indices, drawcount, basevertex); }

	public abstract void glMultiDrawElementsIndirect(int mode, int type, long indirect, int drawcount, int stride);
	public final void multiDrawElementsIndirect(PrimitiveType mode, DrawElementsType type, long indirect, int drawcount, int stride) { glMultiDrawElementsIndirect(mode.token, type.token, indirect, drawcount, stride); }

	public abstract void glMultiDrawElementsIndirectCount(int mode, int type, long indirect, long drawcount, int maxdrawcount, int stride);
	public final void multiDrawElementsIndirectCount(PrimitiveType mode, int type, long indirect, long drawcount, int maxdrawcount, int stride) { glMultiDrawElementsIndirectCount(mode.token, type, indirect, drawcount, maxdrawcount, stride); }

	public abstract void glNamedBufferData(int buffer, long size, long data, int usage);
	public final void namedBufferData(int buffer, long size, long data, VertexBufferObjectUsage usage) { glNamedBufferData(buffer, size, data, usage.token); }

	public abstract void glNamedBufferStorage(int buffer, long size, long data, int flags);
	public final void namedBufferStorage(int buffer, long size, long data, MapBufferUsageMask.Mask flags) { glNamedBufferStorage(buffer, size, data, flags.value()); }

	public abstract void glNamedBufferSubData(int buffer, long offset, long size, long data);
	public final void namedBufferSubData(int buffer, long offset, long size, long data) { glNamedBufferSubData(buffer, offset, size, data); }

	public abstract void glNamedFramebufferDrawBuffer(int framebuffer, int buf);
	public final void namedFramebufferDrawBuffer(int framebuffer, ColorBuffer buf) { glNamedFramebufferDrawBuffer(framebuffer, buf.token); }

	public abstract void glNamedFramebufferDrawBuffers(int framebuffer, int n, long bufs);
	public final void namedFramebufferDrawBuffers(int framebuffer, int n, long bufs) { glNamedFramebufferDrawBuffers(framebuffer, n, bufs); }

	public abstract void glNamedFramebufferParameteri(int framebuffer, int pname, int param);
	public final void namedFramebufferParameteri(int framebuffer, FramebufferParameterName pname, int param) { glNamedFramebufferParameteri(framebuffer, pname.token, param); }

	public abstract void glNamedFramebufferReadBuffer(int framebuffer, int src);
	public final void namedFramebufferReadBuffer(int framebuffer, ColorBuffer src) { glNamedFramebufferReadBuffer(framebuffer, src.token); }

	public abstract void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer);
	public final void namedFramebufferRenderbuffer(int framebuffer, FramebufferAttachment attachment, RenderbufferTarget renderbuffertarget, int renderbuffer) { glNamedFramebufferRenderbuffer(framebuffer, attachment.token, renderbuffertarget.token, renderbuffer); }

	public abstract void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level);
	public final void namedFramebufferTexture(int framebuffer, FramebufferAttachment attachment, int texture, int level) { glNamedFramebufferTexture(framebuffer, attachment.token, texture, level); }

	public abstract void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer);
	public final void namedFramebufferTextureLayer(int framebuffer, FramebufferAttachment attachment, int texture, int level, int layer) { glNamedFramebufferTextureLayer(framebuffer, attachment.token, texture, level, layer); }

	public abstract void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height);
	public final void namedRenderbufferStorage(int renderbuffer, InternalFormat internalformat, int width, int height) { glNamedRenderbufferStorage(renderbuffer, internalformat.token, width, height); }

	public abstract void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height);
	public final void namedRenderbufferStorageMultisample(int renderbuffer, int samples, InternalFormat internalformat, int width, int height) { glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat.token, width, height); }

	public abstract void glPatchParameterfv(int pname, long values);
	public final void patchParameterfv(PatchParameterName pname, long values) { glPatchParameterfv(pname.token, values); }

	public abstract void glPixelStoref(int pname, float param);
	public final void pixelStoref(PixelStoreParameter pname, float param) { glPixelStoref(pname.token, param); }

	public abstract void glPointParameteri(int pname, int param);
	public final void pointParameteri(int pname, int param) { glPointParameteri(pname, param); }

	public abstract void glPointParameteriv(int pname, long params);
	public final void pointParameteriv(int pname, long params) { glPointParameteriv(pname, params); }

	public abstract void glPolygonMode(int face, int mode);
	public final void polygonMode(MaterialFace face, PolygonMode mode) { glPolygonMode(face.token, mode.token); }

	public abstract void glPolygonOffsetClamp(float factor, float units, float clamp);
	public final void polygonOffsetClamp(float factor, float units, float clamp) { glPolygonOffsetClamp(factor, units, clamp); }

	public abstract void glPrimitiveRestartIndex(int index);
	public final void primitiveRestartIndex(int index) { glPrimitiveRestartIndex(index); }

	public abstract void glProgramUniform1d(int program, int location, double v0);
	public final void programUniform1d(int program, int location, double v0) { glProgramUniform1d(program, location, v0); }

	public abstract void glProgramUniform1dv(int program, int location, int count, long value);
	public final void programUniform1dv(int program, int location, int count, long value) { glProgramUniform1dv(program, location, count, value); }

	public abstract void glProgramUniform2d(int program, int location, double v0, double v1);
	public final void programUniform2d(int program, int location, double v0, double v1) { glProgramUniform2d(program, location, v0, v1); }

	public abstract void glProgramUniform2dv(int program, int location, int count, long value);
	public final void programUniform2dv(int program, int location, int count, long value) { glProgramUniform2dv(program, location, count, value); }

	public abstract void glProgramUniform3d(int program, int location, double v0, double v1, double v2);
	public final void programUniform3d(int program, int location, double v0, double v1, double v2) { glProgramUniform3d(program, location, v0, v1, v2); }

	public abstract void glProgramUniform3dv(int program, int location, int count, long value);
	public final void programUniform3dv(int program, int location, int count, long value) { glProgramUniform3dv(program, location, count, value); }

	public abstract void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3);
	public final void programUniform4d(int program, int location, double v0, double v1, double v2, double v3) { glProgramUniform4d(program, location, v0, v1, v2, v3); }

	public abstract void glProgramUniform4dv(int program, int location, int count, long value);
	public final void programUniform4dv(int program, int location, int count, long value) { glProgramUniform4dv(program, location, count, value); }

	public abstract void glProgramUniformMatrix2dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2x3dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2x3dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix2x4dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix2x4dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3x2dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3x2dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix3x4dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix3x4dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4x2dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4x2dv(program, location, count, transpose, value); }

	public abstract void glProgramUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value);
	public final void programUniformMatrix4x3dv(int program, int location, int count, boolean transpose, long value) { glProgramUniformMatrix4x3dv(program, location, count, transpose, value); }

	public abstract void glProvokingVertex(int mode);
	public final void provokingVertex(VertexProvokingMode mode) { glProvokingVertex(mode.token); }

	public abstract void glQueryCounter(int id, int target);
	public final void queryCounter(int id, QueryTarget target) { glQueryCounter(id, target.token); }

	public abstract void glScissorArrayv(int first, int count, long v);
	public final void scissorArrayv(int first, int count, long v) { glScissorArrayv(first, count, v); }

	public abstract void glScissorIndexed(int index, int left, int bottom, int width, int height);
	public final void scissorIndexed(int index, int left, int bottom, int width, int height) { glScissorIndexed(index, left, bottom, width, height); }

	public abstract void glScissorIndexedv(int index, long v);
	public final void scissorIndexedv(int index, long v) { glScissorIndexedv(index, v); }

	public abstract void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding);
	public final void shaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) { glShaderStorageBlockBinding(program, storageBlockIndex, storageBlockBinding); }

	public abstract void glSpecializeShader(int shader, long pEntryPoint, int numSpecializationConstants, long pConstantIndex, long pConstantValue);
	public final void specializeShader(int shader, long pEntryPoint, int numSpecializationConstants, long pConstantIndex, long pConstantValue) { glSpecializeShader(shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue); }

	public abstract void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels);
	public final void texImage1D(TextureTarget target, int level, InternalFormat internalformat, int width, int border, PixelFormat format, PixelType type, long pixels) { glTexImage1D(target.token, level, internalformat.token, width, border, format.token, type.token, pixels); }

	public abstract void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations);
	public final void texImage2DMultisample(TextureTarget target, int samples, InternalFormat internalformat, int width, int height, boolean fixedsamplelocations) { glTexImage2DMultisample(target.token, samples, internalformat.token, width, height, fixedsamplelocations); }

	public abstract void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations);
	public final void texImage3DMultisample(TextureTarget target, int samples, InternalFormat internalformat, int width, int height, int depth, boolean fixedsamplelocations) { glTexImage3DMultisample(target.token, samples, internalformat.token, width, height, depth, fixedsamplelocations); }

	public abstract void glTexStorage1D(int target, int levels, int internalformat, int width);
	public final void texStorage1D(TextureTarget target, int levels, InternalFormat internalformat, int width) { glTexStorage1D(target.token, levels, internalformat.token, width); }

	public abstract void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels);
	public final void texSubImage1D(TextureTarget target, int level, int xoffset, int width, PixelFormat format, PixelType type, long pixels) { glTexSubImage1D(target.token, level, xoffset, width, format.token, type.token, pixels); }

	public abstract void glTextureBarrier();
	public final void textureBarrier() { glTextureBarrier(); }

	public abstract void glTextureBuffer(int texture, int internalformat, int buffer);
	public final void textureBuffer(int texture, InternalFormat internalformat, int buffer) { glTextureBuffer(texture, internalformat.token, buffer); }

	public abstract void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size);
	public final void textureBufferRange(int texture, InternalFormat internalformat, int buffer, long offset, long size) { glTextureBufferRange(texture, internalformat.token, buffer, offset, size); }

	public abstract void glTextureParameterIiv(int texture, int pname, long params);
	public final void textureParameterIiv(int texture, TextureParameterName pname, long params) { glTextureParameterIiv(texture, pname.token, params); }

	public abstract void glTextureParameterIuiv(int texture, int pname, long params);
	public final void textureParameterIuiv(int texture, TextureParameterName pname, long params) { glTextureParameterIuiv(texture, pname.token, params); }

	public abstract void glTextureParameterf(int texture, int pname, float param);
	public final void textureParameterf(int texture, TextureParameterName pname, float param) { glTextureParameterf(texture, pname.token, param); }

	public abstract void glTextureParameterfv(int texture, int pname, long param);
	public final void textureParameterfv(int texture, TextureParameterName pname, long param) { glTextureParameterfv(texture, pname.token, param); }

	public abstract void glTextureParameteri(int texture, int pname, int param);
	public final void textureParameteri(int texture, TextureParameterName pname, int param) { glTextureParameteri(texture, pname.token, param); }

	public abstract void glTextureParameteriv(int texture, int pname, long param);
	public final void textureParameteriv(int texture, TextureParameterName pname, long param) { glTextureParameteriv(texture, pname.token, param); }

	public abstract void glTextureStorage1D(int texture, int levels, int internalformat, int width);
	public final void textureStorage1D(int texture, int levels, InternalFormat internalformat, int width) { glTextureStorage1D(texture, levels, internalformat.token, width); }

	public abstract void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height);
	public final void textureStorage2D(int texture, int levels, InternalFormat internalformat, int width, int height) { glTextureStorage2D(texture, levels, internalformat.token, width, height); }

	public abstract void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, boolean fixedsamplelocations);
	public final void textureStorage2DMultisample(int texture, int samples, InternalFormat internalformat, int width, int height, boolean fixedsamplelocations) { glTextureStorage2DMultisample(texture, samples, internalformat.token, width, height, fixedsamplelocations); }

	public abstract void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth);
	public final void textureStorage3D(int texture, int levels, InternalFormat internalformat, int width, int height, int depth) { glTextureStorage3D(texture, levels, internalformat.token, width, height, depth); }

	public abstract void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations);
	public final void textureStorage3DMultisample(int texture, int samples, InternalFormat internalformat, int width, int height, int depth, boolean fixedsamplelocations) { glTextureStorage3DMultisample(texture, samples, internalformat.token, width, height, depth, fixedsamplelocations); }

	public abstract void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, long pixels);
	public final void textureSubImage1D(int texture, int level, int xoffset, int width, PixelFormat format, PixelType type, long pixels) { glTextureSubImage1D(texture, level, xoffset, width, format.token, type.token, pixels); }

	public abstract void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels);
	public final void textureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, PixelFormat format, PixelType type, long pixels) { glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format.token, type.token, pixels); }

	public abstract void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, long pixels);
	public final void textureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, PixelFormat format, PixelType type, long pixels) { glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format.token, type.token, pixels); }

	public abstract void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers);
	public final void textureView(int texture, TextureTarget target, int origtexture, InternalFormat internalformat, int minlevel, int numlevels, int minlayer, int numlayers) { glTextureView(texture, target.token, origtexture, internalformat.token, minlevel, numlevels, minlayer, numlayers); }

	public abstract void glTransformFeedbackBufferBase(int xfb, int index, int buffer);
	public final void transformFeedbackBufferBase(int xfb, int index, int buffer) { glTransformFeedbackBufferBase(xfb, index, buffer); }

	public abstract void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size);
	public final void transformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) { glTransformFeedbackBufferRange(xfb, index, buffer, offset, size); }

	public abstract void glUniform1d(int location, double x);
	public final void uniform1d(int location, double x) { glUniform1d(location, x); }

	public abstract void glUniform1dv(int location, int count, long value);
	public final void uniform1dv(int location, int count, long value) { glUniform1dv(location, count, value); }

	public abstract void glUniform2d(int location, double x, double y);
	public final void uniform2d(int location, double x, double y) { glUniform2d(location, x, y); }

	public abstract void glUniform2dv(int location, int count, long value);
	public final void uniform2dv(int location, int count, long value) { glUniform2dv(location, count, value); }

	public abstract void glUniform3d(int location, double x, double y, double z);
	public final void uniform3d(int location, double x, double y, double z) { glUniform3d(location, x, y, z); }

	public abstract void glUniform3dv(int location, int count, long value);
	public final void uniform3dv(int location, int count, long value) { glUniform3dv(location, count, value); }

	public abstract void glUniform4d(int location, double x, double y, double z, double w);
	public final void uniform4d(int location, double x, double y, double z, double w) { glUniform4d(location, x, y, z, w); }

	public abstract void glUniform4dv(int location, int count, long value);
	public final void uniform4dv(int location, int count, long value) { glUniform4dv(location, count, value); }

	public abstract void glUniformMatrix2dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2dv(int location, int count, boolean transpose, long value) { glUniformMatrix2dv(location, count, transpose, value); }

	public abstract void glUniformMatrix2x3dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2x3dv(int location, int count, boolean transpose, long value) { glUniformMatrix2x3dv(location, count, transpose, value); }

	public abstract void glUniformMatrix2x4dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix2x4dv(int location, int count, boolean transpose, long value) { glUniformMatrix2x4dv(location, count, transpose, value); }

	public abstract void glUniformMatrix3dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3dv(int location, int count, boolean transpose, long value) { glUniformMatrix3dv(location, count, transpose, value); }

	public abstract void glUniformMatrix3x2dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3x2dv(int location, int count, boolean transpose, long value) { glUniformMatrix3x2dv(location, count, transpose, value); }

	public abstract void glUniformMatrix3x4dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix3x4dv(int location, int count, boolean transpose, long value) { glUniformMatrix3x4dv(location, count, transpose, value); }

	public abstract void glUniformMatrix4dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4dv(int location, int count, boolean transpose, long value) { glUniformMatrix4dv(location, count, transpose, value); }

	public abstract void glUniformMatrix4x2dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4x2dv(int location, int count, boolean transpose, long value) { glUniformMatrix4x2dv(location, count, transpose, value); }

	public abstract void glUniformMatrix4x3dv(int location, int count, boolean transpose, long value);
	public final void uniformMatrix4x3dv(int location, int count, boolean transpose, long value) { glUniformMatrix4x3dv(location, count, transpose, value); }

	public abstract void glUniformSubroutinesuiv(int shadertype, int count, long indices);
	public final void uniformSubroutinesuiv(ShaderType shadertype, int count, long indices) { glUniformSubroutinesuiv(shadertype.token, count, indices); }

	public abstract boolean glUnmapNamedBuffer(int buffer);
	public final boolean unmapNamedBuffer(int buffer) { return glUnmapNamedBuffer(buffer); }

	public abstract void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex);
	public final void vertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) { glVertexArrayAttribBinding(vaobj, attribindex, bindingindex); }

	public abstract void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, boolean normalized, int relativeoffset);
	public final void vertexArrayAttribFormat(int vaobj, int attribindex, int size, VertexAttribType type, boolean normalized, int relativeoffset) { glVertexArrayAttribFormat(vaobj, attribindex, size, type.token, normalized, relativeoffset); }

	public abstract void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset);
	public final void vertexArrayAttribIFormat(int vaobj, int attribindex, int size, VertexAttribType type, int relativeoffset) { glVertexArrayAttribIFormat(vaobj, attribindex, size, type.token, relativeoffset); }

	public abstract void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset);
	public final void vertexArrayAttribLFormat(int vaobj, int attribindex, int size, VertexAttribType type, int relativeoffset) { glVertexArrayAttribLFormat(vaobj, attribindex, size, type.token, relativeoffset); }

	public abstract void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor);
	public final void vertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) { glVertexArrayBindingDivisor(vaobj, bindingindex, divisor); }

	public abstract void glVertexArrayElementBuffer(int vaobj, int buffer);
	public final void vertexArrayElementBuffer(int vaobj, int buffer) { glVertexArrayElementBuffer(vaobj, buffer); }

	public abstract void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride);
	public final void vertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) { glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride); }

	public abstract void glVertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides);
	public final void vertexArrayVertexBuffers(int vaobj, int first, int count, long buffers, long offsets, long strides) { glVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides); }

	public abstract void glVertexAttrib1d(int index, double x);
	public final void vertexAttrib1d(int index, double x) { glVertexAttrib1d(index, x); }

	public abstract void glVertexAttrib1dv(int index, long v);
	public final void vertexAttrib1dv(int index, long v) { glVertexAttrib1dv(index, v); }

	public abstract void glVertexAttrib1s(int index, short x);
	public final void vertexAttrib1s(int index, short x) { glVertexAttrib1s(index, x); }

	public abstract void glVertexAttrib1sv(int index, long v);
	public final void vertexAttrib1sv(int index, long v) { glVertexAttrib1sv(index, v); }

	public abstract void glVertexAttrib2d(int index, double x, double y);
	public final void vertexAttrib2d(int index, double x, double y) { glVertexAttrib2d(index, x, y); }

	public abstract void glVertexAttrib2dv(int index, long v);
	public final void vertexAttrib2dv(int index, long v) { glVertexAttrib2dv(index, v); }

	public abstract void glVertexAttrib2s(int index, short x, short y);
	public final void vertexAttrib2s(int index, short x, short y) { glVertexAttrib2s(index, x, y); }

	public abstract void glVertexAttrib2sv(int index, long v);
	public final void vertexAttrib2sv(int index, long v) { glVertexAttrib2sv(index, v); }

	public abstract void glVertexAttrib3d(int index, double x, double y, double z);
	public final void vertexAttrib3d(int index, double x, double y, double z) { glVertexAttrib3d(index, x, y, z); }

	public abstract void glVertexAttrib3dv(int index, long v);
	public final void vertexAttrib3dv(int index, long v) { glVertexAttrib3dv(index, v); }

	public abstract void glVertexAttrib3s(int index, short x, short y, short z);
	public final void vertexAttrib3s(int index, short x, short y, short z) { glVertexAttrib3s(index, x, y, z); }

	public abstract void glVertexAttrib3sv(int index, long v);
	public final void vertexAttrib3sv(int index, long v) { glVertexAttrib3sv(index, v); }

	public abstract void glVertexAttrib4Nbv(int index, long v);
	public final void vertexAttrib4Nbv(int index, long v) { glVertexAttrib4Nbv(index, v); }

	public abstract void glVertexAttrib4Niv(int index, long v);
	public final void vertexAttrib4Niv(int index, long v) { glVertexAttrib4Niv(index, v); }

	public abstract void glVertexAttrib4Nsv(int index, long v);
	public final void vertexAttrib4Nsv(int index, long v) { glVertexAttrib4Nsv(index, v); }

	public abstract void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w);
	public final void vertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) { glVertexAttrib4Nub(index, x, y, z, w); }

	public abstract void glVertexAttrib4Nubv(int index, long v);
	public final void vertexAttrib4Nubv(int index, long v) { glVertexAttrib4Nubv(index, v); }

	public abstract void glVertexAttrib4Nuiv(int index, long v);
	public final void vertexAttrib4Nuiv(int index, long v) { glVertexAttrib4Nuiv(index, v); }

	public abstract void glVertexAttrib4Nusv(int index, long v);
	public final void vertexAttrib4Nusv(int index, long v) { glVertexAttrib4Nusv(index, v); }

	public abstract void glVertexAttrib4bv(int index, long v);
	public final void vertexAttrib4bv(int index, long v) { glVertexAttrib4bv(index, v); }

	public abstract void glVertexAttrib4d(int index, double x, double y, double z, double w);
	public final void vertexAttrib4d(int index, double x, double y, double z, double w) { glVertexAttrib4d(index, x, y, z, w); }

	public abstract void glVertexAttrib4dv(int index, long v);
	public final void vertexAttrib4dv(int index, long v) { glVertexAttrib4dv(index, v); }

	public abstract void glVertexAttrib4iv(int index, long v);
	public final void vertexAttrib4iv(int index, long v) { glVertexAttrib4iv(index, v); }

	public abstract void glVertexAttrib4s(int index, short x, short y, short z, short w);
	public final void vertexAttrib4s(int index, short x, short y, short z, short w) { glVertexAttrib4s(index, x, y, z, w); }

	public abstract void glVertexAttrib4sv(int index, long v);
	public final void vertexAttrib4sv(int index, long v) { glVertexAttrib4sv(index, v); }

	public abstract void glVertexAttrib4ubv(int index, long v);
	public final void vertexAttrib4ubv(int index, long v) { glVertexAttrib4ubv(index, v); }

	public abstract void glVertexAttrib4uiv(int index, long v);
	public final void vertexAttrib4uiv(int index, long v) { glVertexAttrib4uiv(index, v); }

	public abstract void glVertexAttrib4usv(int index, long v);
	public final void vertexAttrib4usv(int index, long v) { glVertexAttrib4usv(index, v); }

	public abstract void glVertexAttribI1i(int index, int x);
	public final void vertexAttribI1i(int index, int x) { glVertexAttribI1i(index, x); }

	public abstract void glVertexAttribI1iv(int index, long v);
	public final void vertexAttribI1iv(int index, long v) { glVertexAttribI1iv(index, v); }

	public abstract void glVertexAttribI1ui(int index, int x);
	public final void vertexAttribI1ui(int index, int x) { glVertexAttribI1ui(index, x); }

	public abstract void glVertexAttribI1uiv(int index, long v);
	public final void vertexAttribI1uiv(int index, long v) { glVertexAttribI1uiv(index, v); }

	public abstract void glVertexAttribI2i(int index, int x, int y);
	public final void vertexAttribI2i(int index, int x, int y) { glVertexAttribI2i(index, x, y); }

	public abstract void glVertexAttribI2iv(int index, long v);
	public final void vertexAttribI2iv(int index, long v) { glVertexAttribI2iv(index, v); }

	public abstract void glVertexAttribI2ui(int index, int x, int y);
	public final void vertexAttribI2ui(int index, int x, int y) { glVertexAttribI2ui(index, x, y); }

	public abstract void glVertexAttribI2uiv(int index, long v);
	public final void vertexAttribI2uiv(int index, long v) { glVertexAttribI2uiv(index, v); }

	public abstract void glVertexAttribI3i(int index, int x, int y, int z);
	public final void vertexAttribI3i(int index, int x, int y, int z) { glVertexAttribI3i(index, x, y, z); }

	public abstract void glVertexAttribI3iv(int index, long v);
	public final void vertexAttribI3iv(int index, long v) { glVertexAttribI3iv(index, v); }

	public abstract void glVertexAttribI3ui(int index, int x, int y, int z);
	public final void vertexAttribI3ui(int index, int x, int y, int z) { glVertexAttribI3ui(index, x, y, z); }

	public abstract void glVertexAttribI3uiv(int index, long v);
	public final void vertexAttribI3uiv(int index, long v) { glVertexAttribI3uiv(index, v); }

	public abstract void glVertexAttribI4bv(int index, long v);
	public final void vertexAttribI4bv(int index, long v) { glVertexAttribI4bv(index, v); }

	public abstract void glVertexAttribI4sv(int index, long v);
	public final void vertexAttribI4sv(int index, long v) { glVertexAttribI4sv(index, v); }

	public abstract void glVertexAttribI4ubv(int index, long v);
	public final void vertexAttribI4ubv(int index, long v) { glVertexAttribI4ubv(index, v); }

	public abstract void glVertexAttribI4usv(int index, long v);
	public final void vertexAttribI4usv(int index, long v) { glVertexAttribI4usv(index, v); }

	public abstract void glVertexAttribL1d(int index, double x);
	public final void vertexAttribL1d(int index, double x) { glVertexAttribL1d(index, x); }

	public abstract void glVertexAttribL1dv(int index, long v);
	public final void vertexAttribL1dv(int index, long v) { glVertexAttribL1dv(index, v); }

	public abstract void glVertexAttribL2d(int index, double x, double y);
	public final void vertexAttribL2d(int index, double x, double y) { glVertexAttribL2d(index, x, y); }

	public abstract void glVertexAttribL2dv(int index, long v);
	public final void vertexAttribL2dv(int index, long v) { glVertexAttribL2dv(index, v); }

	public abstract void glVertexAttribL3d(int index, double x, double y, double z);
	public final void vertexAttribL3d(int index, double x, double y, double z) { glVertexAttribL3d(index, x, y, z); }

	public abstract void glVertexAttribL3dv(int index, long v);
	public final void vertexAttribL3dv(int index, long v) { glVertexAttribL3dv(index, v); }

	public abstract void glVertexAttribL4d(int index, double x, double y, double z, double w);
	public final void vertexAttribL4d(int index, double x, double y, double z, double w) { glVertexAttribL4d(index, x, y, z, w); }

	public abstract void glVertexAttribL4dv(int index, long v);
	public final void vertexAttribL4dv(int index, long v) { glVertexAttribL4dv(index, v); }

	public abstract void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset);
	public final void vertexAttribLFormat(int attribindex, int size, VertexAttribType type, int relativeoffset) { glVertexAttribLFormat(attribindex, size, type.token, relativeoffset); }

	public abstract void glVertexAttribLPointer(int index, int size, int type, int stride, long pointer);
	public final void vertexAttribLPointer(int index, int size, VertexAttribType type, int stride, long pointer) { glVertexAttribLPointer(index, size, type.token, stride, pointer); }

	public abstract void glVertexAttribP1ui(int index, int type, boolean normalized, int value);
	public final void vertexAttribP1ui(int index, VertexAttribType type, boolean normalized, int value) { glVertexAttribP1ui(index, type.token, normalized, value); }

	public abstract void glVertexAttribP1uiv(int index, int type, boolean normalized, long value);
	public final void vertexAttribP1uiv(int index, VertexAttribType type, boolean normalized, long value) { glVertexAttribP1uiv(index, type.token, normalized, value); }

	public abstract void glVertexAttribP2ui(int index, int type, boolean normalized, int value);
	public final void vertexAttribP2ui(int index, VertexAttribType type, boolean normalized, int value) { glVertexAttribP2ui(index, type.token, normalized, value); }

	public abstract void glVertexAttribP2uiv(int index, int type, boolean normalized, long value);
	public final void vertexAttribP2uiv(int index, VertexAttribType type, boolean normalized, long value) { glVertexAttribP2uiv(index, type.token, normalized, value); }

	public abstract void glVertexAttribP3ui(int index, int type, boolean normalized, int value);
	public final void vertexAttribP3ui(int index, VertexAttribType type, boolean normalized, int value) { glVertexAttribP3ui(index, type.token, normalized, value); }

	public abstract void glVertexAttribP3uiv(int index, int type, boolean normalized, long value);
	public final void vertexAttribP3uiv(int index, VertexAttribType type, boolean normalized, long value) { glVertexAttribP3uiv(index, type.token, normalized, value); }

	public abstract void glVertexAttribP4ui(int index, int type, boolean normalized, int value);
	public final void vertexAttribP4ui(int index, VertexAttribType type, boolean normalized, int value) { glVertexAttribP4ui(index, type.token, normalized, value); }

	public abstract void glVertexAttribP4uiv(int index, int type, boolean normalized, long value);
	public final void vertexAttribP4uiv(int index, VertexAttribType type, boolean normalized, long value) { glVertexAttribP4uiv(index, type.token, normalized, value); }

	public abstract void glViewportArrayv(int first, int count, long v);
	public final void viewportArrayv(int first, int count, long v) { glViewportArrayv(first, count, v); }

	public abstract void glViewportIndexedf(int index, float x, float y, float w, float h);
	public final void viewportIndexedf(int index, float x, float y, float w, float h) { glViewportIndexedf(index, x, y, w, h); }

	public abstract void glViewportIndexedfv(int index, long v);
	public final void viewportIndexedfv(int index, long v) { glViewportIndexedfv(index, v); }

}