
public class Insurance {
	private int currentYear;
	private int birthClient;
	private int premiumAmount;

	public Insurance(int birthClient, int currentYear) {
		this.birthClient = birthClient;
		this.currentYear = currentYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getPremiumAmount() {
		return premiumAmount;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	
	public int getBirthClient() {
		return birthClient;
	}

	public void setBirthClient(int birthClient) {
		this.birthClient = birthClient;
	}

	public void calcPremiumAmount() {
		premiumAmount = (((currentYear - birthClient) / 10) + 15) * 20;
	}
}
