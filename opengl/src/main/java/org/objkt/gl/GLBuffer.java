package org.objkt.gl;

import org.objkt.gl.enums.BufferAccessMask;
import org.objkt.gl.enums.BufferTarget;
import org.objkt.gl.enums.BufferUsage;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.memory.MemBlock;

public class GLBuffer<SELF> extends GLBindableObject<SELF> {
	MemBlock mappedMemBlock;
	final protected BufferTarget target;

	public GLBuffer(BufferTarget target) {
		this(GLContext.current(), target);
	}
	
	GLBuffer(GLContext c, BufferTarget target) {
		super(c, ObjectIdentifier.BUFFER);
		this.target = target;
		createObject();
	}

	@Override
	public int gen() {
		return context.v2w.buff.gen();
	}

	@Override
	public void bind0() {
		context.v2w.buff.bind(target.token, getName());
	}

	public SELF allocate(long bytes, BufferUsage usage) {
		data(bytes, MemBlock.NULL_ADDRESS, usage);
		return getThis();
	}

	public void data(long size, long address, BufferUsage usage) {
		/*check();

		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferData(getName(), size, address, usage.token);
			return;
		}
		

		bind();*/
		//context.wrapper.glBufferData(target.token, size, address, usage.token);
		context.v2w.buff.data(target.token, size, address, usage.token);
	}

	public void subData(long offset, long size, long address) {
		/*check();
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferSubData(getName(), offset, size, address);
			return;
		}
		 
		bind();
		context.wrapper.glBufferSubData(target.token, offset, size, address);*/
		context.v2w.buff.subData(target.token, offset, size, address);
	}
	
	@SuppressWarnings("deprecation")
	public void mapRange(long offset, long size, BufferAccessMask access, MemBlock mb) {
		if(mappedMemBlock != null) { 
			throw new Error("Is already mapped");
		}
		bind();
		long address = context.v2w.buff.mapBufferRange(target.token, offset, size, access.token);//context.wrapper.glMapBufferRange(target.token, offset, size, access.token);
		
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
		context.v2w.buff.unmap(target.token);//context.wrapper.glUnmapBuffer(target.token);
	}

	@Override
	public void delete0() {
		/*context.tempMemBlock.putInt(0, getName());
		context.wrapper.glDeleteBuffers(1, context.tempMemBlock.address());*/
		context.v2w.buff.delete(getName());
	}
}
