package org.objkt.gl;

import java.util.function.*;

import org.objkt.gl.enums.ObjectIdentifier;

public abstract class GLBindableObject<SELF> extends GLObjectWithId<SELF> {
	Consumer<SELF> bindListener;
	Predicate<SELF> contextBindPredicate;
	
	public GLBindableObject(GLContext c, ObjectIdentifier idt) {
		super(c, idt);
	}
	
	@Override
	protected void createObject() {
		setName(gen());
		bind();
	}
	
	@Override
	protected final int create() {
		return NOT_GENERATED;
	}
	
	protected abstract int gen();
	
	protected boolean bind() {
		//check();
		
		if(contextBindPredicate == null || contextBindPredicate.test(getThis())) {
			bind0();
			bindListener.accept(getThis());
			return true;
		}
		
		return false;
	}
	
	public abstract void bind0();
	
	@Override
	public void delete() {
		super.delete();
		contextBindPredicate = null;
	}
	
	public void doAlwaysAfterBind(Consumer<SELF> action) {
		bindListener = action;
	}
	
	void bindOnlyIf(Predicate<SELF> predicate) {
		contextBindPredicate = predicate;
	}
}
