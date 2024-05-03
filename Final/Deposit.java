package banking; 

import java.util.Scanner;

public abstract class Deposit {
	
	public static double deposit(User user) {
		
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Select an account to deposit to: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		int choice = scanner.nextInt();
		//scanner.close(); 
		switch (choice) {
		case 1:
            DepositFromCheckingsToSavings(user);
            break;
        case 2:
            DepositFromSavingsToCheckings(user);
            break;
        default:
            System.out.println("Error: Invalid choice");
    }
	return 0;
}
			
		
	private static void DepositFromCheckingsToSavings(User user) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter amount to deposit: ");
			//scanner.close(); 
			double amount = scanner.nextDouble();
			double balance = user.getCheckingBalance();
			double newBalance = balance + amount;
			user.setCheckingBalance(newBalance);
		    System.out.println("Deposit successful. \nCurrent balance: $" + user.getCheckingBalance());
		    user.addTransaction("Deposit to Checking Account: $" + amount); // Add the transaction to the transaction history
        } 
	private static void DepositFromSavingsToCheckings(User user) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter amount to deposit: ");
			//scanner.close(); 
			double amount = scanner.nextDouble();
        	double balance = user.getSavingsBalance();
        	double newBalance = balance + amount;
			user.setSavingsBalance(newBalance);
    	    System.out.println("Deposit successful. \nCurrent balance: $" + user.getSavingsBalance());
    	    user.addTransaction("Deposit to Savings Account: $" + amount); // Add the transaction to the transaction history
   
	}
}
