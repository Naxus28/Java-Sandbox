import java.util.Scanner;

/**
 * 
 */

/**
 * @author gferraz
 *
 */
public class NumbersAverage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("You will be asked to input 5 numbers and we will calculate the average of these numbers.");
        try {
        	 String firstNumber = getNumber("Enter the first number: ");
             String secondNumber = getNumber("Enter the second number: ");
             String thirdNumber = getNumber("Enter the third number: ");
             String fourthNumber = getNumber("Enter the fourth number: ");
             String fifthNumber = getNumber("Enter the fifth number: ");
             
             double sum = addValues(firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber);
             
             double average = getAverage(sum, 5);
             
             System.out.println("The sum of your five numbers is " + sum + ", thus the average is " + average);
        } catch (NumberFormatException e) {
            System.out.println("number formatting exception: " + e.getMessage());
        }
	}
	
	static private String getNumber(String inputDirections) {
		System.out.println(inputDirections);
		Scanner sc = new Scanner(System.in);
	  
		return sc.nextLine();
	}
	
	// the ... mean that one or more values (or an array) may be passed to this method
	static private double addValues(String ... values) {
        double result = 0;

        for (String value : values) {
            result += Double.parseDouble(value);
        }

        return result;
    }
	
	static private double getAverage(double sum, int numbersCount) {
		double average = sum / numbersCount;

		return  average;
	}

}
