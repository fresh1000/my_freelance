package exercise3;

import java.util.Locale;
import java.util.Scanner;

public class StockDemo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		keyboard.useLocale(Locale.US);
		String sym1, sym2;
		double prcl, prc2, sumPortfolio;
		int shl, sh2;
		// get the values for two stocks
		System.out.print("Enter the symbols for the two stocks: ");
		sym1 = keyboard.next();
		sym2 = keyboard.next();
		System.out.print("Enter their prices: ");
		prcl = keyboard.nextDouble();
		prc2 = keyboard.nextDouble();
		System.out.print("Enter the number of shares for the two stocks: ");
		shl = keyboard.nextInt();
		sh2 = keyboard.nextInt();

		Stock s1 = new Stock(sym1, prcl, shl);
		Stock s2 = new Stock(sym2, prc2, sh2);

		System.out.println();
		System.out.println("I have the following stocks:");
		System.out.println(s1.toString());
		System.out.println();
		System.out.println(s2.toString());
		System.out.println();
		if (s1.compareTo(s2) == 1)
			System.out.println("The value of " + s1.getSymbol() + " is higher than " + s2.getSymbol());
		if (s1.compareTo(s2) == -1)
			System.out.println("The value of " + s2.getSymbol() + " is higher than " + s1.getSymbol());
		if (s1.compareTo(s2) == 0)
			System.out.println("The value of " + s1.getSymbol() + " is equals " + s2.getSymbol());
		sumPortfolio = s1.getPrice() * s1.getNumOfShares() + s2.getPrice() * s2.getNumOfShares();
		System.out.println("The total value of my portfolio is: $ " + sumPortfolio);
	}

}
