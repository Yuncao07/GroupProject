import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Custom panel in which user specifies requirements for a room reservation.
 * @author Steven Tang
 *
 */
public class DatePanel extends JPanel{
	JButton selectedEconomic = new JButton("$100"), selectedLuxurious = new JButton("$300"), show = new JButton("Show available rooms");
	JTextField startDate, endDate;
	
	/**
	 * Constructs the layout of the panel and corresponding entry fields for user to input data
	 */
	public DatePanel(){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		startDate = new JTextField();
		endDate = new JTextField();
		JLabel room = new JLabel("Room type:"), dateEntry = new JLabel("Start and End dates (Format: MM/DD/YYYY)");
		
		selectedEconomic = new JButton("$100");
		selectedLuxurious = new JButton("$300");
		show = new JButton("Show available rooms");
		
		add(dateEntry);
		add(startDate);
		add(endDate);
		add(room);
		add(selectedEconomic);
		add(selectedLuxurious);
		add(show);
	}
	/**
	 * Adds a listener to the economic room button to set the room preference to economic($100)
	 * @param l listener for when button is pressed
	 */
	public void addListenerToSEButton(ActionListener l) {
		selectedEconomic.addActionListener(l);
	}
	/**
	 * Adds a listener to the luxurious room button to set the room preference to luxurious($300)
	 * @param l listener for when button is pressed
	 */
	public void addListenerToSLButton(ActionListener l) {
		selectedLuxurious.addActionListener(l);
	}
	/**
	 * Adds a listener to the show button to move to the next menu
	 * @param l listener for when button is pressed
	 */
	public void addListenerToSButton(ActionListener l) {
		show.addActionListener(l);
	}
	/**
	 * Gets the starting date from the first text field as a string
	 * @return a string with the starting date of the reservation
	 */
	public String getStart() {
		return startDate.getText();
	}
	/**
	 * Gets the ending date from the second text field as a string
	 * @return a string with the ending date of the reservation
	 */
	public String getEnd() {
		return endDate.getText();
	}
}
