public abstract class ChargeCard {
	protected String name;
	protected String cardNumber;
	protected double balance;

	ChargeCard(String name, String cardNumber) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.balance = 0;
	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public abstract void purchase(double pay);

	public abstract void increaseOverdraftLimit();

	public abstract void depositFunds(double deposit);

	public abstract void withdrawFunds(double fund);

	public abstract void payFees();

	public String toString() {
		return "Name of card: " + name + " card number: " + cardNumber+ " balance: " + balance + "$";
	}

}