package org.objkt.gl;

import org.objkt.gl.enums.*;
import org.objkt.memory.Allocation;
import org.objkt.memory.MemBlock;
import org.objkt.memory.NativeAllocation;

public class GLBuffer<SELF> extends GLBindableObject<SELF> {
	NativeAllocation allocation = new NativeAllocation(0, 0);
	final protected BufferTarget target;

	public GLBuffer(BufferTarget target) {
		this(GLContext.current(), target);
	}
	
	/*public GLBuffer(BufferTarget target, BufferUsage usage, MemBlock b) {
		this(target);
		data(b, usage);
	}*/
	
	GLBuffer(GLContext c, BufferTarget target) {
		this(c, target, c.wrap.buff.gen());
	}

	GLBuffer(GLContext c, BufferTarget target, int name) {
		super(c, name);
		this.target = target;
		bind();
	}

	@Override
	public void bind() {
		ctx.wrap.buff.bind(target.token, name);
	}
	
	public int size() {
		return ctx.wrap.buff.getVBOParameteri(BufferTarget.ARRAY_BUFFER, VertexBufferObjectParameter.BUFFER_SIZE);
	}

	public SELF allocate(long bytes, BufferUsage usage) {
		data(bytes, 0L, usage);
		return getThis();
	}

	public void data(MemBlock mem, BufferUsage usage) {
		data(mem.bytes(), mem.address(), usage);
	}
	
	public void data(long size, long address, BufferUsage usage) {
		bind();
		ctx.wrap.buff.data(target.token, size, address, usage.token);
	}

	public void subData(long offset, long size, long address) {
		bind();
		ctx.wrap.buff.subData(target.token, offset, size, address);
	}
	
	@SuppressWarnings("deprecation")
	public Allocation mapRange(long offset, long size, BufferAccess... access) {
		if(allocation.address() != 0) {
			throw new Error("Is already mapped");
		}
		bind();
		long address = ctx.wrap.buff.mapBufferRange(target.token, offset, size, BufferAccess.intMaskOf(access));
		allocation.set(address, size);
		return allocation;
	}
	
	@SuppressWarnings("deprecation")
	public void unmap() {
		allocation.set(0, 0);
		bind();
		ctx.wrap.buff.unmap(target.token);
	}

	@Override
	public void delete() {
		ctx.wrap.buff.delete(name);
	}
}
