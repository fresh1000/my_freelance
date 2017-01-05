class Circle extends Point {
	protected double radius;
	protected double area;
	protected double circumference;
	
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public void area() {
		area = Math.PI * radius * radius;
	}
	
	public void printRadius() {
		System.out.println("Radius Circle: " + radius);
	}

	public void printArea() {
		System.out.println("Area Circle: " + area);
	}
	
	public void printCircumference() {
		System.out.println("Circumference Circle: " + circumference);
	}

	public void circumference() {
		circumference = 2 * Math.PI * radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setCentre(double x, double y) {
		this.xPoint = x;
		this.yPoint = y;
	}
}