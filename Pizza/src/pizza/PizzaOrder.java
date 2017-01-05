package pizza;
import java.util.ArrayList;

public class PizzaOrder {
	private int size;
	private String crustType;
	private String name;
	ArrayList<String> toppings = new ArrayList<String>();
	
	public PizzaOrder(int size, String crustType, String name) {
		this.size = size;
		this.crustType = crustType;
		this.name = name;
	}
	
	public String toString() {
		return "PizzaOrder [size=" + size + ", crustType=" + crustType + ", name=" + name + ", toppings=" + toppings
				+ "]";
	}

	public void addTopping(String topping) {
		toppings.add(topping);
	}
	
	public double calculatePrice() {
		
		double price = 0;
		if(size == 10) {
			price = 10.79 + 1.25 * toppings.size();
			return price;
		}
		if(size == 12) {
			price = 12.79 + 1.25 * toppings.size();
			return price;
		}
		if(size == 14) {
			price = 13.79 + 1.25 * toppings.size();
			return price;
		}else
			price = 15.79 + 1.25 * toppings.size();
			return price;
	}
}
