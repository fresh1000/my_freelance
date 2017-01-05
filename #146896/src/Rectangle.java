import java.awt.Color;

public class Rectangle {
	private double inputX;
	private double inputY;
	private double length;
	private double width;
	private Color color;
	
	public Rectangle(double inputX, double inputY, double length, double width, Color color) {
		this.inputX = inputX;
		this.inputY = inputY;
		this.length = length/2;
		this.width = width/2;
		this.color = color;
	}
	
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.line(0.2, 0.2, 0.8, 0.2);
		StdDraw.filledRectangle(inputX, inputY, this.length, this.width);
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
}
