package org.objkt.gl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.objkt.gl.enums.ObjectIdentifier;

public abstract class GLBindableObject<SELF> extends GLObjectWithId<SELF> {
	List<Consumer<SELF>> bindListeners;
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
	
	public boolean bind() {
		//check();
		
		if(contextBindPredicate == null || contextBindPredicate.test(getThis())) {
			bind0();
			if(bindListeners != null)bindListeners.forEach(action -> action.accept(getThis()));
			return true;
		}
		
		return false;
	}
	
	public abstract void bind0();
	
	@Override
	public void delete() {
		super.delete();
		bindListeners = null;
		contextBindPredicate = null;
	}
	
	public void doAlwaysAfterBind(Consumer<SELF> action) {
		if(bindListeners == null) bindListeners = new ArrayList<>();
		bindListeners.add(action);
	}
	
	void bindOnlyIf(Predicate<SELF> predicate) {
		contextBindPredicate = predicate;
	}
}
