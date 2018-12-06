import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class AvailableRoomViewPanel {
	private JLabel dateString;
	private JTextArea view;
	private String firstLine = "Room Information";
	private String secondLine = "Available rooms: \n";
	private String thirdLine = "Reserved rooms: \n";
	private String str;
	
	public AvailableRoomViewPanel(LocalDate d, RoomList roomList) {
		DateReservation reDate = new DateReservation(d, d);
		dateString = new JLabel(d.toString());
		view = new JTextArea();
		roomList = new RoomList();
		
		ArrayList<Room> availableRooms =  roomList.getAvailableRooms(reDate);
		ArrayList<Room> reservedRooms =  roomList.getReservedRooms(reDate);

		for(Room r : availableRooms) {
			secondLine += r.getRoomNumber() + " ";
		}
		
		for(Room r : reservedRooms) {
			thirdLine += r.getRoomNumber() + " ";
		}
		
		str = firstLine + secondLine + thirdLine;
		view.setText(str);
		
	}
}
