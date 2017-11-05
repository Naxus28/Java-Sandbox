import java.util.*;

public class HashSetDemo {

	public static void main(String[] args) {
		// a hash is a collection that cannot have duplicates
		// it has similar methods to other collections (add, remove, clear, etc)
		
		Set<String> hash = new HashSet<>(Arrays.asList("Apples", "Bananas", "Bananas", "Oranges"));
		System.out.println("hash: " + hash); //hash: [Apples, Bananas, Oranges]
		
		// we can use a hash set to clean up a list for us as well--perhaps not the best use of this interface, but possible
		
		List<String> list = new ArrayList<>(Arrays.asList("Google", "Facebook", "Twitter", "Google"));
		Set<String> hashOne = new HashSet<>(list);
		System.out.println("hashOne: " + hashOne); //hashOne: [Google, Twitter, Facebook]
		
		

	}

}
