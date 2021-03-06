
public class Golfer extends Athlete {
	private String mainSponsor;
	
	public Golfer(String firstName, String lastName, int age, String mainSponsor) {
		super(firstName, lastName, age);
		setMainSponsor(mainSponsor);
	}
	
	public String getMainSponsor() {
		return mainSponsor;
	}

	public void setMainSponsor(String mainSponsor) {
		this.mainSponsor = mainSponsor;
	}
	
	// overload parent method
	public void doThis(String action) {
		System.out.println(action);
	}
	
	@Override
	public String toString() {
		return "Golfer [getFullName()=" + getFullName() + ", getAge()=" + getAge() + ", mainSponsor=" + mainSponsor + "]";
	}

}
