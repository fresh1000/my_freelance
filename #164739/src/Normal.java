
/**
 * Write a description of class Normal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Normal extends TraditionalCurtain{
    public Normal() {
        rValue = 1.9;
    }
    
    public void setPriceForArea(int width, int height) {
        final int PRICING_RODS = 7;
        final int PRICING_MATERIAL = 8;
        int area = width + height;
        int perimeter = (width + height) * 2;
        this.price = PRICING_RODS * perimeter + PRICING_MATERIAL * area;
    }
}
