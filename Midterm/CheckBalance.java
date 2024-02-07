package ATM;

public abstract class CheckBalance implements Transaction {
	
	public static void checkBalance(double balance) {
		System.out.println("Your balance is: $" + balance);
	}
	
}
