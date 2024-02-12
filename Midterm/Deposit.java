package ATM;

import java.util.Scanner;

public abstract class Deposit implements Transaction {
	
	public static void deposit(User user) {
		
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter amount to deposit: ");
	    double amount = scanner.nextDouble();
	    double balance = user.getBalance();

	    double newBalance = balance + amount;
	    user.setBalance(newBalance);
	    System.out.println("Deposit successful. Current balance: $" + user.getBalance());
	    
	}
}
