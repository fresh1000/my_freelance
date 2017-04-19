package game;

public class Stone extends Entity{
	
	public Stone(int x, int y) {
		super(x, y);
		setType("stone");
		setSymbol('S');
	}

	public void move(Room r) {
		
	}
	
	public String toString() {
		return "Entity properties: \nType: " + getType();
	}

}
