package banking;
import java.io.*;
import java.util.*;

public class LoginReg2{
    private String usern;
    private String pass;
    private int account;

    public LoginReg2(String usern, String pass, int account) {
        this.usern = usern;
        this.pass = pass;
        this.account = account;
       
    }

    static Map<String, String> users = new HashMap<>();
    
    static FileOutputStream fileOut = null;
    static FileInputStream fileIn = null;
    static Properties props = new Properties();
    static File ufile = new File ("/Users/nyah/eclipse-workspace/ATM_1/src/ATM/accounts.properties"); 

    public static void main(String[] args) throws IOException {
    	
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
                    /**if (loginUser(scanner)) {
                        ATM.main(args);
                        return;**/
                	
                	User user = loginUser(scanner);
                	if (user != null) {
                		System.out.println("Welcome, " + user.getName() + "!");
                		ATM.main(args);
                		return;
                	}
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            try {
               // FileInputStream readData = new FileInputStream(ufile);
               // ObjectInputStream readStream = new ObjectInputStream(readData);
            	fileIn =new FileInputStream(ufile); 
            	props.load(fileIn);
            	fileIn.close(); 
            
                //users = (HashMap<String, String>) readStream.readObject();

                //readStream.close();
            } catch (IOException e) {
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
            
            User user = new User(0,0);   //might change later to make them make a deposit at registration
            user.setName(username);
            user.setPassword(password);
            users.put(username, password);
            

            try {
                
                fileIn = new FileInputStream(ufile);
                props.load(fileIn);
                props.putAll(users);
                fileOut = new FileOutputStream(ufile,true);
                props.store(fileOut, "usernames");
                fileIn.close(); 
                fileOut.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("\nRegistration successful.\n");
            break;
        }
    }

    static User loginUser(Scanner scanner) throws IOException {
    	fileIn =new FileInputStream(ufile); 
    	props.load(fileIn);
    	fileIn.close(); 
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        
        /**if (!props.containsKey(username)) {
            System.out.println("Invalid username.\n");
        } else {
            if (props.get(username).equals(password)) {
                System.out.println("Login successful.\n");
                return true;
            } else {
                System.out.println("Invalid username or password.\n");
            }
        }
        return false;**/
        
        if (users.containsKey(username)) {
        	User user = null;       // have to read in from file their account information
        	user.setName(username);
        	if (user.getPassword().equals(password)) {
        		System.out.println("Login successful.\n");
        		return user;
        	}
        	
        }
        System.out.println("Invalid username or password.\n");
        return null;
        
    }

    @Override
    public String toString() {
        return "Users{" +
                "Username='" + usern + '\'' +
                ", lastName='" + pass + '\'' +
                ", birthYear=" + account +
                "}\n";
    }
}
