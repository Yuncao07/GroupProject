import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
	JPanel login,guest,main;
	JButton guestButton,managerButton;
	
	public MenuFrame(){
		login = new LoginPanel(); //panel when manager button is pressed
		guest = new JPanel(); //panel when guest button is pressed
		main = new JPanel(); //panel that opens first
		
		
		main.setLayout(new BorderLayout());
		
		guestButton = new JButton("Guest Login");
		managerButton = new JButton("Manager Login");
		
		guestButton.addActionListener(event -> 				//moves user to guest section of program
		{
			getContentPane().removeAll();
			getContentPane().add(guest);
			revalidate();
			repaint();
			pack();
		});
		
		managerButton.addActionListener(event -> 			//moves user to manager section of program
		{
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(event -> {
			//get text from text areas
			//
		});
		login.add(loginButton);
		
		JButton signIn = new JButton("Sign In"), signUp = new JButton("Sign up");
		
		signIn.addActionListener(event -> {					//directs user to log in
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		
		JPanel supanel = new SignUpPanel();
		JButton createAccount = new JButton("Create Account");
		
		signUp.addActionListener(event -> {					//directs user to create a new account
			getContentPane().removeAll();
			getContentPane().add(supanel);
			revalidate();
			repaint();
			pack();
		});
		
		createAccount.addActionListener(event -> {
			//get text info and create a new account
		});
		
		supanel.add(createAccount);
		guest.add(signIn);
		guest.add(signUp);
		
		main.add(BorderLayout.NORTH,new JLabel("Select user type below"));
		main.add(BorderLayout.WEST,guestButton);
		main.add(BorderLayout.EAST,managerButton);
		
		getContentPane().add(main);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
