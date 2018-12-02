import java.util.*;

public class Guest {
	private ArrayList<Account> accounts;
	
	public Guest(){
		accounts = new ArrayList<Account>();
	}
	
	public addGuest(Account a){
		accounts.add(a);
	}
}
