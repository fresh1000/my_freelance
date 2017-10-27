import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//use scanner for read from console
		double radius = 0;
		double area, circumference;
		System.out.print("Enter radius: ");
		radius = sc.nextDouble();//read radius from console
		area = 3.14 * radius * radius;//calculate area 
		circumference = 2 * 3.14 * radius;//calculate circumference
		System.out.println("Area: " + area);//print area
		System.out.println("Circumference:" + circumference);//print circumference
		
	}

}
