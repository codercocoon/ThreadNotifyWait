package javaspringexamples.ThreadExamples;

/**
 * This example shows how to use notify() and wait() methods of Thread class.
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class Player extends Thread {

	private String name;
	private SoccerField sf;

	public Player(String _name, SoccerField _sf) {
		name = _name;
		sf = _sf;
	}

	/**
	 * If the soccer field is available, then the player gets in to shoot balls.
	 */
	public void shootBalls() {
		sf.setAvailable(false);
		System.out.println(getName() + ": Says the field soccer is no more available." + name
				+ " please gets in my player and have fun.");
		for (int i = 1; i <= 10; i++)
			System.out.println(name + " shoots ball " + i);
		System.out.println(getName() + ": Says the field soccer is available.");
		sf.setAvailable(true);
	}

	@Override
	public void run() {
		sf.getSoccerField();
		shootBalls();
	}

	/**
	 * The main method.
	 */
	public static void main(String[] args) throws InterruptedException {
		SoccerField sf = new SoccerField();
		Player p1 = new Player("P1", sf);
		Player p2 = new Player("P2", sf);
		Player p3 = new Player("P3", sf);
		Player p4 = new Player("P4", sf);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		// Waiting for threads terminating their jobs.
		p1.join();
		p2.join();
		p3.join();
		p4.join();
		System.out.println("All balls shooted.");
	}
}
