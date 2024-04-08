package banking;

import java.util.Scanner;

public abstract class Withdraw {
	
	public static double withdraw(User user) {
		
	    Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select an account to withdraw from: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		int choice = scanner.nextInt();
		
		System.out.println("Enter amount to withdraw: ");
	    double amount = scanner.nextDouble();
		
		if (choice == 1) {
			double balance = user.getCheckingBalance();
			if (amount > balance) {
		        System.out.println("Insufficient funds.");
		    } else {
		        double newBalance = balance - amount;
		        user.setCheckingBalance(newBalance);
		        System.out.println("Withdrawal successful. Remaining balance: $" + user.getCheckingBalance());
		        user.addTransaction("Withdrawn from Checkings Account: $" + amount); 
		        return(amount);
		    }
        } else if (choice == 2) {
        	double balance = user.getSavingsBalance();
			if (amount > balance) {
		        System.out.println("Insufficient funds.");
		    } else {
		        double newBalance = balance - amount;
		        user.setSavingsBalance(newBalance);
		        System.out.println("Withdrawal successful. Remaining balance: $" + user.getSavingsBalance());
		        user.addTransaction("Withdrawn from Savings Account: $" + amount); 
		        return(amount);
		    }
        } else {
            System.out.println("Error: Invalid account choice");
            // return;
        }
	    
		return 0;
		
	}
	
}
