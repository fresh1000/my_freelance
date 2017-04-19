package Exercise2;

public class Coin {
	private String name;
	private int value;
	
	public Coin(String name) {
		this.name = name;
		if(name.equals("Toonie")) {
			value = 200;
		}
		if(name.equals("Loonie")) {
			value = 100;
		}
		if(name.equals("Quarter")) {
			value = 25;
		}
		if(name.equals("Dime")) {
			value = 10;
		}
		if(name.equals("Nickel")) {
			value = 5;
		}
	}
	
	public String getName() {
		return name;
	}
	public int getValue() {
		return value;
	}

	public String toString() {
		return "Coin [name=" + name + ", value=" + value + "]";
	}
	
}
