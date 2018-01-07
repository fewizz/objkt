package org.objkt.gl;

import org.objkt.gl.enums.ObjectIdentifier;
import org.objkt.gl.enums.QueryTarget;

public class GLQuery extends GLObjectWithId<GLQuery> {
	public final QueryTarget target;
	
	public GLQuery(GLContext c, QueryTarget target) {
		super(c, ObjectIdentifier.QUERY);
		this.target = target;
		createObject();
	}

	@Override
	public int create() {
		return ctx.wrap.query.create(-1);
	}

	public void begin() {
		ctx.wrap.query.begin(target.token, getName());
	}
	
	public void end() {
		ctx.wrap.query.end(target.token);
	}
	
	/*public void getResult(int type, IntBuffer buffer) {
		GL15.glGetQueryObjectiv(getName(), type, buffer);
	}
	
	public int getResult(int type) {
		return GL15.glGetQueryObjecti(getName(), type);
	}*/

	@Override
	public void delete0() {
		ctx.wrap.query.delete(getName());
	}

}
