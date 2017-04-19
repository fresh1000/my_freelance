package AutoFactory;

public class AsiaSubaru extends Automobile {
	//set all information about auto
	public AsiaSubaru() {
		mark = "Subaru";
		model = "Impreza";
		price = "$13000";
		luxuryBundle.add("Upgrades radio");
		luxuryBundle.add("Sunroof");
		performanceBundle.add("Aluminium wheels");
	}
	//print all information
	void printMarkModel() {
		System.out.println("Mark: " + mark + " ,Model: " + model + " , Price: " + price);
	}

}
