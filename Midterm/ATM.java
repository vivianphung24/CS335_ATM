package ATM;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {
    
    public static void main(String[] args) {
    	System.out.println("Welcome to the Simmons Bank ATM!");
    	System.out.println("What would you like to do today?");
        
    	Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        User user = new User(1000.0);

        while (!quit) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            
            try {

            	int choice = scanner.nextInt();

            	switch (choice) {
                	case 1:
                		CheckBalance.checkBalance(user);
                		break;
                	case 2:
                		Withdraw.withdraw(user);
                		break;
                	case 3:
                		Deposit.deposit(user);
                		break;
                	case 4:
                		quit = true;
                		break;
                	default:
                		System.out.println("Error: Enter a valid choice");
                
            	}
            } catch (InputMismatchException e) {
            	System.out.println("Error: Invalid input. Please enter a number.");
            	scanner.nextLine();
            }

            System.out.println();
        }
        System.out.println("Thank you for using the ATM");
    }
}
