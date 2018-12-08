/**
 * A reservation includes the date a user makes reservation 
 * 	and list of stays
 * @author Yun Cao
 */
import java.time.LocalDate;
import java.util.*;

public class Reservation {
	private LocalDate dateMakeReservation;
	private ArrayList<Room> reserveRooms;
	/**
	 * Constructs a reservation on the day user booked rooms
	 */
	public Reservation() {
		dateMakeReservation = LocalDate.now(); //reservation is made on same day as creation of this
		reserveRooms = new ArrayList<Room>();
	}
	/**
	 * Returns the date that the specified reservation was made
	 * @return date when object was made
	 */
	public LocalDate getDateReserve() {
		return dateMakeReservation;
	}
	/**
	 * Gets the list of rooms that have been reserved
	 * @return list of rooms reserved today
	 */
	public ArrayList<Room> getReservedRooms() {
		return reserveRooms;
	}
	/**
	 * Adds a room to the rooms reserved today
	 * @param r specified room reserved
	 */
	public void addRoom (Room r) {
		reserveRooms.add(r);
	}
	/**
	 * Removes a booking from the users list of reservations made today
	 * @param r specified room to remove
	 */
	public void cancelRoom(Room r) {
		for(int i = reserveRooms.size() - 1; i <= 0; i--) {
			if (reserveRooms.get(i).getRoomNumber() == r.getRoomNumber())
				reserveRooms.remove(i);
 		}		
	}
	
}
