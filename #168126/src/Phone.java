import java.util.Calendar;
import java.util.Date;

public class Phone extends Asset{
	// variables and attribute declaration
	private String display;
	private String dimension;
	/**
	 * Parameterised constructor, initializing attributes
	 */
	public Phone(String serialNumber, String brand, String model, String display, String dimension) {
		super(serialNumber, brand, model);
		this.dimension = dimension;
		this.display = display;
	}
	/**
	 * Method to calculate overdue fee
	 */
	public double getOverdueFee() {
		double overdueFee = 10;
		Calendar can = Calendar.getInstance();
		Date over = can.getTime();
		if(getDueDate().getTime() < over.getTime()) {
		
			overdueFee = overdueFee * (over.getDay() - getDueDate().getDay());
			return overdueFee;
		}
		return 0;
	}

	/**
     * Getter and setter functions to obtain display, dimension.
     */
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	

	public String toString() {
		return "Display " + display;
	}

}
