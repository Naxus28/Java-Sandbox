import java.util.*;
import java.util.Map.Entry;


public class HashMapDemo {

	public static void main(String[] args) {
		// hash map is a subclass of Map
		// it is basically an associative array
		
		Map<String, String> map = new HashMap<>();
		
		map.put("Name", "Gabriel");
		map.put("Nationality", "Brazilian");
		map.put("wife", "Micheline");
		
		System.out.println("map: " + map); //map: {Nationality=Brazilian, Name=Gabriel}
		printMap(map);
	}

	// can use Entry to iterate
	public static void printMap(Map<String, String> m) {
		for (Entry<String, String> entry : m.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	
	}

}
