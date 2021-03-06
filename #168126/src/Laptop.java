import java.util.Calendar;
import java.util.Date;

public class Laptop extends Asset{
	// variables and attribute declaration
	private String processor;
	/**
	 * Parameterised constructor, initializing attributes
	 */
	public Laptop(String serialNumber, String brand, String model, String processor) {
		super(serialNumber, brand, model);
		this.processor = processor;	
	}
	/**
     * Getter and setter  processor
     */
	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
	/**
	 * Method to calculate overdue fee
	 */
	public double getOverdueFee() {
		double overdueFee = 20;
		Calendar can = Calendar.getInstance();
		Date over = can.getTime();
		if(getDueDate().getTime() < over.getTime()) {
		
			overdueFee = overdueFee * (over.getDay() - getDueDate().getDay());
			return overdueFee;
		}
		return 0;
	}

	public String toString() {
		return "Processor " + processor;
	}

}
