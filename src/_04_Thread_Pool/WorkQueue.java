package _04_Thread_Pool;

public class WorkQueue implements Runnable{
	private Thread[] thds;
	private int corecount;
	private boolean running = false;
	public WorkQueue() {
		corecount = Runtime.getRuntime().availableProcessors()-1;
		thds = new Thread[corecount];
		for (int i = 0; i < thds.length; i++) {
			thds[i] = new Thread(this);
			thds[i].start();
		}
	}
	
	@Override
	public void run() {
		while(running) {
			System.out.println("Output from thread #"+Thread.currentThread().threadId());
		}
	}
	
	public int getthdcount() {
		System.out.println("threads: "+thds.length+" | corecount: "+corecount);
		return thds.length;
	}
	
	public void shutdown() {
		running=false;
	}
	
}

public class runner {
	public static void main(String[] args) {
		WorkQueue
	}
}