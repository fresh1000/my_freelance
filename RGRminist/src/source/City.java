package source;

public class City extends AnyData {
	String ministerName;

	public City(String name, String ministerName) {
		this.name = name;
		this.ministerName = ministerName;
	}

	public Dlg showDialog(boolean b) {
		DlgCity d = new DlgCity(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}

	public Dlg showSonDialog() {
		DlgStation d = new DlgStation();
		d.setVisible(true);
		return d;
	}
	
}
