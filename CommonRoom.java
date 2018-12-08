import java.util.ArrayList;
/**
 * Abstract class that combines functionalities of different rooms
 * @author Yun Cao
 *
 */
public abstract class CommonRoom extends Room {
	/**
	 * Allows subclasses to construct a room with a specified room number
	 * @param roomNumber integer that represents the number of the room
	 */
	public CommonRoom(int roomNumber) {
		super(roomNumber);
	}
}
