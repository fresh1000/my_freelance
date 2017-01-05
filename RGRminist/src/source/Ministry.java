package source;

public class Ministry extends AnyData {
	String ministerName;
	

	public Ministry(String name, String ministerName) {
		this.name = name;
		this.ministerName = ministerName;
	}


	public Dlg showDialog(boolean b) {
		DlgMinistry d = new DlgMinistry(this);
		d.setEditable(b);
		d.setVisible(true);
		return d;
	}


	public Dlg showSonDialog() {
		DlgCity d = new DlgCity();
		d.setVisible(true);
		return d;
	}
	

}
