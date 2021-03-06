import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account() {
		this.id = 0;
		this.balance = 0.0;
		this.annualInterestRate = 0.0;
		dateCreated = new Date(115, 2, 12);
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0.0;
		dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = this.annualInterestRate / 12;
		return monthlyInterestRate;
	}
	
	public void withdraw(double amount) {
		if(this.balance - amount >= 0){
			this.balance -= amount;
		}else
			System.out.println("Error!Low balance!");
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
}
