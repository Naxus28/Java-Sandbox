
public class OverridingSubclass extends Overriding {
	public OverridingSubclass() {
		
	}
	
	public static void main(String[] args) {
		// subclass inherits parent's static methods as well as instance methods
		String name = getName();
		System.out.println(name); 
	}
}
