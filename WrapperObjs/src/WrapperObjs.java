
/**
 * 
 * @author gabrielferraz
 *
 * Wrapper classes can be used for primitive types. 
 * These classes “wrap” primitive types into objects. 
 * The process of converting primitives into objects is called “boxing”. 
 * When the value the object holds is used "as a primitive type" the primitive is unboxed.
 * Wrapper classes provide several useful methods that can be helpful when working with primitives. 
 *
 */
public class WrapperObjs {

	public static void main(String[] args) {
		
		Integer i = 5; // this is autoboxing: https://stackoverflow.com/questions/4890802/how-does-the-java-boolean-wrapper-class-get-instantiated
		Integer i2 = new Integer(5); // this is boxed via constructor call
		
		System.out.println(i.intValue());
		System.out.println(i2.intValue());
		
		// objects are unboxed
		int sum = i + i2; 
		System.out.println(sum);
		
		
	}

}
