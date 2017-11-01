
public class OverridingStaticMethod {
	static String name = getName(); // since this subclass also has "getName()" this is the method invoked here
	static String parentName = Overriding.getName(); // invokes superclass' "getName()" directly (cannot use "super" for static methods)
	
	// overrides parent class' static "getName" method
	public static String getName() {
		return "Gabriel in subclass";
	}

	public static void main(String[] args) {
		System.out.println(name); // Gabriel in subclass
		System.out.println(parentName); // Gabriel in parent class
	}

}
