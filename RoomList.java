/**
 * @author Yun Cao

 * This class is for showing available rooms with their room numbers
 * Model of calendar view
 */

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.event.*;

public class RoomList {
	public static RoomList roomList = new RoomList();

	private ArrayList<EconomicRoom> eRoom;
	private ArrayList<LuxRoom> lRoom;
	private ArrayList<ChangeListener> listeners;
	private LocalDate date = LocalDate.now();
	private DateReservation period;
	private boolean isLuxRoom;

	/**
	 * Instances a RoomList with 10 economic rooms 
	 * 	and 10 luxury rooms with it's number
	 */
	private RoomList() {
		period = new DateReservation(LocalDate.now(),LocalDate.now());
		eRoom = new ArrayList<>();
		lRoom = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			eRoom.add(new EconomicRoom(i));
		}
		
		for(int i = 11; i <= 20; i++) {
			lRoom.add(new LuxRoom(i));
		}
		
		listeners = new ArrayList<>();
		
	}
	
	/**
	 * This method used to set the date of reservation. 
	 * The set date can then be used to find the availability of rooms.
	 * @param d is the date. 
	 */
	public void setDate(LocalDate d) {
		date = d;
		mutator();
	}
	
	/**
	 * This method is used to attach the listeners to the data in the model. 
	 * @param c is the changelistener to be added. 
	 */
	public void attach(ChangeListener c) {
		listeners.add(c);
	}
	
	/**
	 * This method is called whenever the data in this class(Model) is changed. 
	 */
	public void mutator() {
		for(ChangeListener c : listeners) {
			c.stateChanged(new ChangeEvent(this));
		}
	}
	
	/**
	 * This method is used to initialize the DateReservation object. 
	 * @param d is the DateReservatoin reference 
	 */
	public void setDateReservation(DateReservation d) {
		period = d;
		mutator();
	}
	
	/**
	 * @return the DateRerservatoin object. 
	 */
	public DateReservation getDateReservation() {
		return period;
	}
	/**
	 * to get available rooms
	 * @return a list of Room with available rooms
	 */
	public List<Room> getAvailableRooms () {
		List<Room> reservedRooms = getReservedRooms();
		List<Room> allRooms = new ArrayList<>();
		allRooms.addAll(eRoom);
		allRooms.addAll(lRoom);

		return allRooms.stream()
					.filter(room -> !reservedRooms.stream().anyMatch(reserved -> reserved.getRoomNumber() == room.getRoomNumber()))
					.collect(Collectors.toList());
	}

	/**
	 * to get reserved rooms
	 * @return a list of Room with reserved rooms
	 */
	public List<Room> getReservedRooms () {
		return Guest.guest.getReservations().stream()
					.map(reservation -> reservation.getReservedRoomsOn(date))
					.reduce(new ArrayList<>(), (list1, list2) -> {
						list1.addAll(list2);
						return list1;
					});
	}

	/**
	 * Gets number of dates reserved for the room
	 * @param room
	 * @return
	 */
	public List<DateReservation> getDaysReserved(Room room) {
		return Guest.guest.getReservations().stream()
					.filter(reservation -> reservation.getReservedRooms().stream()
								.anyMatch(reservedRoom -> reservedRoom.getRoomNumber() == room.getRoomNumber()))
					.map(reservation -> reservation.getRoomReservation(room))
					.reduce(new ArrayList(), (list1, list2) -> {
						list1.addAll(list2);
						return list1;
					});
	}
	
	/**
	 * To check if the room is a Luxury Room. 
	 * @param b is a boolean value to determine if the room is a luxury room or not. 
	 */
	public void luxRoom(boolean b) {
		isLuxRoom = b;
		mutator();
	}
	
	/**
	 * @return a list of Economic Rooms
	 */
	public ArrayList<EconomicRoom> getEconRoomList(){
		return eRoom;
	}
	
	/**
	 * @return a list of luxury rooms 
	 */
	public ArrayList<LuxRoom> getLuxRoomList(){
		return lRoom;
	}
	
	/**
	 * To get a list of rooms that are available for a certain time period. 
	 * @param datePeriod is a DateReservationn object containing the time period of reservation. 
	 * @return the list of needed rooms 
	 */
	public ArrayList<Room> getChosenAvailableRooms(DateReservation datePeriod){
		ArrayList<Room> selected = new ArrayList<>();
		if(isLuxRoom) {
			for(LuxRoom r : lRoom) {
				if(r.isAvailable(datePeriod))
					selected.add(r);
			}
		}
		else {
			for(EconomicRoom r : eRoom) {
				if(r.isAvailable(datePeriod))
					selected.add(r);
			}
		}
		return selected;
	}
	
	/**
	 * To get a reference of a room based on the room number. 
	 * @param i is the room number of the required room 
	 * @return the required room object 
	 */
	public Room getRoom(int i) {
		for(Room r : eRoom) {
			if(r.getRoomNumber() == i) {
				return r;
			}
		}
		for(Room r : lRoom) {
			if(r.getRoomNumber() == i) {
				return r;
			}
		}
		return null;
	}
}
