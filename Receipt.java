import java.util.ArrayList;
import java.util.List;

public abstract class Receipt {
	abstract String getReportType();

	Account account;
	Receipt(Account account) {
		this.account = account;
	}


	String formatHeader() {
		return String.format("  %s\n\n", getReportType());
	}

	String formatRoom() {
		return getRooms().stream()
					.map(room -> String.format("\n%i $%d", room.getRoomNumber(), room.getPrice()))
					.reduce("", (string1, string2) -> string1 + string2);
	}


	String formatFooter() {
		double totalCost = getRooms()
					.stream()
					.map(room -> room.getPrice())
					.reduce(0D, (price1, price2) -> price1 + price2);
		return String.format("Total Cost: %d", totalCost);
	}

	private List<Room> getRooms() {
		List<Room> reservedRooms = new ArrayList<>();
		account.getReservationList()
					.stream()
					.forEach(reservation -> reservedRooms.addAll(reservation.getReservedRooms()));
		return reservedRooms;
	}
}
