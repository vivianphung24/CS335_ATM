package banking;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined username and password
        String username = "user1";
        String password = "randompass";

        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed. Invalid username or password");
        }

        scanner.close();
    }
}