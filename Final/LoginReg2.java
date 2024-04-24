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
    
    
    // user methods to be accessed by ATM file
    private static User user;
    public static void setUser(User newUser) {
    	user=newUser;
    }
    public static User getUser() {
    	return(user);
    }

    
    static Map<String, String> users = new HashMap<>();
    static Set<String> existingUsernames = new HashSet<>();   // Store existing usernames
    
    static FileOutputStream fileOut = null;
    static FileInputStream fileIn = null;
    static Properties props = new Properties();
    static File ufile = new File ("src/ATM/account.properties");

    public static void main(String[] args) throws IOException {
    	
    	// Load existing usernames from account.properties file
    	try {
    		fileIn = new FileInputStream(ufile);
    		props.load(fileIn);
    		existingUsernames.addAll(props.stringPropertyNames());
    		fileIn.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	// load all existing users from properties file into users map
    	try {
    		fileIn = new FileInputStream(ufile);
            props.load(fileIn);
            for (String uname : props.stringPropertyNames()) {
            	String pw = props.getProperty(uname);
            	users.put(uname, pw);
            }
            fileIn.close(); 
    	} catch (IOException e) {
            e.printStackTrace();
        }
    	
    	// MAIN
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
                   
			User user = loginUser(scanner);
			if (user != null) {
				LoginReg2.setUser(user);
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
            
            	fileIn =new FileInputStream(ufile); 
            	props.load(fileIn);
            	fileIn.close(); 
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    static void registerUser(Scanner scanner) {
    	String upath = "src/ATM/userfiles/";
    	String file_ext = ".txt";
    	
        //Random random = new Random();
        System.out.println(users);
        System.out.println("\nPlease Fill Out This Registration Form");
        System.out.println("-----------------");

        // Get username
        String username;
        while (true) {
        	System.out.print("Create a Username: ");
            username = scanner.nextLine();
            
            // Check if username already exists
            if (existingUsernames.contains(username)) {
            	System.out.println("Username taken. Please try again.");
            } else {
            	break;
            }
        }

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
            
            // deposit initial balances
            System.out.println("How much would you like to deposit into your checking accoount?");
            double checkingBalance = scanner.nextDouble();
            System.out.println("How much would you like to deposit into your savings account?");
            double savingsBalance = scanner.nextDouble();
            
            // create new user file
            String fname = upath + username + file_ext;
            try (FileWriter filewriter = new FileWriter(fname)) {
            	filewriter.write("Checking: " + checkingBalance + "\n");
                filewriter.write("Savings: " + savingsBalance + "\n");
            } catch (IOException e) {
            	e.printStackTrace();
            	System.out.println("Error creating user file: " + e.getMessage());
            	return;
            }
            
            
            User user = new User(checkingBalance,savingsBalance);
            user.setName(username);
            user.setPassword(password);
            props.setProperty(username, password);
            users.put(username, password);
            

            try {
                
                fileOut = new FileOutputStream(ufile,true);
                props.store(fileOut, "usernames");
                fileOut.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            

            System.out.println("\nRegistration successful.\n");
            System.out.println(users);
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
        System.out.println(users);
        
        String upath = "src/ATM/userfiles/";
    	String file_ext = ".txt";
        String fname = upath + username + file_ext;
        try (Scanner fileScanner = new Scanner(new File(fname))) {
        	double checkingBalance = Double.parseDouble(fileScanner.nextLine().split(": ")[1]);
        	double savingsBalance = Double.parseDouble(fileScanner.nextLine().split(": ")[1]);
        	User user = new User(checkingBalance, savingsBalance);
        	if (users.containsKey(username)) {
            	//User user = new User(checkingBalance, savingsBalance);       // have to read in from file their account information
            	user.setName(username);
            	String rpassword = users.get(username);
            	user.setPassword(rpassword);
            	if (user.getPassword().equals(password)) {
            		System.out.println("Login successful.\n");
            		return user;
            	}
        	}
        } catch (FileNotFoundException e) {
        	System.out.println("User not found. Make sure to register first as a new user.");
        }
        
     
        System.out.println(users);
        
        System.out.println("Invalid username or password.\n");
        return null;    
    }

    private static Object Readable (String fname) {
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
