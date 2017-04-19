
public class Salad extends Item{

	public Salad(int quantity) {
		super(quantity);
		this.name = "Salad";
		this.price = quantity * 6;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}
	
}
