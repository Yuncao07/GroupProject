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
	
	public void setDate(LocalDate d) {
		date = d;
		mutator();
	}
	public void attach(ChangeListener c) {
		listeners.add(c);
	}
	
	public void mutator() {
		for(ChangeListener c : listeners) {
			c.stateChanged(new ChangeEvent(this));
		}
	}
	public void setDateReservation(DateReservation d) {
		period = d;
		mutator();
	}
	public DateReservation getDateReservation() {
		return period;
	}
	/**
	 * to get available rooms base on the time period
	 * @param datePeriod period of time that user wants to book
	 * @return a list of Room with available rooms
	 */
	public ArrayList<Room> getAvailableRooms () {
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
	
	public void luxRoom(boolean b) {
		isLuxRoom = b;
		mutator();
	}
	
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
