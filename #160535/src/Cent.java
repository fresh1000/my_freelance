import java.util.Scanner;
/* Cent.java */
/* 
   Author: Your Name
   Due Date: 07/02/2017
   Time taken to complete this exercise: 2 hour 
*/ 
/* This program calculates pennies, quarters, dimes, nikels.

  Input:
   Enter the number of cent(0-99).
   Enter "y" for continue and "n" for exit program. 
 Output:
   Display the number of quarters.
   Display the number of dimes.
   Display the number of nikels.
   Display the number of pennies.
*/ 
public class Cent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cent;// variables for save cent
		boolean restart = true;// variables for save continue or no 
		while(restart) {
			System.out.println("Welcome to the Change Calculator");
			System.out.println();
			System.out.print("Enter number of cents (0-99): ");
			cent = sc.nextInt();//read from console
			System.out.println();
			
			int quarters, dimes, nikels, pennies;//variables
			String yesOrNo;//string for save user choice 
			quarters = cent / 25;//quarters calculate, the integer part of(cent / 25)
			System.out.println("Quarters: " + quarters);
			dimes = (cent % 25) / 10;//quarters calculate, the integer part of ((cent % 25) / 10)
			System.out.println("Dimes: " + dimes);
			nikels = ((cent % 25) % 10) / 5;//quarters calculate, the integer part of(((cent % 25) % 10) / 5)
			System.out.println("Nikels: " + nikels);
			pennies = (((cent % 25) % 10) % 5) / 1;//quarters calculate, the integer part of((((cent % 25) % 10) % 5) / 1)
			System.out.println("Pennies: " + pennies);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			yesOrNo = sc.next();//read from console user choice
			if(yesOrNo.equals("Y") || yesOrNo.equals("y")) {
				restart = true;//if user choice yes continue loop
			}else
				restart = false;//else exit loop and program
		}
	}

}
