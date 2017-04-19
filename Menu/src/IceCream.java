
public class IceCream extends Item{

	public IceCream(int quantity) {
		super(quantity);
		this.name = "Ice cream";
		this.price = quantity * 8;
	}

	public String toString() {
		return name + " Price: $" + price + " Quantity:" + quantity;
	}
}
