import java.io.*;
import java.util.*;
/**
 * Class that allows storage and access of the users that have signed up in the program
 * as well as writing to a serialized file
 * @author Yun Cao
 *
 */
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
	/**
	 * Writes the list of guests into a serialized file
	 */
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
	/**
	 * Creates a new guest with storage for user accounts
	 */
	private Guest() {
		accounts = new ArrayList<Account>();
	}
	/**
	 * Adds an account to the list of guests signed up
	 * @param a account to be saved into data
	 */
	public void addGuest(Account a) {
		accounts.add(a);
	}
	/**
	 * Checks to see if the account can be accessed
	 * @param username user name to be checked against all accounts in list
	 * @param password string to be checked against all account password fields in list
	 * @return
	 */
	public boolean verify(String username, String password) {
		boolean accessible = false;
		for (Account a : accounts) {
			if (a.getID().equals(username) && a.getPassword().equals(password)) {
				accessible = true;
			}
		}
		return accessible;
	}
	/**
	 * Gets the list of accounts stored
	 * @return the list of accounts
	 */
	public ArrayList<Account> getGuests() {
		return accounts;
	}
	/**
	 * Returns an account using specified username and password given
	 * @param username username of account being accessed
	 * @param password password of account being accessed
	 * @return the account being accessed if password and username are verified, false otherwise
	 */
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