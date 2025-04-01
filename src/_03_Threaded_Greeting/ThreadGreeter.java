package _03_Threaded_Greeting;

public class ThreadGreeter implements Runnable{

	private int count;
	public ThreadGreeter(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		if(count!=1000) {
			Thread next = new Thread(new ThreadGreeter(count+1));
			next.start();
			System.out.println("Hello from thread number: "+count);
			try {
				next.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
