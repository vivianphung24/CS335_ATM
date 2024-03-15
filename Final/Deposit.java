package banking;

import java.util.Scanner;

public abstract class Deposit implements Transaction {
	
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
        } else if (choice == 2) {
        	double balance = user.getSavingsBalance();
        	double newBalance = balance + amount;
			user.setSavingsBalance(newBalance);
    	    System.out.println("Deposit successful. Current balance: $" + user.getCheckingBalance());
        } else {
            System.out.println("Error: Invalid account choice");
        }
	    
		return 0;	 	    
	  
	}
}
