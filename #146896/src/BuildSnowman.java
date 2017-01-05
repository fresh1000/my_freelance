import java.awt.Color;

public class BuildSnowman {
	
	public static void main( String[] args ) {
		StdDraw.setXscale(0.0, 300.0);
		StdDraw.setYscale(0.0, 300.0);
		
		Snowman snow = new Snowman();
		
		Circle bottom = new Circle(125, 50, 60, StdDraw.BLUE);
		Circle middle = new Circle(125, 150, 40, StdDraw.MAGENTA);
		Circle head = new Circle(125, 210, 20, StdDraw.YELLOW);
		Circle leftEye = new Circle(118, 215, 4, StdDraw.BLACK);
		Circle rightEye = new Circle(132, 215, 4, StdDraw.BLACK);
		
		Rectangle hat = new Rectangle(125, 237, 30, 15, StdDraw.GREEN);
		Rectangle mouth = new Rectangle(125, 204, 15, 4, StdDraw.RED);
		
		snow.setMouth(mouth);
		snow.setRightEye(rightEye);
		snow.setLeftEye(leftEye);
		snow.setHead(head);
		snow.setHat(hat);
		snow.setBottom(bottom);
		snow.setMiddle(middle);
		
		snow.draw();
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(85, 150, 35, 130);
		StdDraw.line(165, 150, 215, 130);
		
		
		StdDraw.line(35, 130, 25, 135);
		StdDraw.line(35, 130, 30, 120);
		StdDraw.line(35, 130, 26, 127);
		
		StdDraw.line(215, 130, 225, 135);
		StdDraw.line(215, 130, 220, 120);
		StdDraw.line(215, 130, 224, 127);
		
		
	}
	
}
