/**
 * @author gabriel ferraz
 *
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Beer {
	/**
	 * constants
	 */
	final static double daysInYear = 365;
	final static double caloriesInBeerCan = 150;
	final static double beerToWeightGain = (double)15 / daysInYear;
	final static DecimalFormat df = new DecimalFormat("#.00"); // use this variable to format two decimal points for all doubles

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please input the information asked of you.");
		System.out.println("");
		
		try  {
			/**
			 * user input
			 */
			String cansOfBeerADay = getNumberInput("On average, how many 12-ounce beers will you consume each day?");
			String averageMoneySpentPerCan = getNumberInput("On average, how much will you pay for each can of beer?");
			
			/**
			 * perform calculations to solve problem
			 */
			String beerCansAYear = getTotalBeerCansAYear(cansOfBeerADay);
			String weightGainedAYear = getWeightGainedAYear(beerCansAYear);
			String caloriesConsumedAYear = getCaloriesConsumedAYear(beerCansAYear);
			String moneySpentAYear = getMoneySpentAYear(averageMoneySpentPerCan, beerCansAYear);
			
			/**
			 * print out answers
			 */
			System.out.println("");
			System.out.println("That is approximately " + beerCansAYear + " beers in one year.");
			System.out.println("In one year, you will consume approximately " + caloriesConsumedAYear + " calories from beer alone.");		
			System.out.println("Without diet or exercise to counter these calories, calories from beer alone can expect to gain " + weightGainedAYear + " pounds from drinking that much beer this year.");
			System.out.println("In one year you will spend $" + moneySpentAYear + " on beer alone.");
		} catch (NumberFormatException e) {
            System.out.println("number formatting exception: " + e.getMessage());
        } 
	}
	
	/**	
	 * 
	 * @param inputDirections
	 * @return
	 */
	static private String getNumberInput(String inputDirections) {
		System.out.println(inputDirections);
		Scanner sc = new Scanner(System.in);
	  
		return sc.nextLine();
	}
	
	static private String getTotalBeerCansAYear(String beerCansADay) {
		double beerCansAYear = Double.parseDouble(beerCansADay) * daysInYear;
		
		return df.format(beerCansAYear);
	}
	
	/**
	 * 
	 * @param beerCansAYear
	 */
	static private String getWeightGainedAYear(String beerCansAYear) {
		double weightGained = Double.parseDouble(beerCansAYear) * beerToWeightGain;
		
		return df.format(weightGained);
	}
	
	/**	
	 * 
	 * @param beerCansAYear
	 */
	static private String getCaloriesConsumedAYear(String beerCansAYear) {
		double totalCalories = caloriesInBeerCan * Double.parseDouble(beerCansAYear);
		
		return df.format(totalCalories);
	}
	
	/**	
	 * 
	 * @param averageMoneySpentPerCan
	 * @param beerCansAYear
	 */
	static private String getMoneySpentAYear(String averageMoneySpentPerCan, String beerCansAYear) {
		double totalMoneySpent = Double.parseDouble(averageMoneySpentPerCan) * Double.parseDouble(beerCansAYear);
		
		return df.format(totalMoneySpent);
	}
}
