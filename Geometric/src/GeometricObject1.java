/** The abstract class is defined with the "abstract" keyword 
 * @param <T>*/
public abstract class GeometricObject1 implements Comparable<GeometricObject1>{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject1() {
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject1(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean, the get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}

	public static GeometricObject1 max(GeometricObject1 obj1, GeometricObject1 obj2) {
		if (obj1.compareTo(obj2) >= 0) {
			return obj1;
		}
		return obj2;
	}
	
    public int compareTo(GeometricObject1 geometricObject) {
        if (this.getArea() > geometricObject.getArea()) {
            return 1;
        } else if (this.getArea() < geometricObject.getArea()) {
            return -1;
        }        
        return 0;
    }
	
    public static double sumArea(GeometricObject1[] arrayGeometricObjects) {
        double sumArea = 0;
        for (int i = 0; i < arrayGeometricObjects.length; i++) {
            sumArea = sumArea + arrayGeometricObjects[i].getArea();
        }
        return sumArea;
    }
    
	/**
	 * Abstract method getArea 1. Similarly as the abstract class, the abstract
	 * method is also defined with the "abstract" keyword 2. The abstract method
	 * does not have its function body 3. Any subclass of GeometricObject must
	 * implement or override this getArea method
	 */
	public abstract double getArea();

	/**
	 * Abstract method getPerimeter Similarly, any subclass of GeometricObject
	 * must implement or override this getPerimeter method
	 */
	public abstract double getPerimeter();
}