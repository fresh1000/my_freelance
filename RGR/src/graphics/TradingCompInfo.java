package graphics;

public class TradingCompInfo extends AnyData {
	String trdcmpAdr;
	String trdcmpActivity;
	
	public TradingCompInfo(String name, String adr, String activity) {
		this.name = name;
		this.trdcmpAdr = adr;
		this.trdcmpActivity = activity;
	}

	@Override
	public MainDialog showDialog(boolean b) {
		TradingCompDialog cd = new TradingCompDialog(this);
		cd.setEditable(b);
		cd.setVisible(true);
		return cd;
	}

	@Override
	public MainDialog showSonDialog() {
		StorageDialog td = new StorageDialog();
		td.setVisible(true);
		return td;
	}
}

