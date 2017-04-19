
public class Pizza extends Item{

	public Pizza(int quantity) {
		super(quantity);
		this.name = "Pizza";
		this.price = quantity * 10;
	}

	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}
}
