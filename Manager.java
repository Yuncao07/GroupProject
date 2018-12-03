import java.util.ArrayList;

public class Manager {
	private ArrayList<Account> accounts;
	
	public Manager() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account("admin","password","default")); //add a default manager because there is no create manager account for this project
	}
	
	public void add(Account a) {
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
