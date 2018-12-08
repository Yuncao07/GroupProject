import java.io.*;
import java.util.*;

public class Guest implements Serializable {
	private static final String filename = "reservations.txt";
	public static Guest guest = null;

	static {
		try {
			FileInputStream fileStream = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fileStream);
			guest = (Guest) inputStream.readObject();

			inputStream.close();
			fileStream.close();
		} catch (IOException e) {
			if (guest == null)
				guest = new Guest();
		} catch (ClassNotFoundException e) {
			if (guest == null)
				guest = new Guest();
		}
	}

	public static void writeToFile() {
		try {
			File outputFile = new File(filename);
			outputFile.createNewFile();
			FileOutputStream fileOut = new FileOutputStream(outputFile);
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);

			outputStream.writeObject(guest);

			outputStream.close();
			fileOut.close();
		} catch (IOException e) {
		}
	}

	private ArrayList<Account> accounts;

	private Guest() {
		accounts = new ArrayList<Account>();
	}

	public void addGuest(Account a) {
		accounts.add(a);
	}

	public boolean verify(String username, String password) {
		boolean accessible = false;
		for (Account a : accounts) {
			if (a.getID().equals(username) && a.getPassword().equals(password)) {
				accessible = true;
			}
		}
		return accessible;
	}

	public ArrayList<Account> getGuests() {
		return accounts;
	}

	public Account getAccount(String username, String password) {
		Account acct = null;
		for (Account a : accounts) {
			if (a.getID().equals(username) && a.getPassword().equals(password)) {
				acct = a;
			}
		}
		return acct;
	}
}