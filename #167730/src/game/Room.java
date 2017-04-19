package game;

/*
 * Class that stores the positions of all the entities
 * Methods to add entities, display the room, display information are not implemented
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Arantza
 */
public class Room {
    // List with all the entities

    private ArrayList<Entity> entities = new ArrayList<Entity>();

    /**
     * Set up a new room with entities in random places first the room, must be
     * clear of entities
     */
    public void resetRoom() {
        clearRoom();

    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * Empty the list of entities
     */
    public void clearRoom() {
        entities.clear();
    }

    /**
     * Method that tell us if a cell is occupied by an entity
     *
     * @param x row 0 <= x <= 9 @
     * param y column 0 <= y <= 9 @
     * return true is cell free
     */
    public boolean isFree(int x, int y) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getX() == x && entities.get(i).getY() == y) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method that returns the position in the arrayList occupied by an entity
     * given its coordinates
     *
     * @param x row 0 <= x <= 9 @
     * param y column 0 <= y <= 9 @
     * return position in the list or -1 if the cell is free
     */
    public int getPosition(int x, int y) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getX() == x && entities.get(i).getY() == y) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Display all the properties of an entity that occupies a particular cell
     * PRE: Cell must not be empty
     *
     * @param x row 0<= x <=9
     * @param y column 0<=y<=9
     * @return String with the properties of the entity or
     *
     */
    public String displayEntity(int x, int y) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getX() == x && entities.get(i).getY() == y) {
                return entities.get(i).toString();
            }
        }
        return ("Not found");
    }

    /**
     * method that moves all the entities that are animated on the room
     */
    public void move() {
        for (Entity e : entities) {
            e.move(this);

        }
    }

    /**
     * method that return string used to display the room as specified
     */
    public String toString() {
        String st = "";
        return st;
    }

    /**
     * Method for version 1 that clears the room and creates a new list with the
     * entities read in a text file
     *
     * @throws FileNotFoundException
     */
    public void loadEntities() throws FileNotFoundException {

    }

    /**
     * Version 2 methods that saves the entities and their positions into a text
     * file
     *
     * @throws FileNotFoundException
     */
    public void saveEntities() throws FileNotFoundException {

    }
}

