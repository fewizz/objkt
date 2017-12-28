package org.objkt.gl;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL15;
import org.objct.gl.enums.ObjectIdentifier;
import org.objct.gl.enums.QueryTarget;

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
		return context.wrapper.genQuerie();
	}

	public void begin() {
		//GL15.glBeginQuery(target, getName());
		context.wrapper.beginQuery(target, getName());
	}
	
	public void end() {
		//GL15.glEndQuery(target);
		context.wrapper.endQuery(target);
	}
	
	public void getResult(int type, IntBuffer buffer) {
		GL15.glGetQueryObjectiv(getName(), type, buffer);
	}
	
	public int getResult(int type) {
		return GL15.glGetQueryObjecti(getName(), type);
	}

	@Override
	public void deleteObject() {
		//GL15.glDeleteQueries(getName());
		context.wrapper.deleteQuerie(getName());
	}

}
