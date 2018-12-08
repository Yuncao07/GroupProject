import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
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
	 * @param list list of rooms that exist
	 */
	public ClickableRoomPanel(RoomList list) {
		final RoomList l = list;
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
			String text = "";
			text = text.concat("Room Number: " + currentRoom + "\nRoom Price: " + (int)l.getRoom(currentRoom).getPrice() + "\n\nReservations: ");
			ArrayList<DateReservation> info = l.getRoom(currentRoom).getReservationsFromRoom();
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