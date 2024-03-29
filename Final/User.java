package banking;

public class User {
	String name;
	String password;
	double checkingBal;
	double savingsBal; 
	
	public User(double c,double s) {
		// name = n;  String n, String pw as parameters once login class is integrated
		// password = pw;
		checkingBal = c;
		savingsBal = s; 
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
	
	public void setName(String n) {
		this.name=n;
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
	
	//methods
	
}
