package banking;

import java.util.Scanner;

public class Transfer implements Transaction{

    public static void transfer(User user) {
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
    }

    private static void transferFromCheckingsToSavings(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= user.getCheckingBalance()) {
            user.setCheckingBalance(user.getCheckingBalance() - amount);
            System.out.println("Transfer successful. New checkings balance: $" + user.getCheckingBalance());

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

        //User savingsAccount = Savings(user);

        if (amount <= user.getSavingsBalance()) {
            user.setSavingsBalance(user.getSavingsBalance() - amount);
            System.out.println("Transfer successful. New savings account balance: $" + user.getSavingsBalance());

            // Update checking account balance
            user.setCheckingBalance(user.getCheckingBalance() + amount);
            System.out.println("New checking account balance: $" + user.getCheckingBalance());
        } else {
            System.out.println("Error: Insufficient funds in savings account");
        }
    }

    /*private static User Savings(User user) {
        // Assuming the savings account is created with the same name as the checking account
        String savingsAcct = user.getName() + "_savings";

        User savingsAccount = new User(1000.0, savingsAcct);
        // You can add additional code here to retrieve the actual savings account from a database or another source

        return savingsAccount;
    }*/
}
