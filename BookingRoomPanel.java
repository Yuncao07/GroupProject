import java.time.LocalDate;
import javax.swing.*;
import java.util.*;

public class BookingRoomPanel extends JPanel{ //Will need to do MVC on this --- not done yet
	private JTextArea rooms;
	private String text = "";
	public BookingRoomPanel(LocalDate start,LocalDate end, RoomList list) {
		rooms = new JTextArea();
		DateReservation stay = new DateReservation(start,end);
		text = text.concat(stay.toString() + "\n\n");
		ArrayList<Room> availableRooms = list.getChosenAvailableRooms(stay);
		for(Room r : availableRooms) {
			text = text.concat(r.getRoomNumber() + " ");
		}
		text.concat("\n");
		rooms.setText(text);
		rooms.setEditable(false);
		add(rooms);
	}
}
