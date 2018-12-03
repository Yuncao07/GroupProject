import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame{
	private JPanel guest,main, reserveChoice, managerOptions;
	private LoginPanel login;
	private SignUpPanel supanel;
	private JButton guestButton,managerButton;
	private Guest guestList;
	private Manager managerList;
	private DatePanel datePicking;
	private ReservationPanel reservePanel;
	
	
	public MenuFrame(){
		login = new LoginPanel(); //panel when manager button is pressed
		guest = new JPanel(); //panel when guest button is pressed
		main = new JPanel(); //panel that opens first
		guestList = new Guest();
		managerList = new Manager();
		
		main.setLayout(new BorderLayout());
		
		//---------------------------------------------------------------------------------------------------
		
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
		
		//-----------------------------------------------------------------------------------------------------
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(event -> {
			if(login.isManager()) {
				if(managerList.verify(login.getUsername(), login.getPassword())) {
					getContentPane().removeAll();
					getContentPane().add(managerOptions); //go to jpanel with manager options
				}
				else {
					JOptionPane.showMessageDialog(this, "Incorrect user name or password or account does not exist.");
				}
			}
			else {
				if(guestList.verify(login.getUsername(), login.getPassword())) {
					getContentPane().removeAll();
					getContentPane().add(reserveChoice);
				}
				else {
					JOptionPane.showMessageDialog(this, "Incorrect user name or password or account does not exist.");
				}
			}
			revalidate();
			repaint();
			pack();
		});
		login.add(loginButton);
		
		//--------------------------------------------------------------------------------------------------------
		
		JButton signIn = new JButton("Sign In"), signUp = new JButton("Sign up");
		
		signIn.addActionListener(event -> {					//directs user to log in
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		
		//---------------------------------------------------------------------------------------------------------
		
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
			guestList.add(new Account(supanel.getUser(),supanel.getPass(),supanel.getName()));
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
			pack();
		});
		supanel.add(createAccount);
		
		guest.add(signIn);
		guest.add(signUp);
		
		//---------------------------------------------------------------------------------------------------------
		
		reserveChoice = new JPanel();
		JButton make = new JButton("Make Reservation"), viewOrCancel = new JButton("View/Cancel Reservation");
		
		make.addActionListener(event ->{			//make a reservation
			getContentPane().removeAll();
			getContentPane().add(datePicking); //add reservation date here
			revalidate();
			repaint();
			pack();
		});
		
		viewOrCancel.addActionListener(event ->{	//allow this guest to check reservations and cancel if needed
			
		});
		
		reserveChoice.add(make);
		reserveChoice.add(viewOrCancel);
		
		//---------------------------------------------------------------------------------------------------------
		
		datePicking = new DatePanel();
		
		datePicking.addListenerToSEButton(event ->{		//user selected economic room
			//selection here
		});
		
		datePicking.addListenerToSLButton(event ->{		//user selected luxurious room
			//selection here
		});
		
		datePicking.addListenerToSButton(event ->{	//show available rooms
			getContentPane().removeAll();
			getContentPane().add(reservePanel); //add reservation date here
			revalidate();
			repaint();
			pack();
		});
		
		//---------------------------------------------------------------------------------------------------------
		
		reservePanel = new ReservationPanel();
		JButton confirm = new JButton("Confirm"), more = new JButton("More Reservations"), done = new JButton("Done");
		
		confirm.addActionListener(event ->{			//add to list of reservations made by person
			//add to list of reservations
		});
		
		more.addActionListener(event ->{			//move back to date picking panel
			getContentPane().removeAll();
			getContentPane().add(datePicking); 
			revalidate();
			repaint();
			pack();
		});
		
		done.addActionListener(event ->{		//move onto reciept	
			getContentPane().removeAll();
			getContentPane().add(new JPanel()); 
			revalidate();
			repaint();
			pack();
		});
		
		reservePanel.add(confirm);
		reservePanel.add(more);
		reservePanel.add(done);
		
		//---------------------------------------------------------------------------------------------------------
		
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
		
		//---------------------------------------------------------------------------------------------------------
		
		main.add(BorderLayout.NORTH,new JLabel("Select user type below"));
		main.add(BorderLayout.WEST,guestButton);
		main.add(BorderLayout.EAST,managerButton);
		
		getContentPane().add(main);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}