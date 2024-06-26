package banking;

import java.util.Scanner;

public class Transfer{

    public static double transfer(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select transfer type:");
        System.out.println("1. From Checkings to Savings");
        System.out.println("2. From Savings to Checkings");
        System.out.print("Enter your choice: ");

        int transferChoice = scanner.nextInt();
        
        switch (transferChoice) {
            case 1:
                transferFromCheckingsToSavings(user);
                break;
            case 2:
                transferFromSavingsToCheckings(user);
                break;
            default:
                System.out.println("Error: Invalid transfer choice");
        }
		return 0;
    }

    private static void transferFromCheckingsToSavings(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ");
         
        double amount = scanner.nextDouble();
        //scanner.close();
        if (amount <= user.getCheckingBalance()) {
            user.setCheckingBalance(user.getCheckingBalance() - amount);
            System.out.println("Transfer successful. \nNew checkings balance: $" + user.getCheckingBalance());
            user.addTransaction("Transfered from Checkings to Savings : $" + amount); 

            // Update savings account balance
            user.setSavingsBalance(user.getSavingsBalance() + amount);
            System.out.println("New savings balance: $" + user.getSavingsBalance());
        } else {
            System.out.println("Error: Insufficient funds in checkings account");
        }
    }

    private static void transferFromSavingsToCheckings(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to transfer: ");
        
        double amount = scanner.nextDouble();
        //scanner.close(); 
        //User savingsAccount = Savings(user);

        if (amount <= user.getSavingsBalance()) {
            user.setSavingsBalance(user.getSavingsBalance() - amount);
            System.out.println("Transfer successful. \nNew savings account balance: $" + user.getSavingsBalance());
            user.addTransaction("Transfered from Savings to Checkings : $" + amount); 

            // Update checking account balance
            user.setCheckingBalance(user.getCheckingBalance() + amount);
            System.out.println("New checking account balance: $" + user.getCheckingBalance());
        } else {
            System.out.println("Error: Insufficient funds in savings account");
        }
    }

   
}
         
