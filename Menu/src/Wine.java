
public class Wine extends Item{

	public Wine(int quantity) {
		super(quantity);
		this.name = "Wine";
		this.price = quantity * 12;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}

}
