package _04_Thread_Pool;

public class Tester {
	public static void main(String[] args) {
		WorkQueue wq = new WorkQueue();
		for (int i = 0; i < 5000 ; i++) {
			int x = i;
			Job j = ()->System.out.println("Printing " + x+ " from thread #"+Thread.currentThread().getId());
		wq.addjob(j);
		}
		
		/*
		System.out.println(wq.getthrdcount() + " Total threads");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		wq.shutdown();
	}
}
