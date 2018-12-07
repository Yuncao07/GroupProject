import java.awt.event.ActionListener;
import javax.swing.*;

public class DatePanel extends JPanel{
	JButton selectedEconomic = new JButton("$100"), selectedLuxurious = new JButton("$300"), show = new JButton("Show available rooms");
	JTextField startDate, endDate;
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
	public void addListenerToSEButton(ActionListener l) {
		selectedEconomic.addActionListener(l);
	}
	public void addListenerToSLButton(ActionListener l) {
		selectedLuxurious.addActionListener(l);
	}
	public void addListenerToSButton(ActionListener l) {
		show.addActionListener(l);
	}
	public String getStart() {
		return startDate.getText();
	}
	public String getEnd() {
		return endDate.getText();
	}
}
