public class Rectangle {

	private double a;
	private double b;
	
	
	public Rectangle(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Rectangle() {
		a = 0;
		b = 0;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public String toString() {
		return "Rectangle [a=" + a + ", b=" + b + "]";
	}

	private double calcDiagonal(double a, double b) {
		double diagonal = Math.sqrt(a * a + b * b);
		return diagonal;
	}

	public double calcArea(double a, double b) {
		double s = a * b;
		return s;
	}

	public double calcPerimeter(double a, double b) {
		double p = (a + b) * 2;
		return p;
	}
}