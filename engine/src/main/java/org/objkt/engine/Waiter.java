package org.objkt.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;

public class Waiter {
	Map<Thread, String> tl = new ConcurrentHashMap<>();
	
	public synchronized void waitFor(String str) {
		Thread t = Thread.currentThread();
		
		if(tl.get(t).equals(str)) {
			tl.remove(t);
			return;
		}
		
		
		LockSupport.park(this);
	}
	
	public void notifyAbout(String str) {
		
	}
}
