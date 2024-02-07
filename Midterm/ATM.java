package ATM;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        
        User user = new User(1000.0);

        while (!quit) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CheckBalance.checkBalance(user.getBalance());
                    break;
                case 2:
                    Withdraw.withdraw(user.getBalance());
                    break;
                case 3:
                    Deposit.deposit(user.getBalance());
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Error, enter a valid choice");
            }

            System.out.println();
        }

        System.out.println("Thank you for using the ATM");
        scanner.close();
    }
}
