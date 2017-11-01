
public class CustomerRecordMissingException extends Exception {
	
	/**
	 * This is suggested by the compiler--not sure why the ID is necessary
	 */
	private static final long serialVersionUID = 1L;

	public CustomerRecordMissingException(String message) {
		super(message); // the super class has a message property, as well as a getter and a setter for the message
	}
	
}
