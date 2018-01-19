package org.objkt.gl.wrapper;

import java.nio.*;

import org.objkt.gl.API;
import org.objkt.gl.enums.*;
import org.objkt.memory.Utils;

import android.opengl.*;

public class AndroidWrapper extends Wrapper {
	ByteBuffer buff;
	IntBuffer buffi;
	
	
	public AndroidWrapper() {
		buff = ByteBuffer.allocateDirect(16 * 1024).order(ByteOrder.nativeOrder());
		buffi = buff.asIntBuffer();
	}

	@Override
	CoreWrap createCoreWrap() {
		return new CoreWrap() {
			
			@Override
			public void viewport(int x, int y, int w, int h) {
				GLES10.glViewport(x, y, w, h);
			}
			
			@Override
			public String getString(int pname) {
				return GLES10.glGetString(pname);
			}
			
			@Override
			public int getInteger(int pname) {
				GLES10.glGetIntegerv(pname, buffi);
				return buffi.get(0);
			}
			
			@Override
			public int getError() {
				return GLES10.glGetError();
			}
			
			@Override
			public void drawArrays(int mode, int first, int count) {
				GLES10.glDrawArrays(mode, first, count);
			}
			
			@Override
			public void debugMessageCallback(DebugMessageCallback callback) {
				GLES31Ext.glDebugMessageCallbackKHR((int source, int type, int id, int severity, java.lang.String message) -> {
					callback.callback(DebugSource.get(source), DebugType.get(type), id, DebugSeverity.get(severity), message);
				});
			}
			
			@Override
			public void clearColor(float r, float g, float b, float a) {
				GLES10.glClearColor(r, g, b, a);
			}
			
			@Override
			public void clear(int mask) {
				GLES10.glClear(mask);
			}
			
			@Override
			public void activeTexture(int index) {
				GLES10.glActiveTexture(index);
			}
		};
	}

	@Override
	TexWrap createTexWrap() {
		return new TexWrap() {
			
			@Override
			public void delete(int name) {
				buffi.put(0, name);
				GLES10.glDeleteTextures(1, buffi);
			}
			
			@Override
			public int gen() {
				GLES10.glGenTextures(1, buffi);
				return buffi.get(0);
			}
			
			@Override
			public void bind(int target, int name) {
				GLES10.glBindTexture(target, name);
			}
			
			@Override
			public void parameteri(int tar, int pname, int val) {
				buffi.put(0, val);
				GLES11.glTexParameteriv(tar, pname, buffi);
			}
			
			@Override
			public void parameterf(int tar, int pname, float val) {
				GLES10.glTexParameterf(tar, pname, val);
			}
			
			@Override
			public int getTexLevelParameteri(int target, int level, int param) {
				GLES31.glGetTexLevelParameteriv(target, level, param, buffi);
				return buffi.get(0);
			}
		};
	}

	@Override
	BuffWrap createBuffWrap() {
		return new BuffWrap() {
			
			@Override
			public void delete(int name) {
				buffi.put(0, name);
				GLES11.glDeleteBuffers(1, buffi);
			}
			
			@Override
			public int gen() {
				GLES11.glGenBuffers(1, buffi);
				return buffi.get(0);
			}
			
			@Override
			public void bind(int target, int name) {
				GLES11.glBindBuffer(target, name);
			}
			
			@Override
			public void unmap(int target) {
				GLES30.glUnmapBuffer(target);
			}
			
			@Override
			public void subData(int target, long offset, long size, long data) {
				long prev = Utils.address(buff);
				int prevSize = buff.capacity();
				Utils.setBuffer(buff, data, (int)size);
				GLES11.glBufferSubData(target, (int)offset, (int)size, buff);
				Utils.setBuffer(buff, prev, prevSize);
			}
			
			@Override
			public long mapBufferRange(int target, long offset, long length, int access) {
				return Utils.address(GLES30.glMapBufferRange(target, (int)offset, (int)length, access));
			}
			
			@Override
			public void data(int target, long size, long data, int usage) {
				long prev = Utils.address(buff);
				int prevSize = buff.capacity();
				Utils.setBuffer(buff, data, (int)size);
				GLES11.glBufferData(target, (int)size, buff, usage);
				Utils.setBuffer(buff, prev, prevSize);
			}
		};
	}

