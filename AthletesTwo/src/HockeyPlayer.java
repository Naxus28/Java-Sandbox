
public class HockeyPlayer extends Athlete implements Helmet {
	private String stickBrand;
	
	public HockeyPlayer(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}

	public String getStickBrand() {
		return stickBrand;
	}

	public void setStickBrand(String stickBrand) {
		this.stickBrand = stickBrand;
	}
	
	//overload--polymorphic method
	public void doThis(String action) {
		System.out.println(action);
	}
	
	@Override
	public Boolean wearsHelmet() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof HockeyPlayer)) {
			return false;
		}
		
		// call parent class to check that it is the same person and the person is an athlete and
		// make sure stickBrand is the same
		if (!super.equals(obj) || this.stickBrand != ((HockeyPlayer) obj).stickBrand) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "HockeyPlayer [ getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", stickBrand=" + stickBrand + "wearsHelmet()=" + wearsHelmet() + "]";
	}	

}
