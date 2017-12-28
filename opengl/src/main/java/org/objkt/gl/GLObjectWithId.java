package org.objkt.gl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objkt.gl.enums.ObjectIdentifier;

public abstract class GLObjectWithId<SELF> {
	public final ObjectIdentifier identifier;
	public static final int NOT_GENERATED = -1;
	public static final int UNUSED = 0;
	
	final List<Consumer<SELF>> deletionListeners = new ArrayList<>();
	GLContext context;
	protected int name = NOT_GENERATED;
	
	public GLObjectWithId(ObjectIdentifier idt) {
		this.identifier = idt;
		preInit();
	}
	
	protected void preInit() {
		context = GLContext.current();
		
		if(context == null)
			throw new Error("There is no GL context on this thread");
		context.onGLObjectCreated(this);
	}
	
	protected void createObject() {
		name = create();
	}
	
	protected final void check() {
		if(name == UNUSED) {
			throw new Error("Object is unused or deleted");
		}
		
	}

	public void delete() {
		check();
		deleteObject();
		
		deletionListeners.forEach(l -> l.accept(getThis()));
		deletionListeners.clear();
		context = null;
		name = UNUSED;
	}

	protected int getName() {
		return name;
	}
	
	protected void setName(int name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	protected SELF getThis() {
		return (SELF) this;
	}

	protected boolean isGenerated() {
		return name != NOT_GENERATED;
	}

	protected abstract void deleteObject();
	
	public void doAlwaysAfterDeletion(Consumer<SELF> action) {;
		deletionListeners.add(action);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalized: " + this);
	}
	
	protected abstract int create();
	
	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + " id:" +  getName() + "]";
	}
}
