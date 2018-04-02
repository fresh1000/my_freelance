
public class Box {
	private String brand;
	private int volume;
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}
	
	public String category() {
		if(volume >= 500) {
			return "Large";
		}else if(volume < 500 && volume >= 100) {
			return "Medium";
		}else
			return "Small";
	}
}
