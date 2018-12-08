import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

public class ReservationPanel extends JPanel{
	public ReservationPanel(RoomList l){
		setLayout(new BorderLayout());
		BookingRoomPanel roomDisplay = new BookingRoomPanel(l);
		JTextField roomNum = new JTextField();
		add(roomDisplay,BorderLayout.NORTH);
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(new JLabel("Room Number:"),BorderLayout.WEST);
		container.add(roomNum,BorderLayout.CENTER);
		add(container,BorderLayout.CENTER);
		l.attach(roomDisplay);
	}
}
