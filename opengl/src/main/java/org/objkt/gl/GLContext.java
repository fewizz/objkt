package org.objkt.gl;

import java.util.*;
import java.util.function.*;

import org.objkt.gl.enums.*;
import org.objkt.gl.wrapper.*;

public final class GLContext {
	static final ThreadLocal<GLContext> CONTEXTS = new ThreadLocal<>();
	final Thread thread;
	final EnumMap<Capability, Boolean> capabilityMap = new EnumMap<>(Capability.class);
	final Wrapper wrap;
	final GLTexture[] activeTextures;
	int activeTextureUnit = 0;
	final API api;
	final int versionMajor;
	final int versionMinor;
	
	public final GLTexture defaultTexture = new GLTexture(this, null) {
		protected void createObject() {};
		protected int getName() {return 0;}
		protected void setName(int id) {/* nope */};
		//public void bind0() {throw new Error();};
		public void delete() {throw new Error();};
	};
	
	public final GLVertexArray defaultVertexArray = new GLVertexArray(this) {
		protected void createObject() {};
		protected int getName() {return 0;}
		protected void setName(int id) {/* nope */};
		//public void bind0() {throw new Error();};
		public void delete() {throw new Error();};
	};
	
	public final GLBuffer<?> defaultBuffer = new GLBuffer<GLBuffer<?>>(this, null) {
		protected void createObject() {};
		protected int getName() {return 0;}
		protected void setName(int id) {/* nope */};
		//public void bind0() {throw new Error();};
		public void delete() {throw new Error();};
	};
	
	public final GLShaderProgram defaultProgram = new GLShaderProgram(this) {
		protected void createObject() {};
		protected int getName() {return 0;}
		protected void setName(int id) {/* nope */};
		public void delete() {throw new Error();};
	};
	
	GLTexture boundTexture = defaultTexture;
	GLVertexArray boundVertexArray = defaultVertexArray;
	GLShaderProgram usingProgram = defaultProgram;
	
	public static GLContext createForThisThread(ContextProvider cp, Wrapper wrapper) {
		if (CONTEXTS.get() != null)
			throw new Error("Already created");
		
		wrapper.preContextObjectCreatrion();
		GLContext c = new GLContext(wrapper);
		CONTEXTS.set(c);
		return c;
	}

	public static GLContext current() {
		return CONTEXTS.get();
	}
	
	public static boolean isThatThreadHaveSameGLContext() {
		return false;
	}

	private GLContext(Wrapper w) {
		thread = Thread.currentThread();
		wrap = w;
		api = wrap.getApi();
		
		versionMajor = getInteger(GLConstants.GL_MAJOR_VERSION);
		versionMinor = getInteger(GLConstants.GL_MINOR_VERSION);
		
		int maxTextureUnitsAmount = getInteger(GLConstants.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS);
		activeTextures = new GLTexture[maxTextureUnitsAmount];
		Arrays.fill(activeTextures, defaultTexture);
		
		for(Capability c : Capability.VALUES) {
			capabilityMap.put(c, wrap.core.isEnabled(c.token));
		}
	}
	
	void onGLObjectCreated(GLObjectWithId<?> obj) {
		if(!(obj instanceof GLBindableObject<?>)) return;
		
		GLBindableObject<?> bindable = (GLBindableObject<?>) obj;
		
		if(bindable instanceof GLTexture) {
			GLTexture tex = (GLTexture) bindable;
			
			tex.doAlwaysAfterDeletion(new Consumer<GLTexture>() {
				@Override
				public void accept(GLTexture t) {
					for (int unit = 0; unit < activeTextures.length; unit++) {
						if (activeTextures[unit] == t)
							activeTextures[unit] = defaultTexture;
					}
				}
			});
			
			tex.bindOnlyIf(new Predicate<GLTexture>() {
				@Override
				public boolean test(GLTexture t) {
					return t != boundTexture;
				}
			});
			tex.doAlwaysAfterBind(new Consumer<GLTexture>() {
				@Override
				public void accept(GLTexture t) {
					activeTextures[activeTextureUnit] = t;
					boundTexture = t;
				}
			});
		}
	}
	
	public void set(Capability cap, boolean bool) {
		if(capabilityMap.put(cap, bool) != bool) {
			if(bool)
				wrap.core.enable(cap.token);
			else
				wrap.core.disable(cap.token);
		}
	}
	
	public void enable(Capability cap) {
		set(cap, true);
	}
	
	public void disable(Capability cap) {
		set(cap, false);
	}
	
	public boolean enabled(Capability cap) {
		return capabilityMap.get(cap);
	}

	public void bindTextureUnit(GLTexture texture, int index) {
		if(activeTextures[index] == texture) {
			return;
		}
		
		if (activeTextureUnit != index) {
			setActiveTextureUnitIndex(index);
		}
		if(texture == boundTexture)
			texture.bind0();
		else {
			texture.bind();
		}
		activeTextures[index] = texture;
	}

	void setActiveTextureUnitIndex(int index) {
		activeTextureUnit = index;
		wrap.core.activeTexture(GLConstants.GL_TEXTURE0 + activeTextureUnit);
	}

	public int getInteger(GetPName pname) {
		return getInteger(pname.token);
	}
	
	public int getInteger(int pname) {
		return wrap.core.getInteger(pname);
	}
	
	public String getString(StringName pname) {
		return wrap.core.getString(pname.token);
	}
	
	public ErrorCode getError() {
		return ErrorCode.get(wrap.core.getError());
	}
	
	public void clearColor(float red, float green, float blue, float alpha) {
		wrap.core.clearColor(red, green, blue, alpha);
	}
	
	public void clear(ClearBuffer... mask) {
		wrap.core.clear(ClearBuffer.intMaskOf(mask));
	}
	
	public void drawArrays(PrimitiveType mode, int count) {
		drawArrays(mode, 0, count);
	}
	
	public void drawArrays(GLVertexArray vao, PrimitiveType mode, int count) {
		vao.bind();
		drawArrays(mode, 0, count);
	}
	
	public void drawArrays(PrimitiveType mode, int first, int count) {
		wrap.core.drawArrays(mode.token, first, count);
	}
	
	public void viewport(int x, int y, int w, int h) {
		wrap.core.viewport(x, y, w, h);
	}
	
	public void dedugMessageCallback(DebugMessageCallback callback) {
		wrap.core.debugMessageCallback(callback);
	}
}
