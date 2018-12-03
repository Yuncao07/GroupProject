import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
	JPanel guest,main, reserveChoice, managerOptions, buttons; //panels with only buttons
	SignUpPanel supanel;	//panel to create an account with
	LoginPanel login;	//panel to sign in and verify user
	
	public MenuFrame(){
		login = new LoginPanel(); //panel when manager button is pressed
		guest = new JPanel(); //panel when guest button is pressed
		main = new JPanel(); //panel that opens first
		buttons = new JPanel(); //panel contains the first 2 buttons
		
		
		main.setLayout(new BorderLayout());
		
		JButton guestButton = new JButton("Guest Login");
		JButton managerButton = new JButton("Manager Login");
		
		guestButton.addActionListener(event -> 				//moves user to guest section of program
		{
			login.manager(false);	//placeholder for manager/guest accounts
			getContentPane().removeAll();
			getContentPane().add(guest);
			revalidate();
			repaint();
			pack();
		});
		
		managerButton.addActionListener(event -> 			//moves user to manager section of program
		{
			login.manager(true);	//placeholder for manager/guest accounts
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
				getContentPane().add(managerOptions); //go to panel with manager options
			}
			else {
				getContentPane().removeAll();
				getContentPane().add(reserveChoice); //go to panel with guest options
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
		
		supanel = new SignUpPanel();
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
			getContentPane().add(new JPanel()); //add reservation date panel here (placeholder right now)
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
			//load reservations from text file
		});
		
		view.addActionListener(event ->{
			//display mvc view of reservations and return when done
		});
		
		save.addActionListener(event ->{
			//write to a file which holds reservation data
		});
		
		quit.addActionListener(event ->{		//closes program after saving data
			//save method here
			System.exit(0);
		});
		
		managerOptions.add(load);
		managerOptions.add(view);
		managerOptions.add(save);
		managerOptions.add(quit);
		
		main.add(BorderLayout.NORTH,new JLabel("Select user type below"));
		buttons.add(guestButton);
		buttons.add(managerButton);
		main.add(buttons, BorderLayout.CENTER); //I just think it looks nicer
		
		getContentPane().add(main);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
