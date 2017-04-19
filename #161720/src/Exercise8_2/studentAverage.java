package Exercise8_2;

import java.util.Scanner;

public class studentAverage {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] grades;
		int numStudent;
		double average = 0;
		System.out.println("Enter number of students in a class:");
		numStudent = sc.nextInt();
		grades = new int[numStudent];
		System.out.println("Enter the final exam grade:");
		for (int i = 0; i < grades.length; i++) {
			grades[i] = sc.nextInt();
		}
		for (int i = 0; i < grades.length; i++) {
			System.out.println(grades[i]);
			average = average + grades[i];
		}
		average = average / numStudent;
		System.out.printf("Class Average = %.2f", average);
	}

}
