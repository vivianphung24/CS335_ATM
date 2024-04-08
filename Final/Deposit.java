package banking;

import java.util.Scanner;

public abstract class Deposit {
	
	public static double deposit(User user) {
		
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Select an account to deposit to: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		int choice = scanner.nextInt();
		
		System.out.println("Enter amount to deposit: ");
	    double amount = scanner.nextDouble();
		
		if (choice == 1) {
			double balance = user.getCheckingBalance();
			double newBalance = balance + amount;
			user.setCheckingBalance(newBalance);
		    System.out.println("Deposit successful. Current balance: $" + user.getCheckingBalance());
		    user.addTransaction("Deposit to Checking Account: $" + amount); // Add the transaction to the transaction history
        } else if (choice == 2) {
        	double balance = user.getSavingsBalance();
        	double newBalance = balance + amount;
			user.setSavingsBalance(newBalance);
    	    System.out.println("Deposit successful. Current balance: $" + user.getSavingsBalance());
    	    user.addTransaction("Deposit to Savings Account: $" + amount); // Add the transaction to the transaction history
        } else {
            System.out.println("Error: Invalid account choice");
        }
	    
		return 0;
	}
}
