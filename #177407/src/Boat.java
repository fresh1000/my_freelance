
public class Boat {
	//all variables 
	private String registeredName;
	private String category;
	private int numberOCabins;
	private double length;
	private boolean hasSails;
	
	//all getters
	public String getRegisteredName() {
		return this.registeredName;
	}
	public String getCategory() {
		return this.category;
	}
	public int getNumberOCabins() {
		return this.numberOCabins;
	}
	public double getLength() {
		return this.length;
	}
	public boolean isHasSails() {
		return this.hasSails;
	}
	
	//all setters
	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setNumberOCabins(int numberOCabins) {
		this.numberOCabins = numberOCabins;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setHasSails(boolean hasSails) {
		this.hasSails = hasSails;
	}
}
