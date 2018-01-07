package org.objkt.gl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objkt.gl.enums.ObjectIdentifier;

public abstract class GLObjectWithId<SELF> {
	public final ObjectIdentifier identifier;
	String label;
	public static final int NOT_GENERATED = -1;
	public static final int UNUSED = 0;
	
	final List<Consumer<SELF>> deletionListeners = new ArrayList<>();
	final GLContext ctx;
	private int name = NOT_GENERATED;
	
	protected GLObjectWithId(GLContext c, ObjectIdentifier idt) {
		this.identifier = idt;
		
		ctx = c;
		
		if(ctx == null)
			throw new Error("There is no GL context on this thread");
		ctx.onGLObjectCreated(this);
	}
	
	//public GLObjectWithId(ObjectIdentifier idt) {
	//	this(GLContext.current(), idt);
	//}
	
	protected void createObject() {
		name = create();
	}
	
	protected final void checkIfGenerated() {
		if(name == UNUSED) {
			throw new Error("Object is unused or deleted");
		}
	}

	public void delete() {
		checkIfGenerated();
		delete0();
		
		deletionListeners.forEach(l -> l.accept(getThis()));
		deletionListeners.clear();
		name = UNUSED;
	}

	protected int getName() {
		return name;
	}
	
	protected void setName(int name) {
		this.name = name;
	}
	
	public void setLabel(String label) {
		
	}
	
	public String getLabel() {
		return label;
	}

	@SuppressWarnings("unchecked")
	protected SELF getThis() {
		return (SELF) this;
	}

	protected boolean isGenerated() {
		return getName() != NOT_GENERATED;
	}

	protected abstract void delete0();
	
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
