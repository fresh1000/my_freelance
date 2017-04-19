package ProjectConversion;

public class Conversion {
	static int celsius(int fahrenheit) {
		int celsius;
		celsius = (int) (5.0 / 9.0 * (fahrenheit - 32));
		return celsius;
	}

	static int fahrenheit(int celsius) {
		int fahrenheit;
		fahrenheit = (int) (9.0 / 5.0 * celsius + 32);
		return fahrenheit;
	}

	static void getTemperatures(int temperatures[]) {
		for (int i = 0; i < temperatures.length; i++) {
			System.out.println(
					temperatures[i] + " degrees Fahrenheit is " + celsius(temperatures[i]) + " degrees Celsius");
			System.out.println(
					temperatures[i] + " degrees Celsius is " + fahrenheit(temperatures[i]) + " degrees Fahrenheit");
		}
	}

	public static void main(String[] args) {
		int temperatures[] = { 10, 15, 20, 25, 30, 32, 40, 45, 50, 55, 60, 65, 70 };
		getTemperatures(temperatures);
	}

}
