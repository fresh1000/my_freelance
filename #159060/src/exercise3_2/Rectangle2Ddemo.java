package exercise3_2;

import java.util.Locale;
import java.util.Scanner;

public class Rectangle2Ddemo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		double xpos,ypos,width,height;
		System.out.print("Enter the xpos, ypos, width and height of the rectangle: ");
		xpos = sc.nextDouble();
		ypos = sc.nextDouble();
		width = sc.nextDouble();
		height = sc.nextDouble();
		Rectangle2D r1 = new Rectangle2D(xpos, ypos, width, height);
		System.out.println("The perimeter of the rectangle is " + r1.getPerimeter());
		System.out.println("The area of the rectangle is " + r1.getArea());
		
		double xPoint,yPoint;
		xPoint = 3;//coordinates 
		yPoint = 3;//test point
		if(r1.contains(xPoint, yPoint)){
			System.out.println(r1.toString() + " contains point [" + xPoint + "," + yPoint + "]");
		}else
			System.out.println(r1.toString() + "  does no contain point [" + xPoint + "," + yPoint + "]");
		
		Rectangle2D r2 = new Rectangle2D(4, 5, 10.5, 3.2);//test rectangle 
		if(r1.contains(r2)) {
			System.out.println(r1.toString() + " contains " + r2.toString());
		}else
			System.out.println(r1.toString() + " does not contain " + r2.toString());
	}
}
