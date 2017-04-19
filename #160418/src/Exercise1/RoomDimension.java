package Exercise1;

public class RoomDimension {
	private double length;
	private double width;

	public RoomDimension(double l, double w) {
		this.length = l;
		this.width = w;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
	
	public String toString() {
		return "Room with Length: " + getLength() + " and Width: " + getWidth();
	}
}
