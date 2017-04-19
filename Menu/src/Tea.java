
public class Tea extends Item{

	public Tea(int quantity) {
		super(quantity);
		this.name = "Tea";
		this.price = quantity * 4;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}

}
