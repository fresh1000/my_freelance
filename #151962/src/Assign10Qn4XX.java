
public class Assign10Qn4XX {
	public static void main(String...arg) {
		Point a = new Point(12, 42);
		a.printX();
		a.setxPoint(2);
		a.printXY();
		
		Circle b = new Circle(12, 22, 5);
		b.setRadius(15);
		b.printRadius();
		b.area();
		b.circumference();
		b.printArea();
		b.printCircumference();

		Cylinder c = new Cylinder(21, 32, 12, 20);
		c.setHeight(15);
		c.areaCylinder();
		c.volume();
		c.printAreaCylinder();
		c.printVolume();
	}
}
