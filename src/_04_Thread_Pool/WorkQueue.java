package _04_Thread_Pool;

import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Iterator;

public class WorkQueue implements Runnable {
	private ArrayDeque<Job> jobq = new ArrayDeque<Job>();
	private Thread[] thrds;
	private int corecount;
	private volatile boolean running = true;

	public WorkQueue() {
		corecount = Runtime.getRuntime().availableProcessors() - 1;
		thrds = new Thread[corecount];
		for (int i = 0; i < thrds.length; i++) {
			thrds[i] = new Thread(this);
			thrds[i].start();
		}
	}

	@Override
	public void run() {
		while (running) {
			if (!performjob()) {
				System.out.println("Output from thread #" + Thread.currentThread().getId());
				synchronized (jobq) {
					try {
						jobq.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public int getthrdcount() {
		System.out.println("threads: " + thrds.length + " | corecount: " + (corecount + 1));
		return thrds.length;
	}

	public void shutdown() {
		completejobs();
		running = false;
		synchronized (jobq) {
			jobq.notifyAll();
		}
	}

	public void addjob(Job j) {
		synchronized (jobq) {
			jobq.add(j);
			jobq.notify();
		}
	}

	public boolean performjob() {
		Job j = null;
		synchronized (jobq) {
			if (!jobq.isEmpty()) {
				j = jobq.remove();
			}
		}
		if (j != null) {
			j.perform();
			return true;
		} else {
			return false;
		}
	}
	
	public void completejobs() {
		while(!jobq.isEmpty()) {
			performjob();
		}
		
		for (int i = 0; i < thrds.length; i++) {
			if(thrds[i].getState()!=State.WAITING) {
				i=-1;
			}
		}
	}
	
}
