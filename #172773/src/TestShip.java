/*
 *  When a method is in more than one class of the inheritance chain, does the system call
 *   the method in the reference’s class 
 *   or the one in the object’s class?
 *   Answer: System call the method in the object’s class
 */
public class TestShip {

	public static void main(String[] args) {
		Ship[] ships = new Ship[5];
		Ship ship = new Ship("Ship", 1947);
		Ship cruiseShip = new CruiseShip("Titanic", 1900, 2000, 1500);
		Ship cargoShip = new CargoShip("Ar-12", 2009, 5000, 3000);
		Ship cruiseShip1 = new CruiseShip("Costa", 1900, 1000, 900);
		Ship cargoShip1 = new CargoShip("AGG-1", 2009, 4000, 3900);

		ships[0] = ship;
		ships[1] = cruiseShip;
		ships[2] = cargoShip;
		ships[3] = cruiseShip1;
		ships[4] = cargoShip1;

		for (int i = 0; i < ships.length; i++) {
			System.out.println(ships[i].toString());
		}

		int readyToTravel = 0;
		for (int i = 0; i < ships.length; i++) {
			if (ships[i].canTravel()) {
				readyToTravel++;
			}
		}
		System.out.println("Number of ships that are ready to travel: " + readyToTravel);

	}

}
