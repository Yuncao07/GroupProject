import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Stores the information of a user and the reservations that they made
 * @author Yun Cao
 *
 */
public class Account implements Serializable{
	private String ID;
	private String password;
	private String fullName;
	private List<Reservation> reservationList;
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
		reservationList = reservationList.stream()
					.filter(reservation -> !reservation.equals(r))
					.collect(Collectors.toList());
	}
	/**
	 * to access reservations made in a specific date
	 * @param date the date someone makes reservation
	 * @return all the reservations made on that date if the date is found, 
	 * 			if not, return null
	 */
	public List<Reservation> getReservations(LocalDate date) {
		return reservationList.stream()
					.filter(reservation -> date.equals(reservation.getDateReserve()))
					.collect(Collectors.toList());
	}

	/**
	 * to access all the reservations made
	 * @return reservationList list of all reservation made
	 */
	public List<Reservation> getReservationList() {
		return reservationList;
	}
	
	
}
