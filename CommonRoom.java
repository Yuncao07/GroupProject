import java.util.ArrayList;

public abstract class CommonRoom implements Room {
	private ArrayList<DateReservation> bookedDates;
	String roomNumber;
	
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
	
	public String getRoomNumber() {
		return roomNumber;
	}

}
