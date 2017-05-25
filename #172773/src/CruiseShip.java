
public class CruiseShip extends Ship {
	private int maxPassengers;
	private int currentPassengers;

	public CruiseShip(String nameShip, int yearShip, int max, int current) {
		super(nameShip, yearShip);
		this.maxPassengers = max;
		this.currentPassengers = current;
	}

	public int getCurrentPassengers() {
		return currentPassengers;
	}

	public void setCurrentPassengers(int currentPassengers) {
		this.currentPassengers = currentPassengers;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public boolean isEquals(CruiseShip cruiseShip) {
		if (getNameShip() == cruiseShip.getNameShip() && getYearShip() == cruiseShip.getYearShip()
				&& this.maxPassengers == cruiseShip.getMaxPassengers()
				&& this.currentPassengers == cruiseShip.getCurrentPassengers()) {
			return true;
		} else
			return false;
	}
	
	public boolean canTravel() {
		if( (double)this.currentPassengers / (double)this.maxPassengers >= 0.8) {
			return true;
		}else
			return false;
	}
	
	public String toString() {
		return "Ship name: " + getNameShip() + ", MaxPassengers: " + maxPassengers;
	}

}
