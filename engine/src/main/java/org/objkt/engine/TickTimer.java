package org.objkt.engine;

import java.util.concurrent.TimeUnit;

public class TickTimer {
	public long tickDurationNano;
	public long startTimeNano;
	public long prevStartTimeNano;
	public long lastSpendTimeNano;

	public TickTimer(double countOfTicksPerSecond) {
		this.tickDurationNano = (long) ((1D / countOfTicksPerSecond) * 1_000_000_000D);
	}
	
	public TickTimer(int countOfTicksPerSecond) {
		this((float)countOfTicksPerSecond);
	}
	
	public void restart() {
		prevStartTimeNano = startTimeNano;
		startTimeNano = System.nanoTime();
		lastSpendTimeNano = startTimeNano - prevStartTimeNano;
	}
	
	public void waitAndRestart() {
		long timeToSleepNano = getWaitTimeNano();
		
		if(timeToSleepNano >= 0) {
			try {
				TimeUnit.NANOSECONDS.sleep(timeToSleepNano);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		restart();
	}
	
	public long getWaitTimeNano() {
		return tickDurationNano - (System.nanoTime() - startTimeNano);
	}
}
