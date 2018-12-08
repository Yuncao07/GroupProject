import java.time.LocalDate;
/**
 * A data type that holds a starting date and an ending date period with fuctionality
 * to check for legal dates for reservation
 * @author 
 *
 */
public class DateReservation {
	private LocalDate startDate;
	private LocalDate endDate;
	/**
	 * Constructs a date reservation period with a specified starting date and ending date
	 * @param sDate the starting date of the period
	 * @param eDate the ending date of the period
	 */
	public DateReservation(LocalDate sDate, LocalDate eDate) {
		startDate = sDate;
		endDate = eDate;
	}
	/**
	 * Checks to see if two dates are allowed for a reservation
	 * @param sDate starting date period
	 * @param eDate ending date period
	 * @return true if reservation is allowed, false otherwise
	 */
	public static boolean allowedDates(LocalDate sDate, LocalDate eDate) {
		if(sDate.plusDays(61).compareTo(eDate) <= 0) { //if end date is longer than 60 days this will be true
			return false;
		}
		return true;
	}
	/**
	 * Gets when the reservation period starts
	 * @return the date which reservation starts
	 */
	public LocalDate getStartDate(){
		return startDate;
	}
	/**
	 * Gets when the reservation period ends
	 * @return the date which reservation ends
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public String toString() {
		return startDate.getMonthValue() + "/" + startDate.getDayOfMonth() + "/" + startDate.getYear() + " - " + endDate.getMonthValue() + "/" + endDate.getDayOfMonth() + "/" + endDate.getYear();
	}
}
