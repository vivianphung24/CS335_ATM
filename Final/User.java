package banking;

public class User {
	String name;
	String password;
	double balance;
	
	public User(double b, String string) {
		// name = n;  String n, String pw as parameters once login class is integrated
		// password = pw;
		balance = b;
	}
	
	// getters and setters; toString
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setName(String n) {
		this.name=n;
	}
	
	public void setBalance(double b) {
		this.balance=b;
	}
	
	public String toString() {
		return (this.name + ", your balance is: $" + this.balance);
	}
	
	//methods
	
}