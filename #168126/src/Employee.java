import java.util.*;
import java.util.Date;

/**
 * Class Employee identified by unique employee number, name and his/her site location
 * Responsible for assigning/removing a laptop to/from an employee
 *
 *
 * @author (Harini Ramadas - 100653718)
 * @version (22nd March 17)
 */

public class Employee {
    //attributes and variables declared
	private int number;
	private String name;
	private String location;

	private Asset laptop; //attribute of class laptop
	private Date assignedLaptopDate;
	private Date returningLaptopDate;
	private int count = 0;

	public Employee() { //default constructor
		number = ++count;
	}
	/**
	 * Parameterised constructor, initializing attributes
	 */
	public Employee(String name, String location) {
	    
		number = ++count;
		this.name = name;
		this.location = location;
	}
    /**
     * Method to remove the assigned laptop from an employee 
     */
	public void removeLaptop() {
		laptop = null;
	}
    /**
     * getNumber returns the employee number
     */
	public int getNumber() {
		return number;
	}
    /**
     * getName returns the employee name
     */
	public String getName() {
		return name;
		}
	public void setName(String name) {
		this.name = name;
	}
    /**
     * getLocation returns the employee location 
     */
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    /**
     * getLaptop returns the assigned laptop for the employee
     */
	public Asset getLaptop() {
		return laptop;
	}

	public void setLaptop(Asset laptop) {
		this.laptop = laptop;
	}
    /**
     * Method getAssignedLaptopDate returns the date on which the laptop
     * was assigned to the employee
     */
	public Date getAssignedLaptopDate() {
		return assignedLaptopDate;
	}

	public void setAssignedLaptopDate(Date assignedLaptopDate) {
		this.assignedLaptopDate = assignedLaptopDate;
	}
	/**
	 * getReturningLaptopDate returns the due date on which the e
	 *employee must return the laptop
	 */
	public Date getReturningLaptopDate() {
		return returningLaptopDate;
	}
	
	public void setReturningLaptopDate(Date returningLaptopDate) {
		this.returningLaptopDate = returningLaptopDate;
	}
	

}

