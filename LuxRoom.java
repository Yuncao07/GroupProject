/**
 * Subclass of room that has the specifications of a luxurious room
 * @author Yun Cao
 *
 */
public class LuxRoom extends Room {
	/**
	 * Returns the value of the room
	 */
	public double getPrice() {
		return 300.0;
	}
	/**
	 * Constructs a luxurious room with the specified room number
	 * @param roomNum number to distinguish rooms
	 */
	public LuxRoom(int roomNum) {
		super(roomNum);
	}
}
