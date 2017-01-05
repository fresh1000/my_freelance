public class Point {
	protected double xPoint;
	protected double yPoint;
	
	public double getxPoint() {
		return xPoint;
	}
	public void setxPoint(double xPoint) {
		this.xPoint = xPoint;
	}
	public double getyPoint() {
		return yPoint;
	}
	public void setyPoint(double yPoint) {
		this.yPoint = yPoint;
	}
	public void printX() {
		System.out.println("x: " + xPoint);
	}
	public void printY() {
		System.out.println("y: " + yPoint);
	}
	public void printXY() {
		System.out.println(xPoint + " " + yPoint);
	}
	public Point(double x, double y) {
		super();
		this.xPoint = x;
		this.yPoint = y;
	}
}