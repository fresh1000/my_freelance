
public class Panini extends Item{

	public Panini(int quantity) {
		super(quantity);
		this.name = "Panini";
		this.price = quantity * 3;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}
}
