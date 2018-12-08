/**
 * A reservation includes the date a user makes reservation 
 * 	and list of stays
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Reservation implements Serializable {
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
	
}
