
package banking;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.time.LocalDate;
// Import the File class
import java.io.*;

public class ATM {

    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
    	//User user = LoginReg2.loginUser(scanner);
    	User user = LoginReg2.getUser();

       
        System.out.println("Hi " + user.getName() +"!");
        System.out.println("What would you like to do today?");
        String oldBal = Double.toString(user.getCheckingBalance());
        String oldSav = Double.toString(user.getSavingsBalance()); 

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
            	String upath = "src/banking/userfiles/";
            	String file_ext = ".txt";
                String fname = upath + user.getName() + file_ext;                         

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
                    	String newBal = Double.toString(user.getCheckingBalance()); 
                    	String newSav = Double.toString(user.getSavingsBalance()); 
                    	modifyFile(fname, "Checking: " + oldBal,"Checking: "+ newBal);
                    	modifyFile(fname,"Savings: "+oldSav,"Savings: "+newSav); 
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

      

        System.out.println("Thank you for using Baddie Banking. Stay Bad!");
    }
    
    //Function to print transaction history for user
    
    public static void viewTransactionHistory(User user) {
    	LocalDate date = LocalDate.now(); // Create a date object
        System.out.println("\nTransaction History for " + date+ ":");
        List<String> transactionHistory = user.getTransactionHistory();
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
         
        String oldBalance = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldBalance = oldBalance + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldBalance.replace(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
}
