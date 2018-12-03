import java.awt.*;
import javax.swing.*;

public class ReservationPanel extends JPanel{
	public ReservationPanel(){
		setLayout(new FlowLayout());
		JPanel roomDisplay = new JPanel();
		JTextField roomNum = new JTextField();
		//need to make this display all available rooms
		add(roomDisplay);
		add(roomNum);
	}
}
