import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * This class prints a receipt based on the reservations that were made by a user for a particular day. 
 */
public class SimpleReceipt extends Receipt {

	/**
	 * The constructor calls the constructor of the abstract class Receipt. 
	 * @param account is the account of the user requesting the receipt. 
	 */
	SimpleReceipt(Account account) {
		super(account);
	}
	
	/**
	 * @return the description of the kind of receipt that is going to be displayed. 
	 */
	String getReportType() {
		return "SIMPLE RECEIPT";
	}
	
	/**
	 * This method returns a list of rooms that were booked by a user under a single reservation date. 
	 */
	protected List<Reservation> getReservations() {
		if(account.getReservations(LocalDate.now()) == null) {
			return new ArrayList<>();
		}
		return account.getReservations(LocalDate.now());
	}
}
