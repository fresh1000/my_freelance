
public class Product {
	private String name;
	private double price;
	private int scanCode;
	private static int numObjects;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
		numObjects++;
		this.scanCode = 1001 + numObjects;
	}

	public static int getNumberInStock() {
		return numObjects;
	}

	public int getScanCode() {
		return scanCode;
	}

	public String getName() {
		return this.name;
	}

	public void changePrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}

	public int getNumObjects() {
		return numObjects;
	}

}
