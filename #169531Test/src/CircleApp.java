

class CircleApp {
	public static void main(String[] args) {
		double rd = Double.parseDouble(args[0]);
		System.out.println("Circle1 radius = " + rd);
		// create an object of Circle with the radius rd
		Circle circle1 = new Circle(rd);
		double cir = circle1.calCircumference();
		double area = circle1.calArea();
		System.out.println("Circumference = " + cir);
		System.out.println("Area = " + area);
		
		Circle circle2 = new Circle(circle1);
		circle1.setR(10);
		System.out.println("Set circle1 radius to 10");
		System.out.println("Circle2 radius = " + circle2.getR());
		double cir2 = circle2.calCircumference();
		double area2 = circle2.calArea();
		System.out.println("Circumference = " + cir2);
		System.out.println("Area = " + area2);		
		
		Circle circle3 = circle2;
		System.out.println("Circle2 radius = " + circle2.getR());
		System.out.println("Circle3 radius = " + circle3.getR());
		circle3.setR(5);
		System.out.println("Set circle3 radius to 5");
		System.out.println("Circle2 radius = " + circle2.getR());
		System.out.println("Circle3 radius = " + circle3.getR());
	}
}