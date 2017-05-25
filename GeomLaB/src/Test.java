import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		int[] xs = {0, 1, 1, 3, 3, 4, 4};

		// y coordinates
		int[] ys = {0, 1, 2, 1, 0, 4, 1};

		// find the convex hull
		ArrayList<Point> convexHull = (ArrayList<Point>) GrahamScan.getConvexHull(xs, ys);

		for(Point p : convexHull) {
		    System.out.println(p.toString());
		}

	}

}
