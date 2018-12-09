import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
/**
 * Stores the information of a user and the reservations that they made
 * @author Yun Cao
 *
 */
public class Account implements Serializable{
	private String ID;
	private String password;
	private String fullName;
	private ArrayList<Reservation> reservationList;
	/**
	 * Constructs an account with the specified elements
	 * @param id username of user account
	 * @param pass password of user account
	 * @param name name of user account
	 */
	public Account(String id, String pass, String name) {
		ID = id;
		password = pass;
		fullName = name;
		reservationList = new ArrayList<Reservation>();
	}
	/**
	 * Gets the user name of an account
	 * @return the user name of an account
	 */
	public String getID() {
		return ID;
	}
	/**
	 * Gets the password of an account
	 * @return password string of account
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Gets the name of the user of the account
	 * @return name of user of account
	 */
	public String getName() {
		return fullName;
	}
	/**
	 * Adds a reservation to the user's list of reservations
	 * @param r A date period of which something is reserved
	 */
	public void reserve(Reservation r) {
		reservationList.add(r);
	}
	/**
	 * To remove a reservation from the user's list
	 * @param r A date period to be removed from the user list
	 */
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
