import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		System.out.println("You will be asked to input 2 numbers and this program will output the quotient.");
		try {
			 String firstNumber = getNumber("Enter the first number: ");
             String secondNumber = getNumber("Enter the second number: ");
             double quotient = divideNumbers(firstNumber, secondNumber);
             System.out.println("The quotient of " + firstNumber + "/" + secondNumber + " is " + quotient);
		} catch (NumberFormatException e) {
            System.out.println("ERROR: number formatting exception: " + e.getMessage() + ". Please enter numbers only.");
        }
	}
	
	static private String getNumber(String inputDirections) {
		System.out.println(inputDirections);
		Scanner sc = new Scanner(System.in);
	  
		return sc.nextLine();
	}
	
	static private double divideNumbers(String firstNumber, String secondNumber) {
		double quotient = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
		
		return quotient;
		
	}

}
