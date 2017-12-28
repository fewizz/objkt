package org.objkt.gl;

import java.util.HashMap;
import java.util.function.BiConsumer;

import org.objct.gl.enums.ObjectIdentifier;
import org.objct.gl.enums.VertexAttribType;
import org.objct.gl.wrapper.GLWrapper;
import org.objkt.memory.MemBlock;

public class GLVertexArray extends GLBindableObject<GLVertexArray> {
	final HashMap<Integer, VertexAttribArray> vbos = new HashMap<>();
	
	public GLVertexArray() {
		super(ObjectIdentifier.VERTEX_ARRAY);
		createObject();
	}
	
	@Override
	public int gen() {
		return context.wrapper.genVertexArray();
	}
	
	@Override
	public void bind0() {
		context.wrapper.bindVertexArray(getName());
	}
	
	@Override
	protected void deleteObject() {
		context.wrapper.deleteVertexArray(getName());
	}
	
	public void forEachAttribArray(BiConsumer<Integer, VertexAttribArray> action) {
		vbos.forEach(action);
	}
	
	public VertexAttribArray getVertexAttribArrayAt(int index) {
		return vbos.get(index);
	}
	
	public VertexAttribArray vertexAttribPointer(int index, VertexAttribInfo attrib, GLVertexBuffer vbo) {
		bind();
		vbo.bind();
		
		if(attrib.serverDataType.isIntegral)
			context.wrapper.vertexAttribIPointer(index, attrib.components, attrib.clientDataType, 0, MemBlock.NULL_ADDRESS);
		else
			context.wrapper.vertexAttribPointer(index, attrib.components, attrib.clientDataType, attrib.normalized, 0, MemBlock.NULL_ADDRESS);
		
		VertexAttribArray arr = new VertexAttribArray(index, attrib, vbo);
		vbos.put(index, arr);
		return arr;
	}
	
	public void enableVertexAttribArray(int index) {
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).enableVertexArrayAttrib(getName(), index);
			return;
		}
		bind();
		context.wrapper.enableVertexAttribArray(index);
	}
	
	public void disableVertexAttribArray(int index) {
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).disableVertexArrayAttrib(getName(), index);
			return;
		}
		bind();
		context.wrapper.disableVertexAttribArray(index);
	}
	
	@Override
	public void delete() {
		super.delete();
		vbos.clear();
	}
	
	public class VertexAttribArray {
		public GLBuffer<?> vbo;
		public final VertexAttribInfo info;
		public final int index;
		
		VertexAttribArray(int index, VertexAttribInfo attrib, GLVertexBuffer vbo) {
			this.vbo = vbo;
			this.info = attrib;
			this.index = index;
		}
		
		public VertexAttribArray enable() {
			enableVertexAttribArray(index);
			return this;
		}
		
		public VertexAttribArray disable() {
			disableVertexAttribArray(index);
			return this;
		}
	}
	
	public static class VertexAttribInfo {
		public final VertexAttribType clientDataType;
		public final VertexAttribType serverDataType;
		public final int components;
		public final boolean normalized;
		
		public VertexAttribInfo(VertexAttribType clientDataType, VertexAttribType serverDataType, int components, boolean normalize) {
			this.clientDataType = clientDataType;
			this.serverDataType = serverDataType;
			this.components = components;
			this.normalized = normalize;
		}
		
		public int componentsBytes() {
			return components * clientDataType.bytes;
		}
		
		public static VertexAttribInfo intType(VertexAttribType clientDataType, int components) {
			return new VertexAttribInfo(clientDataType, VertexAttribType.INT, components, false);
		}
		
		public static VertexAttribInfo floatType(VertexAttribType clientDataType, int components, boolean normalized) {
			return new VertexAttribInfo(clientDataType, VertexAttribType.FLOAT, components, normalized);
		}
		
		public static final VertexAttribInfo
			POS3f = floatType(VertexAttribType.FLOAT, 3, false),
			NORMAL3f = floatType(VertexAttribType.FLOAT, 3, false),
			COLOR4ub = floatType(VertexAttribType.UNSIGNED_BYTE, 4, true),
			UV2f = floatType(VertexAttribType.FLOAT, 2, false);
	}
}
