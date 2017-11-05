import java.util.*;

public class ListDemo {
	
	public static void main(String[] args) {		
		
		String[] things = {"eggs", "pie", "lasers", "hats"};
		List<String> listOne = new ArrayList<>();
		
		
		String[] moreThings = { "lasers", "hats"};
		List<String> listTwo = new ArrayList<>();
		
		
		// create list with array
		List<String> listThree = Arrays.asList(things);
		System.out.println("Arrays.asList: " + listThree);
		
		// sort list -- this method is a mutator
		Collections.sort(listThree);
		System.out.println("sorted listThree: " + listThree);
		
		// sort list in reverse order 
		Collections.sort(listThree, Collections.reverseOrder());
		System.out.println("listThree in reverse order: " + listThree);
		
		// can use the reverse static method in Collections as well
		Collections.reverse(listThree);
		System.out.println("re-reversed listThree: " + listThree);
		
		// copy list into another list
		// it actually replaces items of destination list
		List<String> listFour = new ArrayList<>(Arrays.asList("chocolate", "milk"));
		Collections.copy(listThree, listFour);
		System.out.println("Copied listFour into listThree: " + listThree); // replaces two first indexes of listThree for elements of listFour
		
		
		// collections fill
		Collections.fill(listFour, "Replaced");
		System.out.println("Replaced list four: " + listFour);	
		
		for(String item : things) {
			listOne.add(item);
		}
		
		for(String item : moreThings) {
			listTwo.add(item);
		}
		
		System.out.println("\nList one: " + listOne);

		System.out.println("\nList two: " + listTwo);

		// list.addALl
		listOne.addAll(listTwo);
		System.out.println("\nAdds list two to list one: " + listOne);
		
		editList(listOne, listTwo);
		
		System.out.println("\nEdited list one: " + listOne);
		
		// convert list to array
		String[] simpleArray = listTwo.toArray(new String[listOne.size()]);
		System.out.println("\nConvert list to array: " + Arrays.asList(simpleArray));
		
		// frequency--how many instances of the tested object exist in the list
		listOne.add("chocolate");
		int f = Collections.frequency(listOne, "chocolate");
		System.out.println("\nFrequency of 'chocolate' in listTwo: " + f);
		
		// disjoint--compares two collections: returns true if they don't  anything in common and false if they do
		Boolean haveCommon = Collections.disjoint(listOne, listTwo);
		System.out.println("\nlistOne disjoint listTwo: " + haveCommon);
		
		List<String> listFive = new ArrayList<>(Arrays.asList("ball", "court", "chocolate"));
		
		Boolean haveCommonTwo = Collections.disjoint(listOne, listFive);
		System.out.println("\nlistOne disjoint listFive: " + haveCommonTwo);
	}

	// could use List<String> listOne, List<String> listTwo as arguments
	// but when dealing with polymorphic classes we should always choose the parent class
	private static void editList(Collection<String> listOne, Collection<String> listTwo) {
		Iterator<String> listOneIt = listOne.iterator();
		
		while(listOneIt.hasNext()) {
			if (listTwo.contains(listOneIt.next())) {
				listOneIt.remove();
			}
		}			
	}

}
