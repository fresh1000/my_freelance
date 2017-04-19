
public class Soup extends Item{
	public Soup(int quantity) {
		super(quantity);
		this.name = "Soup";
		this.price = quantity * 5;
	}

	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}
	
	
}
