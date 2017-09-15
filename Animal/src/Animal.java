
public class Animal {
	private int weight;
	private int height;
	
	public Animal(int weight, int height) {
		setWeight(weight);
		setHeight(height);
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "I am a " + this.getClass().getName().toLowerCase()  + ". I am " + height + "\" tall and weight " + weight + "lbs";
	}

}
