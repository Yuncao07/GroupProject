
/**
 * @author Yun Cao
 * The panel for manager's calendar view
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AvailableRoomViewPanel extends JPanel {
	private JPanel roomInfoView, calendarView;
	private JTextArea view;
	private final String firstLine = "Room Information\n";
	private final String secondLine = "Available rooms: ";
	private final String thirdLine = "Reserved rooms: ";

	public AvailableRoomViewPanel(RoomList list) {
		final RoomList roomList = list;
		roomInfoView = new JPanel();

		view = new JTextArea();

		String availableRooms = roomList.getAvailableRooms().stream().map(room -> room.getRoomNumber() + "")
				.collect(Collectors.joining(" "));

		String reservedRooms = roomList.getReservedRooms().stream().map(room -> room.getRoomNumber() + "")
				.collect(Collectors.joining(" "));

		final String text = String.format("%s\n%s%s\n%s%s", firstLine, secondLine, availableRooms, thirdLine,
				reservedRooms);

		list.attach((ChangeEvent e) -> {
			view.setText(text);
			repaint();
		});

		roomInfoView.add(view);
	
		calendarView = new JPanel();
		calendarView.add(new Month() {
			@Override
			public void onDateSelected(LocalDate date) {
				roomList.setDate(date);
			}
		});
		setPreferredSize(new Dimension(800, 300));
		// setLayout(new BorderLayout());
		add(calendarView);
		add(roomInfoView);
	}
}