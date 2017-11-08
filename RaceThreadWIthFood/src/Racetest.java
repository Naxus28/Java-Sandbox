
public class Racetest {

	public static void main(String[] args) {
		Food food = new Food();
		
		Thread turtle = new Thread(new Animal("turtle", 0, 3,food));
		Thread rabbit = new Thread(new Animal("rabbit", 0, 5, food));
		
		turtle.setDaemon(false);
		rabbit.setDaemon(false);
		
		turtle.start();
		rabbit.start();
	}

}
