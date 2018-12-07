import java.util.ArrayList;
import java.util.List;

public class ComprehensiveReceipt extends Receipt {
  ComprehensiveReceipt(Account account) {
    super(account);
  }
  String getReportType() {
    return "COMPREHENSIVE RECEIPT";
  }

  protected List<Room> getRooms() {
    List<Room> reservedRooms = new ArrayList<>();
    account.getReservationList()
          .stream()
          .forEach(reservation -> reservedRooms.addAll(reservation.getReservedRooms()));
    return reservedRooms;
  }
}
