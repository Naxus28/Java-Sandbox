
/**
 * 
 * @author gabrielferraz
 * This class is used to create telephone numbers with this specific format xxx xxx xxxx
 */
public class Telephone {
	
	private String telephone;
	
	public Telephone () {}
	
	public Telephone  (String telephone) throws InvalidTelephoneException {
		
		telephone = telephone.replaceAll("\\s+",""); // removes white space to accept this format xxx xxx xxxx
		
		if (!telephone.matches("[0-9]+") || telephone.length() != 10) {
			throw new InvalidTelephoneException("");
		}
	
		this.telephone = telephone;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * @return the area code
	 */
	public String getAreaCode() {
		return telephone.substring(0, 3);
	}
	
	/**
	 * @return the exchange number
	 */
	public String getExchange() {
		return telephone.substring(3, 6);
	}
	
	/**
	 * @return the local number
	 */
	public String getLocalNumber() {
		return telephone.substring(6, 10);
	}

	@Override
	public String toString() {
		return String.format("This is the phone number: (%s) %s-%s", getAreaCode(), getExchange(), getLocalNumber());
	}
	

}
