package org.objkt.gl.wrapper;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.objkt.gl.API;

public class LWJGLWrp extends Wrpv2 {

	@Override
	public
	API getApi() {
		return API.GL;
	}
	
	@Override
	CoreWrap createCoreWrap() {
		return new CoreWrap() {
			
			@Override
			public void clear(int mask) {
				GL11.glClear(mask);
			}

			@Override
			public void activeTexture(int index) {
				GL13.glActiveTexture(index);
			}

			@Override
			public int getError() {
				return GL11.glGetError();
			}

			@Override
			public void clearColor(float r, float g, float b, float a) {
				GL11.glClearColor(r, g, b, a);
			}
		};
	}
	
	@Override
	public TexWrap createTexWrap() {
		return new TexWrap() {
			
			@Override
			public int gen() {
				return GL11.glGenTextures();
			}
			
			@Override
			public void delete(int name) {
				GL11.glDeleteTextures(name);
			}
			
			@Override
			public void bind(int target, int name) {
				GL11.glBindTexture(target, name);
			}
			
			@Override
			public void parameteri(int tar, int pname, int val) {
				GL11.glTexParameteri(tar, pname, tar);
			}
			
			@Override
			public void parameterf(int tar, int pname, float val) {
				GL11.glTexParameterf(tar, pname, tar);
			}

			@Override
			public int getTexLevelParameteri(int target, int level, int param) {
				return GL11.glGetTexLevelParameteri(target, level, param);
			}
		};
	}

	@Override
	BuffWrap createBuffWrap() {
		return new BuffWrap() {
			
			@Override
			public void delete(int name) {
				GL15.glDeleteBuffers(name);
			}
			
			@Override
			public int gen() {
				return GL15.glGenBuffers();
			}
			
			@Override
			public void bind(int target, int name) {
				GL15.glBindBuffer(target, name);
			}

			@Override
			public void data(int target, long size, long data, int usage) {
				GL15.nglBufferData(target, size, data, usage);
			}

			@Override
			public void subData(int target, long offset, long size, long data) {
				GL15.nglBufferSubData(target, offset, size, data);
			}

			@Override
			public long mapBufferRange(int target, long offset, long length, int access) {
				return GL30.nglMapBufferRange(target, offset, length, access);
			}

			@Override
			public void unmap(int target) {
				GL15.glUnmapBuffer(target);
			}
		};
	}

	@Override
	ShaderWrap createShaderWrap() {
		return new ShaderWrap() {
			
			@Override
			public void delete(int name) {
				GL20.glDeleteShader(name);
			}
			
			@Override
			public int create(int target) {
				return GL20.glCreateShader(target);
			}
			
			@Override
			public void source(int name, String src) {
				GL20.glShaderSource(name, src);
			}
		};
	}

	@Override
	ShaderProgramWrap createShaderProgramWrap() {
		return new ShaderProgramWrap() {
			
			@Override
			public void delete(int name) {
				GL20.glDeleteProgram(name);
			}
			
			@Override
			public int create(int target) {
				return GL20.glCreateProgram();
			}

			@Override
			public void use(int name) {
				GL20.glUseProgram(name);
			}

			@Override
			public int geti(int name, int pname) {
				return GL20.glGetProgrami(name, pname);
			}

			@Override
			public void attachShader(int name, int shader) {
				GL20.glAttachShader(name, shader);
			}

			@Override
			public int attribLoc(int name, String attribName) {
				return GL20.glGetAttribLocation(name, attribName);	
			}

			@Override
			public int uniformLoc(int name, String uniformName) {
				return GL20.glGetUniformLocation(name, uniformName);
			}

			@Override
			public void link(int prog) {
				GL20.glLinkProgram(prog);
			}
		};
	}

	@Override
	VertexArrayWrap createVertexArrayWrap() {
		return new VertexArrayWrap() {
			
			@Override
			public void delete(int name) {
				GL30.glDeleteVertexArrays(name);
			}
			
			@Override
			public int gen() {
				return GL30.glGenVertexArrays();
			}
			
			@Override
			public void bind(int target, int name) {
				GL30.glBindVertexArray(name);
			}
			
			@Override
			public void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
				GL30.nglVertexAttribIPointer(index, size, type, stride, pointer);
			}
			
			@Override
			public void vertexAttribIPointer(int index, int size, int type, int stride, long pointer) {
				GL30.nglVertexAttribIPointer(index, size, type, stride, pointer);
			}

			@Override
			public void enableAttrib(int index) {
				GL20.glEnableVertexAttribArray(index);
			}

			@Override
			public void disableAttrib(int index) {
				GL20.glDisableVertexAttribArray(index);
			}
		};
	}

	@Override
	FrameBuffWrap createFrameBuffWrap() {
		return new FrameBuffWrap() {
			
			@Override
			public void delete(int name) {
				GL30.glDeleteFramebuffers(name);
			}
			
			@Override
			public int gen() {
				return GL30.glGenFramebuffers();
			}
			
			@Override
			public void bind(int target, int name) {
				GL30.glBindFramebuffer(target, name);
			}
		};
	}

}
