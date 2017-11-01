//package user.input;
import java.util.Scanner;

/**
 * @author gferraz
 *
 */
public class UserInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String userName = getName("Enter your name: ");
		System.out.println("User's name is: " + userName);
		System.out.println("User's name is: " + userName);
	}
	
	static private String getName(String inputDirections) {
		System.out.println(inputDirections);
		Scanner sc = new Scanner(System.in);
	  
		return sc.nextLine();
	}

}