	@Override
	ShaderWrap createShaderWrap() {
		return new ShaderWrap() {
			
			@Override
			public void delete(int name) {
				GLES20.glDeleteShader(name);
			}
			
			@Override
			public int create(int target) {
				return GLES20.glCreateShader(target);
			}
			
			@Override
			public void source(int name, String src) {
				GLES20.glShaderSource(name, src);
			}
			
			@Override
			public void compile(int name) {
				GLES20.glCompileShader(name);
			}
		};
	}

	@Override
	ShaderProgramWrap createShaderProgramWrap() {
		return new ShaderProgramWrap() {
			
			@Override
			public void delete(int name) {
				GLES20.glDeleteProgram(name);
			}
			
			@Override
			public int create(int target) {
				return GLES20.glCreateProgram();
			}
			
			@Override
			public void use(int name) {
				GLES20.glUseProgram(name);
			}
			
			@Override
			public int uniformLoc(int name, String uniformName) {
				return GLES20.glGetUniformLocation(name, uniformName);
			}
			
			@Override
			public void link(int prog) {
				GLES20.glLinkProgram(prog);
			}
			
			@Override
			public int geti(int name, int pname) {
				GLES20.glGetProgramiv(name, name, buffi);
				return buffi.get(0);
			}
			
			@Override
			public int attribLoc(int name, String attribName) {
				return GLES20.glGetAttribLocation(name, attribName);
			}
			
			@Override
			public void attachShader(int name, int shader) {
				GLES20.glAttachShader(name, shader);
			}
		};
	}

	@Override
	VertexArrayWrap createVertexArrayWrap() {
		return new VertexArrayWrap() {
			
			@Override
			public void delete(int name) {
				buffi.put(0, name);
				GLES31.glDeleteVertexArrays(1, buffi);
			}
			
			@Override
			public int gen() {
				GLES31.glGenVertexArrays(1, buffi);
				return buffi.get(0);
			}
			
			@Override
			public void bind(int target, int name) {
				GLES31.glBindVertexArray(name);
			}
			
			@Override
			public void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
				GLES31.glVertexAttribPointer(index, size, type, normalized, stride, 0);
			}
			
			@Override
			public void vertexAttribIPointer(int index, int size, int type, int stride, long pointer) {
				GLES31.glVertexAttribIPointer(index, size, type, stride, 0);
			}
			
			@Override
			public void enableAttrib(int index) {
				GLES31.glEnableVertexAttribArray(index);
			}
			
			@Override
			public void disableAttrib(int index) {
				GLES31.glDisableVertexAttribArray(index);
			}
		};
	}

	@Override
	FrameBuffWrap createFrameBuffWrap() {
		return new FrameBuffWrap() {
			
			@Override
			public void delete(int name) {
				buffi.put(0, name);
				GLES20.glDeleteFramebuffers(1, buffi);
			}
			
			@Override
			public int gen() {
				GLES20.glGenFramebuffers(1, buffi);
				return buffi.get(0);
			}
			
			@Override
			public void bind(int target, int name) {
				GLES20.glBindFramebuffer(target, name);
			}
		};
	}

	@Override
	QueryWrap createQueryWrap() {
		return new QueryWrap() {
			
			@Override
			public void delete(int name) {
				buffi.put(0, name);
				GLES30.glDeleteQueries(1, buffi);
			}
			
			@Override
			public int create(int target) {
				GLES30.glGenQueries(1, buffi);
				return buffi.get(0);
			}
			
			@Override
			public void end(int target) {
				GLES30.glEndQuery(target);
			}
			
			@Override
			public void begin(int target, int name) {
				GLES30.glBeginQuery(target, name);
			}
		};
	}

	@Override
	public API getApi() {
		return API.GLES;
	}

}
