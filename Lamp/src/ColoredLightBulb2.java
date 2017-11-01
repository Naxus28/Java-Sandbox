
public class ColoredLightBulb2 {
	private boolean lit;
	private String color;
	
	// constructor chaining
	public ColoredLightBulb2()
	{
		// sets the color to white by default by automatically invoking the constructor below (we can't instantiate that constructor here)
		// notice that the constructor below takes a parameter color and sets the instance variable "color"--this is required
		// for chaining constructors
		this("white"); 
	}
	
	// since it is invoded by the constructor above, this constructor now will always execute
	// whether or not we instantiate this class with an argument
	public ColoredLightBulb2(String color)
	{
		this.color = color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public void setLit(boolean param) 
	{
		if(lit && param)
		{
			System.out.println("The bulb is already lit.");
		}
		else if(!lit && !param)
		{
			System.out.println("The bulb is already unlit.");
		}
		else {
			lit = param;
			String str = lit ? "lit." : "unlit.";
			System.out.println("The bulb is " + str + " and the bulb is " + color + ".");
		}
	}
	
	public boolean isLit()
	{
		return lit;
	}
}
