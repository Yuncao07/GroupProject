import java.awt.*;
import javax.swing.*;

public class LoginPanel extends JPanel{
	private JLabel user,pass;
	private JTextField username;
	private JPasswordField password;
	
	public LoginPanel() {
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
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return new String(password.getPassword());
	}
}
