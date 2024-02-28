package banking; 
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.io.File;  // Import the File class
import java.io.IOException;

public class LoginReg implements Serializable{
	public String usern;
    public String pass;
    public int account;

    public LoginReg(String usern, String pass, int account) {
        this.usern = pass;
        this.pass = pass;
        this.account = account;
    }
    static HashMap<String, String> users = new HashMap<String, String>();
	//static Map<String, ArrayList<String>> users = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Select an option: ");
            System.out.println("1. Register new user");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            
            }
             try{
            	FileInputStream readData = new FileInputStream("userLogin.ser");
            	ObjectInputStream readStream = new ObjectInputStream(readData);

            	HashMap<String, String> users2 = users;
                readStream.readObject();

                //readStream.close();

       
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
          
        }
        scanner.close();
    }

    static void registerUser(Scanner scanner) {
    	Random random = new Random();
        System.out.println("\nPlease Fill Out This Registration Form");
        System.out.println("-----------------");
        
        // Get username
        System.out.print("Create a Username: ");
        String username = scanner.nextLine();
       
        
        while (true) { 
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
       // int randomNumber = random.nextInt(900) + 100;
        
        users.put(username, password); 
       // users.get(username).add(Integer.toString(randomNumber)); 
        
        try{
            FileOutputStream writeData = new FileOutputStream("userLogin.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(users);
            writeStream.flush();
            writeStream.close();

        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nRegistration successful.\n");
        break; 
        }
      
        
    }
      

    static void loginUser(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        
        if (!users.containsKey(username)) {
            System.out.println("Invalid username.\n");
        } 
        else {
            if (users.get(username).equals(password)) {
                System.out.println("Login successful.\n");
            } 
            else { 
                System.out.println("Invalid username or password.\n");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Users{" +
                "Username='" + usern + '\'' +
                ", lastName='" + pass+ '\'' +
                ", birthYear=" + account +
                "}\n";
    }
}
