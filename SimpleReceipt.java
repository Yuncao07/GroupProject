package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class SimpleReceipt implements Receipt 
{
	private int totalCost;
	private LocalDate date;
	public SimpleReciept(LocalDate d)
	{
		date = d; 
	}
	public String formatHeader() 
	{
		totalCost = 0;
		String header = "  SIMPLE RECEIPT\n\n";
		return header;
	}

	@Override
	public String formatRoom(Account acnt) 
	{
		ArrayList<Room> ReservedRooms = acnt.getReservation();
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
