package AutoFactory;

public class NorthAmericaToyota extends Automobile{
	//set all information about auto
	public NorthAmericaToyota() {
		mark = "Toyota";
		model = "Camry";
		price = "$8000";
		luxuryBundle.add("Upgrades radio");
		luxuryBundle.add("Sunroof");
		performanceBundle.add("Aluminium wheels");
	}
	//print all information
	void printMarkModel() {
		System.out.println("Mark: " + mark + " ,Model: " + model + " , Price: " + price);
	}
}
