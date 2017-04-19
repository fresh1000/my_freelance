package game;

public class Hole extends Entity {

    private int depth;
    private int health;

    public Hole(int x, int y, int depth) {
        super(x, y);
        this.depth = depth;
        setType("hole");
        setSymbol('O');
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void move(Room r) {

    }

    public String toString() {
        return "Entity properties: \nType: " + getType() + "\nDepth: " + depth + "\nHealth: " + health;
    }

}
