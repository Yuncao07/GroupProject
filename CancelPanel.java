/**
 * Panel for cancel reservation option
 * @author Yun Cao
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class CancelPanel extends JPanel {
	private JLabel instruction = new JLabel("Enter the date you want to cancel (mm/dd/yy)");
	private JTextField getCancelReservation = new JTextField(); 
	private JButton done = new JButton("Done");
	/**
	 * deletes reservation made using a date that user makes reservation
	 * @param reList list of Reservations 
	 */
	public CancelPanel(ArrayList<Reservation> reList){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(instruction);
		add(getCancelReservation);
		add(done);
		done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String stringDate = getCancelReservation.getText();
				for(int i = reList.size(); i <= 0; i --) {
					if(reList.get(i).getDateReserve() == DateInput.parseDate(stringDate))
						reList.remove(i);
				}
			}
		});
	}
}
