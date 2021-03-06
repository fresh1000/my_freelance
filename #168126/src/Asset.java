import java.util.Date;
import java.util.*;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;


/**
 * Asset class for the asset tracker application, where every asset is 
 * identified by a unique serialNumber, asset brand, its model and also
 * processor type. (Getter and setter functions included)
 *
 *Responsible for keeping track of the list of available asset and if assigned-tracks the
 *upcoming due date
 *
 * @author (Harini Ramadas - 100653718)
 * @version (22nd March 17)
 */
 

public abstract class Asset implements Comparable<Asset>{
    // variables and attribute declaration
	private String serialNumber;
	private String brand;
	private String model;
	

	private boolean available;
	private Date dueDate;
	private boolean assigned;
	private Employee employee;

	/**
	 * Parameterised constructor, initializing attributes
	 */
	public Asset(String serialNumber, String brand, String model) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.model = model;
		available = true;
	}
    /**
     * Getter and setter functions to obtain serial number, 
     * brand, model.
     */
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
    /**
     * Method isAvailable returns available laptops that are currently unassigned
     */
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
    /*
     * Method getDueDate Returns the due date (assumed: 10 days) for each laptop that is assigned
     */
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date today) {
		
		Calendar can = Calendar.getInstance();
		can.setTime(today);
		can.add(Calendar.DATE,10);
		dueDate = can.getTime();
	}
	
	/**
	 * Method to calculate overdue fee
	 */
	public abstract double getOverdueFee();
	
    /**
     * Method isAssigned returns the laptop attributes if assigned
     */
	public boolean isAssigned() {
		return assigned;
	}
	/*
	 * Method for sort assets by brand.
	 * 
	 */
	public int compareTo(Asset o) {
        return brand.compareTo(o.brand);
    }

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
    /**
     * method getEmployee of class type employee - returns the employee details
     */
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

