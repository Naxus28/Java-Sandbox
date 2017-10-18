import java.util.Arrays;

public class InvalidGradeException extends Exception {
	private static final long serialVersionUID = 1L;
	private int[] numbers;
	
	public InvalidGradeException(){}
	
	public InvalidGradeException(int[] numbers){
		super("Array has invalid integer(s). Integer range: 0 < integer < 100." + Arrays.asList(numbers).toString()); // use super's message property to set and get message
		this.numbers = numbers;
	}

	/**
	 * @return the numbers
	 */
	public int[] getNumbers() {
		return numbers;
	}
	
	public void getError() {
		int[] numbers = this.numbers;
		StringBuilder error = new StringBuilder("InvalidGradeException: ");
		boolean hasErrors = false;
		
		for (int i=0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > 100) {
				hasErrors = true;
				error.append("invalid number " + numbers[i] + " at index " + i + "; ");
			}
			
			// replace ";" for "." if it is the last word on "error"
			if (i == numbers.length - 1) {
				int lastIndexOFSeparator = error.lastIndexOf(";");
				error.replace(lastIndexOFSeparator, lastIndexOFSeparator + 1,".");
			}
		}
		
		// check if exception was thrown correctly
		// testing for either "invalidNumbers" or "invalidIndexes" suffices
		if (!hasErrors) {
			error.append("No exception needs to be thrown. Please make sure you are throwing the exception for the right reason.");
		}
		
		System.out.println(error);
	}

}
