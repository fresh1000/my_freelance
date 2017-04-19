package class1;

public class HireCar {
	private String manufacturer;
	private String registrationNumber;
	private int mileage;
	private int serviceInterval;
	private int lastService;
	
	public HireCar() {
		this.manufacturer = null;
		this.registrationNumber = null;
		this.mileage = 0;
		this.serviceInterval = 0;
		this.lastService = 0;
	}
	
	public HireCar(String manufacturer, String registrationNumber, int mileage, int serviceInterval, int lastService) {
		this.manufacturer = manufacturer;
		this.registrationNumber = registrationNumber;
		this.mileage = mileage;
		this.serviceInterval = serviceInterval;
		this.lastService = lastService;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public int getMileage() {
		return mileage;
	}

	public int getServiceInterval() {
		return serviceInterval;
	}

	public int getLastService() {
		return lastService;
	}
	
	public int differenceMileage(int newMileage) {
		int difference = newMileage - this.mileage;
		this.mileage = newMileage;
		return difference;
	}
	
	public boolean serviceDue() {
		if(this.lastService > this.serviceInterval) {
			return false;
		}else
			return true;
	}
	
	public void updateLastService() {
		this.lastService = 0;
	}
	
	public boolean isManufacturer(String manufacturer) {
		if(this.manufacturer.equals(manufacturer)) {
			return true;
		}else
			return false;
	}

	public String toString() {
		return "HireCar [manufacturer=" + manufacturer + ", registrationNumber=" + registrationNumber + ", mileage="
				+ mileage + " miles , serviceInterval=" + serviceInterval + " miles , lastService=" + lastService + " miles ]";
	}
	
}
