import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Account implements Serializable {
	private String ID;
	private String password;
	private String fullName;
	private ArrayList<Reservation> reservationList;
	
	public Account(String id, String pass, String name) {
		ID = id;
		password = pass;
		fullName = name;
		reservationList = new ArrayList<Reservation>();
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return fullName;
	}
	
	public void reserve(Reservation r) {
		reservationList.add(r);
	}
	
	public void cancel(Reservation r) {
		for(int i = reservationList.size(); i >= 0; i--) {
			if(reservationList.get(i) == r)
				reservationList.remove(i);
				
		}
	}
	/**
	 * to access reservation made in a specific date
	 * @param d the date someone makes reservation
	 * @return all the reservations made on that date if the date is found, 
	 * 			if not, return null
	 */
	public Reservation getReservation(LocalDate d) {
		for(Reservation r : reservationList) {
			if(d.equals(r.getDateReserve()))
					return r;
		}
		return null;
	}
	/**
	 * to access all the reservations made
	 * @return reservationList list of all reservation made
	 */
	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}
	
	
}
