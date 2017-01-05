/*The payoff comparison program will do the following: 
 * This program calculates how long it will take to pay off your credit
 * 		card balance with minimum payments vs. larger payments
 */

/**
 *
 * @author Linu Alex
 * @version 1.0, java Assn 6
 */
public class CreditCardAccount {
	private double currentBalance;
	private double annualInterstRate;
	private double percentOfMonth;
	
	public CreditCardAccount(double currentBalance, double annualInterstRate) {
		this.currentBalance = currentBalance;
		this.annualInterstRate = annualInterstRate;
		this.percentOfMonth = 0;
	}

	public CreditCardAccount(double currentBalance, double annualInterstRate, double percentOfMonth) {
		this.currentBalance = currentBalance;
		this.annualInterstRate = annualInterstRate;
		this.percentOfMonth = percentOfMonth;
	}

	public double getPercentOfMonth() {
		return percentOfMonth;
	}
	
	public double instance() {
		final double LOW_BALANCE_MINIMUN_PAYMENT = 50;
		final double HIGH_BALANCE_PERCENTAGE = .05;
		final double LOW_BALANCE_LIMIT = 1000;
		
		if(currentBalance < LOW_BALANCE_LIMIT) {
			return LOW_BALANCE_MINIMUN_PAYMENT;
		}
		
		return currentBalance * HIGH_BALANCE_PERCENTAGE;
	}
	
	public void makePayment() {
		System.out.printf("      %8.2f",currentBalance);
		
		double interestCharge = currentBalance * (double)((annualInterstRate/100)/12);
		System.out.printf("       %8.2f",interestCharge);
		
		currentBalance = currentBalance + interestCharge;
		System.out.printf("      %8.2f",currentBalance);
		
		double paymentOfMonth = currentBalance * (double)(percentOfMonth/100);
		double minRequiredPay = this.instance(); 
		if(paymentOfMonth < minRequiredPay) {
			paymentOfMonth = minRequiredPay;
		}
		if(currentBalance < paymentOfMonth) {
			paymentOfMonth = currentBalance;
			currentBalance = 0;
		}
		
		System.out.printf("    %8.2f",paymentOfMonth);
		currentBalance = currentBalance - paymentOfMonth;
		if(currentBalance < 0) {
			currentBalance = 0;
		}
		System.out.printf("   %8.2f\n",currentBalance);
	}
	
	public int payoff() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("           Initial       Month's      Balance                  End    ");
		System.out.println("Month      Balance       Interest     w/Interest    Payment    Balance");
		System.out.println("----------------------------------------------------------------------");
		int month = 0;
		while(currentBalance > 0) {
			month++;
			System.out.printf("%4d",month);
			this.makePayment();
			
		}
		return month;
	}
	
}
