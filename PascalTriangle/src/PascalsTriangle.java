import java.util.Arrays;

public class PascalsTriangle {
	private int rows;
	private String triangle;
	
	/**
	 * Constructor
	 */
	public PascalsTriangle(int rows) {
		this.rows = rows;
		this.triangle = "";
		pascalTriangle();
	}

	/**
	 * Get rows triangle
	 * @return
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * Set rows triangle
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * Generate string pascalTriangle 
	 */
	private void pascalTriangle() {
		for (int row = 0; row < this.rows; row++) {
            int number = 1;//initialize number equals 1
            triangle += String.format("%" + (rows - row) * 2 + "s", "");//special string format for print 
            for (int column = 0; column <= row; column++) {
                triangle += String.format("%4d", number);//special string format for print 
                number = number * (row - column) / (column + 1);//recalculate number for Pascal triangle 
            }
            triangle += '\n';//add new line symbol for end row
        }
	}
	
	/**
	 * Return string Pascal triangle
	 */
	public String toString() {
		return this.triangle;//return Pascal triangle
	}
	
}
