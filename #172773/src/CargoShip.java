
public class CargoShip extends Ship{
	private double capacity;
	private double currentAmount;
	
	public CargoShip(String nameShip, int yearShip, double capacity, double currentAmount) {
		super(nameShip, yearShip);
		this.capacity = capacity;
		this.currentAmount = currentAmount;
	}

	public double getCapacity() {
		return capacity;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}

	
	public boolean isEquals(CargoShip cargoShip) {
		if (getNameShip() == cargoShip.getNameShip() && getYearShip() == cargoShip.getYearShip()
				&& this.capacity == cargoShip.getCapacity()
				&& this.currentAmount == cargoShip.getCurrentAmount()) {
			return true;
		} else
			return false;
	}
	
	public boolean canTravel() {
		if(this.currentAmount / this.capacity >= 0.9) {
			return true;
		}else
			return false;
	}
	
	public String toString() {
		return "Ship name: " + getNameShip() + ", Capacity: " + capacity;
	}
	
	
}
