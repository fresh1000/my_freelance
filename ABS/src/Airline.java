
public class Airline {
	private String airlineID;

	public Airline(String airlineID) {
		this.airlineID = airlineID;
	}

	public String getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(String airlineID) {
		this.airlineID = airlineID;
	}
	
	public String toString() {
		return "Airline [airlineID=" + airlineID + "]";
	}
	
}
