package org.objkt.gl;

import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glGetInteger;
import static org.lwjgl.opengl.GL11.glIsEnabled;

import java.util.Arrays;
import java.util.EnumMap;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.objkt.gl.enums.Capability;
import org.objkt.gl.enums.ClearBufferMask;
import org.objkt.gl.enums.ErrorCode;
import org.objkt.gl.wrapper.LWJGLWrp;
import org.objkt.gl.wrapper.Wrpv2;
import org.objkt.memory.MemBlock;

public final class GLContext {
	static final ThreadLocal<GLContext> CONTEXTS = new ThreadLocal<>();
	final Thread thread;
	final MemBlock tempMemBlock = new MemBlock(64 * Float.BYTES);
	final EnumMap<Capability, Boolean> capabilityMap = new EnumMap<>(Capability.class);
	final Wrpv2 v2w;
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
	
	public static GLContext createForThisThread() {
		if (CONTEXTS.get() != null)
			throw new Error("Already created");
		
		GL.createCapabilities();
		GLContext c = new GLContext();
		CONTEXTS.set(c);
		return c;
	}

	public static GLContext current() {
		return CONTEXTS.get();
	}
	
	public static boolean isThatThreadHaveSameGLContext() {
		return false;
	}

	private GLContext() {
		//wrapper = new LWJGLWrapper();
		thread = Thread.currentThread();
		v2w = new LWJGLWrp();
		api = v2w.getApi();
		
		versionMajor = getInteger(GL30.GL_MAJOR_VERSION);
		versionMinor = getInteger(GL30.GL_MINOR_VERSION);
		//glAPI = wrapper instanceof GLWrapper ? API.GL : API.GLES;
		
		int maxTextureUnitsAmount = getInteger(GL20.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS);
		activeTextures = new GLTexture[maxTextureUnitsAmount];
		Arrays.fill(activeTextures, defaultTexture);
		
		for(Capability c : Capability.VALUES) {
			capabilityMap.put(c, glIsEnabled(c.token));
		}
	}
	
	void onGLObjectCreated(GLObjectWithId<?> obj) {
		if(!(obj instanceof GLBindableObject<?>)) return;
		
		GLBindableObject<?> bindable = (GLBindableObject<?>) obj;
		
		if(bindable instanceof GLTexture) {
			GLTexture tex = (GLTexture) bindable;
			
			tex.doAlwaysAfterDeletion(t -> {
				for (int unit = 0; unit < activeTextures.length; unit++) {
					if (activeTextures[unit] == t)
						activeTextures[unit] = defaultTexture;
				}
			});
			
			tex.bindOnlyIf(t -> t != boundTexture);
			tex.doAlwaysAfterBind(t ->  {
				activeTextures[activeTextureUnit] = t;
				boundTexture = t;
			});
		}
		
		//if(bindable instanceof GLVertexArray) {
		//	bindable.bindOnlyIf(vao -> boundVertexArray != vao);
		//	((GLVertexArray)bindable).doAlwaysAfterBind(vao -> boundVertexArray = vao);
		//}
	}
	
	//void onObjectBound() {
	//	
	//}
	
	boolean bindRequest(GLObjectWithId<?> o) {
		switch (o.identifier) {
			case PROGRAM :
				return usingProgram != o;
			case VERTEX_ARRAY :
				return boundVertexArray != o;
		default:
			break;
		}
		
		return true;
	}
	
	public void set(Capability cap, boolean bool) {
		if(capabilityMap.put(cap, bool) != bool) {
			if(bool)
				glEnable(cap.token);
			else
				glDisable(cap.token);
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
		v2w.core.activeTexture(GLConstants.GL_TEXTURE0 + activeTextureUnit);
	}

	public static int getInteger(int pname) {
		return glGetInteger(pname);
	}
	
	public ErrorCode getError() {
		return ErrorCode.get(v2w.core.getError());
	}

	public boolean supportsGL(int major, int minor) {
		return api == API.GL && this.versionMajor > major ? true : (this.versionMajor == major && this.versionMinor >= minor);
	}
	
	public boolean supportsGLES(int major, int minor) {
		return api == API.GLES && this.versionMajor > major ? true : (this.versionMajor == major && this.versionMinor >= minor);
	}
	
	public void clearColor(float red, float green, float blue, float alpha) {
		v2w.core.clearColor(red, green, blue, alpha);
	}
	
	public void clear(ClearBufferMask.Mask mask) {
		v2w.core.clear(mask.value());
	}
}
