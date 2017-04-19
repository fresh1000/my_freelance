
/**
 * Write a description of class Heavy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heavy extends TraditionalCurtain{
    public Heavy() {
        rValue = 2.2;
    }
    
    public void setPriceForArea(int width, int height) {
        final int PRICING_RODS = 9;
        final int PRICING_MATERIAL = 9;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_RODS * perimeter + PRICING_MATERIAL * area;
    }
}
