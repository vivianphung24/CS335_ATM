package banking;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
// Import the File class
import java.io.*;

public class ATM {

    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Welcome to the Simmons Bank ATM!");
    	//User user = LoginReg2.loginUser(scanner);
    	User user = LoginReg2.getUser();

       

        System.out.println("What would you like to do today?");

        boolean quit = false;

        while (!quit) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            try {

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        CheckBalance.checkBalance(user);
                        break;
                    case 2:
                        double withdrawAmount = Withdraw.withdraw(user);
                       
                        break;
                    case 3:
                        double depositAmount = Deposit.deposit(user);
                      
                        break;
                    case 4:
                    	double transferAmount = Transfer.transfer(user);
                        break;
                    case 5:
                    	viewTransactionHistory(user);
                        break;
                    case 6:
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
    
    public static void viewTransactionHistory(User user) {
        System.out.println("Transaction History:");
        List<String> transactionHistory = user.getTransactionHistory();
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
