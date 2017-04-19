package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dragon extends Entity {

    private int health;//health dragon
    private boolean canFly;//can fly dragon

    public Dragon(int x, int y, int health, boolean canfly) {
        super(x, y);
        this.health = health;
        setSymbol('#');
        this.setCanFly(canfly);
        if (canfly) {
            setType("flying dragon");
        } else {
            setType("non-flying dragon");
        }
    }

    public void move(Room r) {
        //if non-flying dragon
        if (!canFly) {
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
                    health -= (int) (Math.random() * 5);//delete random health(0-5)
                }else
                    pos++;
            }
                    
        } else {//if flying dragon
            boolean move = true;//variable for while loop
            while (move) {
                int xNew = (int) (Math.random() * 9);//random row
                int yNew = (int) (Math.random() * 9);//random column
                //check free random row and column
                if (r.isFree(xNew, yNew)) {
                    setX(xNew);//set new x
                    setY(yNew);//set new y
                    move = false;//if check, end loop
                }
            }

        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String toString() {
        return "Entity properties: \nType: " + getType() + "\nHealth: " + health;
    }

}
