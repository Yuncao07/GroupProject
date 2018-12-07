/**
 * This class is for showing available rooms with their room numbers
 */

import java.util.*;

public class RoomList {
	private ArrayList<EconomicRoom> eRoom;
	private ArrayList<LuxRoom> lRoom;
	private ArrayList<Room> availableRooms, reservedRooms;
	private boolean isLuxRoom;
	/**
	 * Instances a RoomList with 10 economic rooms 
	 * 	and 10 luxury rooms with it's number
	 */
	public RoomList() {
		eRoom = new ArrayList<EconomicRoom>();
		lRoom = new ArrayList<LuxRoom>();
		availableRooms = new ArrayList<Room>();
		reservedRooms = new ArrayList<Room>();
		
		for(int i = 1; i <= 10; i++) {
			eRoom.add(new EconomicRoom(i));
		}
		
		for(int i = 11; i <= 20; i++) {
			lRoom.add(new LuxRoom(i));
		}
	}
	
	/**
	 * to get available rooms base on the time period
	 * @param datePeriod period of time that user wants to book
	 * @return a list of Room with available rooms
	 */
	public ArrayList<Room> getAvailableRooms (DateReservation datePeriod) {
		for(EconomicRoom r : eRoom) {
			if(r.isAvailable(datePeriod))
				availableRooms.add(r);
		}
		
		for(LuxRoom r : lRoom) {
			if(r.isAvailable(datePeriod))
				availableRooms.add(r);
		}
		
		return availableRooms;
	}
	
	public ArrayList<Room> getReservedRooms (DateReservation datePeriod) {
		for(EconomicRoom r : eRoom) {
			if(!r.isAvailable(datePeriod))
				reservedRooms.add(r);
		}
		
		for(LuxRoom r : lRoom) {
			if(!r.isAvailable(datePeriod))
				reservedRooms.add(r);
		}
		
		return reservedRooms;
	}
	
	public void luxRoom(boolean b) {
		isLuxRoom = b;
	}
	
	public ArrayList<Room> getChosenAvailableRooms(DateReservation datePeriod){
		if(isLuxRoom) {
			for(LuxRoom r : lRoom) {
				if(r.isAvailable(datePeriod))
					availableRooms.add(r);
			}
		}
		else {
			for(EconomicRoom r : eRoom) {
				if(r.isAvailable(datePeriod))
					availableRooms.add(r);
			}
		}
		return availableRooms;
	}
}
