import java.util.Locale;
import java.util.Scanner;

/* HW.java: Assignment #3 – CIT130: Java Programming */
/* 
   Author: Your Name
   Due Date: 06/02/2017
   Time taken to complete this exercise: 3 hour 
*/ 
/* This program calculates and 
 * a)Calculate and display the number of years and days( people have spent working).
 * b)Calculate pennies.
 * c)Calculate volume and area of the cylinder.
 * d)Calculate item price marked up by 20%, after calculate discount 5%.
 * e)Calculate minimum runway length needed for an airplane.

  Input:
   a)Enter the number of minutes a bunch of people have spent working.
   b)Enter the number of half-dollars, quarters, dimes and nickels.
   c)Enter the radius and length of a cylinder.
   d)Enter price item.
   e)Enter the acceleration and take-off speed of an airplane.
 Output:
   a)Display the number of years and days.
   b)Display the number of pennies.
   c)Display area and volume.
   d)Display price after up by 20% and price after discount 5%
   e)Display minimum runway length needed for an airplane.
*/ 
public class HW {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//create instance scanner
		sc.useLocale(Locale.US);//read scanner double with "."
		
		int minutes, year, day;//variables
		System.out.println("a)");
		System.out.print("Enter minutes: ");
		minutes = sc.nextInt();//read from console minutes
		year = minutes / (365 * 24 * 60);//calculate year
		day = (minutes % (365 * 24 * 60)) / (24 * 60);//calculate days
		System.out.println("Result: " + year + " years " + day + " days");//print result
  	    System.out.println();
		
		System.out.println("b)");
		int half_dollars, quarters, dimes, nickels, pennies;//variables
		System.out.print("Enter  half_dollars: ");
		half_dollars = sc.nextInt();//read from console half-dollars
		System.out.print("Enter quarters: ");
		quarters = sc.nextInt();//read from console quarters
		System.out.print("Enter dimes: ");
		dimes = sc.nextInt();//read from console dimes
		System.out.print("Enter nickels: ");
		nickels = sc.nextInt();//read from console half_nickels
		pennies = half_dollars * 50 + quarters * 25 + dimes * 10 + nickels * 5;//calculate pennies
		System.out.println("Result pennies: " + pennies);//print pennies
		System.out.println();
		
		System.out.println("c)");
		double radius, length, volume, area;//variables
		System.out.print("Enter radius: ");
		radius = sc.nextDouble();//read from console radius
		System.out.print("Enter length: ");
		length = sc.nextDouble();//read from console length
		area = radius * radius * Math.PI;//calculate area
		volume = area * length;//calculate volume
		System.out.println("Result area: " + area);//print area
		System.out.println("Result volume: " + volume);//print volume
		System.out.println();
		
		System.out.println("d)");
		double price;//variable
		System.out.print("Enter price item: ");
		price = sc.nextDouble();//read from console price
		price = price * 1.2;//calculate update price up by 20%
		System.out.println("Price item after up 20%: " + price);//print update
		price = price * 0.95;//calculate update price discount 5%
		System.out.println("Price item after discount 5%: " + price);//print update
		System.out.println();
		
		System.out.println("e)");
		double speed, acceleration, lengthRunaway;//variables
		System.out.print("Enter speed: ");
		speed = sc.nextDouble();//read from console speed
		System.out.print("Enter acceleration: ");
		acceleration = sc.nextDouble();//read from console acceleration
		lengthRunaway = speed * speed / (2 * acceleration);//calculate length
		System.out.println("Minimum runway length needed for an airplane: " + lengthRunaway);//print length
	}//end of main method 

}//end of the class definition
