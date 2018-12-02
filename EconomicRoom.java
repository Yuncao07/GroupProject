
public class EconomicRoom extends CommonRoom{
	static final double PRICE = 100.0;
	private double price = PRICE;
	
	public EconomicRoom(int roomNum) {
		super(roomNum);
	}
	
	public double getPrice() {
		return price;
	}
	
}
