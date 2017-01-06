package source;

public class Trip extends AnyData {
	String numberTrip;
	String startCity;
	String finishCity;

	public Trip(String name, String numberTrip, String startCity, String finishCity) {
		this.name = name;
		this.numberTrip = numberTrip;
		this.startCity = startCity;
		this.finishCity = finishCity;
	}

	public String toString() {
		return name + " " + numberTrip + " " + startCity + "-" + finishCity;
	}

	public Dlg showDialog(boolean b) {
		DlgTrip d = new DlgTrip(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	public Dlg showSonDialog() {
		return null;
	}

}
