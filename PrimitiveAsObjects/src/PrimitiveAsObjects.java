
public class PrimitiveAsObjects {

	public static void main(String[] args) {
		double d = new Double(12.5); // takes strings too: "12.5"
		double doub = new Double(12.5).intValue(); // 12
		// System.out.println(d.intValue()); the method can only be used directly from the constructor, not the object holding the value
	
	
		// compareTo method
		System.out.println(new Double(12.5).compareTo(new Double(12.5))); // 0
		System.out.println(new Integer(12).compareTo(new Integer(11))); // 1
		System.out.println(new Byte((byte) 4).compareTo(new Byte((byte) 5))); // -1
		
		// value of
		Double doubleObj = Double.valueOf("10.4"); // creates an obj
		System.out.println(doubleObj);
		System.out.println(doubleObj.intValue()); // now it is possible to get the int value
		
		System.out.println( new Double(23.24).toString() instanceof String); // true 
		
		
		// boxing, unboxing, auto-boxing, auto-unboxing
		// Integer intObj = new Integer(2); this can be simplified due to auto boxing
		Integer intObj1 = 2; // the compiler converts (box) this into an obj if the context requires it and vice-versa (unbox)
		
		// this is valid (autoboxing)
		Integer intObj2 = intObj1 + new Integer(3);
		
		// so is this (auto unboxing)
		Integer intObj3 = intObj1 + 3;
		
	}

}
