package application;

/**
 * this class holds state for People objects
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
	private String ssnHash;
	private String creditCardHash;

	/**
	 * default constructor
	 */
	public People() {
	}

	/**
	 * overloaded constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param ssn
	 * @param creditCard
	 */
	public People(String firstName, String lastName, int age, long ssn, long creditCard) {
		this(firstName, lastName, age, "", "");
		this.ssn = ssn;
		this.creditCard = creditCard;
	}

	/**
	 * overloaded constructor that takes hashed values for ssn and cc
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param ssnHash
	 * @param creditCardHash
	 */
	public People(String firstName, String lastName, int age, String ssnHash, String creditCardHash) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ssnHash = ssnHash;
		this.creditCardHash = creditCardHash;
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

	// hashed ssn
	public String getSsnHash() {
		return ssnHash;
	}

	public void setSsnHash(String ssnHash) {
		this.ssnHash = ssnHash;
	}

	// hashed crdit card
	public String getCreditCardHash() {
		return creditCardHash;
	}

	public void setCreditCardHash(String creditCardHash) {
		this.creditCardHash = creditCardHash;
	}

	@Override
	public String toString() {
		return String.format("DB entry: %-10s %-10s *age*: %-5d *ssn*: %20s *credit card*: %20s", getFirstName(),
				getLastName(), getAge(), getSsnHash(), getCreditCardHash());
	}

}
