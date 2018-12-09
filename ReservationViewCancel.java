/**
 * The panel show reservations the user made and let user cancel
 * @author Yun Cao
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public abstract class ReservationViewCancel extends JPanel {
	/**
	 * makes an instance of view/cancel panel
	 * @param rList list of reservations to show
	 */
	ReservationViewCancel(List<Reservation> rList) {

		String text = "You have reservations on: \n";
		for(Reservation r : rList) {
			for(Room room : r.getReservedRooms())
				text += r.getDateReserve().toString() + " with room: " + room.getRoomNumber() + "\n";
		}

		final JTextArea view = new JTextArea();
		view.setEditable(false);
		view.setPreferredSize(new Dimension(500, 500));
		view.setText(text);
		add(view);

		final JButton cancel = new JButton("Cancel");
		add(cancel);
		cancel.addActionListener((ActionEvent arg0) -> {
				final JFrame cancelFrame = new JFrame();
				cancelFrame.add(new CancelPanel() {
					@Override
					public void onDone(LocalDate date) {
						cancelReservationsOnDay(date);

						cancelFrame.setVisible(false);

						returnToHome();
					}
				});
				cancelFrame.pack();
				cancelFrame.setVisible(true);
				cancelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
	}

	public abstract void cancelReservationsOnDay(LocalDate date);
	public abstract void returnToHome();
}