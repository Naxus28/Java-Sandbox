
public class DataTypes {

	public static void main(String[] args) {
		byte b = -128; // 128 doesn't compile but 127 does 
		short s = 32700;
		int i = 1234567891;
		long al = 1234567891101010L; //1234567891101010 without the "L" doesn't compile because it doesn't fit into an 'int'
		
		float f = 12.5F; // needs the "F" to compile or needs to be casted to a float, otherwise it defaults to a double
		float fl = (float) 12.5; // "F" is preferred over (float)
		double d = 234.6;
		
		boolean bool = true;
		char c = 'A'; // can't use double quotes otherwise JAVA thinks it is a string
		
		//==================
		
		int x = 10, y = 6, result;
		double d1 = 4.5, d2 = 3.1, doubleResult;
		
		doubleResult = x;  // int allocated in "x" is promoted to a double and stored in "doubleResult"
		// result = d1; //doens't compile because a double can't be promoted to an int. Need to downcast the double to and int in this case
		result = (int) d1;
		doubleResult = d1 / d2;
		doubleResult = d1 / x; // x is promoted to a double
		
		result = x / y; // result will be integer 1 (no floating point)
		doubleResult = (double) x / y; // need o upcast the int to double to get floating points--x is casted to a double then y is promoted to a double
	}
}
