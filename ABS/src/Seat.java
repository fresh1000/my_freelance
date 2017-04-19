
public class Seat {
	private int row;
	private char column;
	private boolean isAvailable = true;
	
	public Seat(int row, char column) {
		this.row = row;
		this.column = column;
		setAvailable(false); 
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRow() {
		return row;
	}

	public char getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public String toString() {
		return "Seat: Row=" + row + ", Column=" + column + "\n";
	}
	
	
}
