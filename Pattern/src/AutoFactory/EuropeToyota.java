package AutoFactory;

public class EuropeToyota extends Automobile {
	//set all information about auto
	public EuropeToyota() {
		mark = "Toyota";
		model = "Camry";
		price = "$7000";
		luxuryBundle.add("Upgrades radio");
		luxuryBundle.add("Aluminium wheels");
		luxuryBundle.add("Sunroof");
		performanceBundle.add("Aluminium wheels");
	}
	//print all information
	void printMarkModel() {
		System.out.println("Mark: " + mark + " ,Model: " + model + " , Price: " + price);
	}

}
