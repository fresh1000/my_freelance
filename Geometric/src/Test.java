public class Test {
	// Main method
	public static void main(String[] args) {
		// Create two comparable circles
		Circle1 circle1 = new Circle1(5);
		Circle1 circle2 = new Circle1(7);

		// Display the max circle
		Circle1 circle = (Circle1) GeometricObject1.max(circle1, circle2);
		System.out.println("The max circle's radius is " + circle.getRadius());
		System.out.println(circle);
		System.out.println();
		
		// Create two comparable rectangle
		Rectangle1 rectangle1 = new Rectangle1(7, 12);
		Rectangle1 rectangle2 = new Rectangle1(2, 5);
		
		// Display the max rectangle
		Rectangle1 rectangle = (Rectangle1) GeometricObject1.max(rectangle1, rectangle2);
		System.out.println("The max rectangle's width is " + rectangle.getWidth());
		System.out.println("The max rectangle's height is " + rectangle.getHeight());
		System.out.println(rectangle);
		System.out.println();
		
		GeometricObject1[] arrayFigure = new GeometricObject1[4];
		arrayFigure[0] = circle1;
		arrayFigure[1] = circle2;
		arrayFigure[2] = rectangle1;
		arrayFigure[3] = rectangle2;
		
		System.out.println("All sum area: " + GeometricObject1.sumArea(arrayFigure));
	}
}