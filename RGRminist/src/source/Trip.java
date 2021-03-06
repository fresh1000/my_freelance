package source;

public class Trip extends AnyData {
	double priceTrip;
	String startCity;
	String finishCity;

	public Trip(String name, double priceTrip, String startCity, String finishCity) {
		this.name = name;
		this.priceTrip = priceTrip;
		this.startCity = startCity;
		this.finishCity = finishCity;
	}

	public String toString() {
		return name + " " + startCity +"-"+ finishCity + " " + priceTrip;
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
