import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author gabrielferraz
 * this class has only a main method 
 * the code reads text from a file into the BufferedReader
 * and breaks each line into an array of words
 * the program then counts the total number of words in each array and prints out the result
 */
public class ReadFile {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader("assignment.txt"));
			int counter = 0;

			while(bufferedReader.ready()){
				String nextLine = bufferedReader.readLine().trim();
				

				if (!nextLine.isEmpty() && nextLine != null) {
					String [] words = nextLine.split(" ");
					
					// trims empty indexes
					for (String word : words) {
						if(word != null && !word.isEmpty()) {
							counter++;
						}
					}
					
				}	
			}
			
			System.out.println(counter);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	