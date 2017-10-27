
public class DebitCard extends ChargeCard {
	private double overdraftLimit;
	private double overdraftFee;
	private double feesIncurred;

	DebitCard(String name, String cardNumber) {
		super(name, cardNumber);
		this.overdraftFee = 50;
		this.overdraftLimit = 100;
	}

	public double getFeesIncurred() {
		return feesIncurred;
	}

	public double getOverdraftFee() {
		return overdraftFee;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void purchase(double pay) {
		if (pay <= balance)
			balance -= pay;
		else if (pay > balance) {
			if (pay <= (balance + overdraftLimit + overdraftFee))
				balance -= pay + overdraftFee;
		}
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
		return super.toString() + " overdraftLimit: " + overdraftLimit + "$" + " overdraftFee: " + overdraftFee + "$"
				+ " feesIncurred: " + feesIncurred + "$";
	}

}

