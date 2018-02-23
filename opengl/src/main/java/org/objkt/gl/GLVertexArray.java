package org.objkt.gl;

import java.util.HashMap;
import java.util.function.BiConsumer;

import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.VertexAttribType;
import org.objkt.memory.MemBlock;

public class GLVertexArray extends GLBindableObject<GLVertexArray> {
	final HashMap<Integer, VertexAttribArray> vbos = new HashMap<>();
	
	public GLVertexArray() {
		this(GLContext.current());
	}
	
	GLVertexArray(GLContext c) {
		super(c, ObjectIdentifier.VERTEX_ARRAY);
		createObject();
	}
	
	@Override
	public int gen() {
		return ctx.wrap.vertexArray.gen();
	}
	
	@Override
	public void bind0() {
		ctx.wrap.vertexArray.bind(-1, getName());
	}
	
	@Override
	protected void delete0() {
		ctx.wrap.vertexArray.delete(getName());
	}
	
	public void forEachAttribArray(BiConsumer<Integer, VertexAttribArray> action) {
		vbos.forEach(action);
	}
	
	public VertexAttribArray getVertexAttribArrayAt(int index) {
		return vbos.get(index);
	}
	
	public VertexAttribArray vertexAttribPointer(VertexAttribFormat attrib, GLVertexBuffer vbo) {
		bind();
		vbo.bind();
		
		if(attrib.serverDataType.isIntegral)
			ctx.wrap.vertexArray.vertexAttribIPointer(attrib.index, attrib.components, attrib.clientDataType.token, 0, MemBlock.NULL_ADDRESS);
		else
			ctx.wrap.vertexArray.vertexAttribPointer(attrib.index, attrib.components, attrib.clientDataType.token, attrib.normalized, 0, MemBlock.NULL_ADDRESS);
		
		VertexAttribArray arr = new VertexAttribArray(attrib, vbo);
		vbos.put(attrib.index, arr);
		return arr;
	}
	
	public void enableVertexAttribArray(int index) {
		/*if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).enableVertexArrayAttrib(getName(), index);
			return;
		}*/
		bind();
		ctx.wrap.vertexArray.enableAttrib(index);
	}
	
	public void disableVertexAttribArray(int index) {
		bind();
		ctx.wrap.vertexArray.disableAttrib(index);
	}
	
	@Override
	public void delete() {
		super.delete();
		vbos.clear();
	}
	
	public class VertexAttribArray {
		public GLBuffer<?> vbo;
		public final VertexAttribFormat info;
		
		VertexAttribArray(VertexAttribFormat attrib, GLVertexBuffer vbo) {
			this.vbo = vbo;
			this.info = attrib;
		}
		
		public VertexAttribArray enable() {
			enableVertexAttribArray(info.index);
			return this;
		}
		
		public VertexAttribArray disable() {
			disableVertexAttribArray(info.index);
			return this;
		}
	}
	
	public static class VertexAttribFormat {
		public final VertexAttribType clientDataType;
		public final VertexAttribType serverDataType;
		public final int components;
		public final boolean normalized;
		public final int index;
		
		public VertexAttribFormat(int index, VertexAttribType clientDataType, VertexAttribType serverDataType, int components, boolean normalize) {
			this.clientDataType = clientDataType;
			this.serverDataType = serverDataType;
			this.components = components;
			this.normalized = normalize;
			this.index = index;
		}
		
		public int componentsBytes() {
			return components * clientDataType.bytes;
		}
		
		public static VertexAttribFormat intType(int index, VertexAttribType clientDataType, int components) {
			return new VertexAttribFormat(index, clientDataType, VertexAttribType.INT, components, false);
		}
		
		public static VertexAttribFormat floatType(int index, VertexAttribType clientDataType, int components, boolean normalized) {
			return new VertexAttribFormat(index, clientDataType, VertexAttribType.FLOAT, components, normalized);
		}
		
		public static VertexAttribFormat pos3f(int index) {return floatType(index, VertexAttribType.FLOAT, 3, false);}
		public static VertexAttribFormat pos2f(int index) {return floatType(index, VertexAttribType.FLOAT, 2, false);}
		public static VertexAttribFormat normal3f(int index) {return floatType(index, VertexAttribType.FLOAT, 3, false);}
		public static VertexAttribFormat color4ub(int index) {return floatType(index, VertexAttribType.UNSIGNED_BYTE, 4, true);}
		public static VertexAttribFormat uv2f(int index) {return floatType(index, VertexAttribType.FLOAT, 2, false);}
	}
}
