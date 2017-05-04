import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(0.045);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println("Balance: $" + account.getBalance());
		System.out.println("Monthly interest: " + account.getMonthlyInterestRate() * 100 + "%");
		System.out.println("Date created: " + account.getDateCreated());

	}

}