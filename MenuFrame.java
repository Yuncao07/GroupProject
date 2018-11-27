import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
	JPanel guest,main, reserveChoice, managerOptions;
	LoginPanel login;
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
			login.manager(false);
			getContentPane().removeAll();
			getContentPane().add(guest);
			revalidate();
			repaint();
			pack();
		});
		
		managerButton.addActionListener(event -> 			//moves user to manager section of program
		{
			login.manager(true);
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(event -> {
			//get text from text area and checking flag for manager
			if(login.isManager()) {
				getContentPane().removeAll();
				getContentPane().add(managerOptions); //go to jpanel with manager options
			}
			else {
				getContentPane().removeAll();
				getContentPane().add(reserveChoice);
			}
			revalidate();
			repaint();
			pack();
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
		
		createAccount.addActionListener(event -> {			//directs user to log in
			//get text info and create a new account
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		
		supanel.add(createAccount);
		guest.add(signIn);
		guest.add(signUp);
		
		reserveChoice = new JPanel();
		JButton make = new JButton("Make Reservation"), viewOrCancel = new JButton("View/Cancel Reservation");
		
		make.addActionListener(event ->{			//make a reservation
			getContentPane().removeAll();
			getContentPane().add(new JPanel()); //add reservation date here
			revalidate();
			repaint();
			pack();
		});
		
		viewOrCancel.addActionListener(event ->{	//allow this guest to check reservations and cancel if needed
			
		});
		
		reserveChoice.add(make);
		reserveChoice.add(viewOrCancel);
		
		managerOptions = new JPanel();
		JButton load = new JButton("Load"), view = new JButton("View"), save = new JButton("Save"), quit = new JButton("Quit");
		
		load.addActionListener(event ->{
			//load from text
		});
		
		view.addActionListener(event ->{
			//display mvc view of reservations
		});
		
		save.addActionListener(event ->{
			//write to text file of reservations
		});
		
		quit.addActionListener(event ->{
			System.exit(0);
		});
		
		managerOptions.add(load);
		managerOptions.add(view);
		managerOptions.add(save);
		managerOptions.add(quit);
		
		main.add(BorderLayout.NORTH,new JLabel("Select user type below"));
		main.add(BorderLayout.WEST,guestButton);
		main.add(BorderLayout.EAST,managerButton);
		
		getContentPane().add(main);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
