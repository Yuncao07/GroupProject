import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;
/**
 * Panel that displays list of available rooms to book based on specified dates and specifications
 * @author Steven Tang
 *
 */
public class ReservationPanel extends JPanel{
	JTextField roomNum;
	/**
	 * Constructs a custom panel that allows viewing and modication of a reservation
	 * @param l list of rooms in hotel
	 */
	public ReservationPanel(RoomList l){
		setLayout(new BorderLayout());
		BookingRoomPanel roomDisplay = new BookingRoomPanel(l);
		roomNum = new JTextField();
		add(roomDisplay,BorderLayout.NORTH);
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(new JLabel("Room Number:"),BorderLayout.WEST);
		container.add(roomNum,BorderLayout.CENTER);
		add(container,BorderLayout.CENTER);
		l.attach(roomDisplay);
	}
	/**
	 * Gets the room number entered by user in the text field
	 * @return room number entered by user
	 */
	public Integer getRoomNum() {
		if (roomNum.getText() == "") return null;
		return Integer.parseInt(roomNum.getText());
	}
}
