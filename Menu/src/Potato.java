
public class Potato extends Item{

	public Potato(int quantity) {
		super(quantity);
		this.name = "Potato";
		this.price = quantity * 5;
	}
	
	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}

}
