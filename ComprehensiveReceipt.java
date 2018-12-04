package Hotel;

import java.util.ArrayList;

public class ComprehensiveReceipt implements Receipt 
{
	private int totalCost;
	public String formatHeader() 
	{
		totalCost = 0;
		String header = "  SIMPLE RECEIPT\n\n";
		return header;
	}

	@Override
	public String formatRoom(Account acnt) 
	{
		ArrayList<Room> ReservedRooms = acnt.getAllRooms();
		String roomsString = "";
		for (Room r : ReservedRooms)
		{
			totalCost += r.getPrice();
		}
		for (Room r : ReservedRooms)
		{
			roomsString = "\n"+r.getRoomNumber()+" $"+r.getPrice();
		}
		return roomsString;
	}

	public String formatFooter() 
	{
		System.out.println();
		return "Total Cost: $ "+totalCost;
	}
}
