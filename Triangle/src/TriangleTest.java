
public class TriangleTest {
	
	public static void main(String[] args) {
		
		// passes
		try {
			Triangle t = new Triangle(2,2,3);
			System.out.println(t);
		} catch (InvalidTriangleException e) {
			e.printStackTrace();
		}
		
		// fails
		try {
			Triangle tOne = new Triangle(0,3,4);
			System.out.println(tOne);
		} catch (InvalidTriangleException e) {
			e.printStackTrace();
		}
	}


}
