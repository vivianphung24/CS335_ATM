package ATM;

public abstract class CheckBalance implements Transaction {
	
	public static void checkBalance(User user) {
		System.out.println("Your balance is: $" + user.getBalance());
	}
	
}
