
/**
 * @author Yun Cao
 * The panel for manager's calendar view
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AvailableRoomViewPanel extends JPanel {
	private JPanel roomInfoView, calendarView;
	private final String firstLine = "Room Information\n";
	private final String secondLine = "Available rooms: ";
	private final String thirdLine = "Reserved rooms: ";

	public AvailableRoomViewPanel(RoomList list) {
		final RoomList roomList = list;
		roomInfoView = new JPanel();

		final JTextArea view = new JTextArea();

		list.attach((ChangeEvent e) -> {
			String availableRooms = roomList.getAvailableRooms().stream().map(room -> room.getRoomNumber() + "")
					.collect(Collectors.joining(" "));

			String reservedRooms = roomList.getReservedRooms().stream()
					.map(room -> {
						List<String> guestNames = Guest.guest.getGuests().stream()
								.filter(guest -> {
									List<Reservation> matchingReservations = guest.getReservationList().stream()
										.filter(reservation -> reservation.getReservedRooms().stream()
												.anyMatch(reservedRoom -> reservedRoom.getRoomNumber() == room.getRoomNumber())
										)
										.collect(Collectors.toList());
									return matchingReservations.size() > 0;
								})
								.map(guest -> guest.getName())
								.collect(Collectors.toList());
						String guestName = guestNames.get(0);

						return String.format("%d %s", room.getRoomNumber(), guestName != null ? guestName : "");
					})
					.collect(Collectors.joining(", "));

			final String text = String.format("%s\n%s%s\n%s%s", firstLine, secondLine, availableRooms, thirdLine,
					reservedRooms);

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
		setPreferredSize(new Dimension(900, 300));
		// setLayout(new BorderLayout());
		add(calendarView);
		add(roomInfoView);
	}
}