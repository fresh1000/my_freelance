
public class Airport {
	private String nameAirport;

	public Airport(String name) {
		this.nameAirport = name;
	}

	public String getName() {
		return nameAirport;
	}

	public void setName(String name) {
		this.nameAirport = name;
	}

	public String toString() {
		return "Airport [name=" + nameAirport + "]";
	}

}
