import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ReservationViewCancel extends JPanel {
	private JTextArea view = new JTextArea();
	private CancelPanel cancelPanel;
	
	ReservationViewCancel(ArrayList<Reservation> rList) {
		String text = "Your reservations: \n";
		for(Reservation r : rList) {
			for(Room room : r.getReservedRooms())
				text += r.getDateReserve().toString() + room.getRoomNumber();
		}
		
		view.setText(text);
		
		JButton cancel = new JButton("Cancel");
		
		cancel.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancelPanel = new CancelPanel(rList);
				
			}
			
		});;
	}
}
