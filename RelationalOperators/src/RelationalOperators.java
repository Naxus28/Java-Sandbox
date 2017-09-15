
public class RelationalOperators {
	public static void main(String[] args) {
		int a = 10, b = 6, c;
		
		//	if else
		if (a > b) {
			System.out.println("a > b");
		} else {
			System.out.println("a < b");
		} 
		
		// switch
		switch(a % 2) {
			case 0:
				System.out.println("it is a 0");
				break;
			case 1:
				System.out.println("it is a 1");
				break;
			default:
				System.out.println("it is neither 1 or 2");
				break;
		}
		
		// ternary operator
		c = a > b ? a-b :  b-a; 
		System.out.println("c: " + c +"\n");
		
		// while loop
		while(a > b) {
			System.out.println("a: "+ a + " | b: " + b);
			b++;
		}
		
		// do while loop
		do {
			System.out.println("b: " + b);
			b++;
		} while (b < 30);
		
		
		// for loop
		for(int i = 0; i < 10; i++) {
			System.out.println("i: " + i);
		}
		
		// for loop -- break statement
		for(int i = 0; i < 10; i++) {
			System.out.println("break i: " + i);
			if (i > 4) {
				break;
			}
		}
		
		// for loop -- continue statement
		for(int i = 0; i < 10; i++) {
			if (i == 4) {
				continue;
			}
			System.out.println("continue i: " + i);
		}
		
		// enhanced for loop
		int [] numArray = {1, 2, 3, 4, 5};
		for(int num : numArray) {
			System.out.println("num: " + num);
		}
	}
}
