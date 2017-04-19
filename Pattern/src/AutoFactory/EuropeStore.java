package AutoFactory;

public class EuropeStore extends AutoStore {
	//method return object type Automobile
	Automobile createAuto(String mark) {
		Automobile auto = null;
		if (mark.equals("Toyota")) {
			auto = new EuropeToyota();//create EuropeToyota auto
		} else if (mark.equals("Subaru")) {
			auto = new EuropeSubaru();//create EuropeSubaru auto
		}
		return auto;//return auto
	}

}
