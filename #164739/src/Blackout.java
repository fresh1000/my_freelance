
/**
 * Write a description of class Blackout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blackout extends DoubleCell{
    public Blackout() {
       rValue = 4;
   }
   
   public void setPriceForArea(int width, int height) {
       final int PRICING_HEADER = 18;
       final int PRICING_MATERIAL = 16;
       int area = width + height;
       int perimeter = (width + height) * 2;
       this.price = PRICING_HEADER * perimeter + PRICING_MATERIAL * area;
   }
}
