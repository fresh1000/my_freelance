import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Account {
	private int accountNumber;
	private String accountHolder;
	private double balance = 0;
	private double annualInterestRate;
	private Date dateCreated;
	private static int numberOfAccounts;
	
	public Account() {
		accountNumber = 0;
		accountHolder = null;
		balance = 0;
		annualInterestRate = 0.0;
		Calendar cal = Calendar.getInstance();
		
		dateCreated = new Date(115, 2, 12);
		numberOfAccounts++;
	}
	
	public Account(int accountNumber, String accountHolder, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		numberOfAccounts++;
		dateCreated = new Date();
		
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public static void setNumberOfAccounts(int numberOfAccounts) {
		Account.numberOfAccounts = numberOfAccounts;
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate/12;
	}
	

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	

	public String toString() {
		DateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
	
		System.out.println();
		return "Account [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance= $" + balance
				+ ", annualInterestRate=" + annualInterestRate + ", dateCreated=" + dt.format(dateCreated) + "]";
	}
}
