import javax.swing.*;

public class SignUpPanel extends JPanel{
	private JLabel name,user,pass;
	private JTextField nameField,userField,passwordField;
	
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
	
	public String getName() {
		return nameField.getText();
	}
	public String getUser() {
		return userField.getText();
	}
	public String getPass() {
		return passwordField.getText();
	}
}
