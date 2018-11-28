
public class LuxRoom extends CommonRoom {
	static final double PRICE = 300.0;
	private double price = PRICE;
	
	public LuxRoom(int roomNum) {
		roomNumber = roomNum;
	}
	
	public double getPrice() {
		return price;
	}
}
