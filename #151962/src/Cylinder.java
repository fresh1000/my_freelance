
public class Cylinder extends Circle{
	private double height;
	private double volume;
	private double areaCylinder;
	
	public Cylinder(double x, double y, double radius, double height) {
		super(x, y, radius);
		this.height = height;
	}
	
	public void volume() {
		volume = Math.PI * height * radius * radius;
	}
	
	public void areaCylinder() {
		areaCylinder = 2 * Math.PI * radius * height;
	}
	
	public void printVolume() {
		System.out.println("Volume: " + volume);
	}

	public void printAreaCylinder() {
		System.out.println("Area Cylinder: " + areaCylinder);
	}
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setCentre(double x, double y) {
		this.xPoint = x;
		this.yPoint = y;
	}

}
