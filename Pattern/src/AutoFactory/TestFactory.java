package AutoFactory;

public class TestFactory {

	public static void main(String[] args) {
		
		AutoStore asiaStore = new AsiaStore();
		AutoStore northAmericaStore = new NorthAmericaStore();
		AutoStore europeStore = new EuropeStore();
		
		//create asiaStore auto
		Automobile auto = asiaStore.createAuto("Toyota");
		auto.printMarkModel();
		
		auto = asiaStore.createAuto("Subaru");
		auto.printMarkModel();
		
		//create europeStore auto
		auto = europeStore.createAuto("Toyota");
		auto.printMarkModel();
		
		auto = europeStore.createAuto("Subaru");
		auto.printMarkModel();
		
		//create northAmericaStore auto
		auto = northAmericaStore.createAuto("Toyota");
		auto.printMarkModel();
		
		auto = northAmericaStore.createAuto("Subaru");
		auto.printMarkModel();

	}

}
