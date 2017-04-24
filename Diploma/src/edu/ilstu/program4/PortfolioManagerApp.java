package edu.ilstu.program4;

import java.util.Scanner;

public class PortfolioManagerApp {
	// takes over the job of the main method and logic for main in here
	private void run() {
		// create variables and objects needed for this app
		Investor investor = new Investor("1234323", "Fred", "Sane", "str. Aven", "NY", "Washington", "213212",
				"(123)-2132-2321");

		Stocks st1 = new Stocks("AMZN", "Amazon", 14, 14, 730.0, 798.0, "02/20/2016");
		Stocks st2 = new Stocks("AAPL", "Apple", 84, 84, 120.0, 100.0, "02/20/2016");
		Stocks st3 = new Stocks("FB", "Facebook", 77, 77, 130.0, 150.0, "02/20/2016");
		Stocks st4 = new Stocks("TSLA", "Tesla", 67, 67, 150.0, 125.0, "02/20/2016");

		Portfolio portfolio = new Portfolio(st1, st2, st3, st4, investor, 50000);

		// display main menu for portfolio management and get user input
		int i = 0;
		while (i != 4) {
			System.out.println("1.Edit a Stock ");
			System.out.println("2.Update to current stock prices ");
			System.out.println("3.Print account statement ");
			System.out.println("4.Quit");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			switch (i) {
			case 1:
				int z = 0;
				while (z != 5) {
					Scanner scan = new Scanner(System.in);
					System.out.println("Choise edit stock:");
					System.out.println("1.Edit Stock 1 ");
					System.out.println("2.Edit Stock 2 ");
					System.out.println("3.Edit Stock 3 ");
					System.out.println("4.Edit Stock 4 ");
					System.out.println("5.Quit back menu ");
					z = scan.nextInt();
					switch (z) {
					case 1:
						System.out.println("StockSymbol = ");
						String symbol = scan.nextLine();
						st1.setStockSymbol(symbol);
						System.out.println("NameStock = ");
						String name = scan.nextLine();
						st1.setStockName(name);
						System.out.println("Initial share =");
						int initialShare = scan.nextInt();
						st1.setInitialShares(initialShare);
						System.out.println("Current share = ");
						int currentShare = scan.nextInt();
						st1.setCurrentShares(currentShare);
						System.out.println("Initial price = ");
						double initialPrice = scan.nextDouble();
						st1.setInitialPrice(initialPrice);
						System.out.println("Current price = ");
						double currentPrice = scan.nextDouble();
						st1.setCurrentPrice(currentPrice);
						System.out.println("Last purchase date = ");
						String last = scan.nextLine();
						st1.setLastPurchaseDate(last);
						break;
					case 2:
						System.out.println("StockSymbol = ");
						String symbol2 = scan.nextLine();
						st2.setStockSymbol(symbol2);
						System.out.println("NameStock = ");
						String name2 = scan.nextLine();
						st2.setStockName(name2);
						System.out.println("Initial share =");
						int initialShare2 = scan.nextInt();
						st2.setInitialShares(initialShare2);
						System.out.println("Current share = ");
						int currentShare2 = scan.nextInt();
						st2.setCurrentShares(currentShare2);
						System.out.println("Initial price = ");
						double initialPrice2 = scan.nextDouble();
						st2.setInitialPrice(initialPrice2);
						System.out.println("Current price = ");
						double currentPrice2 = scan.nextDouble();
						st2.setCurrentPrice(currentPrice2);
						System.out.println("Last purchase date = ");
						String last2 = scan.nextLine();
						st1.setLastPurchaseDate(last2);
						break;
					case 3:
						System.out.println("StockSymbol = ");
						String symbol3 = scan.nextLine();
						st3.setStockSymbol(symbol3);
						System.out.println("NameStock = ");
						String name3 = scan.nextLine();
						st3.setStockName(name3);
						System.out.println("Initial share =");
						int initialShare3 = scan.nextInt();
						st3.setInitialShares(initialShare3);
						System.out.println("Current share = ");
						int currentShare3 = scan.nextInt();
						st3.setCurrentShares(currentShare3);
						System.out.println("Initial price = ");
						double initialPrice3 = scan.nextDouble();
						st3.setInitialPrice(initialPrice3);
						System.out.println("Current price = ");
						double currentPrice3 = scan.nextDouble();
						st3.setCurrentPrice(currentPrice3);
						System.out.println("Last purchase date = ");
						String last3 = scan.nextLine();
						st3.setLastPurchaseDate(last3);
						break;
					case 4:
						System.out.println("StockSymbol = ");
						String symbol4 = scan.nextLine();
						st4.setStockSymbol(symbol4);
						System.out.println("NameStock = ");
						String name4 = scan.nextLine();
						st4.setStockName(name4);
						System.out.println("Initial share =");
						int initialShare4 = scan.nextInt();
						st4.setInitialShares(initialShare4);
						System.out.println("Current share = ");
						int currentShare4 = scan.nextInt();
						st4.setCurrentShares(currentShare4);
						System.out.println("Initial price = ");
						double initialPrice4 = scan.nextDouble();
						st4.setInitialPrice(initialPrice4);
						System.out.println("Current price = ");
						double currentPrice4 = scan.nextDouble();
						st4.setCurrentPrice(currentPrice4);
						System.out.println("Last purchase date = ");
						String last4 = scan.nextLine();
						st4.setLastPurchaseDate(last4);
						break;
					default:
						break;
					}
				}
				// portfolio.displayPositions();
				// portfolio.updatePosition();
				break;
			case 2:
				portfolio.updateCurrentPrices();
				break;
			case 3:
				System.out.println();
				System.out.println(portfolio.calcTotalAccountValue());
				break;
			default:
				break;
			}
		}

		// rest of your code

	}

	/*
	 * Complete this method. This method will display the main menu and should
	 * be used from the run method. Displays the menu and prompts for user
	 * input.
	 */
	private void displayChoices() {

	}

	/*
	 * This method will display the menu for the stocks in the portfolio. This
	 * method should accept the Portfolio instance created in the run method.
	 * Displays the menu and prompts for user input.
	 */
	public void displayStockChoices() {

	}

	public static void main(String[] args) {
		// create instance of app class
		PortfolioManagerApp app = new PortfolioManagerApp();
		app.run();
	}
}