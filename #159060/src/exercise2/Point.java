package exercise2;

import java.util.Scanner;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void isEqual(Point b, Point c, Point d) {
		if (x == b.getX() && y == b.getY())
			System.out.println("Points " + toString()+" eguals point " + b);
		if (x == c.getX() && y == c.getY())
			System.out.println("Points " + toString()+" eguals point " + c);
		if (x == d.getX() && y == d.getY())
			System.out.println("Points " + toString()+" eguals point " + c);
	}

	public void isHigher(Point b, Point c, Point d) {
		double distance1, distance2, distance3, distanñe4;
		boolean once = true;
		distance1 = (double) Math.sqrt(x * x + y * y);
		distance2 = (double) Math.sqrt(b.getX() * b.getX() + b.getY() * b.getY());
		distance3 = (double) Math.sqrt(c.getX() * c.getX() + c.getY() * c.getY());
		distanñe4 = (double) Math.sqrt(d.getX() * d.getX() + d.getY() * d.getY());
		if (distance1 <= distance2 && distance1 <= distance3 && distance1 <= distanñe4 && once) {
			System.out.println(toString() + " is the highest point");
			once = false;
		}else if (distance2 <= distance1 && distance2 <= distance3 && distance2 <= distanñe4 && once) {
			System.out.println(b.toString() + " is the highest point");
			once = false;
		}else if (distance3 <= distance1 && distance3 <= distance2 && distance3 <= distanñe4 && once) {
			System.out.println(c.toString() + " is the highest point");
			once = false;
		}else if (distanñe4 <= distance2 && distance1 <= distance3 && distanñe4 <= distance1 && once) {
			System.out.println(d.toString() + " is the highest point");
			once = false;
		}
		

	}

	public double findDistance(Point b) {
		double distanñe;
		distanñe = Math.sqrt(Math.pow((b.getX() - x), 2) + Math.pow((b.getY() - y),2));
		return distanñe;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pointX1,pointX2,pointX3, pointX4,pointY1,pointY2,pointY3,pointY4;
		System.out.print("Enter the X and Ó coordinates of point1 :");
		pointX1 = sc.nextInt();
		pointY1 = sc.nextInt();
		System.out.print("Enter the X and Ó coordinates of point2 :");
		pointX2 = sc.nextInt();
		pointY2 = sc.nextInt();
		System.out.print("Enter the X and Ó coordinates of point3 :");
		pointX3 = sc.nextInt();
		pointY3 = sc.nextInt();
		System.out.print("Enter the X and Ó coordinates of point4 :");
		pointX4 = sc.nextInt();
		pointY4 = sc.nextInt();
		Point p1 = new Point(pointX1, pointY1);
		Point p2 = new Point(pointX2, pointY2);
		Point p3 = new Point(pointX3, pointY3);
		Point p4 = new Point(pointX4, pointY4);
		p1.isHigher(p2, p3, p4);
		
		System.out.println("The distanse between " + p1.toString() + " and " + p2.toString() + " is " + p1.findDistance(p2));
		System.out.println("The distanse between " + p3.toString() + " and " + p4.toString() + " is " + p3.findDistance(p4));
		if(p1.findDistance(p2) < p3.findDistance(p4))
			System.out.println(p3.toString() + "-->" + p4.toString() + " is longer than " + p1.toString() + "-->" + p2.toString());
		if(p1.findDistance(p2) > p3.findDistance(p4))
			System.out.println(p1.toString() + "-->" + p2.toString()+ " is longer than " + p3.toString() + "-->" + p4.toString());
		else 
			System.out.println(p1.toString() + "-->" + p2.toString()+ " is equals " + p3.toString() + "-->" + p4.toString());
		
	}

}
