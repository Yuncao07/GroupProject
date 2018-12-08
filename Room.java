import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Serializable{
	private List<DateReservation> bookedDates = new ArrayList<DateReservation>();
	protected int roomNumber;
	protected double price;
	
	public Room(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
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
	public ArrayList<DateReservation> getReservationsFromRoom(){
		return (ArrayList<DateReservation>)bookedDates;
	}
	public int getRoomNumber() {
		return roomNumber;
	}

	public double getPrice() {
		return price;
	}
}
