import java.awt.Point;

class GeomPoint extends Point {

	public GeomPoint(int ptx, int pty) {
		this.x = ptx;
		this.y = pty;
	}

	int min(int a, int b) {
		if (a <= b)
			return a;
		else
			return b;
	}

	int max(int a, int b) {
		if (a >= b)
			return a;
		else
			return b;
	}
}
