package exercise3;

public class Stock {
	private String symbol;
	private double price;
	private int numOfShares;
	
	public Stock(String symbol, double price, int numOfShares) {
		this.symbol = symbol;
		this.price = price;
		this.numOfShares = numOfShares;
	}

	public String toString() {
		return "Symbol: " + symbol + "\nPrice: " + price + "\nNumber of shares: " + numOfShares;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumOfShares() {
		return numOfShares;
	}

	public void setNumOfShares(int numOfShares) {
		this.numOfShares = numOfShares;
	}
	public int compareTo(Stock s) {
		if(price * numOfShares < s.getPrice()*getNumOfShares())
			return -1;
		if(price * numOfShares > s.getPrice()*getNumOfShares())
			return 1;
		else
			return 0;
	}

}
