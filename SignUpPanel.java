import javax.swing.*;
/**
 * The class is a Panel that allows users to sign up with the system. 
 */
public class SignUpPanel extends JPanel{
	private JLabel name,user,pass;
	private JTextField nameField,userField,passwordField;
	/**
	 * The constructor adds a couple of text fields for the users to enter their name, username and password to sign up.
	 */
	public SignUpPanel() {
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		name = new JLabel("Name");
		user = new JLabel("Username");
		pass = new JLabel("Password");
		
		nameField = new JTextField();
		userField = new JTextField();
		passwordField = new JTextField();
		
		add(name);
		add(nameField);
		add(user);
		add(userField);
		add(pass);
		add(passwordField);
	}
	
	/**
	 * @return the name of the user
	 */
	public String getName() {
		return nameField.getText();
	}
	
	/**
	 * @return the username of the user
	 */
	public String getUser() {
		return userField.getText();
	}
	
	/**
	 * @return the password of the user
	 */
	public String getPass() {
		return passwordField.getText();
	}
}
