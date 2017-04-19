package A;

public class TriangleArea {

	public static void main(String[] args) {
		double a,b,area,sinAB;
		a = 12;
		b = 6;
		sinAB = 60;
		area = 0.5 * a * b * Math.sin(Math.toRadians(sinAB));
		System.out.println(area);
	}

}
