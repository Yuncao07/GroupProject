/**
 * @author Yun Cao
 * This class is for showing available rooms with their room numbers
 * Model of calendar view
 */

import java.time.LocalDate;
import java.util.*;
import javax.swing.event.*;

public class RoomList {
	public static RoomList roomList = new RoomList();

	private ArrayList<EconomicRoom> eRoom;
	private ArrayList<LuxRoom> lRoom;
	private ArrayList<Room> availableRooms, reservedRooms;
	private ArrayList<ChangeListener> listeners;
	private LocalDate date;
	private DateReservation period;
	private boolean isLuxRoom;

	/**
	 * Instances a RoomList with 10 economic rooms 
	 * 	and 10 luxury rooms with it's number
	 */
	private RoomList() {
		period = new DateReservation(LocalDate.now(),LocalDate.now());
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
		
		listeners = new ArrayList<ChangeListener>();
		
	}
	

	/**
	 * This method will set the date in the roomlist to the values passed by the user. 
	 * This date can then be used to check the availability of the rooms in the room list 
	 */
	public void setDate(LocalDate d) {
		date = d;
		mutator();
	}

	/**
	 * @param c is the change listener that is added to the Model. 
	 */
	public void attach(ChangeListener c) {
		listeners.add(c);
	}
	

	/**
	 * This method is called every time there is a change in the data that stored in this model class.
	 */
	public void mutator() {
		for(ChangeListener c : listeners) {
			c.stateChanged(new ChangeEvent(this));
		}
	}


	/**
	 * This method will create an object that will hold the reservation dates. 
	 * This date can then be used to check the availability of the rooms in the room list 
	 */

	public void setDateReservation(DateReservation d) {
		period = d;
		mutator();
	}

	/**
	 * @return an object containing the reservation dates. 
	 */

	public DateReservation getDateReservation() {
		return period;
	}
	/**
	 * to get available rooms base on the time period
	 * @param datePeriod period of time that user wants to book
	 * @return a list of Room with available rooms
	 */
	public ArrayList<Room> getAvailableRooms () {
		availableRooms.clear(); //Necessary otherwise we would add duplicate rooms
		for(EconomicRoom r : eRoom) {
			if(r.isAvailable(new DateReservation(date, date)))
				availableRooms.add(r);
		}
		
		for(LuxRoom r : lRoom) {
			if(r.isAvailable(new DateReservation(date, date)))
				availableRooms.add(r);
		}
		
		return availableRooms;
	}
	
	/**
	 * to get reserved rooms base on the time period
	 * @param datePeriod period of time that user wants to book
	 * @return a list of Room with reserved rooms
	 */
	public ArrayList<Room> getReservedRooms () {
		reservedRooms.clear(); //Necessary if called multiple times since otherwise we would add duplicate rooms
		for(EconomicRoom r : eRoom) {
			if(!r.isAvailable(new DateReservation(date, date)))
				reservedRooms.add(r);
		}
		
		for(LuxRoom r : lRoom) {
			if(!r.isAvailable(new DateReservation(date, date)))
				reservedRooms.add(r);
		}
		
		return reservedRooms;
	}
	

	/**
	 * To check if the room is a luxury room. 
	 */

	public void luxRoom(boolean b) {
		isLuxRoom = b;
		mutator();
	}
	public ArrayList<EconomicRoom> getEconRoomList(){
		return eRoom;
	}
	public ArrayList<LuxRoom> getLuxRoomList(){
		return lRoom;
	}

	/**
	 * To return a list of rooms selected by the user for a particular date 
	 * @param datePeriod the chosen period of date. 
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
	 * @param i the specific room number requested by the user. 
	 * @return The object of the room requested  by the user. 
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
