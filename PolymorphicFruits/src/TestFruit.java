
public class TestFruit {

	public static void main(String[] args) {
		Fruit fruit = new GoldenDelicious();
		Orange orange = new Orange();
		
		System.out.println(fruit instanceof Fruit); // true
		System.out.println(fruit instanceof Orange); // true
		System.out.println(fruit instanceof Apple); // false
		System.out.println(fruit instanceof GoldenDelicious); // true
		System.out.println(fruit instanceof McIntosh); // false
		System.out.println(orange instanceof Orange); // true
	}

}
