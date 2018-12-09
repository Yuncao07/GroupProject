
/**
 * @author Yun Cao
 * Controller/View for calendar
 */
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;;

public abstract class Month extends JPanel implements DatePicker {
	final JPanel displayPanel;
	final JPanel monthDaysPanel;
	final JLabel monthDisplay;

	LocalDate currentMonth;
	LocalDate selectedDate;

	
	public Month() {
		selectedDate = LocalDate.now();
		currentMonth = LocalDate.now().minusDays(LocalDate.now().getDayOfMonth() - 1);

		monthDisplay = new JLabel(getMonthDisplayText());

		displayPanel = getDisplayPanel();
		monthDaysPanel = getMonthDaysPanel();

		setLayout(new BorderLayout());

		add(displayPanel, BorderLayout.NORTH);
		add(monthDaysPanel, BorderLayout.SOUTH);
	}

	/**
	 * panel with buttons to change month and shows current month
	 * @return
	 */
	private JPanel getDisplayPanel() {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));

		final JButton previous = new JButton("<");
		previous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCurrentMonth(currentMonth.getMonth().getValue() - 1);
			}
		});

		final JButton next = new JButton(">");
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				setCurrentMonth(currentMonth.getMonth().getValue() + 1);
			}
		});

		panel.add(previous);
		panel.add(monthDisplay);
		panel.add(next);

		return panel;
	}

	/**
	 * panel with days in month calendar
	 * @return
	 */
	private JPanel getMonthDaysPanel() {
		final JPanel monthPanel = new JPanel();
		final GridLayout layout = new GridLayout(6, 7);
		monthPanel.setLayout(layout);

		addDaysOfMonthToPanel(monthPanel);

		return monthPanel;
	}

	/**
	 * Gets the month in text
	 * @return the month in text
	 */
	private String getMonthDisplayText() {
		return String.format("%s %d", currentMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.US),
				currentMonth.getYear());
	}

	/**
	 * set current month to display
	 * @param month the month to display
	 */
	private void setCurrentMonth(final int month) {
		final int monthsPerYear = 12;
		int year = currentMonth.getYear();
		if (month < 1) {
			year--;
		} else if (month > monthsPerYear) {
			year++;
		}

		int newMonth = month % monthsPerYear;
		if (newMonth == 0)
			newMonth = monthsPerYear;

		currentMonth = LocalDate.of(year, newMonth, 1);
		monthDisplay.setText(getMonthDisplayText());

		redrawMonthDaysPanel();

		repaint();
	}

	/**
	 * redraw the calendar when the month is changed
	 */
	private void redrawMonthDaysPanel() {
		monthDaysPanel.removeAll();
		addDaysOfMonthToPanel(monthDaysPanel);
	}

	/**
	 * add days of month to the panel
	 * @param monthPanel panel with month displayed
	 */
	private void addDaysOfMonthToPanel(JPanel monthPanel) {
		for (int i = 0; i < currentMonth.getDayOfWeek().getValue(); i++) {
			monthPanel.add(Box.createRigidArea(new Dimension(1, 1)));
		}

		for (int i = 1; i <= currentMonth.lengthOfMonth(); i++) {
			final int dayOfMonth = i;
			final JButton button = new JButton(i + "");
			if (dayOfMonth == selectedDate.getDayOfMonth() && selectedDate.getMonth() == currentMonth.getMonth()
					&& selectedDate.getYear() == currentMonth.getYear()) {
				button.setBorder(new LineBorder(Color.cyan, 1));
			}

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					selectedDate = LocalDate.of(currentMonth.getYear(), currentMonth.getMonth(), dayOfMonth);
					onDateSelected(selectedDate);
					redrawMonthDaysPanel();
					revalidate();
				}
			});

			monthPanel.add(button);
		}
	}

}
