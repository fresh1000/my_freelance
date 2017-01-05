package graphics;

public class ProductInfo extends AnyData {
	//String name; 
	double prdctPrice;
	String prdctCountry;
	int prdctValue;
	
	public ProductInfo(String name, double price, String country, int value) {
		this.name = name;
		this.prdctValue = value;
		this.prdctCountry = country;
		this.prdctPrice = price;
	}

	@Override
	public String toString() {
		return name + " - " + prdctPrice + "uah";
	}

	@Override
	public MainDialog showDialog(boolean b) {
		ProductDialog pd = new ProductDialog(this);
		pd.setEditable(b);
		pd.setVisible(true);
		return pd;
	}

	@Override
	public MainDialog showSonDialog() {
		return null;
	}
}

