package AutoFactory;

public class NorthAmericaSubaru extends Automobile{
	//set all information about auto
	public NorthAmericaSubaru() {
		mark = "Subaru";
		model = "Impreza";
		price = "$12000";
		luxuryBundle.add("Upgrades radio");
		luxuryBundle.add("Aluminium wheels");
		performanceBundle.add("Sunroof");
	}
	//print all information
	void printMarkModel() {
		System.out.println("Mark: " + mark + " ,Model: " + model + " , Price: " + price);
	}
}
