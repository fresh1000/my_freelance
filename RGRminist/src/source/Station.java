package source;

public class Station extends AnyData {
	String addressStation;

	public Station(String name, String addressStation) {
		this.name = name;
		this.addressStation = addressStation;
	}

	public Dlg showDialog(boolean b) {
		DlgStation d = new DlgStation(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	public Dlg showSonDialog() {
		DlgTrip d = new DlgTrip();
		d.setVisible(true);
		return d;
	}

}
