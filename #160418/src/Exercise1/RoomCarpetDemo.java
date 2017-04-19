package Exercise1;

import java.util.Locale;
import java.util.Scanner;

public class RoomCarpetDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// scanner for read from console
		sc.useLocale(Locale.US);// read double with "."
		double length1, length2, width1, width2, cost1, cost2;
		System.out.print("Enter the dimensions of the first room:");
		length1 = sc.nextDouble();// read from console
		width1 = sc.nextDouble();// read from console
		System.out.print("Enter the cost per square foot of carpet: ");
		cost1 = sc.nextDouble();// read from console
		System.out.print("Enter the dimensions of the second room:");
		length2 = sc.nextDouble();// read from console
		width2 = sc.nextDouble();// read from console
		System.out.print("Enter the cost per square foot of carpet: ");
		cost2 = sc.nextDouble();// read from console

		RoomDimension roomDim1 = new RoomDimension(length1, width1);
		RoomDimension roomDim2 = new RoomDimension(length2, width2);
		RoomCarpet roomCarpet1 = new RoomCarpet(roomDim1, cost1);
		RoomCarpet roomCarpet2 = new RoomCarpet(roomDim2, cost2);

		if (roomCarpet1.costsMore(roomCarpet2)) {//if costs room carpet 1 more carpet 2
			System.out.println(roomCarpet1.toString());
			System.out.println("costs more than");
			System.out.println(roomCarpet2.toString());
		} else if (roomCarpet1.getTotalCost() == roomCarpet2.getTotalCost()) {//if costs equals 
			System.out.println(roomCarpet1.toString());
			System.out.println("and");
			System.out.println(roomCarpet2.toString());
			System.out.println("cost the same");
		} else if (roomCarpet2.costsMore(roomCarpet1)) {//if costs room carpet 2 more carpet 1
			System.out.println(roomCarpet2.toString());
			System.out.println("costs more than");
			System.out.println(roomCarpet1.toString());
		}

	}

}
