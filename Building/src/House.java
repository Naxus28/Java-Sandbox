import java.text.DecimalFormat;

public class House extends Building implements MLSListable{
	private int bathrooms;
	private Room[] rooms;
	
	// format two decimal points for all doubles
	final static DecimalFormat df2 = new DecimalFormat("#.00"); 
	
	/**
	 * default constructor
	 */
	public House() {}
	
	public House(int bathrooms, Room[] rooms, int floors, int windows) {
		super(floors, windows);
		this.bathrooms = bathrooms;
		this.rooms = rooms;
	}
	
	/**
	 * @return the bathrooms
	 */
	public int getBathrooms() {
		return bathrooms;
	}

	/**
	 * @param bathrooms the bathrooms to set
	 */
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	/**
	 * @return the rooms
	 */
	public Room[] getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	@Override
	public int getArea() {
		int area = 0;
		
		for(Room room: rooms) {
			area+=room.getArea();
		}
		
		return area;
	}
	
	public String averageRoomArea() {
		return df2.format((double)getArea() / rooms.length);
	}
	
	@Override
	public String getMLSListing() {
		return toString();
	}
	
	@Override
	public String toString() {
		return super.toString() + " The construction has " + bathrooms + " bathrooms, and " + 
				rooms.length + " rooms. \nThe total area of rooms is " + getArea() + 
					" feet and the average room area is " + averageRoomArea() + " feet.\n";
	}
}
