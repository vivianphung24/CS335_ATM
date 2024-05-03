package banking;
import java.util.Scanner;

public abstract class Withdraw {
	
	public static double withdraw(User user) {
		
	    Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select an account to withdraw from: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		int choice = scanner.nextInt();
		 
		
		switch (choice) {
		case 1: 
			withdrawCheckings(user); 
			break; 
		case 2: 
			withdrawSavings(user); 
			break; 
		default:
            System.out.println("Error: Invalid choice");
		}
         return 0;
		
		}
	private static void withdrawCheckings(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount to withdraw: ");
	    double amount = scanner.nextDouble();
	    
	    double balance = user.getCheckingBalance();
	    
			if (amount > balance) {
		        System.out.println("Insufficient funds.");
		    } else {
		        double newBalance = balance - amount;
		        user.setCheckingBalance(newBalance);
		        System.out.println("Withdrawal successful. \nRemaining balance: $" + user.getCheckingBalance());
		        user.addTransaction("Withdrawn from Checkings Account: $" + amount); 
		     	}
        	} 
		

	private static void withdrawSavings(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount to withdraw: ");
	    double amount = scanner.nextDouble();
	   
	    double balance = user.getSavingsBalance();
	    
			if (amount > balance) {
		        System.out.println("Insufficient funds.");
		    } else {
		        double newBalance = balance - amount;
		        user.setSavingsBalance(newBalance);
		        System.out.println("Withdrawal successful. \nRemaining balance: $" + user.getSavingsBalance());
		        user.addTransaction("Withdrawn from Savings Account: $" + amount); 
		     	}
        	} 
		
	

}
