
public class Casting {

	public static void main(String[] args) {
		Machine [] machs = new Machine[4];
		machs[0] = new Lamp();
		machs[1] = new Toaster2();
		machs[2] = new Lamp();
		machs[3] = new Toaster2();

		for(int i=0; i < machs.length; i++) 
		{
			machs[i].turnOn(); // any machine can turn on
			
			//machs[i].heatUp(); // heatUp() is not defined in the Machine object so this code doesn' compile
								 // we need to cast the obj whose reference type is "Machine" to whatever runtime type of that object 
								 // in order to access the runtime methods
			
			if(machs[i] instanceof Toaster2) 
			{
				// after down casting the machine super class to a toaster2 subclass we can access the toaster2's methods
				Toaster2 t = (Toaster2)machs[i];
				t.heatUp();
				t.coolDown();
			}
			
			machs[i].turnOff(); //any machine can be turned off
			
			System.out.println("======================");
		} 


	}

}
