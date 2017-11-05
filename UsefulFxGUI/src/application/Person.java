package application;

public class Person implements Comparable<Person>{
	String name;
	String email; 
	String phone;
	
	public Person() {}
	
	public Person(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return String.format("Person => name: %s, email: %s, phone#: %s",  name, email, phone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Person)) {
			return false;
		}
		
		boolean isSame = ((Person)obj).name == this.name &&
						((Person)obj).email == this.email &&
						((Person)obj).phone == this.phone;
				
		return isSame;
	}

	@Override
	public int compareTo(Person o) {
		// sort people by name
		return this.getName().compareTo(o.getName());
	}
	
}
