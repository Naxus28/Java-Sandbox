
public class Food {
	String[] foodTypes = {"carrot", "lettuce", "potato", "banana"};

	public Food() {}
	
	synchronized public void eat(String animal) {
		String animalName = animal.toUpperCase();
		int foodIndex = (int) Math.round((foodTypes.length -1) * Math.random());
		int timeEating = animalName.equals("TURTLE") ? 80 : 130;
		float eatingTime = (float)timeEating/100;
		
		
		System.out.println("\n============EATING TIME==============");
		System.out.println(animalName + " started eating " + foodTypes[foodIndex]);
		
		try {
			Thread.sleep((long) (timeEating * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("It took " + animalName + " " + eatingTime + "s to eat.");
		System.out.println("===========END EATING TIME===========\n");
	}
	

}
