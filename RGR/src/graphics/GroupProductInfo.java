package graphics;

public class GroupProductInfo extends AnyData {
	String grpprdType;
	
	
	public GroupProductInfo(String name, String type) {
		this.name = name;
		this.grpprdType = type;
		
	}

	@Override
	public MainDialog showDialog(boolean b) {
		GroupProductDialog ad = new GroupProductDialog(this);
		ad.setEditable(b);
		ad.setVisible(true);
		return ad;
	}

	@Override
	public MainDialog showSonDialog() {
		ProductDialog pd = new ProductDialog();
		pd.setVisible(true);
		return pd;
	}
}

