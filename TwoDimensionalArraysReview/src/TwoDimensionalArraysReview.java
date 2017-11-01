import java.util.Arrays;

public class TwoDimensionalArraysReview {
	public static void main(String[] args) {
		int[][] table1 = {
		  {13, 12, 53, 19}, 
		  {1, 9, 6, 25, 18, 17}, 
		  {7, 28, 4}  
		}; 

		int[][] table2 = { 
		  {13, 13, -85},
		  {11, 19}, 
		  {31, -89, 47, 26, +895}  
		}; 
		
		int[][] table3 = { 
			{11, 12, -84},
			{1, 192, 20}, 
			{1, 2, 3,-2, +345}  
		}; 
		
		
		int[][][] tables = {table1, table2, table3};
		int odds;
		int tableNumber;

		odds = countOdds(table1);
		tableNumber = getTableNumber(tables, table1); 
		printHelper(odds, tableNumber);
		
		odds = countOdds(table2);
		tableNumber = getTableNumber(tables, table2); 
		printHelper(odds, tableNumber);

		odds = countOdds(table3);
		tableNumber = getTableNumber(tables, table3); 
		printHelper(odds, tableNumber);
	
	}
	
	public static int countOdds(int[][] table) {
		int counter = 0;
		
		for(int[] innerArray : table ) {
			for(int num : innerArray ) {
				if (num % 2 != 0) {
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	
	/*
	 * Helpers
	 */
	public static void printHelper(int odds, int tableNumber) {
		System.out.println("There are " + odds  + " odd numbers in table " + tableNumber);
	}
	
	public static int getTableNumber(int[][][] tables, int[][] table) {
		return Arrays.asList(tables).indexOf(table) + 1; 
	}
}
