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
	  if(account.getReservation(LocalDate.now()) == null) {
		  return new ArrayList<Room>();
	  }
    return account.getReservation(LocalDate.now()).getReservedRooms();
  }
}
