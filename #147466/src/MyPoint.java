
public class MyPoint {
	private double X;
	private double Y;
	
	public MyPoint(double X, double Y) {
		this.X = X;
		this.Y = Y;
	}
	
	public double getX(double X) {
		return this.X;
	}
	
	public double getY(double Y) {
		return this.Y;
	}
	
	public void setX(double X) {
		this.X = X;
	}
	
	public void setY(double Y) {
		this.Y = Y;
	}
	
	public void translate(double a, double b) {
		X += a;
		Y += b;
	}
	
	public String toString() {
		return "Point x: " + X + " Point y: " + Y;
	}
}
