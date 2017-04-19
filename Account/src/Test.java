import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Account accountDefault = new Account();
		accountDefault.setAccountNumber(1);
		accountDefault.setAccountHolder("Will Smit");
		accountDefault.setBalance(25000.00);
		accountDefault.setAnnualInterestRate(0.045);
		accountDefault.withdraw(9500.00);
		accountDefault.deposit(7500.00);
		System.out.println(accountDefault.toString());
		
		Account[] arrObj = new Account[2];
		int accountNumber;
		double annualInterestRate, balance;
		String holderName;
		for (int i = 0; i < arrObj.length; i++) {
			System.out.print("Enter account number: ");
			accountNumber = sc.nextInt();
			System.out.print("Enter holder name: ");
			holderName = sc.next();
			System.out.print("Enter balance: ");
			balance = sc.nextDouble();
			System.out.print("Enter annual interest rate(0-0.99): ");
			annualInterestRate = sc.nextDouble();
			arrObj[i] = new Account(accountNumber, holderName, balance);
			arrObj[i].setAnnualInterestRate(annualInterestRate);
			double withdraw, deposit;
			System.out.print("Amount withdraw:");
			withdraw = sc.nextDouble();
			arrObj[i].withdraw(withdraw);
			System.out.print("Amount deposit:");
			deposit = sc.nextDouble();
			arrObj[i].deposit(deposit);
			System.out.println(arrObj[i].toString());
		}

	}

}
