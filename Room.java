import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * This class holds the room number of a room. 
 * It keeps a list of a list of bookings made on the room and it can check if its available for a period of time or not. 
 */
public abstract class Room implements Serializable{
	private List<DateReservation> bookedDates = new ArrayList<DateReservation>();
	protected int roomNumber;
	protected double price;
	
	/**
	 * The constructor of the class initializes the room number. 
	 * @param roomNumber
	 */
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	/**
	 * This method checks if the room is available for a reservation date or not. 
	 * @param checkingDate is the reservation date 
	 * @return a boolean value to determine if the room is available or not. 
	 */
	public boolean isAvailable(DateReservation checkingDate) {
		for(DateReservation d : bookedDates) {
			boolean startingDateInRange = checkingDate.getStartDate().compareTo(d.getStartDate()) >= 0 && 
					checkingDate.getStartDate().compareTo(d.getEndDate()) < 0;
			boolean endingDateInRange = checkingDate.getEndDate().compareTo(d.getStartDate()) > 0 && 
					checkingDate.getEndDate().compareTo(d.getEndDate()) <= 0;
			boolean containsRange = checkingDate.getStartDate().compareTo(d.getStartDate()) <= 0 && checkingDate.getEndDate().compareTo(d.getEndDate()) >= 0;
			
			if (startingDateInRange || endingDateInRange || containsRange) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns the list of bookings that have been made on the room. 
	 * @return
	 */
	public ArrayList<DateReservation> getReservationsFromRoom(){
		return (ArrayList<DateReservation>)bookedDates;
	}
	
	/**
	 * @return the room number of the room. 
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	
	/**
	 * @return the cost of the room.
	 */
	public double getPrice() {
		return price;
	}
}
