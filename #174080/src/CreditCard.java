
public class CreditCard extends ChargeCard{
	private double overdraftLimit;
	private double feesIncurred;
	
	CreditCard(String name, String cardNumber) {
		super(name, cardNumber);
		balance = 1000;
	}

	public void purchase(double pay) {
		balance -= pay;
	}

	public void increaseOverdraftLimit() {
		overdraftLimit += 100;
	}

	public void depositFunds(double deposit) {
		balance += deposit;
	}

	public void withdrawFunds(double fund) {
		balance -= fund;
	}

	public void payFees() {
		feesIncurred = 0;
	}
	
	public String toString() {
		return super.toString() + " overdraftLimit: " + overdraftLimit + "$" + " feesIncurred: " + feesIncurred + "$";
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

}
