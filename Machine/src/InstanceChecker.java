public class InstanceChecker 
{

	public static void main(String[] args) 
	{
		Machine [] machs = new Machine[4];
		machs[0] = new Lamp();
		machs[1] = new Toaster2();
		machs[2] = new Toaster2();
		machs[3] = new Lamp();
		
		for(int i=0; i < machs.length; i++) 
		{
			System.out.print("Element " + i + " is a ");
			
			if(machs[i] instanceof Lamp) 
			{
				System.out.println("Lamp Object");
			}
			else if(machs[i] instanceof Toaster2) 
			{
				System.out.println("Toaster2 Object");
			}
		} 

	}

}
