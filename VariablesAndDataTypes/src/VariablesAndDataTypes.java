
public class VariablesAndDataTypes {
	static int a;
	static int b;
	static int result; 
	
	public static void main(String[] args) {
		System.out.println("Hello Universe");
		int variable;
		// System.out.println(variable); // variable not initialized
		
		variable = 10;
		System.out.println(variable); // 10
		// double taxRate;
		// int ___56$;  compiles but does not follow convention

		a = 10;
		b = 6;
		
		result = a % b;
		System.out.println(result); // 4
		
		b = 0;
		// result = a % b;
		// System.out.println(result); // Exception in thread "main" java.lang.ArithmeticException: / by zero
		
		b = 3;
		result = a + b * 3;
		System.out.println(result); // 19
		
		result = (a + b) * 3;
		System.out.println("The result is " + result); // 39
		
	
	}
}
