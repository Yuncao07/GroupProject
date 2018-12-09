
/**
 * @author Yun Cao
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DateInput extends JPanel implements ActionListener, DatePicker {
	final JTextField inputField;

	/**
	 * parse a string into a valid date
	 * @param text the date in type string needs to be converted
	 * @return a valid date
	 */
	public static LocalDate parseDate(final String text) {
		final Pattern pattern = Pattern.compile("(\\d{1,2})[/-](\\d{1,2})[/-](\\d{2,4})");
		final Matcher matcher = pattern.matcher(text);
		if (!matcher.find() || matcher.groupCount() < 3)
			return null;

		int year = Integer.parseInt(matcher.group(3));
		return LocalDate.of(year < 100 ? year + 2000 : year, Integer.parseInt(matcher.group(1)),
				Integer.parseInt(matcher.group(2)));
	}

	/**
	 * Instances calendar days
	 */
	DateInput() {
		inputField = new JTextField(10);
		inputField.addActionListener(this);
		add(inputField);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String newText = inputField.getText();
		LocalDate parsedDate = parseDate(newText);
		inputField.setBorder(parsedDate != null ? null : new LineBorder(Color.red, 1));
		if (parsedDate != null) {
			onDateSelected(parsedDate);
		}
		repaint();
	}

}
