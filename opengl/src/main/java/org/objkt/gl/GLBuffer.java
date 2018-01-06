package org.objkt.gl;

import org.objkt.gl.enums.BufferAccessMask;
import org.objkt.gl.enums.BufferTarget;
import org.objkt.gl.enums.BufferUsage;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.wrapper.GLWrapper;
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
		context.wrapper.glGenBuffers(1, context.tempMemBlock.address());
		return context.tempMemBlock.getInt(0);
	}

	@Override
	public void bind0() {
		context.wrapper.glBindBuffer(target.token, getName());
	}

	public void bindBufferBase(int index) {
		check();
		context.wrapper.glBindBufferBase(target.token, index, getName());
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
		context.wrapper.glBufferData(target.token, size, address, usage.token);
	}

	public void subData(long offset, long size, long address) {
		check();
		if(context.supportsGL(4, 5)) {
			((GLWrapper)context.wrapper).glNamedBufferSubData(getName(), offset, size, address);
			return;
		}
		 
		bind();
		context.wrapper.glBufferSubData(target.token, offset, size, address);
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
		long address = context.wrapper.glMapBufferRange(target.token, offset, size, access.token);
		
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
		context.wrapper.glUnmapBuffer(target.token);
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
		context.tempMemBlock.putInt(0, getName());
		context.wrapper.glDeleteBuffers(1, context.tempMemBlock.address());
	}
}
