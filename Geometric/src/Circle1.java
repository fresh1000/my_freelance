
public class Circle1 extends GeometricObject1{
	private double radius;
	
	public Circle1(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return this.radius * this.radius * Math.PI;
	}

	public double getPerimeter() {
		return 2 * this.radius * Math.PI;
	}
	
	public String toString() {
		return "Circle - Radius: " + this.radius + " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter();
	}

}
