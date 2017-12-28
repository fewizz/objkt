package org.objkt.gl;

import org.objct.gl.enums.BufferAccessMask;
import org.objct.gl.enums.BufferTarget;
import org.objct.gl.enums.BufferUsage;
import org.objct.gl.enums.ObjectIdentifier;
import org.objct.gl.wrapper.GLWrapper;
import org.objkt.memory.MemBlock;

public class GLBuffer<SELF> extends GLBindableObject<SELF> {
	MemBlock mappedMemBlock;
	final protected BufferTarget target;

	public GLBuffer(BufferTarget target) {
		super(ObjectIdentifier.BUFFER);
		this.target = target;
		createObject();
	}

	@Override
	public int gen() {
		return context.wrapper.genBuffer();
	}

	@Override
	public void bind0() {
		context.wrapper.bindBuffer(target, getName());
	}

	public void bindBufferBase(int index) {
		check();
		context.wrapper.bindBufferBase(target, index, getName());
	}

	public SELF allocate(long bytes, BufferUsage usage) {
		data(bytes, MemBlock.NULL_ADDRESS, usage);
		return getThis();
	}

	public void data(long size, long address, BufferUsage usage) {
		check();

		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferData(getName(), size, address, usage.token);
			return;
		}
		

		bind();
		context.wrapper.bufferData(target, size, address, usage);
	}

	public void subData(long offset, long size, long address) {
		check();
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).namedBufferSubData(getName(), offset, size, address);
			return;
		}
		 
		bind();
		context.wrapper.bufferSubData(target, offset, size, address);
	}

	/*public SELF dataOrSubData(long size, long address, BufferUsage usage) {
		if (size <= loadedSize) {
			subData(0, size, address);
		} else {
			data(size, address, usage);
		}

		return getThis();
	}*/
	
	@SuppressWarnings("deprecation")
	public void mapRange(long offset, long size, BufferAccessMask access, MemBlock mb) {
		if(mappedMemBlock != null) { 
			throw new Error("Is already mapped");
		}
		bind();
		long address = context.wrapper.mapBufferRange(target, offset, size, access);
		
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
		context.wrapper.unmapBuffer(target);
	}
	
	public void parameter() {
		//context.gl.bufferPa
	}

	@Override
	public void delete() {
		super.delete();
	}

	@Override
	public void deleteObject() {
		context.wrapper.deleteBuffer(getName());
	}
}
