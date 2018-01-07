package org.objkt.gl.wrapper;

import org.objkt.gl.API;

public abstract class Wrapper {
	public final TexWrap tex;
	public final BuffWrap buff;
	public final ShaderWrap shader;
	public final ShaderProgramWrap shaderProg;
	public final VertexArrayWrap vertexArray;
	public final CoreWrap core;
	public final FrameBuffWrap frameBuff;
	
	public Wrapper() {
		core = createCoreWrap();
		tex = createTexWrap();
		buff = createBuffWrap();
		shader = createShaderWrap();
		shaderProg = createShaderProgramWrap();
		vertexArray = createVertexArrayWrap();
		frameBuff = createFrameBuffWrap();
	}
	
	public void preContextObjectCreatrion(){};
	
	abstract CoreWrap createCoreWrap();
	abstract TexWrap createTexWrap();
	abstract BuffWrap createBuffWrap();
	abstract ShaderWrap createShaderWrap();
	abstract ShaderProgramWrap createShaderProgramWrap();
	abstract VertexArrayWrap createVertexArrayWrap();
	abstract FrameBuffWrap createFrameBuffWrap();
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
	}
	
	public static interface BuffWrap extends BindableObjWrap {
		void data(int target, long size, long data, int usage);
		void subData(int target, long offset, long size, long data);
		long mapBufferRange(int target, long offset, long length, int access);
		void unmap(int target);
	}
	
	public static interface ShaderWrap extends CreatableObjWrap {
		void source(int name, String src);
	}
	
	public static interface ShaderProgramWrap extends CreatableObjWrap {
		void use(int name);
		void attachShader(int name, int shader);
		void link(int prog);
		int geti(int name, int pname);
		int attribLoc(int name, String attribName);
		int uniformLoc(int name, String uniformName);
	}
	
	public static interface VertexArrayWrap extends BindableObjWrap {
		void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer);
		void vertexAttribIPointer(int index, int size, int type, int stride, long pointer);
		void enableAttrib(int index);
		void disableAttrib(int index);
	}
	
	public static interface FrameBuffWrap extends BindableObjWrap {
	}
}