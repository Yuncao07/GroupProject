import java.util.*;

public class Guest {
	private ArrayList<Account> accounts;
	
	public Guest(){
		accounts = new ArrayList<Account>();
	}
	
	public void addGuest(Account a){
		accounts.add(a);
	}
	
	public boolean verify(String username,String password) {
		boolean accessible = false;
		for(Account a : accounts) {
			if(a.getID().equals(username) && a.getPassword().equals(password)) {
				accessible = true;
			}
		}
		return accessible;
	}
	
	public ArrayList<Account> getGuests(){
		return accounts;
	}
	
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
