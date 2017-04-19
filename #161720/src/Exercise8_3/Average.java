package Exercise8_3;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[6];
		double average = 0;
		System.out.println("Enter 6 numbers:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
			average += numbers[i];
		}
		average /= numbers.length;
		System.out.printf("Average = %.2f", average);
	}

}
