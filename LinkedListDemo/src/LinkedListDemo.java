/**
 * these are different ways to add values to a List
 */

import java.util.*;

public class LinkedListDemo {

	public static void main(String[] args) {
		// initialize the list using the Arrays.asList method in the list arguments
		List<String> linkedList = new LinkedList<>(Arrays.asList("banana", "tomato", "eggs", "apples"));
		printList(linkedList);
		
		
		// similar to above
		String[] countries = {"Japan", "Brazil", "Colombia"};
		List<String> linkedListTwo = new LinkedList<>(Arrays.asList(countries));
		linkedListTwo.add("USA");
		printList(linkedListTwo);
		
		
		// use the collections parent interface to add all elements at once to the linked list
		List<String> linkedListThree = new LinkedList<>();
		Collections.addAll(linkedListThree, "Gabriel", "Paul", "Gilbert", "Mark");
		printList(linkedListThree);
		
		
		// using loop
		String[] cities = {"NY", "Tokio", "Rio"};
		List<String> linkedListFour = new LinkedList<>();
		
		for(String city : cities) {
			linkedListFour.add(city);
		}
		
		printList(linkedListFour);
		
		
		// add a list to another list
		List<String> linkedListFive = new LinkedList<>(Arrays.asList("house", "apartment", "office"));
		linkedListFive.addAll(linkedListFour);
		printList(linkedListFive);
		
		// removes elements on from first list if they exist in the second
		removeElementsFromList(linkedListFive, linkedListFour);
		printList(linkedListFive);
		
		// sublist
		List<String> shortListFive = sublist(linkedListFive, 1, 3);
		printList(shortListFive);
		
		
		// remove from list
		removeFromList(linkedListFive, 1, 3);
		printList(linkedListFive);
		
		
		// reverse list and store in new list
		List<String> reversedList = new LinkedList<>();
		reverseList(linkedListFour, reversedList);
		printList(reversedList);
		
	}
	
	// returns a sublist
	private static List<String> sublist(List<String> linkedList, int start, int end) {
		return linkedList.subList(start, end);
	}
	
	// removes from list
	private static void removeFromList(List<String> linkedList, int start, int end) {
		linkedList.subList(start, end).clear();
	}
	
	// reverse list using iterator and store values in new list
	private static void reverseList(List<String> list, List<String> reverserList) {
		// ListIterator is used to traverse sub-type list only while Iterator can traverse other types
		ListIterator<String> originalList = list.listIterator(list.size());
		
		while(originalList.hasPrevious()) {
			reverserList.add(originalList.previous());
		}
	}
	
	// remove elements from list if present in another list
	public static void removeElementsFromList(Collection<String> list, Collection<String> otherList) {
		Iterator<String> listIterator = list.iterator();
		
		while(listIterator.hasNext()) {
			if (otherList.contains(listIterator.next())) {
				listIterator.remove();
			}
		}
	}

	// print helper
	public static void printList(Collection<String> list) {
		System.out.println("\n" + Arrays.toString(list.toArray()));
	}
	

	
}
