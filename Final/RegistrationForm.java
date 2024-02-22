package banking; 
import java.util.Random;
import java.util.Scanner;

public class RegistrationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Array to store user details
        String[][] users = new String[10][3];
        int userCount = 0;
        System.out.println("Please Fill Out This Registration Form");
        System.out.println("-----------------");
     
        while (true) {  
            // Get username
            System.out.print("Create a Username: ");
            String username = scanner.nextLine();
            
            // Get password
            System.out.print("Create a Password: ");
            String password = scanner.nextLine();
            
            // Validate password length
            if (password.length() < 8) {
                System.out.println("Passwords must be at least 8 characters long.");
                continue;
            }
            
            // Confirm password
            System.out.print("Confirm Password: ");
            String confirmPassword = scanner.nextLine();
            
            // Check if passwords match
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match. Please try again.");
                continue;
            }
            
            // Generate random 3-digit number for the account number
            int randomNumber = random.nextInt(900) + 100;
            
            // Store details in user array
            users[userCount][0] = username;
            users[userCount][1] = password;
            users[userCount][2] = String.valueOf(randomNumber);
            userCount++;
            
            System.out.println("\nRegistration successful!");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Account Number: " + randomNumber);
            
            // Prompt for another registration
            System.out.print("\nDo you want to register another user? (yes/no): ");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        // Print all registered users
        System.out.println("\nRegistered Users:");
        System.out.println("-----------------");
        for (int i = 0; i < userCount; i++) {
            System.out.println("Username: " + users[i][0]);
            System.out.println("Password: " + users[i][1]);
            System.out.println("Account Number: " + users[i][2]);
            System.out.println("-----------------");
        }
        
        scanner.close();
    }
}
