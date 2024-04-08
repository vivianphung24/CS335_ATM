package banking;
import java.util.ArrayList;
import java.util.List;

public class User {
	String name;
	String password;
	double checkingBal;
	double savingsBal; 
	List<String> transactionHistory;
	
	public User(double c,double s) {
		// name = n;  String n, String pw as parameters once login class is integrated
		// password = pw;
		this.checkingBal = c;
		this.savingsBal = s; 
		this.transactionHistory = new ArrayList<>();
	}
	
	// getters and setters; toString
	public String getName() {
		return name;
	}
	
	public double getCheckingBalance() {
		return checkingBal;
	}
	
	public double getSavingsBalance() { 
		return savingsBal; 
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String n) {
		this.name=n;
	}
	
	public void setPassword(String pw) {
		this.password=pw;
	}
	
	public void setCheckingBalance(double b) {
		this.checkingBal=b;
	}
	
	public void setSavingsBalance(double s) {
		this.savingsBal=s; 
	}
	
	public String toString() {
		return (this.name + ", your checkings balance is: $" + this.checkingBal
				+"\n saving balance is: $"+ this.savingsBal);
	}
	public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
	
	public List<String> getTransactionHistory() {
        return transactionHistory;
    }



	
}
