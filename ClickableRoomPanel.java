import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This panel uses the room list model to display room information based on
 * the room number clicked.
 * @author Steven Tang
 * 
 */
public class ClickableRoomPanel extends JPanel{
	JPanel roomClick, roomInfo;
	int currentRoom;
	
	/**
	 * Constructs a panel with buttons that change the view text area.
	 */
	public ClickableRoomPanel() {
		final RoomList l = RoomList.roomList;
		roomClick = new JPanel();
		roomClick.setLayout(new GridLayout(4,5));
		for(EconomicRoom r : l.getEconRoomList()) {
			JRoomButton b = new JRoomButton(r.getRoomNumber());
			b.addActionListener(event ->{
				currentRoom = b.getRoomNum();
				l.mutator();
			});
			roomClick.add(b);
		}
		for(LuxRoom lr : l.getLuxRoomList()) {
			JRoomButton b = new JRoomButton(lr.getRoomNumber());
			b.addActionListener(event ->{
				currentRoom = b.getRoomNum();
				l.mutator();
			});
			roomClick.add(b);
		}
		roomInfo = new JPanel();
		
		JTextArea roomInfoDisplay = new JTextArea();
		roomInfoDisplay.setPreferredSize(new Dimension(250,250));
		l.attach(event ->{
			Room selectedRoom = RoomList.roomList.getRoom(currentRoom);
			if (selectedRoom == null) return;
			String text = "Room Number: " + currentRoom + "\nRoom Price: " + (int)selectedRoom.getPrice() + "\n\nReservations: ";
			List<DateReservation> info = RoomList.roomList.getDaysReserved(selectedRoom);
			for(DateReservation dr : info) {
				text = text.concat(dr.toString() + "\n");
			}
			roomInfoDisplay.setText(text);
			repaint();
		});
		roomInfo.add(roomInfoDisplay);
		
		add(roomClick,BorderLayout.WEST);
		add(roomInfo,BorderLayout.EAST);
	}
}
