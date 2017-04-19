
public class Television {
	private TelevisionManufacturer supplier;
	private String code;
	private int screenSize;
	private String type;
	private static int totalTVs;
	
	public Television() {
		this.supplier = null;
		this.code = null;
		this.screenSize = 0;
		this.type = null;
		totalTVs++;
	}

	public Television(TelevisionManufacturer supplier, String code, int screenSize, String type) {
		this.supplier = supplier;
		this.code = code;
		this.screenSize = screenSize;
		this.type = type;
		totalTVs++;
	}
	


	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isManufacturer(TelevisionManufacturer tele) {
		if(this.supplier.equals(tele)) {
			return true;
		}else
			return false;
	}
	
}
