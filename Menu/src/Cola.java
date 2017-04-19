
public class Cola extends Item{

	public Cola(int quantity) {
		super(quantity);
		this.name = "Cola";
		this.price = quantity * 2;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}

}
