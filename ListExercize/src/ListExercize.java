import java.util.*;

public class ListExercize {

	public static void main(String[] args) {
		// initialize the list with values
		List<String> list = new ArrayList<>(Arrays.asList("Bob", "Susan", "Jerome", "Peter", "Mark"));
		
		// add more values
		list.add("Paul");
		list.add("Xavier");
		list.add("Abel");
		
		printList(list);
		searchEntry("Susan", list); // call this method before list order is changed
		searchEntry("Joe Schmoe", list); // call this method before list order is changed
		sortList(list);
		shuffleList(list);
		listToArray(list);
	}
	
	private static void listToArray(List<String> list) {
		String[] simpleArray = list.toArray(new String[list.size()]);
		System.out.println("simpleArray: " + Arrays.asList(simpleArray));
		arrayToList(simpleArray);
	}

	private static void arrayToList(String[] simpleArray) {
		List<String> list = Arrays.asList(simpleArray);
		System.out.println("list: " + list);
	}

	private static void searchEntry(String string, List<String> list) {
		System.out.println("Object index: " + list.indexOf(string));
	}


	private static void printList(List<String> list) {
		for(String name : list) {
			System.out.println("Name: " + name);
		}
	}
	
	private static void sortList(List<String> list) {
		Collections.sort(list);
		System.out.println("Sorted list: " + list);
		
	}
	
	private static void shuffleList(List<String> list) {
		Collections.shuffle(list);
		System.out.println("Shuffled list: " + list);
	}
	
}
