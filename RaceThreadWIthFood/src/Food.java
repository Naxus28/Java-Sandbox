
public class Food {
	String foodType;

	public Food() {}
	
	public void eat(String animal) {
		String animalName = animal.toUpperCase();
		
		int timeEating = animal == "TURTLE" ? 83 : 150;
		System.out.println("======================");
		System.out.println(animalName + " started eating.");
		
		try {
			Thread.sleep((long) (timeEating * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(animalName + " is done eating.");
		System.out.println("======================");
	}
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

}
