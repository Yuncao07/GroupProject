import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

public class ReservationPanel extends JPanel{
	public ReservationPanel(){
		setLayout(new BorderLayout());
		BookingRoomPanel roomDisplay = new BookingRoomPanel(LocalDate.now(),LocalDate.now(),new RoomList());
		JTextField roomNum = new JTextField();
		add(roomDisplay,BorderLayout.NORTH);
		add(roomNum,BorderLayout.CENTER);
	}
}
