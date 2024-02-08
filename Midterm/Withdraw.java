package ATM;

import java.util.Scanner;

public abstract class Withdraw implements Transaction {
	
	public static void withdraw(User user) {
		
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter amount to withdraw: ");
	    double amount = scanner.nextDouble();
	    double balance = user.getBalance();

		if (amount > balance) {
	        System.out.println("Insufficient funds.");
	    } else {
	        balance -= amount;
	        System.out.println("Withdrawal successful. Remaining balance: $" + user.getBalance());
	    }
		
	}
	
}
