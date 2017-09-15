
public class AnimalTest {

	public static void main(String[] args) {
		// generic animal
		Animal pet = new Animal(23, 10);
		System.out.println(pet);
		
		// dog
		Date maxDOB = new Date(12, 31, 2009);
		Animal max = new Dog(23, 10, "Max", "labrador", maxDOB);
		System.out.println(max);
		
		// cat
		Animal fluffy = new Cat(12, 5, "Fluffy");
		System.out.println(fluffy);
		((Cat) fluffy).die().die().die().die().die();
		System.out.println(fluffy);
		((Cat) fluffy).die().die().die().die();
		System.out.println(fluffy);
		
		// bird
		Animal joe  = new Bird(3, 5, 4, true, "parrot");
		System.out.println(joe);
		
		Animal jimmy  = new Bird(4, 5, 4, false, "penguin");
		System.out.println(jimmy);
	}

}
