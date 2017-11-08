/**
 * @author gferraz
 *
 */
public class Animal implements Runnable {
	private String name;
	private int yardsRan; 
	private int speed;
	Food food;
	
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
	public Animal(String name, int yardsRan, int speed, Food food) {
		this.name = name;
		this.yardsRan = yardsRan;
		this.speed = speed;
		this.food = food;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(int i = initialPosition; i <= raceYards; i++) {
			
			// break out of loop if there is winner
			if (winner) {
				break;
			}
			
			yardsRan += speed;
			
			System.out.printf("%s is running at %dy/h. It has ran %d yards.\n", name.toUpperCase(), speed, yardsRan);
			
			if (yardsRan >= raceYards) {
				System.out.printf("\n*****%s IS THE WINNER!*****\n\n",  name.toUpperCase());
				winner = true;
			} else {
				food.eat(name);
			}
	
		}
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

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public static boolean isWinner() {
		return winner;
	}

	public static void setWinner(boolean winner) {
		Animal.winner = winner;
	}

}
