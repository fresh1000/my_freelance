
public class SavingsAccount extends BankAccount implements InterestBearing {
	private int numWithdrawals;
	
	public SavingsAccount(String number) {
		super(number);
		this.type = 1;
		this.numWithdrawals = 0;
	}
	
	public void withdraw(double amount) {
		super.withdraw(amount);
		numWithdrawals++;
		if(this.balance < amount){
			System.out.println("Not enough funds");
			balance = balance + amount;
		    if(numWithdrawals > 5) {
				if(this.balance < 5) {
					System.out.println("Not enough funds for commission");
				}
				this.balance = this.balance - 5;
			}
		}else if(numWithdrawals > 5)
		this.balance = this.balance - 5;
	}
	
	public void processEndOfMonth() {
		numWithdrawals = 0;
		payInterest();
	}
	
	public void payInterest() {
		double interest = this.balance * (interestRate / 12);
		balance = balance + balance * interest;
	}
}
