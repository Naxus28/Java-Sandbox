
public class RectangleTest {
	
	public static void printResult(Rectangle rect, String text)
	{
		String textToPrint = text != null && !text.isEmpty() ? "==========" + text + "==========\n" : "====================\n";
		System.out.println();
		System.out.println(textToPrint);
		System.out.println(rect);
	}
	
	public static void main(String[] args) 
	{
		
		
		
		Rectangle parentRectangle = new Rectangle();
		System.out.println(parentRectangle);
		
		parentRectangle.setWidth(13);
		parentRectangle.setHeight(30);
		
		printResult(parentRectangle, "Re-setting parent rectangle's values");

		Rectangle rect1 = new Rectangle("Rect Child One", 10, 20);
		printResult(rect1, "");

	}

}
