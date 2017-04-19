package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Monster extends Entity {

    private int strength;
    private int health;

    public Monster(int x, int y, int strength, int health) {
        super(x, y);
        this.strength = strength;
        this.health = health;
        setSymbol('*');
        setType("monster");
    }

    public void move(Room r) {
        //set the position row plus strength ,column plus strength
        if (r.isFree(getX() + strength, getY() + strength) && getX() + strength <= 9 && getY() + strength <= 9) {
            setX(getX() + strength);
            setY(getY() + strength);
            health -= strength;
        } else if (r.isFree(getX() - strength, getY() + strength) && getX() - strength >= 0 && getY() + strength <= 9) {
            //set the position row minus strength ,column plus strength
            setX(getX() - strength);
            setY(getY() + strength);
            health -= strength;
        } else if (r.isFree(getX() + strength, getY() - strength) && getX() + strength <= 9 && getY() - strength >= 0) {
            //set the position row plus strength ,column minus strength
            setX(getX() + strength);
            setY(getY() - strength);
            health -= strength;
        } else if (r.isFree(getX() - strength, getY() - strength) && getX() - strength >= 0 && getY() - strength >= 0) {
            //set the position row minus strength ,column minus strength
            setX(getX() - strength);
            setY(getY() - strength);
            health -= strength;
        } else {
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
                    health -= strength;//delete strength from health for move
                }else
                    pos++;
            }
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String toString() {
        return "Entity properties: \nType: " + getType() + "\nStrength: " + strength + "\nHealth: " + health;
    }

}
