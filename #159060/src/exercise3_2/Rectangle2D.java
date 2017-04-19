package exercise3_2;

public class Rectangle2D {
	private double xpos;
	private double ypos;
	private double width;
	private double height;
	
	public Rectangle2D() {
		xpos = 0.0;
		ypos = 0.0;
		width = 0.0;
		height = 0.0;
	}
	
	public Rectangle2D(double xpos, double ypos, double width, double height) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
	}

	public double getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		double area;
		area = width * height;
		return area;
	}
	
	public double getPerimeter() {
		double perimeter;
		perimeter = 2 *(width + height);
		return perimeter;
	}
	
	public boolean contains(double x,double y) {
		if(y >= ypos && x >= xpos && y <= ypos + height && x <= xpos + width) {
			return true;
		}else
			return false;
	}
	
	public boolean contains(Rectangle2D r) {
		if(r.getYpos() >= ypos && r.getXpos() >= xpos && r.getYpos() <= ypos + height && r.getXpos() <= xpos + width) {
			if(r.getYpos() + r.getHeight() > ypos + height &&  r.getXpos() + r.getWidth() > xpos + width){
				return false;
			}
			return true;
		}
		return false;
	}

	public String toString() {
		return "Rectangle [[" + xpos + "," + ypos + "], width=" + width + ", height=" + height + "]";
	}
}
