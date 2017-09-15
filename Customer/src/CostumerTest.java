
public class CostumerTest {

	public static void main(String[] args) {
		Costumer john = new Costumer("John", "Doe", 1, "jdoe@mail.com"); 
		Costumer mark = new Costumer("Mark", "Smith", 2, "msmith@mail.com"); 
		Costumer anitta = new Costumer("Anitta", "Salinger", 3, "asal@mail.com");
		Costumer maria = new Costumer("Maria", "Bulova", 4, "mbulov@mail.com");
		
		Costumer [] costumers = {john, mark, anitta, maria};
		
		for(Costumer costumer : costumers) {
			printCostumer(costumer);
		}
		
		System.out.println("\n");
		
		// mutators and accessors
		john.setLastName("Doerman");
		System.out.println(john.getLastName());
		
		maria.setEmailAddress("mariabulova@mail.com");
		System.out.println(maria.getEmailAddress());
		
		System.out.println("\n");
		
		// compare costumer numbers
		printCostumersComparing(mark, maria);
		printCostumersComparing(anitta, john);
		
		System.out.println("\n");
	}
	
	
	// helper
	public static void printCostumer(Costumer costumer) {
		System.out.println(costumer);
	}
	
	// assumes costumer number reflects chronological order that individuals became costumers (of a particular store)
	public static void printCostumersComparing(Costumer costumerOne, Costumer costumerTwo) {
		int result = costumerOne.compareTo(costumerTwo);
		
		if(result == 1) {
			System.out.println(costumerOne.getFirstName() + " became a customer before " + costumerTwo.getFirstName());
		} else {
			System.out.println(costumerTwo.getFirstName() + " became a customer before " + costumerOne.getFirstName());
		}
	}

}
