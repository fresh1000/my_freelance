package source;

public class Station extends AnyData {
	String nameStation;

	public Station(String name, String nameStation) {
		this.name = name;
		this.nameStation = nameStation;
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
