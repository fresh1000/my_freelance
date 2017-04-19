package exercise1;

public class Bug {
	private int position;
	private int direction;
	
	public Bug(int initialPos,int initialDir) {
		this.position = initialPos;
		this.direction = initialDir;
	}
	
	public void move() {
		if(position == 0 && direction == 0) {
			direction = 1;
			position++;
		}
		if(position == 50 && direction == 1) {
			direction = 0;
			position--;
		}
		if(direction == 0)
			position--;
		if(direction == 1)
			position++;
	//Here the algorithm:
	/*if the direction is left,  decrement the position by 1; 
	if the direction is right,  increment the position by 1;
	However,  before you do the above,  if the position is 0 and the direction 
	is left,  change the direction to right and increment the position by 1; 
	Similarly,  if the position is 50 and the direction is right,  change the 
	direction to left and decrement the position by 1 
	*/
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String toString() {
		String dir;
		if(direction == 0)
			dir = "Left";
		else
			dir = "Right";
		return "Position: " + position + "   " + "Direction: " + dir;
	}
	
	public static void main(String[] args) {
		int initialPos = (int)(Math.random()*51);
		int initialDir = (int)(Math.random()*2);
		Bug bugsy = new Bug(initialPos, initialDir);
		System.out.println(bugsy);
		for(int i = 0; i <= 50; i++) {
			if (i==bugsy.getPosition())
				System.out.print("X");
			else
				System.out.print("-");
		}
		System.out.println();
		
		int moves = (int)(Math.random()*51);
		System.out.println("Moves: "   + moves);
		for(int i=1;i<=moves;i++) 
			bugsy.move();
		System.out.println(bugsy);
		
		for(int i = 0; i <= 50; i++) {
			if (i==bugsy.getPosition())
				System.out.print("X");
			else
				System.out.print("-");
		}
		System.out.println();
	}
	
}
