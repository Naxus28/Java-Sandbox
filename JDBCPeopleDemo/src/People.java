/**
 * this class holds state for People objs
 * 
 * @author gferraz
 *
 */
public class People {
	private String firstName;
	private String lastName;
	private int age;
	private long ssn;
	private long creditCard;

	public People() {
	}

	public People(String firstName, String lastName, int age, long ssn, long creditCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ssn = ssn;
		this.creditCard = creditCard;
	}

	/*** GETTERS AND SETTERS ***/

	// first name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// last name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// ssn
	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	// credit card
	public long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(long creditCard) {
		this.creditCard = creditCard;
	}

}
