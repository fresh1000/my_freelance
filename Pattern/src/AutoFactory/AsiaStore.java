package AutoFactory;

public class AsiaStore extends AutoStore {
	//method return object type Automobile
	Automobile createAuto(String mark) {
		Automobile auto = null;
		if (mark.equals("Toyota")) {
			auto = new AsiaToyota();//create AsiaToyota auto
		} else if (mark.equals("Subaru")) {
			auto = new AsiaSubaru();//create AsiaSubaru auto
		}
		return auto;//return auto
	}

}
