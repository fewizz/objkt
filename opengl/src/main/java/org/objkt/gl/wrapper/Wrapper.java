package org.objkt.gl.wrapper;

import org.objkt.gl.API;
import org.objkt.gl.enums.*;

public abstract class Wrapper {
	public final TexWrap tex;
	public final BuffWrap buff;
	public final ShaderWrap shader;
	public final ShaderProgramWrap shaderProg;
	public final VertexArrayWrap vertexArray;
	public final CoreWrap core;
	public final FrameBuffWrap frameBuff;
	public final QueryWrap query;
	
	public Wrapper() {
		core = createCoreWrap();
		tex = createTexWrap();
		buff = createBuffWrap();
		shader = createShaderWrap();
		shaderProg = createShaderProgramWrap();
		vertexArray = createVertexArrayWrap();
		frameBuff = createFrameBuffWrap();
		query = createQueryWrap();
	}
	
	public void preContextObjectCreatrion(){};
	
	abstract CoreWrap createCoreWrap();
	abstract TexWrap createTexWrap();
	abstract BuffWrap createBuffWrap();
	abstract ShaderWrap createShaderWrap();
	abstract ShaderProgramWrap createShaderProgramWrap();
	abstract VertexArrayWrap createVertexArrayWrap();
	abstract FrameBuffWrap createFrameBuffWrap();
	abstract QueryWrap createQueryWrap();
	public abstract API getApi();
	
	public static interface CoreWrap {
		void clear(int mask);
		void clearColor(float r, float g, float b, float a);
		void activeTexture(int index);
		int getError();
		void drawArrays(int mode, int first, int count);
		int getInteger(int pname);
		String getString(int pname);
		void viewport(int x, int y, int w, int h);
		void debugMessageCallback(DebugMessageCallback callback);
		boolean isEnabled(int cap);
		void enable(int cap);
		void disable(int cap);
	}
	
	static interface ObjWrap {
		void delete(int name);
	}
	
	static interface BindableObjWrap extends ObjWrap {
		void bind(int target, int name);
		int gen();
	}
	
	static interface CreatableObjWrap extends ObjWrap {
		int create(int target);
	}
	
	public static interface TexWrap extends BindableObjWrap {
		void parameteri(int tar, int pname, int val);
		void parameterf(int tar, int pname, float val);
		int getTexLevelParameteri(int target, int level, int param);
		void image2D(int tar, int level, int internalFormat, int w, int h, int border, int bufferPixelFormat, int bufferDataType, long address);
		void subImage2D(int tar, int level, int xOff, int yOff, int w, int h, int bufferPixelFormat, int bufferDataType, long address);
		void image3D(int tar, int level, int internalFormat, int w, int h, int d, int border, int bufferPixelFormat, int bufferDataType, long address);
		void subImage3D(int tar, int level, int xOff, int yOff, int zOff, int w, int h, int d, int bufferPixelFormat, int bufferDataType, long address);
	}
	
	public static interface BuffWrap extends BindableObjWrap {
		void data(int target, long size, long data, int usage);
		void subData(int target, long offset, long size, long data);
		long mapBufferRange(int target, long offset, long length, int access);
		void unmap(int target);
		int getVBOParameteri(BufferTarget tar, VertexBufferObjectParameter pname);
	}
	
	public static interface ShaderWrap extends CreatableObjWrap {
		void source(int name, String src);
		void compile(int name);
		int geti(int name, int pname);
		String getInfoLog(int name);
	}
	
	public static interface ShaderProgramWrap extends CreatableObjWrap {
		void use(int name);
		void attachShader(int name, int shader);
		void link(int prog);
		int geti(int name, int pname);
		int attribLoc(int name, String attribName);
		int uniformLoc(int name, String uniformName);
		String getInfoLog(int name);
		void uniform1iv(int loc, int count, long address);
		void uniformMatrix4fv(int loc, int count, boolean trans, long address);
		void uniform1i(int loc, int val);
		void attrib1fv(int loc, int count, long address);
	}
	
	public static interface VertexArrayWrap extends BindableObjWrap {
		void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer);
		void vertexAttribIPointer(int index, int size, int type, int stride, long pointer);
		void enableAttrib(int index);
		void disableAttrib(int index);
	}
	
	public static interface FrameBuffWrap extends BindableObjWrap {
	}
	
	public static interface QueryWrap extends CreatableObjWrap {
		void begin(int target, int name);
		void end(int target);
	}
}