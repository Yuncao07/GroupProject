import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;
/**
 * This class sets up all required panels and storages in which users can move between panels and
 * guest users may book reservations which will be stored, and managers can access storage and view
 * them in two different ways.
 * @author Steven Tang
 *
 */
public class MenuFrame extends JFrame{
	private JPanel guest,main, initial, reserveChoice, receiptChoice, managerOptions, managerView;
	private LoginPanel login;
	private SignUpPanel supanel;
	private JButton guestButton, managerButton, cancel;
	private DatePanel datePicking;
	private ReservationPanel reservePanel;
	private Account current;
	private ReservationViewCancel viewCancel;
	
	/**
	 * This creates a menu that the user can move around the program with.
	 */
	public MenuFrame(){
		login = new LoginPanel(); //panel when manager button is pressed
		initial = new JPanel();
		guest = new JPanel(); //panel when guest button is pressed
		main = new JPanel(); //panel that opens first
		
		
		
		main.setLayout(new BorderLayout());
		
		//---------------------------------------------------------------------------------------------------
		
		guestButton = new JButton("Guest Login");
		managerButton = new JButton("Manager Login");
		
		guestButton.addActionListener(event -> {			//moves user to guest section of program
			login.manager(false);
			getContentPane().removeAll();
			getContentPane().add(guest);
			revalidate();
			repaint();
			pack();
		});
		
		managerButton.addActionListener(event -> {			//moves user to manager section of program
			login.manager(true);
			getContentPane().removeAll();
			getContentPane().add(managerOptions);
			revalidate();
			repaint();
			pack();
		});
		
		//-----------------------------------------------------------------------------------------------------
		
		JButton loginButton = new JButton("Log in");
		loginButton.addActionListener(event -> {
			String user = login.getUsername();
			String pass = login.getPassword();
			if(login.isManager()) {
				getContentPane().removeAll();
				getContentPane().add(managerOptions); //go to jpanel with manager options
			}
			else {
				if(Guest.guest.verify(user, pass)) {
					current = Guest.guest.getAccount(user, pass);
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
			Guest.guest.addGuest(new Account(supanel.getUser(),supanel.getPass(),supanel.getName()));
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
			viewCancel = new ReservationViewCancel(current.getReservationList()) {
				@Override
				public void returnToHome() {
					getContentPane().removeAll();
					getContentPane().add(initial);
					revalidate();
					repaint();
					pack();
				}

				@Override
				public void cancelReservationsOnDay(LocalDate date) {
					Guest.guest.cancelReservations(current, date);
					Guest.guest.writeToFile();
				}
			};
			getContentPane().removeAll();
			getContentPane().add(viewCancel);
			revalidate();
			repaint();
			pack();
		});
		
		reserveChoice.add(make);
		reserveChoice.add(viewOrCancel);
		
		//---------------------------------------------------------------------------------------------------------
		
		datePicking = new DatePanel();
		
		datePicking.addListenerToSEButton(event -> {		//user selected economic room
			RoomList.roomList.luxRoom(false);
		});
		
		datePicking.addListenerToSLButton(event -> {		//user selected luxurious room
			RoomList.roomList.luxRoom(true);
		});
		
		datePicking.addListenerToSButton(event -> {	//show available rooms
			LocalDate startDate = DateInput.parseDate(datePicking.getStart());
			LocalDate endDate = DateInput.parseDate(datePicking.getEnd());
			if (startDate != null && endDate != null) {
				if (DateReservation.allowedDates(startDate, endDate)){
					RoomList.roomList.setDateReservation(new DateReservation(startDate, endDate));
					getContentPane().removeAll();
					getContentPane().add(reservePanel); //add reservation date here
					revalidate();
					repaint();
					pack();
				}  else {
					JOptionPane.showMessageDialog(this, "Stay cannot be longer than 60 nights.");
				}
			}  else {
				JOptionPane.showMessageDialog(this, "Invalid date has been entered.");
			}
		});
		
		//---------------------------------------------------------------------------------------------------------
		
		reservePanel = new ReservationPanel(RoomList.roomList);
		JButton confirm = new JButton("Confirm"),
					more = new JButton("More Reservations"),
					done = new JButton("Done"),
					econ = new JButton("$100"),
					lux = new JButton("$300"),
					change = new JButton("Confirm Change of Date");
		
		confirm.addActionListener(event -> {			//add to list of reservations made by person
			Reservation reservation = new Reservation();
			Integer roomNumber = reservePanel.getRoomNum();
			if (roomNumber == null || RoomList.roomList.getRoom(roomNumber) == null) return;
			// Arrays start at 0
			reservation.addRoom(RoomList.roomList.getRoom(roomNumber), RoomList.roomList.getDateReservation());

			current.reserve(reservation);
			Guest.guest.writeToFile();
		});
		
		more.addActionListener(event -> {			//move back to date picking panel
			getContentPane().removeAll();
			getContentPane().add(datePicking); 
			revalidate();
			repaint();
			pack();
		});
		
		done.addActionListener(event ->{		//move onto reciept	
			getContentPane().removeAll();
			getContentPane().add(receiptChoice); 
			revalidate();
			repaint();
			pack();
		});
		econ.addActionListener(event ->{
			RoomList.roomList.luxRoom(false);
			repaint();
		});
		
		lux.addActionListener(event ->{
			RoomList.roomList.luxRoom(true);
			repaint();
		});
		JPanel container = new JPanel();
		JTextField sDate = new JTextField(), eDate = new JTextField();
		container.setLayout(new GridLayout(3,3));
		container.add(new JLabel("Start/End Date Change:"));
		
		change.addActionListener(event ->{
			//change date and notify
			if(DateInput.parseDate(sDate.getText()) != null && DateInput.parseDate(eDate.getText()) != null) {
				if(DateReservation.allowedDates(DateInput.parseDate(sDate.getText()),DateInput.parseDate(eDate.getText()))){
					RoomList.roomList.setDateReservation(new DateReservation(DateInput.parseDate(sDate.getText()),DateInput.parseDate(eDate.getText())));
				}
				else {
					JOptionPane.showMessageDialog(this, "Invalid date entered, no changes have been made.");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid date entered, no changes have been made.");
			}
		});
		
		container.add(sDate);
		container.add(eDate);
		container.add(econ);
		container.add(lux);
		container.add(change);
		container.add(confirm);
		container.add(more);
		container.add(done);
		reservePanel.add(container,BorderLayout.SOUTH);
		
		//---------------------------------------------------------------------------------------------------------
		
		receiptChoice = new JPanel();
		JButton simple = new JButton("Simple"), comprehensive = new JButton("Comprehensive");
		simple.addActionListener(event -> showReceipt(new SimpleReceipt(current)));
		comprehensive.addActionListener(event -> showReceipt(new ComprehensiveReceipt(current)));

		receiptChoice.add(new JLabel("Choose a type of receipt:"));
		receiptChoice.add(simple);
		receiptChoice.add(comprehensive);

		
		//---------------------------------------------------------------------------------------------------------
		managerOptions = new JPanel();
		JButton load = new JButton("Load"), view = new JButton("View"), save = new JButton("Save"), quit = new JButton("Quit");
		
		load.addActionListener(event ->{
			//load from text
			
		});
		
		managerView = new JPanel();
		managerView.setLayout(new BorderLayout());
		
		view.addActionListener(event ->{
			getContentPane().removeAll();
			getContentPane().add(new AvailableRoomViewPanel(RoomList.roomList), BorderLayout.NORTH);
			getContentPane().add(new ClickableRoomPanel(),BorderLayout.SOUTH);
			revalidate();
			repaint();
			pack();
			//add room clickable panel here with BorderLaybout.SOUTH
		});
		
		save.addActionListener(event ->{
			Guest.guest.writeToFile();
			//write to text file of reservations
		});
		
		quit.addActionListener(event ->{
			//save then quit
			Guest.guest.writeToFile();
			System.exit(0);
		});
		
		managerOptions.add(load);
		managerOptions.add(view);
		managerOptions.add(save);
		managerOptions.add(quit);
		
		//---------------------------------------------------------------------------------------------------------
		
		main.add(BorderLayout.NORTH,new JLabel("Select user type below"));
		main.add(initial, BorderLayout.CENTER);
		initial.add(guestButton);
		initial.add(managerButton);
		
		getContentPane().add(main);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void showReceipt(Receipt receipt) {
		JFrame receiptFrame = new JFrame();
		ReceiptPanel receiptPanel = new ReceiptPanel(receipt);
		receiptPanel.addListener(event -> { //make the button in receipt panel to return to main menu
			current = null;
			getContentPane().removeAll();
			getContentPane().add(main);
			revalidate();
			repaint();
			pack();

			receiptFrame.setVisible(false);
		});

		receiptFrame.add(receiptPanel);
		receiptFrame.pack();
		receiptFrame.setVisible(true);
		receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
