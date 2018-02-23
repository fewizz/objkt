package org.objkt.engine;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Tasks {
	private final ConcurrentLinkedDeque<Runnable> tasks = new ConcurrentLinkedDeque<>();
	private final Semaphore semaphore = new Semaphore(0);

	public void add(Runnable run) {
		tasks.add(run);
		semaphore.release();
	}

	public FutureTask<?> add(FutureTask<?> task) {
		tasks.add(task);
		semaphore.release();
		return task;
	}

	public void addAhead(Runnable run) {
		tasks.addFirst(run);
		semaphore.release();
	}

	public void waitAndExecuteTask(long maxWaitTimeNano) throws InterruptedException {
		long start = System.nanoTime();
		while (semaphore.tryAcquire(maxWaitTimeNano, TimeUnit.NANOSECONDS) && System.nanoTime() - start < maxWaitTimeNano) {
			tasks.poll().run();
		}
	}

	public void waitAndExecute() throws InterruptedException {
		semaphore.acquire();
		tasks.poll().run();
	}
	
	public void waitAndExecuteUninterruptibly() {
		try {
			waitAndExecute();
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
	}

	public void executeAvailable() {
		for (; semaphore.tryAcquire(); ) {
			tasks.pop().run();
		}
	}
}
