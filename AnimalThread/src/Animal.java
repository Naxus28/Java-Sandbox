/**
 * @author gferraz
 *
 */
public class Animal implements Runnable {
	private String name;
	private int yardsRan; 
	private int speed;
	private int maxRest;
	
	static boolean winner = false;
	final static int raceYards = 100;
	final static int initialPosition = 0;
	
	/**
	 * default constructor
	 */
	public Animal() {}
	
	/**
	 * overloaded constructor
	 */
	public Animal(String name, int yardsRan, int speed, int maxRest) {
		this.name = name;
		this.yardsRan = yardsRan;
		this.speed = speed;
		this.maxRest = maxRest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i = initialPosition; i <= raceYards; i++) {
			
			if (winner) {
				break;
			}
			
			yardsRan += speed;
			
			System.out.printf("Competidor %s is running at %dy/h. It has ran %d yards.\n", name.toUpperCase(), speed, yardsRan);
			
			if (yardsRan >= raceYards) {
				System.out.printf("Competidor %s is the winner!\n", name);
				winner = true;
			}
			
			try {
				Thread.sleep((long) (maxRest * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread turtle = new Thread(new Animal("turtle", initialPosition, 3, 150));
		Thread rabbit = new Thread(new Animal("rabbit", initialPosition, 5, 100));
		
		turtle.setDaemon(false);
		rabbit.setDaemon(false);
		
		turtle.start();
		rabbit.start();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return yardsRan;
	}

	public void setPosition(int position) {
		this.yardsRan = position;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRestMax() {
		return maxRest;
	}

	public void setRestMax(int restMax) {
		this.maxRest = restMax;
	}

	public static boolean isWinner() {
		return winner;
	}

	public static void setWinner(boolean winner) {
		Animal.winner = winner;
	}

}
