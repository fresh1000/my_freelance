
/**
 * Write a description of class SingleCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingleCell extends HoneycombShade {
   public SingleCell() {
       rValue = 2.3;
   }
   
   public void setPriceForArea(int width, int height) {
       final int PRICING_HEADER = 15;
       final int PRICING_MATERIAL = 11;
       int area = width + height;
       int perimeter = (width + height) * 2;
       this.price = PRICING_HEADER * perimeter + PRICING_MATERIAL * area;
   }
}
