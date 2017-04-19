package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Human extends Entity {

    private String name;//name human
    private int health;//health human

    public Human(int x, int y, String name, int health) {
        super(x, y);
        this.name = name;
        this.health = health;
        setSymbol('@');
        setType("human");
    }

    public void move(Room r) {
        if (r.isFree(getX(), getY() + 1) && getY() != 9) {//set to right
            setY(getY() + 1);
            health -= 1;
        } else {//else move to unoccupied randomly chosen cell adjacent to their current position
            boolean move = true;//variable for while loop
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            ArrayList<Integer> index = new ArrayList<Integer>();
            index.add(0);
            index.add(1);
            index.add(2);
            index.add(3);
            long seed = System.nanoTime();
            Collections.shuffle(index, new Random(seed));
            int pos = 0;
            
            while (move) {
                int xNew = getX() + dx[index.get(pos)];//generate random row
                int yNew = getY() + dy[index.get(pos)];//generate random column
                //check free random row and column, 0 <= row <=9 0 <= column <=9
                if (r.isFree(xNew, yNew) && (xNew >= 0 && xNew <= 9) && (yNew <= 9 && yNew >= 0)) {
                    setX(xNew);//set new x
                    setY(yNew);//set new y
                    move = false;//if check, end loop
                    health -= 1;
                }else
                    pos++;
            }
        }
    }

    public String toString() {
        return "Entity properties: \nType: " + getType() + "\nName: " + name + "\nHealth: " + health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
