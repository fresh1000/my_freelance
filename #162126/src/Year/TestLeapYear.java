package Year;

public class TestLeapYear {

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int year = 1999;
		boolean result = isLeapYear(year);
		System.out.println("Is " + year + " a leap year? " + result);

		year = 2012;
		result = isLeapYear(year);
		System.out.println("Is " + year + " a leap year? " + result);
	}

}
