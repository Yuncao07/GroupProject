package Hotel;

public interface Receipt 
{
	String formatHeader();
	String formatRoom(Account acnt);
	String formatFooter();
}
