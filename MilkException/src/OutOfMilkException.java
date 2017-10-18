
public class OutOfMilkException extends Exception {
	private static final long serialVersionUID = 1L;
	private long timeTakenToDrinkMilk;
	
	public OutOfMilkException() {}
	
	public OutOfMilkException(long timeTakenToDrinkMilk) {
		this.timeTakenToDrinkMilk = timeTakenToDrinkMilk;
	}
	
	@Override
	public String toString() {
		return "All milk was drank. You are now out of milk! Time taken to drink milk: " + timeTakenToDrinkMilk + " ms";
	}
}
