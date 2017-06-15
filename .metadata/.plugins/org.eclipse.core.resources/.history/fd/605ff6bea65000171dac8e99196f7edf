/**
 * 
 */

/**
 * @author gabrielferraz
 *
 */
public class NestedLoop {

	public static void main(String[] args) {
		
		test:
		for(int i = 0; i < 3; i++) 
		{
			int j = 0;
			System.out.println("Outer loop: " + i);
			
			while(true)
			{
				System.out.println("Inner loop: " + j);
				
				if(j++ > 2) // j increments AFTER the expression is tested
				{
					break test;
				}
			}
			
		}
		
		System.out.println("Outside both loops");

	}

}
