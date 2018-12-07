import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimpleReceipt extends Receipt {
  SimpleReceipt(Account account) {
    super(account);
  }

  String getReportType() {
    return "SIMPLE RECEIPT";
  }

  protected List<Room> getRooms() {
    return account.getReservation(LocalDate.now()).getReservedRooms();
  }
}
