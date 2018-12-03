import java.util.*;

public class Guest {
	private ArrayList<Account> accounts;
	
	public Guest(){
		accounts = new ArrayList<Account>();
	}
	
	public addGuest(Account a){
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
}
