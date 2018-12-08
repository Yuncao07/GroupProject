/**
 * Subclass of room that has specifics of an economic room
 * @author Yun Cao
 *
 */
public class EconomicRoom extends Room {
	/**
	 * Returns room's value
	 */
	public double getPrice() {
		return 100.0;
	}
	/**
	 * Creates an economic room with specified room number
	 * @param roomNum the number to distinguish a room
	 */
	public EconomicRoom(int roomNum) {
		super(roomNum);
	}

}
