/**
 * A reservation includes the date a user makes reservation 
 * 	and list of stays
 * @author Yun Cao
 */
import java.io.Serializable;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Reservation implements Serializable{
	private LocalDate dateMakeReservation;
	private ArrayList<RoomReservation> reservations;
	private final String id;
	/**
	 * Constructs a reservation on the day user booked rooms
	 */
	public Reservation() {
		id = new String(new byte[7], Charset.forName("UTF-8"));
		dateMakeReservation = LocalDate.now(); //reservation is made on same day as creation of this
		reservations = new ArrayList<>();
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
	public List<Room> getReservedRooms() {
		return reservations.stream()
					.map(reservation -> reservation.getRoom())
					.collect(Collectors.toList());
	}

	/**
	* Get all rooms reserved on date by all accounts
	* @param date The date want the reserved rooms for
	* @return List<Room> all rooms with a reservation on the specified day
	*/
	public List<Room> getReservedRoomsOn(LocalDate date) {
		return reservations.stream()
					.filter(reservation -> date.isAfter(reservation.getDateReservation().getStartDate()) &&
								date.isBefore(reservation.getDateReservation().getEndDate()))
					.map(reservation -> reservation.getRoom())
					.collect(Collectors.toList());
	}

	/**
	 * Adds a room to the rooms reserved today
	 * @param r specified room reserved
	 */
	public void addRoom (Room r, DateReservation dates) {
		reservations.add(new RoomReservation(r, dates));
	}

	/**
	 * Gets total price for all reservationa
	 * @return total of rerseravtions
	 */
	public double getTotal() {
		return reservations.stream()
					.map(reservation -> reservation.getRoom().getPrice() * reservation.getDateReservation().getNumberDays())
					.reduce(0D, (price1, price2) -> price1 + price2);
	}

	/**
	 * Gets all reservations on the room
	 * @param room room needs to get accessed
	 * @return list of reservations on a room
	 */
	public List<DateReservation> getRoomReservation(Room room) {
		return reservations.stream()
					.filter(reservation -> reservation.getRoom().getRoomNumber() == room.getRoomNumber())
					.map(reservation -> reservation.getDateReservation())
					.collect(Collectors.toList());
	}

	public int getDaysRoomReserved(Room room) {
		return getRoomReservation(room).stream()
					.map(reservation -> reservation.getNumberDays())
					.reduce(0, (stay1, stay2) -> stay1 + stay2);
	}

	/**
	 * Removes a booking from the users list of reservations made today
	 * @param r specified room to remove
	 */
	public void cancelRoom(Room r) {
		for(int i = reservations.size() - 1; i <= 0; i--) {
			if (reservations.get(i).getRoom().getRoomNumber() == r.getRoomNumber())
				reservations.remove(i);
 		}		
	}

	/**
	 * checks 2 ids are equal
	 * @param reservation reservation made
	 * @return true or false
	 */
	public boolean equals(Reservation reservation) {
		return id.equals(reservation.id);
	}

	/**
	 * Inner class, a pairing between a room and a reservation
	 *
	 */
	private static class RoomReservation implements Serializable {
		private Room room;
		private DateReservation reservedDates;

		public RoomReservation(Room room, DateReservation reservedDates) {
			this.room = room;
			this.reservedDates = reservedDates;
		}

		public Room getRoom() {
			return room;
		}

		public DateReservation getDateReservation() {
			return reservedDates;
		}
	}
}
