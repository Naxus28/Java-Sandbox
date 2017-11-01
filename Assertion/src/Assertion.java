/**
 * 
 * @author gabrielferraz
 *
 
 	Demonstrate using the assert keyword.  Create a private method that takes an int parameter.  

	If the value passed in is negative, the method will assert something that is false, causing the method to throw an AssertionError.  

	Pass the value that was passed into the method to the constructor of the AssertionError class.  

	All of this is done with a single assert statement.

	Why did I ask you to make this method private?  It works the same with public methods.  Put a comment in the code if you can find an answer that question.  
	(It isn’t something you can figure out, you will need to read about the convention and the reason for having that convention.)

 */


public class Assertion {
	
	public static void main(String[] args) {
		
		// passes 
		String pass = assertionTest(1);
		System.out.println(pass);
		
		// fails
		String fail = assertionTest(-1);
		System.out.println(fail);
	}
	
	
	
	private static String assertionTest(int someNumber) {
		assert someNumber >= 0 : "Number passed to assertionTest must be >= 0. You passed: " + someNumber;
		
		return "You passed an accepted value: " + someNumber;
	}
	
	/**
	 * According to the Java docs, public methods must always check the arguments passed to it. 
	 * "It must check its arguments whether or not assertions are enabled." (http://docs.oracle.com/javase/7/docs/technotes/guides/language/assert.html)
	 * I believe this means the developer needs to explicitly check for arguments. In case there is an invalid argument the developer needs to throw an exception of the correct type.
	 * Private methods on the other hand can use assertions on arguments to verify internal implementation since private methods are not available publicly.
	 * If the code asserts a "false" value, an Error will be thrown and the developer will know there is a bug in the method implementation.
	 */
	
}
