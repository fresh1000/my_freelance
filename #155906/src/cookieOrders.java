
/**
* Final Exam
* Final Exam Challenge Girl Scout Cookies
*
* @author 
* Date: December 3, 2016
* Filename: cookieOrders.java
*
* This is the cookieOrders program which contains the cookieOrders class and main method.
* This class create order and make some manipulations. 
*
*
* @param �
* @return �
*/
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class cookieOrders {
	private int numOfCustomers;

	// get order from file
	public ArrayList<girlScoutCookie> getPrevOrder() throws IOException {
		ArrayList<girlScoutCookie> scout = new ArrayList<girlScoutCookie>();// create
																			// scout
																			// list
																			// for
																			// file
		File file1 = new File("Orders.txt");
		FileReader file = new FileReader(file1);
		Scanner input = new Scanner(file);
		// if file empty
		if (!input.hasNextLine()) {
			numOfCustomers = 0;
			return null;
		}
		// if file not exists
		if (!file1.exists()) {
			file1.createNewFile();
			numOfCustomers = 0;
			return null;
		} else {
			// variables for all informations read from file
			String line;
			String[] lineVec;
			String text;
			String title;
			String firstName;
			String lastName;
			String address;
			String city;
			String state;
			String zipCode;
			String phoneNum;
			ArrayList<Integer> cookie = new ArrayList<Integer>(8);
			while (input.hasNextLine()) {
				line = input.nextLine();
				lineVec = line.split(",");
				title = lineVec[0];
				firstName = lineVec[1];
				lastName = lineVec[2];
				address = lineVec[3];
				city = lineVec[4];
				state = lineVec[5];
				zipCode = lineVec[6];
				phoneNum = lineVec[7];
				cookie.add(Integer.parseInt(lineVec[8]));
				cookie.add(Integer.parseInt(lineVec[9]));
				cookie.add(Integer.parseInt(lineVec[10]));
				cookie.add(Integer.parseInt(lineVec[11]));
				cookie.add(Integer.parseInt(lineVec[12]));
				cookie.add(Integer.parseInt(lineVec[13]));
				cookie.add(Integer.parseInt(lineVec[14]));
				cookie.add(Integer.parseInt(lineVec[15]));
				scout.add(new girlScoutCookie(title, firstName, lastName, address, city, state, zipCode, phoneNum,
						cookie));
				numOfCustomers++;
			}
		}
		return scout; // return array list customers
	}

	// display menu
	public void displayMenu() throws IOException {
		Scanner sc = new Scanner(System.in);// for read all informations from
											// console
		int choice;
		ArrayList<girlScoutCookie> prev = getPrevOrder();
		ArrayList<girlScoutCookie> scout = new ArrayList<girlScoutCookie>();// all
																			// customers
																			// list
		if (prev != null) {// if method getPrevOrder return customers
			scout.addAll(getPrevOrder());// add to list
		}
		// infinity loop
		while (true) {
			// menu
			System.out.println();
			System.out.println("GIRL SCOUT COOKIES�MENU");
			System.out.println("-----------------------");
			System.out.println("0. Exit the program");
			System.out.println("1. Input Customer Order");
			System.out.println("2. Change Customer Order");
			System.out.println("3. Delete Customer Order");
			System.out.println("4. Display Customer Order");
			System.out.println("5. Display all the Customer Orders");
			System.out.println("6. Print Customer Invoices");
			System.out.print("Please enter your choice (0-6): ");
			choice = sc.nextInt();// read from console choice
			switch (choice) {
			case 0:
				// write all customer info and end program
				FileWriter writer = new FileWriter("Orders.txt");
				if (scout != null) {
					for (int i = 0; i < scout.size(); i++) {
						writer.write(scout.get(i).toString());
						writer.append("\n");

					}

					writer.flush();
					writer.close();
				}
				System.exit(0);
				break;
			case 1:
				// read and add customer from console with validations
				String title;
				String firstName;
				String lastName;
				String address;
				String city;
				String state;
				String zipCode;
				String phoneNum;
				ArrayList<Integer> cookie = new ArrayList<Integer>(8);
				title = sc.nextLine();
				do {
					System.out.print("Title(Mr.,Mrs. or Ms.):");
					title = sc.nextLine();
					if (!title.equals("Mr.") && !title.equals("Mrs.") && !title.equals("Ms.")) {
						System.out.println("Invalid input!!");
					}
				} while (!title.equals("Mr.") && !title.equals("Mrs.") && !title.equals("Ms."));

				do {
					System.out.print("First name(max size 15):");
					firstName = sc.nextLine();
					if (firstName.length() > 15 || !firstName.matches("^([A-Za-z])+$")) {
						System.out.println("Invalid input!!");
					}
				} while (firstName.length() > 15 || !firstName.matches("^([A-Za-z])+$"));

				do {
					System.out.print("Last name(max size 15):");
					lastName = sc.nextLine();
					if (lastName.length() > 15 || !lastName.matches("^([A-Za-z])+$")) {
						System.out.println("Invalid input!!");
					}
				} while (lastName.length() > 15 || !lastName.matches("^([A-Za-z])+$"));

				do {
					System.out.print("Address(max size 20):");
					address = sc.nextLine();
					if (address.length() > 20) {
						System.out.println("Invalid input!!");
					}
				} while (address.length() > 20);

				do {
					System.out.print("City(max size 15):");
					city = sc.nextLine();
					if (city.length() > 15) {
						System.out.println("Invalid input!!");
					}
				} while (city.length() > 15);

				do {
					System.out.print("State(max size 2):");
					state = sc.nextLine();
					if (state.length() > 2) {
						System.out.println("Invalid input!!");
					}
				} while (state.length() > 2);

				do {
					System.out.print("Zip code(max size 5):");
					zipCode = sc.nextLine();
					if (zipCode.length() > 5 || !zipCode.matches("^[0-9]+$")) {
						System.out.println("Invalid input!!");
					}
				} while (zipCode.length() > 5 || !zipCode.matches("^[0-9]+$"));

				do {
					System.out.print("Phone number (nnn-mmm-mmmm):");
					phoneNum = sc.nextLine();
					if (phoneNum.length() > 12 || !phoneNum.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
						System.out.println("Invalid input!!");
					}
				} while (phoneNum.length() > 12 || !phoneNum.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"));

				int cookie0;
				int cookie1;
				int cookie2;
				int cookie3;
				int cookie4;
				int cookie5;
				int cookie6;
				int cookie7;
				System.out.println("Cookie(0-100):");
				do {
					System.out.print("Do-Si-Dos:");
					cookie0 = sc.nextInt();
					System.out.print("Dulce DeLeche:");
					cookie1 = sc.nextInt();
					System.out.print("Samoas:");
					cookie2 = sc.nextInt();
					System.out.print("Savannah Smiles:");
					cookie3 = sc.nextInt();
					System.out.print("Tagalongs:");
					cookie4 = sc.nextInt();
					System.out.print("Thank U Berry Munch:");
					cookie5 = sc.nextInt();
					System.out.print("Thin Mints:");
					cookie6 = sc.nextInt();
					System.out.print("Trefoils:");
					cookie7 = sc.nextInt();
					if ((cookie0 > 100 || cookie0 < 0) || (cookie1 > 100 || cookie1 < 0)
							|| (cookie2 > 100 || cookie2 < 0) || (cookie3 > 100 || cookie3 < 0)
							|| (cookie4 > 100 || cookie4 < 0) || (cookie5 > 100 || cookie5 < 0)
							|| (cookie6 > 100 || cookie6 < 0) || (cookie7 > 100 || cookie7 < 0)) {
						System.out.println("Invalid input!");
					}
				} while ((cookie0 > 100 || cookie0 < 0) || (cookie1 > 100 || cookie1 < 0)
						|| (cookie2 > 100 || cookie2 < 0) || (cookie3 > 100 || cookie3 < 0)
						|| (cookie4 > 100 || cookie4 < 0) || (cookie5 > 100 || cookie5 < 0)
						|| (cookie6 > 100 || cookie6 < 0) || (cookie7 > 100 || cookie7 < 0));

				cookie.add(cookie0);
				cookie.add(cookie1);
				cookie.add(cookie2);
				cookie.add(cookie3);
				cookie.add(cookie4);
				cookie.add(cookie5);
				cookie.add(cookie6);
				cookie.add(cookie7);

				scout.add(new girlScoutCookie(title, firstName, lastName, address, city, state, zipCode, phoneNum,
						cookie));
				numOfCustomers++;
				break;
			case 2:
				// change order
				int number;
				ArrayList<Integer> cookieSet = new ArrayList<Integer>(8);
				System.out.println("Customer - ");
				for (int i = 0; i < scout.size(); i++) {
					System.out.println(i);
					System.out.println(scout.get(i).getLastName() + " " + scout.get(i).getFirstName());
				}
				System.out.print("Enter number customer:");
				number = sc.nextInt();
				System.out.println(
						"Customer: " + scout.get(number).getLastName() + " " + scout.get(number).getFirstName());
				for (int i = 0; i < scout.get(number).getCookie().size(); i++) {
					if (i == 0) {
						System.out.print("Do-Si-Dos:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 1) {
						System.out.print("Dulce DeLeche:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 2) {
						System.out.print("Samoas:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 3) {
						System.out.print("Savannah Smiles:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 4) {
						System.out.print("Tagalongs:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 5) {
						System.out.print("Thank U Berry Munch:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 6) {
						System.out.print("Thin Mints:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
					if (i == 7) {
						System.out.print("Trefoils:");
						System.out.println(scout.get(number).getCookie().get(i));
					}
				}

				int cookie0Set;
				int cookie1Set;
				int cookie2Set;
				int cookie3Set;
				int cookie4Set;
				int cookie5Set;
				int cookie6Set;
				int cookie7Set;
				System.out.println();
				System.out.println("Set your change");
				System.out.println("Cookie(0-100):");
				do {
					System.out.print("Do-Si-Dos:");
					cookie0Set = sc.nextInt();
					System.out.print("Dulce DeLeche:");
					cookie1Set = sc.nextInt();
					System.out.print("Samoas:");
					cookie2Set = sc.nextInt();
					System.out.print("Savannah Smiles:");
					cookie3Set = sc.nextInt();
					System.out.print("Tagalongs:");
					cookie4Set = sc.nextInt();
					System.out.print("Thank U Berry Munch:");
					cookie5Set = sc.nextInt();
					System.out.print("Thin Mints:");
					cookie6Set = sc.nextInt();
					System.out.print("Trefoils:");
					cookie7Set = sc.nextInt();
					if ((cookie0Set > 100 || cookie0Set < 0) || (cookie1Set > 100 || cookie1Set < 0)
							|| (cookie2Set > 100 || cookie2Set < 0) || (cookie3Set > 100 || cookie3Set < 0)
							|| (cookie4Set > 100 || cookie4Set < 0) || (cookie5Set > 100 || cookie5Set < 0)
							|| (cookie6Set > 100 || cookie6Set < 0) || (cookie7Set > 100 || cookie7Set < 0)) {
						System.out.println("Invalid input!");
					}
				} while ((cookie0Set > 100 || cookie0Set < 0) || (cookie1Set > 100 || cookie1Set < 0)
						|| (cookie2Set > 100 || cookie2Set < 0) || (cookie3Set > 100 || cookie3Set < 0)
						|| (cookie4Set > 100 || cookie4Set < 0) || (cookie5Set > 100 || cookie5Set < 0)
						|| (cookie6Set > 100 || cookie6Set < 0) || (cookie7Set > 100 || cookie7Set < 0));

				cookieSet.add(cookie0Set);
				cookieSet.add(cookie1Set);
				cookieSet.add(cookie2Set);
				cookieSet.add(cookie3Set);
				cookieSet.add(cookie4Set);
				cookieSet.add(cookie5Set);
				cookieSet.add(cookie6Set);
				cookieSet.add(cookie7Set);
				scout.get(number).setCookie(cookieSet);
				if (scout.get(number).getCookie().get(0) == 0 && scout.get(number).getCookie().get(1) == 0
						&& scout.get(number).getCookie().get(2) == 0 && scout.get(number).getCookie().get(3) == 0
						&& scout.get(number).getCookie().get(4) == 0 && scout.get(number).getCookie().get(5) == 0
						&& scout.get(number).getCookie().get(6) == 0 && scout.get(number).getCookie().get(7) == 0) {
					scout.remove(number);
					numOfCustomers--;
				}
				break;
			case 3:
				// delete customer
				int deleteCustomer;
				System.out.println("Customer - ");
				for (int i = 0; i < scout.size(); i++) {
					System.out.println(i);
					System.out.println(scout.get(i).getLastName() + " " + scout.get(i).getFirstName());
				}
				System.out.print("Choice num customer was delete:");
				deleteCustomer = sc.nextInt();
				scout.remove(deleteCustomer);
				numOfCustomers--;
				System.out.println("Customer " + deleteCustomer + "deleted");
				break;
			case 4:
				// display customer information
				for (int i = 0; i < scout.size(); i++) {
					System.out.println("Customer - ");
					int total = 0;
					double totalPrice = 0;
					total = total + scout.get(i).getCookie().get(0) + scout.get(i).getCookie().get(1)
							+ scout.get(i).getCookie().get(2) + scout.get(i).getCookie().get(3)
							+ scout.get(i).getCookie().get(4) + scout.get(i).getCookie().get(5)
							+ scout.get(i).getCookie().get(6) + scout.get(i).getCookie().get(7);
					totalPrice = total * 4.50;
					String firstPlast = scout.get(i).getFirstName() + " " + scout.get(i).getLastName();
					System.out.printf("  %-4s %-31s ", scout.get(i).getTitle(), firstPlast);
					System.out.printf("                                  Total Boxes Ordered:  %d\n", total);
					System.out.printf(
							"  %-35s                                    Amount Due:            $     %10.2f\n",
							scout.get(i).getAddress(), totalPrice);
					System.out.printf("  %s, %s  %s\n", scout.get(i).getCity(), scout.get(i).getState(),
							scout.get(i).getZipCode());
					System.out.printf("  %s\n\n", scout.get(i).getPhoneNum());
					System.out.println("Cookies Ordered � ");
					System.out.printf(" Do-Si-Dos:      %d Dulce DeLeche:   %d  Samoas:               %d\n",
							scout.get(i).getCookie().get(0), scout.get(i).getCookie().get(1),
							scout.get(i).getCookie().get(2));
					System.out.printf(" Savannah:       %d Tagalongs:       %d  Thank U Berry Munch:  %d\n",
							scout.get(i).getCookie().get(3), scout.get(i).getCookie().get(4),
							scout.get(i).getCookie().get(5));
					System.out.printf(" Thin Mints:     %d Trefoils:        %d\n\n", scout.get(i).getCookie().get(6),
							scout.get(i).getCookie().get(7));
				}
				break;
			case 5:
				// total order information
				int totalAll = 0;
				double totalAllPrice;
				System.out.println("GIRL SCOUT COOKIE TOTALS");
				System.out.printf("  Total Number of Customers:     %d\n", scout.size());
				for (int i = 0; i < scout.size(); i++) {
					totalAll = totalAll + scout.get(i).getCookie().get(0) + scout.get(i).getCookie().get(1)
							+ scout.get(i).getCookie().get(2) + scout.get(i).getCookie().get(3)
							+ scout.get(i).getCookie().get(4) + scout.get(i).getCookie().get(5)
							+ scout.get(i).getCookie().get(6) + scout.get(i).getCookie().get(7);
				}
				totalAllPrice = totalAll * 4.50;
				System.out.printf("  Total Boxes Ordered:          %d\n", totalAll);
				System.out.printf("  Gross Sales:                   $   %10.2f", totalAllPrice);
				System.out.println();

				int sum0 = 0;
				int sum1 = 0;
				int sum2 = 0;
				int sum3 = 0;
				int sum4 = 0;
				int sum5 = 0;
				int sum6 = 0;
				int sum7 = 0;
				for (int i = 0; i < scout.size(); i++) {
					sum0 += scout.get(i).getCookie().get(0);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum1 += scout.get(i).getCookie().get(1);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum2 += scout.get(i).getCookie().get(2);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum3 += scout.get(i).getCookie().get(3);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum4 += scout.get(i).getCookie().get(4);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum5 += scout.get(i).getCookie().get(5);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum6 += scout.get(i).getCookie().get(6);
				}
				for (int i = 0; i < scout.size(); i++) {
					sum7 += scout.get(i).getCookie().get(7);
				}
				System.out.println("Total Sold �");
				System.out.printf("  Do-Si-Dos:   %d    Dulce DeLeche:    %d    Samoas:               %d\n", sum0, sum1,
						sum2);
				System.out.printf("  Savannah:    %d    Tagalongs:        %d    Thank U Berry Munch:  %d\n", sum3, sum4,
						sum5);
				System.out.printf("  Thin Mints:  %d    Trefoils:         %d\n", sum6, sum7);
				break;
			case 6:
				// write invoices
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				String date = dtf.format(localDate);
				File file2 = new File("CustomerInvoices.txt");
				if (!file2.exists()) {
					file2.createNewFile();
				}
				FileWriter writeInvoices = new FileWriter(file2);
				for (int i = 0; i < scout.size(); i++) {
					int totalInvoices = 0;
					double totalInvoicesPrice = 0;
					for (int j = 0; j < scout.get(i).getCookie().size(); j++) {
						totalInvoices = totalInvoices + scout.get(i).getCookie().get(j);
					}
					totalInvoicesPrice = totalInvoices * 4.50;
					writeInvoices.write(date + '\n');
					writeInvoices.write("\n");
					writeInvoices.write(scout.get(i).getTitle() + " " + scout.get(i).getFirstName() + " "
							+ scout.get(i).getLastName() + '\n');
					writeInvoices.write(scout.get(i).getAddress() + '\n');
					writeInvoices.write(scout.get(i).getCity() + ", " + scout.get(i).getState() + "  "
							+ scout.get(i).getZipCode() + '\n');
					writeInvoices.write("\n");
					writeInvoices.write("Dear " + scout.get(i).getTitle() + " " + scout.get(i).getFirstName() + " "
							+ scout.get(i).getLastName() + '\n');
					writeInvoices.write("\n");
					writeInvoices.write("Your Girl Scout Cookie order has arrived. You order consists of the following:"
							+ '\n' + '\n');
					writeInvoices.write("       Cookie           Quantity        Cost\n");
					writeInvoices.write("-------------------- --------------- ----------\n");
					writeInvoices.write("Do-Si-Dos                  " + scout.get(i).getCookie().get(0) + "          "
							+ "$ " + scout.get(i).getCookie().get(0) * 4.50 + "\n");
					writeInvoices.write("Dulce DeLeche              " + scout.get(i).getCookie().get(1) + "          "
							+ "$ " + scout.get(i).getCookie().get(1) * 4.50 + "\n");
					writeInvoices.write("Samosas                    " + scout.get(i).getCookie().get(2) + "          "
							+ "$ " + scout.get(i).getCookie().get(2) * 4.50 + "\n");
					writeInvoices.write("Savannah Smiles            " + scout.get(i).getCookie().get(3) + "          "
							+ "$ " + scout.get(i).getCookie().get(3) * 4.50 + "\n");
					writeInvoices.write("Tagalongs                  " + scout.get(i).getCookie().get(4) + "          "
							+ "$ " + scout.get(i).getCookie().get(4) * 4.50 + "\n");
					writeInvoices.write("Thank U Berry Much         " + scout.get(i).getCookie().get(5) + "          "
							+ "$ " + scout.get(i).getCookie().get(5) * 4.50 + "\n");
					writeInvoices.write("Thin Mints                 " + scout.get(i).getCookie().get(6) + "          "
							+ "$ " + scout.get(i).getCookie().get(6) * 4.50 + "\n");
					writeInvoices.write("Trefoils                   " + scout.get(i).getCookie().get(7) + "          "
							+ "$ " + scout.get(i).getCookie().get(7) * 4.50 + "\n");
					writeInvoices.write("                                     ----------\n");

					writeInvoices
							.write("Total Due:                            " + "$ " + totalInvoicesPrice + "\n" + "\n");
					writeInvoices
							.write("Girl scouting builds girls of courage, confidence, and character, who make the world a better place. On\n"
									+ "behalf of the Girl Scouts, I would like to sincerely thank you for your support which helps us continue\n"
									+ "our mission.\n\n");
					writeInvoices.write("Sincerely,\n\n");
					writeInvoices.write("Dakota Fanning");
					writeInvoices.append("\n");
					writeInvoices.append("\n");
				}
				writeInvoices.flush();
				writeInvoices.close();
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		cookieOrders orders = new cookieOrders();
		orders.displayMenu();
	}

}
