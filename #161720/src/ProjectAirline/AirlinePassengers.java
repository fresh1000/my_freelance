package ProjectAirline;

import java.util.Scanner;

public class AirlinePassengers {

	public static void main(String[] args) {
		String[] names;
		String[] sections;
		names = new String[3];
		sections = new String[3];
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (count != 3) {
			System.out.print("Enter section(First Class, Economy Class):");
			sections[count] = sc.nextLine();
			System.out.print("Enter you name:");
			names[count] = sc.nextLine();
			count++;
		}
		System.out.println("Passenger and Seat Type:");
		for (int i = 0; i < names.length; i++) {
			System.out.println("Passenger: " + names[i] + " is in " + sections[i]);
		}
	}

}
