/**
 * Panel for cancel reservation option
 * @author Yun Cao
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

public abstract class CancelPanel extends JPanel {
	private JLabel instruction = new JLabel("Enter the date you want to cancel (mm/dd/yy)");
	private JTextField getCancelReservation = new JTextField(); 
	private JButton done = new JButton("Done");
	/**
	 * deletes reservation made using a date that user makes reservation
	 */
	public CancelPanel(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(instruction);
		add(getCancelReservation);
		add(done);
		done.addActionListener((ActionEvent e) -> {
			String stringDate = getCancelReservation.getText();
			LocalDate enteredDate = DateInput.parseDate(stringDate);
			if (enteredDate != null) {
				onDone(enteredDate);
			}
		});
	}

	public abstract void onDone(LocalDate date);
}
