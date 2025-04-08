package _05_Synchronized_Swimming;

/*
 * This class represents one of the world-class swimmers that would like to take
 * a turn in the pool!
 *
 * Challenge: Complete the run() method, using a for-loop to swim 5 laps by calling
 * the static takeTurn() method in SynchronizedSwimming.
 */
public class Swimmer extends Thread {
	public final String name;

	public Swimmer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		SynchronizedSwimming ss = new SynchronizedSwimming();
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "'s lap: "+(i+1));
			ss.takeTurn(this);
		}
		
	}
	
	public String swimname() {
		return name;
	}
}
