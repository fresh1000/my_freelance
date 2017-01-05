/*The payoff comparison program will do the following: 
 * This program calculates how long it will take to pay off your credit
 * 		card balance with minimum payments vs. larger payments
 */
/**
 *
 * @author Linu Alex
 * @version 1.0, java Assn 6
 */

import java.util.Scanner;

public class PayoffComparison {

	static double promptBalance() {
		final double LOWEST_INITIAL_BALANCE = 500;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the beginning balance (at least $500): ");
		double balance = sc.nextDouble();
		while(balance < LOWEST_INITIAL_BALANCE) {
			System.out.println("Error, input balance");
			System.out.print("Enter the beginning balance (at least $500): ");
			balance = sc.nextDouble();
		}
		return balance;
	}
	
	static int readPercent(int LOWEST_PAYDOWN, int HIGHEST_PAYDOWN) {
		boolean a = true;
		int percentage = 0;
		Scanner sc = new Scanner(System.in);
		while(a) {
			percentage = sc.nextInt();
			if(percentage >= LOWEST_PAYDOWN && percentage <= HIGHEST_PAYDOWN) {
				a = false;
			}else
				System.out.print("Error,try again"+ "(" +  LOWEST_PAYDOWN + "," + HIGHEST_PAYDOWN + "):");
		}
		return percentage;
	}
	
	static int percentageMonth() {
		final int LOWEST_PAYDOWN = 6;
		final int HIGHEST_PAYDOWN = 33;
		int validChoice = 0;
		int percentageMonth = 0;
		boolean forWhile = true;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1 - 10% of remaining balance each month");
			System.out.println("2 - 20% of remaining balance each month");
			System.out.println("3 - 30% of remaining balance each month");
			System.out.println("4 - Some other percent of the balance each month between 6 and 33");
			System.out.print("Enter choice from Menu above: ");
			validChoice = sc.nextInt();
			switch(validChoice) {
			case 1:
				percentageMonth = 10;
				forWhile = false;
				break;
			case 2:
				percentageMonth = 20;
				forWhile = false;
				break;
			case 3:
				percentageMonth = 30;
				forWhile = false;
				break;
			case 4:
				System.out.print("Percentage of month: ");
				percentageMonth = readPercent(LOWEST_PAYDOWN, HIGHEST_PAYDOWN);
				forWhile = false;
				break;
			default:
				System.out.println("Error choice.");
				break;
			}
			
		}while(forWhile);
		return percentageMonth;
	}
	
	static void description() {
		System.out.println("This program calculates how long it will take to pay off your credit\n"
				+ "card balance with minimum payments vs. larger payments");
		System.out.println();
	}
	
	public static void main(String[] args) {
		final int HIGHEST_ANNUAL_INTEREST = 25;
		final int LOWEST_ANNUAL_INTEREST = 3;
		description();
		double startBalance = promptBalance();
		System.out.print("the credit card's annual interest rate (between 3% and 25%): ");
		double interest = readPercent(LOWEST_ANNUAL_INTEREST, HIGHEST_ANNUAL_INTEREST);
		System.out.println();
		System.out.println("What will the monthly payment will be?");
		double percentOfMonth = percentageMonth();
		
		CreditCardAccount account1 = new CreditCardAccount(startBalance, interest);
		CreditCardAccount account2 = new CreditCardAccount(startBalance, interest, percentOfMonth);
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Results when paying minimum required payment per month");
		int month = account1.payoff();
		
		System.out.println("Results when paying " + (int)account2.getPercentOfMonth() + "% of the balance per month");
		int month2 = account2.payoff();
		
		System.out.println();	
		System.out.println("Paying minimum required payment per month,\n"
				+ "			it will take " + month + " months to pay off the credit card.");
		System.out.println();
		System.out.println("Paying 20% of the balance per month,\n"
				+ "			it will take "+ month2 + " months to pay off the credit card.");
		
	}

}
