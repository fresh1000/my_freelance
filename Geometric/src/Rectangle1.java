public class Rectangle1 extends GeometricObject1 {
	private double width;
	private double height;
	
	public Rectangle1(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return this.width * this.height;
	}

	public double getPerimeter() {
		return 2 * (this.width * this.height);
	}

	public String toString() {
		return "Rectangle - Width: " + this.width + " Height: " + this.height
			+ " Area: " + this.getArea() + " Perimeter: " + this.getPerimeter();
	}
}
