import java.util.ArrayList;
import java.util.List;
/**
 * Concrete strategy of printing receipt by showing all reservations
 * booked by current user.
 * @author Yun Cao, Keshuv Bagaria
 *
 */
public class ComprehensiveReceipt extends Receipt {
	/**
	 * Constructs a receipt using the account information
	 * @param account the user currently logged in
	 */
  ComprehensiveReceipt(Account account) {
    super(account);
  }
  /**
   * Returns the type of receipt being printed
   */
  String getReportType() {
    return "COMPREHENSIVE RECEIPT";
  }
  /**
   * return the list of rooms booked by user
   */
  protected List<Room> getRooms() {
    List<Room> reservedRooms = new ArrayList<>();
    account.getReservationList()
          .stream()
          .forEach(reservation -> reservedRooms.addAll(reservation.getReservedRooms()));
    return reservedRooms;
  }
}
