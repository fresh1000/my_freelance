package AutoFactory;

public class NorthAmericaStore extends AutoStore {
	//method return object type Automobile
	Automobile createAuto(String mark) {
		Automobile auto = null;
		if (mark.equals("Toyota")) {
			auto = new NorthAmericaToyota();//create NorthAmericaToyota auto
		} else if (mark.equals("Subaru")) {
			auto = new NorthAmericaSubaru();//create NorthAmericaSubaru auto
		} 
		return auto;//return auto
	}

}
