
public class BankAccount {  
	private double balance;
	public BankAccount() {   
		balance = 0;
	}

	public BankAccount(double initialBalance) {
		balance = initialBalance;
		System.out.print("Balance is: ");
		System.out.println(balance + 10);
	}
	
	public void withdraw(double withDraw) {
		balance = balance - withDraw;
		System.out.print("Balance is: " + balance);
	}
}
