package banking;

import java.util.Scanner;

public abstract class Deposit implements Transaction {
	
	public static void deposit(User user) {
		
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter amount to deposit: ");
	    double amount = scanner.nextDouble();
	    double balance = user.getBalance();

	    balance += amount;
	    System.out.println("Deposit successful. Current balance: $" + balance);
	    
	}
}