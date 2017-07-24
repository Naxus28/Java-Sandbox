
public class HockeyPlayer extends Athlete {
	private String stickBrand;
	
	public HockeyPlayer(String firstName, String lastName, int age, String stickBrand) {
		super(firstName, lastName, age);
		setStickBrand(stickBrand);
	}

	public String getStickBrand() {
		return stickBrand;
	}

	public void setStickBrand(String stickBrand) {
		this.stickBrand = stickBrand;
	}
	
	// overload parent method
	public void doThis(String action) {
		System.out.println(action);
	}

	@Override
	public String toString() {
		return "HockeyPlayer [ getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", stickBrand=" + stickBrand + "]";
	}	

}
