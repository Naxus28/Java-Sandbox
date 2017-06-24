
public class LampWithBulb3 {
	ColoredLightBulb bulb;
	
	/**
	 * The design with two constructors (one that takes an argument and the other that doesn't)
	 * allows us to instantiate LampWithBulb3 without having to pass an argument to the constructor(like we did in LampWithBulb2)
	 * because the LightBulb class is initialized inside LampWithBulb3. 
	 * This makes sense since a Lamp always needs some sort of light bulb to be called a lamp.
	 */
	
	// constructor with argument
	public LampWithBulb3(ColoredLightBulb bulb)
	{
		this.bulb = bulb;
	}
	
	// constructor without argument
	public LampWithBulb3()
	{
		bulb = new ColoredLightBulb();
	}
	
	
	public void turnOn()
	{
		if(bulb == null)
		{
			System.out.println("There is no lightbulb");
		}
		else if(bulb.isLit())
		{
			System.out.println("The lamp is already on.");
		} 
		else
		{
			bulb.setLit(true);
			System.out.println("The lamp is on.");
		}		
	}
	
	public void turnOff()
	{
		if(bulb == null)
		{
			System.out.println("There is no lightbulb");
		}
		else if(bulb.isLit())
		{
			bulb.setLit(false);
			System.out.println("The lamp is off.");
		} 
		else
		{
			System.out.println("The lamp is already off.");
		}		
	}	
	
}
