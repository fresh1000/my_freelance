
/**
 * Write a description of class DoubleCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoubleCell extends HoneycombShade{
    public DoubleCell() {
       rValue = 2.8;
   }
   
   public void setPriceForArea(int width ,int height) {
        final int PRICING_HEADER = 18;
        final int PRICING_MATERIAL = 14;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_HEADER * perimeter + PRICING_MATERIAL * area;
   }
}
