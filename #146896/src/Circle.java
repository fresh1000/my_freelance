import java.awt.Color;

public class Circle {
	private double inputX;
	private double inputY;
	private double radius;
	private Color color;
	
	public Circle (double inputX, double inputY, double radius, Color color ) {
		this.inputX = inputX;
		this.inputY = inputY;
		this.radius = radius;
		this.color = color;
	}
	
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.line(0.2, 0.2, 0.8, 0.2);
		StdDraw.filledCircle(inputX, inputY, radius);
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
}
