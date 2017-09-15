
public class Dog extends Animal{
	private String name;
	private String breed;
	private Date DOB;

	public Dog(int weight, int height, String name, String breed, Date DOB) {
		super(weight, height);
		setName(name);
		setBreed(breed);
		setDOB(DOB);	
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
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}


	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}


	/**
	 * @return the dOB
	 */
	public Date getDOB() {
		return DOB;
	}


	/**
	 * @param dOB the DOB to set
	 */
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}


	@Override
	public String toString() {
		return "I am a " + this.getClass().getName().toLowerCase()   + ". My name is " + name + ", my breed is "+ breed + 
				", and I was born in " + DOB +". I am " + getHeight() + "\" tall and weight " + getWeight() + "lbs.";
	}
	
}
