package banking;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {

    public static void main(String[] args) {

        System.out.println("Welcome to the Simmons Bank ATM!");

        System.out.println("Select an account:");
        System.out.println("1. Checkings Account");
        System.out.println("2. Savings Account");
        System.out.print("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int accountChoice = scanner.nextInt();

        User user;

        if (accountChoice == 1) {
            user = new User(1000.0, 0);          // for now, start off with 1000 in account were dealing with
        } else if (accountChoice == 2) {
            user = new User(0, 1000.0);
        } else {
            System.out.println("Error: Invalid account choice");
            return;
        }

        TransactionHistory transaction = new TransactionHistory(); // Create an instance of the Transaction class

        System.out.println("What would you like to do today?");

        boolean quit = false;

        while (!quit) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            try {

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        CheckBalance.checkBalance(user);
                        break;
                    case 2:
                        double withdrawAmount = Withdraw.withdraw(user);
                        transaction.addTransaction("Withdrawn: " + withdrawAmount); // Add the transaction to the Transaction object
                        break;
                    case 3:
                        double depositAmount = Deposit.deposit(user);
                        transaction.addTransaction("Deposited: " + depositAmount); // Add the transaction to the Transaction object
                        break;
                    case 4:
                        Transfer.transfer(user);
                        break;
                    case 5:
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

        transaction.printTransactions(); // Print all the transactions made by the user

        System.out.println("Thank you for using the ATM");
    }
}
