
public abstract class Building {
	private int floors;
	private int windows;
	
	/**
	 * default constructor
	 */
	protected Building() {}
	
	protected Building(int floors) {
		this(floors, 0);
	}
	
	protected Building(int floors, int windows) {
		this.floors = floors;
		this.windows = windows;
	}
	
	/**
	 * abstract method
	 */
	public abstract int getArea();
	
	/**
	 * @return the floors
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * @param floors the floors to set
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * @return the windows
	 */
	public int getWindows() {
		return windows;
	}

	/**
	 * @param windows the windows to set
	 */
	public void setWindows(int windows) {
		this.windows = windows;
	}
	
	@Override
	public String toString() {		
		String floorText = floors > 1 ? "floors" : "floor";
		String windowText = windows > 1 ? "windows" : "window";
		
		return "This " + this.getClass().getName().toLowerCase() + " has " + floors + " " + floorText + " and " + windows + " " + windowText + ".";
	}
}
