/**
 * The panel show reservations the user made and let user cancel
 * @author Yun Cao
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class ReservationViewCancel extends JPanel {
	private JTextArea view = new JTextArea();
	
	/**
	 * makes an instance of view/cancel panel
	 * @param rList list of reservations to show
	 */
	ReservationViewCancel(ArrayList<Reservation> rList) {
		String text = "You have reservations on: \n";
		for(Reservation r : rList) {
			for(Room room : r.getReservedRooms())
				text += r.getDateReserve().toString() + " with room: " + room.getRoomNumber() + "\n";
		}
		
		view.setPreferredSize(new Dimension(500, 500));
		view.setText(text);
		add(view);
		JButton cancel = new JButton("Cancel");
		add(cancel);
		cancel.addActionListener((ActionEvent arg0) -> {
				JFrame cancelFrame = new JFrame();
				cancelFrame.add(new CancelPanel(rList));
				cancelFrame.pack();
				cancelFrame.setVisible(true);
				cancelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			});
	}
}