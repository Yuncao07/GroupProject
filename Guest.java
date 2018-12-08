import java.util.*;
/**
 * Class that stores all accounts made and checks for accessibility to
 * a certain account
 * @author
 *
 */
public class Guest {
	public static final Guest guest = new Guest();
	private ArrayList<Account> accounts;
	/**
	 * Constructs this class with a new account storage
	 */
	private Guest(){
		accounts = new ArrayList<Account>();
	}
	/**
	 * Adds an account to the list of accounts held by this object
	 * @param a the account to be added to the list
	 */
	public void addGuest(Account a){
		accounts.add(a);
	}
	/**
	 * Checks to see whether or not user can access a specific account
	 * @param username ID of the account
	 * @param password the accessor of the account
	 * @return true if access is allowed, false otherwise
	 */
	public boolean verify(String username,String password) {
		boolean accessible = false;
		for(Account a : accounts) {
			if(a.getID().equals(username) && a.getPassword().equals(password)) {
				accessible = true;
			}
		}
		return accessible;
	}
	/**
	 * Returns the list of accounts 
	 * @return list of accounts
	 */
	public ArrayList<Account> getGuests(){
		return accounts;
	}
	/**
	 * Finds account given a username and password
	 * @param username the ID of the account
	 * @param password the accessor of the account
	 * @return an account if it exists, null otherwise
	 */
	public Account getAccount(String username,String password) {
		Account acct = null;
		for(Account a : accounts) {
			if(a.getID().equals(username) && a.getPassword().equals(password)) {
				acct = a;
			}
		}
		return acct;
	}
}
