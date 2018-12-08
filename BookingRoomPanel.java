import java.time.LocalDate;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
/**
 * Custom Panel that displays the list of available rooms of a certain type
 * for a date period.
 * @author Steven Tang
 *
 */
public class BookingRoomPanel extends JPanel implements ChangeListener{
	private JTextArea rooms;
	private String text = "";
	private ArrayList<Room> listOfRooms;
	private DateReservation stay;
	private final RoomList l;
	/**
	 * Constructs the layout of the panel
	 * @param list list of rooms that hotel has
	 */
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
