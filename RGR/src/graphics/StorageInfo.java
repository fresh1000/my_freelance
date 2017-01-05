package graphics;

public class StorageInfo extends AnyData {
	String strgAdr;
	double strgArea;
	
	public StorageInfo(String name, String adr, double area) {
		this.name = name;
		this.strgAdr = adr;
		this.strgArea = area;
	}

	@Override
	public MainDialog showDialog(boolean b) {
		StorageDialog td = new StorageDialog(this);
		td.setEditable(b);
		td.setVisible(true);
		return td;
	}

	@Override
	public MainDialog showSonDialog() {
		GroupProductDialog ad = new GroupProductDialog();
		ad.setVisible(true);
		return ad;
	}
}

