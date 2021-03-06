package edu.ilstu.program4;

public class Portfolio {
	Stocks stock1;
	Stocks stock2;
	Stocks stock3;
	Stocks stock4;
	Investor investor;
	private double cashBalance;

	public Portfolio(Stocks stock1, Stocks stock2, Stocks stock3, Stocks stock4, Investor investor, double cash) {
		this.stock1 = stock1;
		this.stock2 = stock2;
		this.stock3 = stock3;
		this.stock4 = stock4;
		this.investor = investor;
		this.cashBalance = cash;
	}

	public Stocks getStock1() {
		return stock1;
	}

	public Stocks getStock2() {
		return stock2;
	}

	public Stocks getStock3() {
		return stock3;
	}

	public Stocks getStock4() {
		return stock4;
	}

	public Investor getInvestor() {
		return investor;
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void displayPositions() {
		System.out.println();
		System.out.println("Initial price Amazon:   " + stock1.getInitialPrice() + " $");
		System.out.println("Initial price Apple:    " + stock2.getInitialPrice() + " $");
		System.out.println("Initial price Facebook: " + stock3.getInitialPrice() + " $");
		System.out.println("Initial price Tesla:    " + stock4.getInitialPrice() + " $");
		System.out.println();
		System.out.println("Initial market value Amazon:   " + stock1.calcInitialMarketValue() + " $");
		System.out.println("Initial market value Apple:    " + stock2.calcInitialMarketValue() + " $");
		System.out.println("Initial market value Facebook: " + stock3.calcInitialMarketValue() + " $");
		System.out.println("Initial market value Tesla:    " + stock4.calcInitialMarketValue() + " $");
		System.out.println();
	}

	public void displayStatement() {
		if (stock1.getInitialPrice() * 1.15 <= stock1.getCurrentPrice()) {
			this.cashBalance += stock1.getCurrentPrice() * (int) Math.floor(
					(stock1.calcCurrentMarketValue() - stock1.calcInitialMarketValue()) / stock1.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock1.calcCurrentMarketValue() - stock1.calcInitialMarketValue()) / stock1.getCurrentPrice()));
		}
		if (stock2.getInitialPrice() * 1.15 <= stock2.getCurrentPrice()) {
			this.cashBalance += stock2.getCurrentPrice() * (int) Math.floor(
					(stock2.calcCurrentMarketValue() - stock2.calcInitialMarketValue()) / stock2.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock2.calcCurrentMarketValue() - stock2.calcInitialMarketValue()) / stock2.getCurrentPrice()));
		}
		if (stock3.getInitialPrice() * 1.15 <= stock3.getCurrentPrice()) {
			this.cashBalance += stock3.getCurrentPrice() * (int) Math.floor(
					(stock3.calcCurrentMarketValue() - stock3.calcInitialMarketValue()) / stock3.getCurrentPrice());
			stock3.updateCurrentShares((int) Math.floor(
					(stock3.calcCurrentMarketValue() - stock3.calcInitialMarketValue()) / stock3.getCurrentPrice()));
		}
		if (stock4.getInitialPrice() * 1.15 <= stock4.getCurrentPrice()) {
			this.cashBalance += stock4.getCurrentPrice() * (int) Math.floor(
					(stock4.calcCurrentMarketValue() - stock4.calcInitialMarketValue()) / stock4.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock4.calcCurrentMarketValue() - stock4.calcInitialMarketValue()) / stock4.getCurrentPrice()));
		}
		if (stock1.getInitialPrice() * 0.85 >= stock1.getCurrentPrice()) {
			this.cashBalance += stock1.getCurrentPrice() * (int) Math.floor(
					(stock1.calcCurrentMarketValue() - stock1.calcInitialMarketValue()) / stock1.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock1.calcCurrentMarketValue() - stock1.calcInitialMarketValue()) / stock1.getCurrentPrice()));
		}
		if (stock2.getInitialPrice() * 0.85 >= stock2.getCurrentPrice()) {
			this.cashBalance += stock2.getCurrentPrice() * (int) Math.floor(
					(stock2.calcCurrentMarketValue() - stock2.calcInitialMarketValue()) / stock2.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock2.calcCurrentMarketValue() - stock2.calcInitialMarketValue()) / stock2.getCurrentPrice()));
		}
		if (stock3.getInitialPrice() * 0.85 >= stock3.getCurrentPrice()) {
			this.cashBalance += stock3.getCurrentPrice() * (int) Math.floor(
					(stock3.calcCurrentMarketValue() - stock3.calcInitialMarketValue()) / stock3.getCurrentPrice());
			stock3.updateCurrentShares((int) Math.floor(
					(stock3.calcCurrentMarketValue() - stock3.calcInitialMarketValue()) / stock3.getCurrentPrice()));
		}
		if (stock4.getInitialPrice() * 0.85 >= stock4.getCurrentPrice()) {
			this.cashBalance += stock4.getCurrentPrice() * (int) Math.floor(
					(stock4.calcCurrentMarketValue() - stock4.calcInitialMarketValue()) / stock4.getCurrentPrice());
			stock1.updateCurrentShares((int) Math.floor(
					(stock4.calcCurrentMarketValue() - stock4.calcInitialMarketValue()) / stock4.getCurrentPrice()));
		}
	}

	public double calcTotalAccountValue() {
		double totalvalue = cashBalance / 5 + stock1.calcCurrentMarketValue() + stock2.calcCurrentMarketValue()
				+ stock3.calcCurrentMarketValue() + stock4.calcCurrentMarketValue();
		return totalvalue;
	}

	public void updateCurrentPrices() {
		stock1.setCurrentPrice(PortfolioPrices.getPrice(stock1.getStockSymbol()));
		stock2.setCurrentPrice(PortfolioPrices.getPrice(stock2.getStockSymbol()));
		stock3.setCurrentPrice(PortfolioPrices.getPrice(stock3.getStockSymbol()));
		stock4.setCurrentPrice(PortfolioPrices.getPrice(stock4.getStockSymbol()));
	}

	public void updatePosition() {
		System.out.println();
		System.out.println("Current price Amazon: " + stock1.getCurrentPrice() + " Change: "
				+ (stock1.getCurrentPrice() - stock1.getInitialPrice()) + " $");
		System.out.println("Current price Apple: " + stock2.getCurrentPrice() + " Change: "
				+ (stock2.getCurrentPrice() - stock2.getInitialPrice()) + " $");
		System.out.println("Current price Facebook: " + stock3.getCurrentPrice() + " Change: "
				+ (stock3.getCurrentPrice() - stock3.getInitialPrice()) + " $");
		System.out.println("Current price Tesla: " + stock4.getCurrentPrice() + " Change: "
				+ (stock4.getCurrentPrice() - stock4.getInitialPrice()) + " $");
		System.out.println();
		System.out.println("Current market value Amazon:   " + stock1.calcCurrentMarketValue() + " $");
		System.out.println("Current market value Apple:    " + stock2.calcCurrentMarketValue() + " $");
		System.out.println("Current market value Facebook: " + stock3.calcCurrentMarketValue() + " $");
		System.out.println("Current market value Tesla:    " + stock4.calcCurrentMarketValue() + " $");
		System.out.println();
	}
}
