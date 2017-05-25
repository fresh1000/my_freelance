
public class Ship {
	private String nameShip;
	private int yearShip;
	
	public Ship(String nameShip, int yearShip) {
		this.nameShip = nameShip;
		this.yearShip = yearShip;
	}
	
	public boolean canTravel() {
		return true;
	}
	
	public boolean isEquals(Ship ship) {
		if(this.nameShip == ship.getNameShip() && this.yearShip == ship.getYearShip()) {
			return true;
		}else
			return false;
	}
	
	public String toString() {
		return "Ship name: " + nameShip + ", Year ship: " + yearShip;
	}

	public String getNameShip() {
		return nameShip;
	}

	public int getYearShip() {
		return yearShip;
	}

	public void setNameShip(String nameShip) {
		this.nameShip = nameShip;
	}

	public void setYearShip(int yearShip) {
		this.yearShip = yearShip;
	}
	
}
