/**
 * @author gabrielferraz
 *
 */
public class Doubler {
	private int number;
	
	public static void main(String[] args) {
		Doubler doubler = new Doubler();
		doubler.setNumber(2);
		// because we return 'this'--an instance of the obj--we can chain the method (it is like doing Doubler.doubleIt() + Doubler.doubleIt() + Doubler.doubleIt())
		doubler.doubleIt().doubleIt().doubleIt(); 
		int result = doubler.getNumber();
		
		System.out.println("The result is: " + result);

	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	public int getNumber()
	{
		return number;
	}
	public Doubler doubleIt()
	{
		number*=2;
		return this;
	}

}
