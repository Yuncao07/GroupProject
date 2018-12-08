import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReceiptPanel extends JPanel{
	JTextArea receipt;
	JButton done;
	String text;
	
	public ReceiptPanel() {
		done = new JButton("Done");
	}
	
	public ReceiptPanel(Receipt r) {
		receipt = new JTextArea();
		done = new JButton("Done");
		text = r.getReportType() + "\n" + r.formatHeader() + r.formatRoom() + r.formatFooter();
		receipt.setText(text);
		receipt.setEditable(false);
		add(receipt,BorderLayout.CENTER);
		add(done,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(900, 300));
	}
	
	public void addListener(ActionListener l) {
		done.addActionListener(l);
	}
}
