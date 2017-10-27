class GeomEdge {

	int xmin, xmax; /* horizontal, +x вправо */
	int ymin, ymax; /* vertical, +y вниз*/
	double m, b; /* y = mx + b */
	boolean isTop, isRight; /* положение ребра */

	public GeomEdge(GeomPoint p, GeomPoint q) {
		this.xmin = p.min(p.x, q.x);
		this.xmax = p.max(p.x, q.x);
		this.ymin = p.min(p.y, q.y);
		this.ymax = p.max(p.y, q.y);
		this.m = ((double) (q.y - p.y)) / ((double) (q.x - p.x));
		this.b = p.y - m * (p.x);
		this.isTop = p.x > q.x; // ребро с права на лево (ccw)
		this.isRight = p.y > q.y; // ребро снизу вверх (ccw)
	}
}
