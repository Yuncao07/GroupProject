import java.time.LocalDate;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

public class BookingRoomPanel extends JPanel implements ChangeListener{ //Will need to do MVC on this --- not done yet
	private JTextArea rooms;
	private String text = "";
	private ArrayList<Room> listOfRooms;
	private DateReservation stay;
	private final RoomList l;
	public BookingRoomPanel(RoomList list) {
		rooms = new JTextArea();
		rooms.setColumns(40);
		stay = list.getDateReservation();
		text = text.concat(stay.toString() + "\nRooms Available:\n");
		l = list;
		listOfRooms = l.getChosenAvailableRooms(stay);
		for(Room r : listOfRooms) {
			text = text.concat(r.getRoomNumber() + " ");
		}
		text.concat("\n");
		rooms.setText(text);
		rooms.setEditable(false);
		add(rooms);
	}
	
	public void stateChanged(ChangeEvent e) {
		text = l.getDateReservation().toString() + "\nRooms Available:\n";
		listOfRooms = l.getChosenAvailableRooms(l.getDateReservation());
		for(Room r : listOfRooms) {
			text = text.concat(r.getRoomNumber() + " ");
		}
		text.concat("\n");
		rooms.setText(text);
		repaint();
	}
}
