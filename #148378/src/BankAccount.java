
public class BankAccount {
	protected String accountNumber;
	protected int type;
	protected double balance;
	
	
	public BankAccount(String number) {
		this.accountNumber = number;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void setType(int value) {
		this.type = value;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println(accountNumber + "-" + type + " Deposit: $" + amount);
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println(accountNumber + "-" + type + " Withdrawal: $" + amount);
	}
	
	public String toString() {
		return (accountNumber + "-" + type + " Balance: $" + balance);
	}
	
}
