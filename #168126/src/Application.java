import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Class Application that contains the main method/console interface, which
 * takes input from the user to add, delete, assign, list out available and
 * assigned laptops
 * 
 * Includes methods to perform the above functions.
 *
 * @author (Harini Ramadas - 100653718)
 * @version (22nd March 17)
 */

public class Application {

	private static Scanner scanner = new Scanner(System.in);
	private static AssetPool assetPool = new AssetPool(); // attribute of class
															// AssetPool

	/**
	 * Method formatDate uses class DateFormat for formatting and parsing date
	 * in simple syntax
	 */
	private static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		return dateFormat.format(date);
	}

	
	/**
	 * Method addAsset to add a laptop or phone 
	 * 
	 */
	private static void addAsset() {
		int option;
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------Add Asset----------");
		System.out.println("Select option:");
		System.out.println("1) Add Laptop");
		System.out.println("2) Add Phone");
		System.out.println("Select option:");
		option = scanner.nextInt();
		switch (option) {
		case 1:
			System.out.println("Add Laptop");
			addLaptop();
			break;
		case 2:
			System.out.println("Add Phone");
			addPhone();
			break;
		default:
			System.out.println("Invalid");
			break;
		}

	}
	
	/**
	 * Method addLaptop to add a laptop with its attributes to the arraylist
	 * asset
	 */
	private static void addLaptop() {
	    Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the serial number");
		String serialNumber = scanner.next();
		System.out.println("Enter the brand");
		String brand = scanner.next();
		System.out.println("Enter the model");
		String model = scanner.next();
		System.out.println("Enter the processor");
		String processor = scanner.next();
		Asset laptop = new Laptop(serialNumber, brand, model, processor);
		assetPool.add(laptop);
	}
	/**
	 * Method addPhone to add a phone with its attributes to the arraylist
	 * asset
	 */
	private static void addPhone() {
	    Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the serial number");
		String serialNumber = scanner.next();
		System.out.println("Enter the brand");
		String brand = scanner.next();
		System.out.println("Enter the model");
		String model = scanner.next();
		System.out.println("Enter the display");
		String display = scanner.next();
		System.out.println("Enter the dimention");
		String dimention = scanner.next();
		Asset phone = new Phone(serialNumber, brand, model, display, dimention);
		assetPool.add(phone);
	}

	/**
	 * Method deleteLaptop checks to see if a asset is assigned to an employee,
	 * if not - it searches the arraylist of asset using the serial number,
	 * and deletes that asset entry
	 */
	private static void deleteAsset() {
		System.out.println("Enter the serial number of the laptop");
		String serialNumber = scanner.nextLine();
		Asset laptop = assetPool.getLaptop(serialNumber);
		boolean laptopExist = laptop != null;
		if (laptopExist) {
			boolean laptopIsDeleted = assetPool.delete(laptop);
			if (laptopIsDeleted) {
				System.out.println("Deleting successfully");
			} else {
				System.out.println("Asset is assigned to an employee");
			}
		} else {
			System.out.println("No asset with this serial number !");
		}
	}

	/**
	 * Method searchLaptops, searches for a asset in the list using the serial
	 * number and then displays all its attributes in the specified format and
	 * sets the assigned asset date and the expected due date
	 */
	private static void searchAsset() {
		System.out.println("Enter the serial number of the asset");
		String serialNumber = scanner.nextLine();
		Asset laptop = assetPool.getLaptop(serialNumber);
		boolean laptopNotExist = laptop == null;
		if (laptopNotExist) {
			System.out.println("No asset with this serial number !");
			return;
		}
		System.out.printf("%-30s%-30s%-30s%-30s\n", "serialNumber", "brand", "model", "other");
		System.out.println(".................................................................");
		System.out.printf("%-30s%-30s%-30s%-30s\n", laptop.getSerialNumber(), laptop.getBrand(), laptop.getModel(), laptop.toString());

		if (laptop.isAssigned()) {
			Employee employee = laptop.getEmployee();
			System.out.printf("%-30s%-30s%-30s%-30s%-30s\n", "Employee number","Employee name","Employee location","assigned date","returning date");
			System.out.println(".................................................................");
			System.out.printf("%-30s%-30s%-30s%-30s%-30s\n", employee.getNumber(), employee.getName(), employee.getLocation(),
					employee.getAssignedLaptopDate(), laptop.getDueDate());

		}
	}

	/**
	 * Method assignLaptop first checks if the asset is assigned, if not it
	 * assigns the asset to the mentioned employee and sets the expected
	 * duedate
	 */
	private static void assignAsset() {
		System.out.println("Enter the serial number of the asset");
		String serialNumber = scanner.nextLine();
		Asset laptop = assetPool.getLaptop(serialNumber);
		boolean laptotNotExist = laptop == null;
		if (laptotNotExist) {
			System.out.println("No asset with this serial number !");
			return;
		}
		if (laptop.isAssigned()) {
			System.out.println("Asset already assigned !");
			return;
		}
		System.out.println("Enter the employee name");
		String name = scanner.nextLine();
		System.out.println("Enter the employee location");
		String location = scanner.nextLine();
		Employee employee = new Employee(name, location);
		employee.setAssignedLaptopDate(new Date());
		employee.setLaptop(laptop);
		laptop.setDueDate(new Date());
		laptop.setEmployee(employee);
		laptop.setAssigned(true);
	}

	/**
	 * Method returnLaptop obtains the asset from the list, and checks if it is
	 * already assigned if not,
	 */
	private static void returnAsset() {
		System.out.println("Enter the serial number of the asset");
		String serialNumber = scanner.nextLine();
		Asset laptop = assetPool.getLaptop(serialNumber);
		boolean laptotNotExist = laptop == null;
		if (laptotNotExist) {
			System.out.println("No asset with this serial number !");
			return;
		}
		if (!laptop.isAssigned()) {
			System.out.println("Laptop is not assigned yet !");
			return;
		}
		laptop.getEmployee().setReturningLaptopDate(new Date());
		laptop.getEmployee().removeLaptop();
		laptop.setAssigned(false);
	}

	/**
	 * Method printAssignedLaptop prints the list of assigned asset and their
	 * attributes in the specified format
	 */
	private static void printAssignedAsset() {
		Employee e;
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","Type", "Serial No", "Brand", "Model", "Assigned To",
				"Location", "Assigned Date", "Due Date", "Overdue By","ByLate Fee", "Other");
		System.out.println("................................................................................."
				+ "..........................................................");
		for (Asset laptop : assetPool.assignedLaptops()) {
			e = laptop.getEmployee();
			String line = "";
			long overdue;
			Date assignedDate = e.getAssignedLaptopDate();
			Date returnedDate = laptop.getEmployee().getReturningLaptopDate();
			if (!(returnedDate == null)) {

				if (returnedDate.getTime() > laptop.getDueDate().getTime()) {
				 
					overdue = returnedDate.getTime() - laptop.getDueDate().getTime();
					line = milliSecondToDays(overdue) + " days";
					System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", laptop.getClass().getName(), laptop.getSerialNumber(), laptop.getBrand(),
							laptop.getModel(), e.getName(), e.getLocation(), formatDate(assignedDate),
							formatDate(laptop.getDueDate()), line, laptop.toString());
				}
			} else {
				overdue = 0;
				String temp = String.valueOf(overdue)+ " days";
				System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20.2f%-20s\n", laptop.getClass().getName(), laptop.getSerialNumber(), laptop.getBrand(),
						laptop.getModel(), e.getName(), e.getLocation(), formatDate(assignedDate),
						formatDate(laptop.getDueDate()), temp,laptop.getOverdueFee(), laptop.toString());

			}

			System.out.printf(line);
			System.out.println();
		}
	}

	/**
	 * Method milliSecondToDays to convert milliseconds to days to obtain due
	 * date
	 */
	private static long milliSecondToDays(long milliseconds) {
		long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
		return days;
	}

	/**
	 * Main Class defining the console interface
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Asset Tracker Application \n");
		while (true) {

			System.out.println("1:  Add asset");
			System.out.println("2:  Delete asset (only if not assigned)");
			System.out.println("3:  List Assigned asset (if overdue; indicate number of days)");
			System.out.println("4:  Assign asset");
			System.out.println("5:  Return asset");
			System.out.println("6:  Search Laptops(if assigned; show assigned Employee details and usage period)");
			System.out.println("7:  Exit");

			int choice = scanner.nextInt();

			if (choice == 1) {
				addAsset();

			} else if (choice == 2) {
				deleteAsset();

			} else if (choice == 3) {
				printAssignedAsset();

			} else if (choice == 4) {
				assignAsset();

			} else if (choice == 5) {
				returnAsset();

			} else if (choice == 6) {
				searchAsset();

			} else {
				System.out.println("Exiting");
				System.exit(0);
			}

		}

	}
}
