package edu.ilstu.program4;

public class Stocks {
	private String stockSymbol;
	private String stockName;
	private int initialShares;
	private int currentShares;
	private double initialPrice;
	private double currentPrice;
	private String lastPurchaseDate;
	
	public Stocks(String stockSymbol, String stockName, int initialShares,int currentShares, double initialPrice, double currentPrice,
			String lastPurchaseDate) {
		this.stockSymbol = stockSymbol;
		this.stockName = stockName;
		this.initialShares = initialShares;
		this.currentShares = currentShares;
		this.initialPrice = initialPrice;
		this.currentPrice = currentPrice;
		this.lastPurchaseDate = lastPurchaseDate;
	}

	public int getCurrentShares() {
		return currentShares;
	}

	public void setCurrentShares(int currentShares) {
		this.currentShares = currentShares;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getInitialShares() {
		return initialShares;
	}

	public void setInitialShares(int initialShares) {
		this.initialShares = initialShares;
	}
	
	public double getInitialPrice() {
		return initialPrice;
	}
	
	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getLastPurchaseDate() {
		return lastPurchaseDate;
	}

	public void setLastPurchaseDate(String lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	
	public double calcCurrentMarketValue() {
		double currentMarketValue = currentPrice * currentShares;
		return currentMarketValue;
	}
	
	public double calcInitialMarketValue(){
		double calcInitialMarketValue = initialPrice * initialShares;
		return calcInitialMarketValue;
	}
	
	public void updateCurrentShares(int numShares){
		this.currentShares =this.currentShares - numShares;
		
	}
}
