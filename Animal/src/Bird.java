
public class Bird extends Animal {
	
	private int wingSpan; 
	private boolean canFly;
	private String family;

	public Bird(int weight, int height, int wingSpan, boolean canFly, String family) {
		super(weight, height);
		setWingSpan(wingSpan);
		setCanFly(canFly);
		setFamily(family);
	}

	
	/**
	 * @return the wingSpan
	 */
	public int getWingSpan() {
		return wingSpan;
	}

	/**
	 * @param wingSpan the wingSpan to set
	 */
	public void setWingSpan(int wingSpan) {
		this.wingSpan = wingSpan;
	}

	/**
	 * @return the canFly
	 */
	public boolean canFly() {
		return canFly;
	}

	/**
	 * @param canFly the canFly to set
	 */
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}


	/**
	 * @param family the family to set
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	
	@Override
	public String toString() {
		String canFly = this.canFly ? "I can fly." : "Although I am a bird I cannot fly.";
		return super.toString() + ". I belong to the " + family + " family." 
									+ " My wing spans " + wingSpan + " feet. " + canFly;
	}

}
