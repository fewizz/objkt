package org.objkt.gl;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL15;
import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.QueryTarget;

public class GLQuery extends GLObjectWithId<GLQuery> {
	public final QueryTarget target;
	
	public GLQuery(QueryTarget target) {
		super(ObjectIdentifier.QUERY);
		this.target = target;
		createObject();
	}

	@Override
	public int create() {
		ctx.wrapper.glGenQueries(1, ctx.tempMemBlock.address());
		return ctx.tempMemBlock.getInt(0);
	}

	public void begin() {
		ctx.wrapper.glBeginQuery(target.token, name);
	}
	
	public void end() {
		ctx.wrapper.glEndQuery(target.token);
	}
	
	public void getResult(int type, IntBuffer buffer) {
		GL15.glGetQueryObjectiv(getName(), type, buffer);
	}
	
	public int getResult(int type) {
		return GL15.glGetQueryObjecti(getName(), type);
	}

	@Override
	public void delete0() {
		ctx.tempMemBlock.putInt(0, name);
		ctx.wrapper.glDeleteQueries(1, ctx.tempMemBlock.address());
	}

}
