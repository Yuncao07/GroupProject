/**
 * @author Yun Cao
 * The panel for manager's calendar view
 */
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;

public class AvailableRoomViewPanel extends JPanel {
	private JLabel dateString;
	private JTextArea view;
	private String firstLine = "Room Information\n";
	private String secondLine = "Available rooms: ";
	private String thirdLine = "Reserved rooms: ";
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
		
		str = firstLine + secondLine +"\n" + thirdLine;
		view.setText(str);
	}
}
