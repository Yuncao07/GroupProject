import javax.swing.*;

public class JRoomButton extends JButton{
	private int roomNumber;
	
	public JRoomButton(int roomNum) {
		super(Integer.toString(roomNum));
		roomNumber = roomNum;
	}
	
	public int getRoomNum() {
		return roomNumber;
	}
}
