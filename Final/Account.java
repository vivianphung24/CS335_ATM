package banking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Account {

    public static void main(String[] args) {
    	
    	System.out.println("Select an Account");
    	
    	Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        User user = new User(1000.0, null);

        while (!quit) {
        	System.out.println("1. Checkings Account");
            System.out.println("2. Savings Account");
            System.out.print("Enter your choice: ");
            try {

            	int choice = scanner.nextInt();

            	switch (choice) {
                	case 1:
                		System.out.println("Checkings");
                		break;
                	case 2:
                		System.out.println("Savings");
                		break;
                	case 3:
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