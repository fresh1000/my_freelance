package source;

public class City extends AnyData {
	String cityName;

	public City(String name, String cityName) {
		this.name = name;
		this.cityName = cityName;
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