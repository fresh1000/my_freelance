/**
 *
 * @author 
 * @version 1.0, Java Project 5: Fractions
 */
import java.util.Scanner;

public class FractionTester {

	public static void main(String[] args) {
		int numerator;
		int denominator;
		int choice;
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numerator:");
		numerator = sc.nextInt();
		System.out.print("Enter denominator(not equals 0):");
		denominator = sc.nextInt();
		while (loop) {
			Fraction fraction = new Fraction(numerator, denominator);
			System.out.println("1.To string");
			System.out.println("2.To decimal");
			System.out.println("3.Reduce");
			System.out.println("4.Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(fraction.toString());
				break;
			case 2:
				System.out.println(fraction.toDecimal());
				break;
			case 3:
				fraction.reduce();
				System.out.println(fraction.toString());
				break;
			default:
				loop = false;
				break;
			}
		}

	}

}
