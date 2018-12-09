import java.awt.*;
import javax.swing.*;
/**
 * Customized panel for user to enter their user name
 * and password to access their account in the list of
 * guests.
 * @author Steven Tang
 *
 */
public class LoginPanel extends JPanel{
	private JLabel user,pass;
	private JTextField username;
	private JPasswordField password;
	private boolean isManager;
	/**
	 * Constructs a panel with specified areas to take in user input.
	 */
	public LoginPanel() {
		isManager = false;
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		user = new JLabel("Username: ");
		pass = new JLabel("Password: ");
		username = new JTextField();
		password = new JPasswordField();

		add(user);
		add(username);
		add(pass);
		add(password);
	}
	/**
	 * Gets the text inputted in the first text field
	 * @return the user name of the account to be accessed
	 */
	public String getUsername() {
		return username.getText();
	}
	/**
	 * Gets the text inputted in the second text field
	 * @return the password of the account to be accessed
	 */
	public String getPassword() {
		return new String(password.getPassword());
	}
	/**
	 * Returns whether or not the login type is manager or guest
	 * @return true if manager access, false if guest access
	 */
	public boolean isManager() {
		return isManager;
	}
	/**
	 * Sets login type to either manager or guest using boolean flag
	 * @param b boolean to determine type of login
	 */
	public void manager(boolean b) {
		isManager = b;
	}
}
