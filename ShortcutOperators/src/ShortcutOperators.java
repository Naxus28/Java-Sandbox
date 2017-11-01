
public class ShortcutOperators {
	public static void main(String[] args) {
		// compound assignment operator -- takes less precedence than other operators
		int x = 10, y = 20, w;
		double a = 1.2, b = 3.5, c;
		
		x += y;
		System.out.println(x); // 30
		
		x /= y;
		System.out.println(x); // 1 (30/20) not 1.5 because it is an int, not a double or float
		
		x *= y; 
		System.out.println(x); // 20 (1 * 20) 
		
		x -= y; 
		System.out.println(x); // 0  (20 - 20)
		
		x+=10; // 10  (10 + 0)  back to initial value
		
		a *= x + y;
		System.out.println(a); // 36.0  ( (10 + 20) * 1.2 )
		
		// c+=a; doesn't compile because c was not initialized
		
		// Increment
		w = x++; // post increment -- increment after all other operations are finished: assign x to w then increment x => w will get the value of x before incrementing but x will be incremented
		System.out.println(w + " | " + x ); // 30 | 31
		
		w = ++x; // pre increment -- increment before any other operation is performed: increment x then assign to w
		System.out.println(w + " | " + x ); // 32 | 32
		
		// Decrement
		w = y--; // post decrement -- decrement y after all other operations are completed
		System.out.println(w + " | " + x ); // 19 |20
		
		w = --y; // pre decrement -- decrement y before all other operations are completed
		System.out.println(w + " | " + x ); // 18 | 18
		
		// misc
		final double TAX_RATE = 0.07; // can't be changed -- value assigned to a final is constant
		// TAX_RATE = 0.075; does not compile
		
		final int score; // we can assign a final at runtime though
		score = 30;
	}
}
