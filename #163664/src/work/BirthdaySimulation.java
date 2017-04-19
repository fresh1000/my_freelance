package work;

import java.util.Random;

public class BirthdaySimulation {

	public static int getDayInMonth(int month) {
		final int JANUARY = 1;
		final int JULY = 7;
		final int FEBRUARY = 2;
		final int AUGUST = 8;
		final int MARCH = 3;
		final int SEPTEMBER = 9;
		final int APRIL = 4;
		final int OCTOBER = 10;
		final int MAY = 5;
		final int NOVEMBER = 11;
		final int JUNE = 6;
		final int DECEMBER = 12;

		Random dayGenerator = new Random();

		switch (month) {
		case JANUARY:
		case MARCH:
		case MAY:
		case JULY:
		case AUGUST:
		case OCTOBER:
		case DECEMBER:
			return dayGenerator.nextInt(31) + 1;
		case APRIL:
		case JUNE:
		case SEPTEMBER:
		case NOVEMBER:
			return dayGenerator.nextInt(30) + 1;
		case FEBRUARY:
			return dayGenerator.nextInt(28) + 1;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		Random month = new Random();
		int birthdayDay = 19;// bithday day
		int birthdayMonth = 10;// bithday month
		boolean found = false;// found bithday in loop
		for (int i = 0; i < 100; i++) {
			int resultMonth = month.nextInt(12) + 1;// random month
			int resultDay = getDayInMonth(resultMonth);// random day
			if (resultMonth == birthdayMonth && resultDay == birthdayDay) {
				System.out.println("Found!" + " Month: " + resultMonth + " Day: " + resultDay);
				found = true;// found true
			}
		}
		if (!found) {
			System.out.println("Not found!");
		}
	}

}
