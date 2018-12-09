import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Panel that displays the receipt of guest reservations.
 * @author Steven Tang
 *
 */
public class ReceiptPanel extends JPanel{
	JTextArea receipt;
	JButton done;
	String text;
	
	public ReceiptPanel() {
		done = new JButton("Done");
	}
	/**
	 * Constructs a receipt with the specified format to print
	 * @param r A receipt format to print with
	 */
	public ReceiptPanel(Receipt r) {
		receipt = new JTextArea();
		done = new JButton("Done");
		text = r.formatHeader() + "\n" + r.formatRoom() + "\n" + r.formatFooter();
		receipt.setText(text);
		receipt.setEditable(false);
		add(receipt,BorderLayout.CENTER);
		add(done,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(900, 300));
	}
	/**
	 * Adds a listener to the button that allows changes or movement within program
	 * @param l listener that is notified by button
	 */
	public void addListener(ActionListener l) {
		done.addActionListener(l);
	}
}
