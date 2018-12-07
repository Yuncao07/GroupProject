/**
 * @author Yun Cao
 * The panel for manager's calendar view
 */
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AvailableRoomViewPanel extends JPanel {
	private JLabel dateString;
	private JPanel roomInfoView, calendarView;
	private JTextArea view;
	private String firstLine = "Room Information\n";
	private String secondLine = "Available rooms: ";
	private String thirdLine = "Reserved rooms: ";
	private String str;
	private ChangeListener l;
	
	public AvailableRoomViewPanel(RoomList list) {
		final RoomList roomList = list;
		roomInfoView = new JPanel();
		roomInfoView.setLayout(new BorderLayout());

		view = new JTextArea();
		
		ArrayList<Room> availableRooms =  roomList.getAvailableRooms();
		ArrayList<Room> reservedRooms =  roomList.getReservedRooms();

		for(Room r : availableRooms) {
			secondLine += r.getRoomNumber() + " ";
		}
		
		for(Room r : reservedRooms) {
			thirdLine += r.getRoomNumber() + " ";
		}
		
		str = firstLine + secondLine +"\n" + thirdLine;
		l = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				view.setText(str);
				repaint();
				
			}
		};
		list.attach(l);
		roomInfoView.add(dateString, BorderLayout.NORTH);
		roomInfoView.add(view, BorderLayout.CENTER);
		
		calendarView = new JPanel();
		calendarView.add(new DateInput() {
			@Override
			public void onDateSelected(LocalDate date) {
				roomList.setDate(date);
			}
		});
	}
}
