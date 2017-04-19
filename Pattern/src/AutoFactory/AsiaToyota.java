package AutoFactory;

public class AsiaToyota extends Automobile{
	//set all information about auto
	public AsiaToyota() {
		mark = "Toyota";
		model = "Camry";
		price = "$10000";
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
