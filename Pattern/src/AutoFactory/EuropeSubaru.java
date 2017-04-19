package AutoFactory;

public class EuropeSubaru extends Automobile{
	//set all information about auto
	public EuropeSubaru() {
		mark = "Subaru";
		model = "Impreza";
		price = "$6000";
		luxuryBundle.add("Upgrades radio");
		luxuryBundle.add("Sunroof");
		performanceBundle.add("Aluminium wheels");
	}
	//print all information
	void printMarkModel() {
		System.out.println("Mark: " + mark + " ,Model: " + model + " , Price: " + price);
	}

}
