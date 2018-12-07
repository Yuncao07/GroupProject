import java.time.LocalDate;

public class DateReservation {
	private LocalDate startDate;
	private LocalDate endDate;
	
	public DateReservation(LocalDate sDate, LocalDate eDate) {
		startDate = sDate;
		endDate = eDate;
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
