
public class RectangleFromSimpleGeometricObject extends SimpleGeometricObject{
	private double width;
	private double height;

	public RectangleFromSimpleGeometricObject(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public RectangleFromSimpleGeometricObject(double width, double height, String color, boolean filled) {
		super(color, filled);
		
		/*
		 * or use setters to set color and filled
		 */
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}	
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
	@Override
	public String toString() {
		return "RectangleFromSimpleGeometricObject: \n" + super.toString() + "\nwidth=" + width + ", height=" + height;
	}

}
