import java.util.ArrayList;
import java.util.Arrays;

public class TestBuilding {

	public static void main(String[] args) {
		/*
		 * build first house
		 */
		Room houseOneMainRoom = new Room(12, 12, "wood", 2, "houseOneMainRoom");
		Room houseOneGuestRoomOne = new Room(7, 7, "tile", 1, "houseOneGuestRoomOne");
		Room houseOneGuestRoomTwo = new Room(7, 7, "tile", 1, "houseOneGuestRoomTwo");
		Room[] rooms = {houseOneMainRoom, houseOneGuestRoomOne, houseOneGuestRoomTwo};
		Building houseOne = new House(3, rooms, 2, 8);
		
		/*
		 * build second house
		 */
		Room houseTwoMainRoom = new Room(14, 11, "carpet", 2, "houseTwoMainRoom");
		Room houseTwoGuestRoom = new Room(10, 9, "wood", 1, "houseTwoGuestRoom");
		Room[] roomstwo = {houseTwoMainRoom, houseTwoGuestRoom};
		Building houseTwo = new House(4, roomstwo, 3, 12);
		
		/*
		 * build two garages 
		 */
		Building garageOne = new Garage(2, 10, 10, "cement", 2); 
		Building garageTwo = new Garage(1, 6, 6, "gravel", 1);
		
		/*
		 * build buildings array list 
		 */
		Building[] buildings = {houseOne, houseTwo, garageOne, garageTwo};
		ArrayList<Building> buildingList = new ArrayList<>(Arrays.asList(buildings));
		
		for(Building building: buildingList) {
			System.out.println(building);
		}
		
		/*
		 * check if a given building is of type MLSListable and print information
		 */
		System.out.println("");
		
		for(Building building : buildings) {
			if (building instanceof MLSListable) {
				listPropertyForSale((MLSListable)building);
			} else {
				System.out.println("I AM A " + building.getClass().getTypeName().toUpperCase() + " AND I AM NOT FOR SALE");
			}
		}
		
		/*
		 * check if room is of type MLSListable and print information
		 */
		Room[] roomListing = {houseOneMainRoom, houseOneGuestRoomOne, houseOneGuestRoomTwo};

		for(Room room : roomListing) {
			if (room instanceof MLSListable) {
				listPropertyForSale((MLSListable)room);
			} else {
				System.out.println("I AM A " + room.getClass().getTypeName().toUpperCase() + " AND I AM NOT FOR SALE");
			}
		}
		
		/*
		 * check if rooms are the same and print information
		 */
		System.out.println("");
		System.out.println(houseOneMainRoom.equals(houseOneMainRoom));
		System.out.println(houseOneGuestRoomTwo.equals(houseTwoGuestRoom));
		System.out.println(houseOneGuestRoomOne.equals(houseOneGuestRoomOne));
		
		/*
		 * compare rooms and print information
		 */
		System.out.println("");
		System.out.println(compareRooms(houseOneMainRoom, houseOneMainRoom));
		System.out.println(compareRooms(houseOneGuestRoomTwo, houseTwoGuestRoom));
		System.out.println(compareRooms(houseOneGuestRoomOne, houseOneGuestRoomOne));
	}
	
	/*
	 * static method that takes a MLSListable type
	 */
	public static void listPropertyForSale(MLSListable property) {
		System.out.println("I AM FOR SALE! " + property);
	}
	
	/*
	 * helper method that returns a string describing the result of rooms comparison
	 */
	public static String compareRooms(Room roomOne, Room roomTwo) {
		int result = roomOne.compareTo(roomTwo);
		String resultDescription;
		
		if (result == 1) {
			resultDescription = " is bigger ";
		} else if (result == -1) {
			resultDescription = " is smaller ";
		} else {
			resultDescription = " is the same size as ";
		}
		
		return roomOne.getRoomName() + resultDescription + roomTwo.getRoomName() + ".";
	}
}
