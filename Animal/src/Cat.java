
public class Cat extends Animal {
	private String name;
	private int lives = 9;
	
	public Cat(int weight, int height, String name) {
		super(weight, height);
		setName(name);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @return the Cat object
	 * since a cat's initial number of lives is always 9, this method can safely replace "setLives"
	 */
	public Cat die() {
		lives = lives > 0 ? lives - 1 : lives;
		
		return this; // allow method chaining
	}
	
	@Override
	public String toString() {
		String catAlive = "I am a " + this.getClass().getName().toLowerCase()  + ". My name is " + name + ". I am " 
						 + getHeight() + "\" tall and weight " + getWeight() + " lbs, and I have " + lives + " lives";
		String catDead = this.name + " has died 9 times. It has no remaining lives. When alive, " + name + " was " 
						 + getHeight() + "\" tall and weighted " + getWeight() + " lbs.";
		
		return lives <= 0  ? catDead : catAlive;
	}
}
