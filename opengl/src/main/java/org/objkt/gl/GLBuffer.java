package org.objkt.gl;

import org.objkt.gl.enums.*;
import org.objkt.memory.MemBlock;

public class GLBuffer<SELF> extends GLBindableObject<SELF> {
	MemBlock mappedMemBlock;
	final protected BufferTarget target;

	public GLBuffer(BufferTarget target) {
		this(GLContext.current(), target);
	}
	
	public GLBuffer(BufferTarget target, BufferUsage usage, MemBlock b) {
		this(target);
		data(b, usage);
	}
	
	GLBuffer(GLContext c, BufferTarget target) {
		super(c, ObjectIdentifier.BUFFER);
		this.target = target;
		createObject();
	}

	@Override
	public int gen() {
		return ctx.wrap.buff.gen();
	}

	@Override
	public void bind0() {
		ctx.wrap.buff.bind(target.token, getName());
	}
	
	public int size() {
		return ctx.wrap.buff.getVBOParameteri(BufferTarget.ARRAY_BUFFER, VertexBufferObjectParameter.BUFFER_SIZE);
	}

	public SELF allocate(long bytes, BufferUsage usage) {
		data(bytes, MemBlock.NULL_ADDRESS, usage);
		return getThis();
	}

	public void data(MemBlock mem, BufferUsage usage) {
		data(mem.bytes(), mem.address(), usage);
	}
	
	public void data(long size, long address, BufferUsage usage) {
		/*check();

		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferData(getName(), size, address, usage.token);
			return;
		}
		

		bind();*/
		//context.wrapper.glBufferData(target.token, size, address, usage.token);
		bind();
		ctx.wrap.buff.data(target.token, size, address, usage.token);
	}

	public void subData(long offset, long size, long address) {
		/*check();
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferSubData(getName(), offset, size, address);
			return;
		}
		 
		bind();
		context.wrapper.glBufferSubData(target.token, offset, size, address);*/
		bind();
		ctx.wrap.buff.subData(target.token, offset, size, address);
	}
	
	@SuppressWarnings("deprecation")
	public void mapRange(long offset, long size, MemBlock mb, BufferAccess... access) {
		if(mappedMemBlock != null) {
			throw new Error("Is already mapped");
		}
		bind();
		long address = ctx.wrap.buff.mapBufferRange(target.token, offset, size, BufferAccess.intMaskOf(access));//context.wrapper.glMapBufferRange(target.token, offset, size, access.token);
		
		if(mb.address() != address && mb.address() != MemBlock.NULL_ADDRESS)
			mb.free();
		mb.capture(address, size);
		mappedMemBlock = mb;
	}
	
	@SuppressWarnings("deprecation")
	public void unmap() {
		mappedMemBlock.capture(MemBlock.NULL_ADDRESS, 0);
		mappedMemBlock = null;
		bind();
		ctx.wrap.buff.unmap(target.token);//context.wrapper.glUnmapBuffer(target.token);
	}

	@Override
	public void delete0() {
		/*context.tempMemBlock.putInt(0, getName());
		context.wrapper.glDeleteBuffers(1, context.tempMemBlock.address());*/
		ctx.wrap.buff.delete(getName());
	}
}
