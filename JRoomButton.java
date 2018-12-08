import javax.swing.*;
/**
 * Custom button that holds a room number for easy search.
 * @author Steven Tang
 * @version 1.0 12/8/18
 */
public class JRoomButton extends JButton{
	private int roomNumber;
	/**
	 * Makes a button with a label of the room number and holds that room number
	 * @param roomNum the number of room
	 */
	public JRoomButton(int roomNum) {
		super(Integer.toString(roomNum));
		roomNumber = roomNum;
	}
	/**
	 * Return this buttons room number
	 * @return the room number associated with the button
	 */
	public int getRoomNum() {
		return roomNumber;
	}
}
