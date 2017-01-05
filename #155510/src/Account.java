
public abstract class Account {
	protected double currentBalance;
	protected int counterWithdraw;
	
	public Account(double initialBalance) {
		this.currentBalance = initialBalance;
		counterWithdraw = 0;
	}
	
	public void deposit(double amount) {
		currentBalance = currentBalance + amount;
		System.out.println("Current balance: " + currentBalance);
	}
	
	public void withdraw(double amount) {
		currentBalance = currentBalance - amount;
		System.out.println("Current balance: " + currentBalance);
		counterWithdraw++;
	}
	
	public abstract void endMonth();
}
