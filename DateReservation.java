import java.io.Serializable;
import java.time.LocalDate;

public class DateReservation implements Serializable {
	private LocalDate startDate;
	private LocalDate endDate;
	
	public DateReservation(LocalDate sDate, LocalDate eDate) {
		startDate = sDate;
		endDate = eDate;
	}
	
	public static boolean allowedDates(LocalDate sDate, LocalDate eDate) {
		if(sDate.plusDays(61).compareTo(eDate) <= 0) { //if end date is longer than 60 days this will be true
			return false;
		}
		return true;
	}
	
	public LocalDate getStartDate(){
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public String toString() {
		return startDate.getMonthValue() + "/" + startDate.getDayOfMonth() + "/" + startDate.getYear() + " - " + endDate.getMonthValue() + "/" + endDate.getDayOfMonth() + "/" + endDate.getYear();
	}
}
