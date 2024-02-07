package ATM;

import java.util.Scanner;

public abstract class Deposit implements Transaction {
	
	public static void deposit(double balance) {
		
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter amount to deposit: ");
	    double amount = scanner.nextDouble();

	    balance += amount;
	    System.out.println("Deposit successful. Current balance: $" + balance);
	    
	    scanner.close();
	}
}

