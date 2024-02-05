package ATM;

public class User {
	String name;
	double balance;
	
	public User(String n, double b) {
		name = n;
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
}
