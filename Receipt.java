import java.util.ArrayList;
import java.util.List;
/**
 * This is an abstract class that defines certain methods that are required by receipts. 
 * It will define how the text will look in the header, body and footer of the receipt 
 */
public abstract class Receipt {
	/**
	 * This method will contain information of the type of reciept that is on display 
	 * @return a string showing the kind of receipt. 
	 */
	abstract String getReportType();

	Account account;
	
	/**
	 * The constructor takes in  an account of a user asking for the receipt. 
	 * @param account is the account of the user
	 */
	Receipt(Account account) {
		this.account = account;
	}

	/**
	 * This method formats the header of the receipt by calling the getReportType() method of the subclasses. 
	 * @return a string that will represent the header. 
	 */
	String formatHeader() {
		return String.format("  %s\n\n", getReportType());
	}
	
	/**
	 * This method formats the body of the receipt by calling the getRooms method of the subclasses. 
	 * @return a string containing the information of the reservations mdae by the user. 
	 */
	String formatRoom() {
		return getRooms().stream()
					.map(room -> String.format("\n%i $%d", room.getRoomNumber(), room.getPrice()))
					.reduce("", (string1, string2) -> string1 + string2);
	}

	/**
	 * This method returns the footer of the receipt
	 * @return the total cost of the bookings that the user made. 
	 */
	String formatFooter() {
		double totalCost = getRooms()
					.stream()
					.map(room -> room.getPrice())
					.reduce(0D, (price1, price2) -> price1 + price2);
		return String.format("Total Cost: %d", totalCost);
	}
	
	/**
	 * The method returns a list of rooms that have to be shown in the reciept 
	 * @return a list of Rooms. 
	 */
	protected abstract List<Room> getRooms();
}
