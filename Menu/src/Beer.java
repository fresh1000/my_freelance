
public class Beer extends Item{

	public Beer(int quantity) {
		super(quantity);
		this.name = "Beer";
		this.price = quantity * 6;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}

}
