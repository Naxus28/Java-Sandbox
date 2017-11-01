
public class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "FirstName=" + firstName + ", LastName=" + lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Person)) {
			return false;
		}
		
		if (this.firstName != ((Person)obj).firstName || this.lastName != ((Person)obj).lastName) {
			return false;
		}
		
		return true;
	}
}
