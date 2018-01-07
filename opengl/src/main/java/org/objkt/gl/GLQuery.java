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
		//return GL15.glGenQueries();
		context.wrapper.glGenQueries(1, context.tempMemBlock.address());
		return context.tempMemBlock.getInt(0);
	}

	public void begin() {
		//GL15.glBeginQuery(target, getName());
		//context.wrapper.beginQuery(target, getName());
		context.wrapper.glBeginQuery(target.token, name);
	}
	
	public void end() {
		//GL15.glEndQuery(target);
		context.wrapper.glEndQuery(target.token);
	}
	
	public void getResult(int type, IntBuffer buffer) {
		GL15.glGetQueryObjectiv(getName(), type, buffer);
	}
	
	public int getResult(int type) {
		return GL15.glGetQueryObjecti(getName(), type);
	}

	@Override
	public void delete0() {
		//GL15.glDeleteQueries(getName());
		context.tempMemBlock.putInt(0, name);
		context.wrapper.glDeleteQueries(1, context.tempMemBlock.address());
	}

}
