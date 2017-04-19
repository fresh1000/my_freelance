package Factorial;

public class TestFactorial {

	public static int factorial(int x) {
		int n = 1;
		for (int i = 2; i <= x; i++) {
			n = n * i;
		}
		return n;
	}

	public static void main(String[] args) {
		int input = 3;

		int result = factorial(input);

		System.out.println("Factorial of " + input + " is " + result);

		input = 5;

		result = factorial(input);

		System.out.println("Factorial of " + input + " is " + result);
	}

}
