

/*
 * Abstract Class Entity
 * 
 */

package game;
 

/**
 *
 * @author Arantza
 */
public abstract class Entity {
 private char symbol; // symbol that represents the entity
 private String type; // every entity is of a type
 private int x; // x coordinate in the room
 private int y; // y coordinate in the room
 
 
 public Entity (int x, int y) {
     type = "entity";
     this.x=x;
     this.y =y;
 }
 
 

 public char getSymbol() {
     return symbol;
 }
 
 public void setSymbol(char c) {
     symbol = c;
 }

 public int getX() {
     return x;
 }
 
 public int getY() {
     return y;
 }
 public void setX (int newx) {
    this.x=newx;
    
 }

 public void setY (int newy) {
    this.y=newy;
    
 }
 public String getType() {
     return type;
 }
 
 public void setType(String type) {
     this.type = type;
 }

 
 /**
  * 
  * @param r the room with the positions of all the entities
  * abstract method that moves the entity according to the rules of the game
  */
 public abstract void move(Room r);
    
/**
 * 
 * @return string with information about an abstract entity 
 */
   public String toString() {      
       
       String s =  symbol  + " " + x + "  " + y;
       return s;
   }

}
