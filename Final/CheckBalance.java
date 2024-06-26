package banking;

import java.util.Scanner;

public abstract class CheckBalance {
	
	public static void checkBalance(User user) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nWhich account balance would you like to check?");
		System.out.println("1. Checking Account");
		System.out.println("2. Savings Account");
		int choice = sc.nextInt();
		//sc.close(); 
		if (choice == 1) {
			System.out.println("Your balance is: $" + user.getCheckingBalance());
        } else if (choice == 2) {
        	System.out.println("Your balance is: $" + user.getSavingsBalance());
        } else {
            System.out.println("Error: Invalid account choice");
            return;
        }
	}
	
}
