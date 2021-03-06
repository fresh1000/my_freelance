import java.awt.Color;

/**
 * HeadPhone.java
 * Class HeadPhone represent a headphone set.
 *
 * Date:
 * @author (your name)
 */

public class HeadPhone {
	final int LOW = 1;//constant LOW
	final int MEDIUM = 2;//constant MEDIUM
	final int HIGH = 3;//constant HIGH
	private int volume;//field that specifies the volume of the headphone.
	private boolean pluggedIn;//field that specifies if the headphone is plugged in
	private String manufacturer;//field that specifies the name of the manufacturer of the headphones
	private Color headPhoneColor;//field that specifies the color of the headphones.
	private String headPhoneModel;//field that specifies the Model of the headphones

	public HeadPhone() {
		//initialization all field 
		this.volume = MEDIUM;//default MEDIUM
		this.pluggedIn = false;//default false
		this.manufacturer = null;
		this.headPhoneColor = null;
		this.headPhoneModel = null;
	}
	
	//method return volume
	public int getVolume() {
		return volume;
	}
	
	//method return pluggedIn
	public boolean isPluggedIn() {
		return pluggedIn;
	}

	//method return manufacturer
	public String getManufacturer() {
		return manufacturer;
	}

	//method return color
	public Color getHeadPhoneColor() {
		return headPhoneColor;
	}

	//method return model headphone
	public String getHeadPhoneModel() {
		return headPhoneModel;
	}

	//method set volume
	public void setVolume(int volume) {
		this.volume = volume;
	}

	//method set pluggedIn
	public void setPluggedIn(boolean pluggedIn) {
		this.pluggedIn = pluggedIn;
	}

	//method set manufacturer
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	//method set color
	public void setHeadPhoneColor(Color headPhoneColor) {
		this.headPhoneColor = headPhoneColor;
	}

	//method set model
	public void setHeadPhoneModel(String headPhoneModel) {
		this.headPhoneModel = headPhoneModel;
	}

	//method print all information about headphone
	public String toString() {
		return "Volume: " + volume + " PluggedIn: " + pluggedIn + " Manufacturer: " + manufacturer + " Color: "
				+ headPhoneColor + " Model: " + headPhoneModel;
	}

	//method change volume
	public void changeVolume(int value) {
		this.volume = value;
	}

}
