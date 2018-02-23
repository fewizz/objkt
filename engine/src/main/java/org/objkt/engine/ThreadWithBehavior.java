package org.objkt.engine;

import java.util.concurrent.atomic.AtomicReference;

public class ThreadWithBehavior extends Thread {
	private volatile AtomicReference<Runnable> beh;

	public ThreadWithBehavior(String name) {
		super(name);
	}

	public void setBehavior(Runnable behavior) {
		this.beh.set(behavior);
		interrupt();
	}

	@Override
	public final void run() {
		while(beh != null && !isInterrupted()) {
			beh.getAndSet(null).run();
		}
	}
}
