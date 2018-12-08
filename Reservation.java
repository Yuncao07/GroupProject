/**
 * A reservation includes the date a user makes reservation 
 * 	and list of stays
 */
import java.time.LocalDate;
import java.util.*;

public class Reservation {
	private LocalDate dateMakeReservation;
	private ArrayList<Room> reserveRooms;
	
	public Reservation() {
		dateMakeReservation = LocalDate.now(); //reservation is made on same day as creation of this
		reserveRooms = new ArrayList<Room>();
	}
	
	public LocalDate getDateReserve() {
		return dateMakeReservation;
	}
	
	public ArrayList<Room> getReservedRooms() {
		return reserveRooms;
	}
	public void addRoom (Room r) {
		reserveRooms.add(r);
	}
	
	public void cancelRoom(Room r) {
		for(int i = reserveRooms.size() - 1; i <= 0; i--) {
			if (reserveRooms.get(i).getRoomNumber() == r.getRoomNumber())
				reserveRooms.remove(i);
 		}		
	}
	
}
