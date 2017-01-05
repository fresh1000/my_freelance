
public class Stock {
	private String name;
	private double previousPrice;
	private double closingPrice;
	private int numberOfShares;
	
	public Stock() {
		this.name = "";
		this.previousPrice = 0;
		this.closingPrice = 0;
		this.numberOfShares = 0;
	}

	public Stock(String name, double previousPrice, double closingPrice, int numberOfShares) {
		this.name = name;
		this.previousPrice = previousPrice;
		this.closingPrice = closingPrice;
		this.numberOfShares = numberOfShares;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreviousPrice() {
		return previousPrice;
	}

	public void setPreviousPrice(double previousPrice) {
		this.previousPrice = previousPrice;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	
	public double percentGain() {
		double percent;
		percent = (closingPrice - previousPrice) * (previousPrice/100);
		return percent;
	}
	
	public double shareValues() {
		double totalValues;
		totalValues = numberOfShares * previousPrice;
		return totalValues;
	}
	
	public String toString() {
		return "Stock [name=" + name + ", previousPrice=" + previousPrice + ", closingPrice=" + closingPrice
				+ ", numberOfShares=" + numberOfShares + "]";
	}
	
}
